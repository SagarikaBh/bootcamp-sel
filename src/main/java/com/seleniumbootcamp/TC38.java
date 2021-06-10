package com.seleniumbootcamp;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC38 extends BaseClass {

	    @Test(priority=1)
	    public void testCase38()throws InterruptedException {

		driver.executeScript("arguments[0].click();", driver.findElementByXPath(
				"//button[@class=\"bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader\" and @type=\"button\"]"));
		Thread.sleep(3000);
		driver.findElementByXPath("//button[contains(text(),\"View All\")]").click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll down the page by 1000 pixel vertical
		WebElement dashBordClick = driver
				.findElementByXPath("//p[@class=\"slds-truncate\" and normalize-space()=\"Dashboards\"]");
		js.executeScript("arguments[0].scrollIntoView();", dashBordClick);
		dashBordClick.click();
		driver.findElementByXPath("//div[@title=\"New Dashboard\" and normalize-space()=\"New Dashboard\"]").click();
		Thread.sleep(8000);
		driver.switchTo().frame(0);
		driver.findElementById("dashboardNameInput").sendKeys("Salesforce Automation by Sagarika");
		driver.findElementByXPath("//button[text()=\"Create\"]").click();
		Thread.sleep(4000);
		driver.executeScript("arguments[0].click();",
				driver.findElementByXPath("//span[@class=\"slds-truncate\" and text()='Dashboards']"));
		driver.findElementByXPath(
				"//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']")
				.sendKeys("Salesforce Automation by Sagarika");
		Thread.sleep(1000);
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//table/tbody/tr[1]/td[6]//button"));
		Thread.sleep(1000);
		driver.executeScript("arguments[0].click();",
				driver.findElementByXPath("//table/tbody/tr[1]/td[6]//span[text()=\"Delete\"]"));
		driver.findElementByXPath("//button[@type=\"button\"and @title=\"Delete\"]//span[text()='Delete']").click();
		Thread.sleep(3000);
	
		SoftAssert asert=new SoftAssert();
			
		String str = driver.findElementByXPath("//div[@class=\"slds-align-middle slds-hyphenate\"]//span").getText();
    	if(str.matches("ashboard was deleted.")) {
//			System.out.println("Test case Passed!!!");
    		asert.assertTrue(true);
		} else {
			//System.out.println("Test case Failed!!!");
			asert.assertFalse(false);
		}
		
		asert.assertAll();
	}

}
