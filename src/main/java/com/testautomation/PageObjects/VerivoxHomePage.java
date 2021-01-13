package com.testautomation.PageObjects;


//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VerivoxHomePage 
{
	WebDriver driver;
	
	public VerivoxHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() throws Exception
	{
		Thread.sleep(2000);
		return driver.getTitle();
	}
	
	@FindBy(how=How.ID,using="uc-btn-accept-banner")
	public WebElement AcceptCookie;
	
	@FindBy(how=How.XPATH,using=".//a[@href='/internet/']")
	public WebElement DSLTab;
	
	public void clickAcceptCookie() {
		AcceptCookie.click();
	}

	public void clickDSLTab() {
		DSLTab.click();
	}
	
}
