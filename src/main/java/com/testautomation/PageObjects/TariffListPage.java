package com.testautomation.PageObjects;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TariffListPage {
	WebDriver driver;

	public TariffListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//h2[@class='summary-tariff']")
	public WebElement ErmittelteTarife;

	@FindBy(how = How.TAG_NAME, using = "app-tariff")
	public List<WebElement> ErmittelteTarifeList;
	
	@FindBy(how = How.XPATH, using = ".//app-tariff-price")
	public List<WebElement> appTariffPrice;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='download-icon']//following-sibling::b")
	public List<WebElement> internetSpeed;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'weitere tarife laden')]")
	public WebElement LoadMoreTariffs;

	@FindBy(how = How.XPATH, using = ".//strong[@class='headline-large']")
	public List<WebElement> totalTariffProviderName;

	@FindBy(how = How.XPATH, using = ".//div[contains(@class,'headline-short-name')]")
	public List<WebElement> tariffProviderDescription;
	
	public String zumAngebotButton = ".//ancestor::*[@class='container']//*[text()='Zum Angebot']";
	
	public String getErmittelteTarifeText() {
		return ErmittelteTarife.getText();
	}

	public WebElement getElementFromErmittelteTarifeList(int TariffPosition) {
		return ErmittelteTarifeList.get(TariffPosition - 1);
	}
	
	public void clickLoadMoreTariffs(Integer sizeOfTariffPerPage) {
		driver.findElement(By.xpath(".//button[contains(text(),'" + sizeOfTariffPerPage + " weitere tarife laden')]")).click();
	}
	
	public boolean isLoadMoreTariffsDisplayed() {
		return LoadMoreTariffs.isDisplayed();
	}
	
	public String getTariffProviderName(int indexOfTariffProvider) {
		return totalTariffProviderName.get(indexOfTariffProvider).getText();
	}
	
	public String getTariffProviderDescription(int indexOfTariffProvider) {
		return tariffProviderDescription.get(indexOfTariffProvider).getText();
	}
	
	public int getTariffProviderPrice(int indexOfTariffProvider) {
		return Integer.parseInt(driver
		.findElement(By.xpath("(.//img[contains(@class,'info-icon cursor-pointer')])["
				+ indexOfTariffProvider + "]//preceding-sibling::strong"))
		.getText().replaceAll("[^0-9]", ""));	
		}
	
	public boolean clickZumAngebotButton(int indexOfTariffProvider) {
		totalTariffProviderName.get(indexOfTariffProvider).findElement(By.xpath(zumAngebotButton)).click();
		return true;
	}
	
	public String getInternetSpeedText(int priceIteraor) {
		return internetSpeed.get(priceIteraor-1).getText();
	}
	
}
