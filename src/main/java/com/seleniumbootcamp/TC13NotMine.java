package com.seleniumbootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13NotMine {
    
	@Test
	    public void test() throws InterruptedException {
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
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("(//span[text()=\"Accounts\"])[1]"));
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()=\"Account Name\"]"));

		List<WebElement> rows = driver.findElementsByXPath("//tbody/tr/th//a");
		Thread.sleep(2000);
		System.out.println(rows.size());
		List<String> listAccountName = new ArrayList<String>();
		for (int i = 1; i <= rows.size(); i++) {
			String accountName = driver.findElementByXPath("//tbody/tr[" + i + "]/th//a").getText();
			System.out.println(accountName);
			listAccountName.add(accountName);
		}
		Thread.sleep(2000);
		Collections.sort(listAccountName);
		System.out.println("After Collections.sort of before sorting data " + listAccountName);

		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text() = 'Account Name']"));
		Thread.sleep(2000);

		List<WebElement> rows2 = driver.findElementsByXPath("//tbody/tr/th//a");
		System.out.println(rows2.size());
		System.out.println("After clicking sort arrow in the Account Name");
		List<String> listAccountNameAfterSorted = new ArrayList<String>();
		for (int i = 1; i <= rows2.size(); i++) {
			String accountName2 = driver.findElementByXPath("//tbody/tr[" + i + "]/th//a").getText();
			System.out.println(accountName2);
			listAccountNameAfterSorted.add(accountName2);
		}
		if (listAccountName.equals(listAccountNameAfterSorted)) {
			System.out.println("Acount Name are displayed in the Ascending order");
		} else {
			System.out.println("Acount Name are displayed in the Ascending order");
		}
	}
}
