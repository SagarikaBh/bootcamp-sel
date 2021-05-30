package com.seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC62notComplete {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		Thread.sleep(13000);
//		List<WebElement> lightningSwitch = driver.findElementsByXPath("//a[@class='switch-to-lightning']"); 
//		if(lightningSwitch.size() !=0) 
//		{
//			driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
		Thread.sleep(5000);
		driver.executeScript("arguments[0].click();", driver.findElementByXPath(
				"//button[@class=\"bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader\" and @type=\"button\"]"));
		Thread.sleep(3000);
		driver.findElementByXPath("//button[contains(text(),\"View All\")]").click();
		driver.findElementByXPath("//p[@class=\"slds-truncate\" and normalize-space()=\"Content\"]").click();
		driver.findElementByXPath("(//a[@class=\"viewAllLink\"]//span[@class=\"viewAllLabel\" and normalize-space()=\"View All\"])[2]").click();
        Thread.sleep(5000);
        driver.findElementByXPath("(//a[@class=\"slds-button slds-button_reset\"])[2]").click();
        driver.executeScript("arguments[0].click();", driver.findElementByXPath(
				"(//span[text()=\"Open Tasks\"])[1]"));
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class=\"slds-dropdown-trigger slds-dropdown-trigger_click\"]").click();
		
        driver.findElementByXPath("(//div[@class=\"slds-dropdown-trigger slds-dropdown-trigger_click\"])[2]").click();
        driver.findElementByXPath("//span[@class=\"slds-truncate\" and normalize-space()=\"Clone\"]").click();
        driver.findElementByXPath("(//div[@class=\"slds-form-element__control slds-grow\"]//input[@class=\"slds-input\"])[1]").sendKeys("New open tasks");
        driver.findElementByXPath("//input[@class=\"slds-input\" and @name=\"developerName\"]").clear();
        driver.findElementByXPath("//input[@class=\"slds-input\" and @name=\"developerName\"]").sendKeys("New _open tasks");
        driver.findElementByXPath("(//span[@class='slds-radio_faux'])[2]").click();
        driver.findElementByXPath("(//span[@class=' label bBody' and text()=\"Save\"]) [2]").click();
	}

}
