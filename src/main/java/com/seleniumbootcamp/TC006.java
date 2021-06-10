package com.seleniumbootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006{
	
	public ChromeDriver driver ;
	public ChromeOptions options;
	   @BeforeMethod

	    public void lunchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		Thread.sleep(13000);
	   }
	@Test()
	public void testCaseSix() throws InterruptedException {
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
		// driver.findElementByXPath("//table[contains(@class,'slds-table
		// forceRecordLayout')]").click();
		List<WebElement> rows = driver.findElementsByXPath("//table[contains(@class,'slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered')]//tr//td[6]");
		Thread.sleep(2000);
		System.out.println(rows.size());
		List<String> listClosedate = new ArrayList<String>();
		for (int i = 1; i <= rows.size(); i++) {
			String closedateprint = driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered')]//tr["+i+"]//td[6]").getText();
			//System.out.println("accountName"+accountName);
			listClosedate.add(closedateprint);
			System.out.println(listClosedate);
			Collections.sort(listClosedate);
			System.out.println("After Collections.sort of before sorting data " + listClosedate);
		}
		
		
		

		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()=\"Close Date\"]"));

		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()=\"Close Date\"]"));

	}

}
