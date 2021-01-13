package com.testautomation.PageObjects;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DSLCalculatorPage 
{
	WebDriver driver;
	
	public DSLCalculatorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(.//input[@class='float-label-input'])[1]")
	public WebElement AreaCode;
	
	@FindBy(how=How.XPATH,using=".//span[text()='Internet+Telefon']")
	public WebElement InternetPlanType;
	
	@FindBy(how=How.XPATH,using="(.//button[text()='Jetzt vergleichen'])[1]")
	public WebElement JetztVergleichenButton;
	
	public boolean sendKeysIntoAreaCode(String areaCode) {
		AreaCode.sendKeys(areaCode);
		return true;
	}
	
	public boolean clickInternetSpeed(String internetSpeed) {
		driver.findElement(By.xpath("(.//strong[contains(text(),'" + internetSpeed + "')])[1]")).click();
		return true;
	}
	
	public boolean clickJetztVergleichenButton() {
		JetztVergleichenButton.click();
		return true;
	}
	
	public void clickInternetPlanType() {
		InternetPlanType.click();
	}
}
