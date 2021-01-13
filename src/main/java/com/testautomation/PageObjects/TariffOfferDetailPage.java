package com.testautomation.PageObjects;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TariffOfferDetailPage {
	WebDriver driver;
    
	public TariffOfferDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//h1[contains(text(),'Angebot')]")
	public WebElement OfferDetailElement;
	
	@FindBy(how = How.XPATH, using = ".//a[@data-description='firstAvailabilityCheckButton']")
	public WebElement firstAvailabilityCheckButton;
	
	@FindBy(how = How.XPATH, using = ".//a[@data-description='secondAvailabilityCheckButton']")
	public WebElement secondAvailabilityCheckButton;
	
	@FindBy(how = How.XPATH, using = ".//th[text()='Tarifkosten']")
	public WebElement tarifKostenButton;
	
	@FindBy(how = How.XPATH, using = ".//td[text()='Vorteile']")
	public WebElement vorteile;
	
	@FindBy(how = How.XPATH, using = ".//div[@class='price']")
	public WebElement offerPageTarrifPrice;
	
	@FindBy(how = How.XPATH, using = ".//tr[@class='average-price']")
	public WebElement averagePrice;
	
	@FindBy(how = How.XPATH, using = ".//div[@class='option-description hardware-tab']")
	public WebElement optionalHardwareSelect;
	
	@FindBy(how = How.XPATH, using = ".//div[@class='option-description hardware-tab']//label")
	public WebElement hardwareSelectButton;
	
	@FindBy(how = How.XPATH, using = ".//td[text()='Hardware']")
	public WebElement hardwareDescription;
	
	public boolean isOfferDetailElementDisplayed() {
		return OfferDetailElement.isDisplayed();
	}
	
	public boolean isTariffProviderDescriptionDisplayed(String tariffProviderDescription) {
		return driver.findElement(By.xpath(".//h1[text()='Angebot " + tariffProviderDescription + "']")).isDisplayed();
	}
	
	public boolean isFirstAvailabilityCheckButtonDisplayed() {
		return firstAvailabilityCheckButton.isDisplayed();
	}
	
	public boolean isSecondAvailabilityCheckButtonDisplayed() {
		return secondAvailabilityCheckButton.isDisplayed();
	}
	
	public boolean isTarifKostenButtonDisplayed() {
		return tarifKostenButton.isDisplayed();
	}
	
	public boolean isVorteileDisplayed() {
		return vorteile.isDisplayed();
	}
	
	public int getTarrifPriceinOfferPage() {
		return Integer.parseInt(offerPageTarrifPrice.getText().replaceAll("[^0-9]", ""));
	}
	
	public boolean isAveragePriceDisplayed() {
		return averagePrice.isDisplayed();
	}
	
	public boolean isTariffProviderDescriptionDisplayedInOffersPage(String tariffProviderDescription) {
		return driver.findElement(By.xpath(".//h3[text()='" + tariffProviderDescription + "']")).isDisplayed();
	}
	
	public boolean isOptionalHardwareSelectDisplayed() {
		return optionalHardwareSelect.isDisplayed();
	}
	
	public void clickHardwareSelectButton() {
		hardwareSelectButton.click();
	}
	
	public boolean isHardwareDescriptionDisplayed() {
		return hardwareDescription.isDisplayed();
	}	
	
}
