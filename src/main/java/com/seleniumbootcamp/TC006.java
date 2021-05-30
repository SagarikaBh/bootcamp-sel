package com.seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006 extends BaseClass {

	@Test(threadPoolSize=2,invocationCount=2)
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

		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()=\"Close Date\"]"));

		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()=\"Close Date\"]"));

	}

}
