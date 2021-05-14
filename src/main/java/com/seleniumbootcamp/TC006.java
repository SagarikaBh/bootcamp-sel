package com.seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006 {

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
		Thread.sleep(9000);
		driver.executeScript("arguments[0].click();",
				driver.findElementByXPath("//span[@class=\"slds-truncate\" and normalize-space()='Opportunities']"));
		// driver.findElementByXPath("//span[@class=\"slds-truncate\" and
		// normalize-space()='Opportunities']").click();

		// driver.findElementByXPath(" //span[@class=\"slds-assistive-text\" and
		// normalize-space()='Display as Table']").click();
		//driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout')]").click();
		
		
		
		driver.executeScript("arguments[0].click();",
				driver.findElementByXPath("//span[text()=\"Close Date\"]"));
		
		
		
		
	}

}
