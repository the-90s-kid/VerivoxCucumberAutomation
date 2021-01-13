package Utility;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testautomation.PageObjects.TariffListPage;

import junit.framework.Assert;

public class BrowserUtility {
	public static Logger logger = LogManager.getLogger(BrowserUtility.class);
	static String projectPath = System.getProperty("user.dir");
	
	public static WebDriver OpenBrowser(WebDriver driver, String url, String browserName) throws InterruptedException {

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.ie.driver", projectPath + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {

			logger.info("Could not able to Instatiate using the browserName " + browserName
					+ ". Please provide it as 'Chrome' or 'Firefox'");
			return null;
		}

		driver.manage().window().maximize();
		driver.get(url);

		return driver;

	}

	public static boolean scrollIntoView(WebDriver driver, WebElement Element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
		return true;
	}

	public static boolean isMinimumThreasholdMaintained(int priceElementsSize, int minimumInternetSpeed,
			WebDriver driver) {
		boolean isMinimumThreasholdMaintained = false;

		for (int priceIteraor = 1; priceIteraor <= priceElementsSize; priceIteraor++) {

			TariffListPage tariffListPage = new TariffListPage(driver);
			int currentInternetSpeed = Integer
					.parseInt(tariffListPage.getInternetSpeedText(priceIteraor).replaceAll("[^0-9]", ""));
			if (currentInternetSpeed >= minimumInternetSpeed) {
				isMinimumThreasholdMaintained = true;
			} else {
				isMinimumThreasholdMaintained = false;
				break;
			}
		}
		return isMinimumThreasholdMaintained;
	}
	
	public static void waitForElementUsingXpath(WebDriver driver, String xpathElement, int timeToWait) {
		   LocalDateTime after = LocalDateTime.now().plusSeconds(timeToWait);
		do {
				if (!(driver.findElement(By.xpath(xpathElement))
						.isDisplayed())) {
					logger.info("Current Window State       : "
							+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				} else {
					break;
				}
			   
		   } while (LocalDateTime.now().isBefore(after));
		
	}

	public static void clickLoadMoreTariffs(TariffListPage tariffListPage,int totalErmittelteTarife,int tarrifPerPage) {
		if (totalErmittelteTarife >= tarrifPerPage) {
			tariffListPage.clickLoadMoreTariffs(tarrifPerPage);
		} else {
			tariffListPage.clickLoadMoreTariffs(totalErmittelteTarife);
			logger.info("Final weitere Tarife laden button displays the expected number of tariffs remaining");
		}
		
	}

	public static boolean assertWeiterButton(int totalErmittelteTarife, int maxTariffPerpage, int totalTariffCurrentpage, TariffListPage tariffListPage) {
		boolean TarifeLadenButton = true;
		
		if (totalErmittelteTarife == 0) {
			Assert.assertTrue(maxTariffPerpage == totalTariffCurrentpage);
			logger.info(
					"The total number of tariffs displayed matches the total listed in the Ermittelte Tarife section");
			try {

				tariffListPage.isLoadMoreTariffsDisplayed();

			} catch (Exception e) {
				TarifeLadenButton = false;
			}
			Assert.assertTrue(!TarifeLadenButton);
			logger.info("Weitere Tarife laden button is no longer displayed when all the tariffs are visible ");

		}
		
		return TarifeLadenButton;
		
	}

}
