package com.seleniumbootcamp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC072 {

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
		driver.findElementByXPath("//p[text()=\"Sales\"]").click();
		Thread.sleep(8000);
		driver.findElementByXPath("//span[text()=\"More\"]").click();
		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("//span[@class=\"slds-truncate\"]//span[text()=\"Cases\"]"));
		Thread.sleep(6000);
		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("//a[contains(@class,\"slds-button slds-button--icon-x-small\")]"));
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//a[@title=\"Edit\"]"));

		Thread.sleep(4000);
		// new window
		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[2]"));
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()=\"Working\"]"));

		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("(//div[@class=\"uiMenu\"]//a[@class=\"select\"])[1]"));
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//a[@title='Low' and normalize-space()='Low']"));

		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("(//div[@class=\"uiMenu\"]//a[@class=\"select\"])[3]"));
		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("//a[@title='Phone' and normalize-space()='Phone']"));
		
		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("(//div[@class=\"uiPopupTrigger\"]//a[@class=\"select\"])[7]"));
		driver.executeScript("arguments[0].click();",
		driver.findElementByXPath("//a[@title='No' and normalize-space()='No']"));
		
		driver.findElementByXPath("//button[@class=\"slds-button slds-button--neutral uiButton--brand uiButton forceActionButton\"]").click();

	}

}
