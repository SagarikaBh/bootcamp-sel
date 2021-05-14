package com.seleniumbootcamp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

	public static void main(String[] args) throws InterruptedException {	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		List<WebElement> lightningSwitch = driver.findElementsByXPath("//a[@class='switch-to-lightning']"); if(lightningSwitch.size() !=0) { driver.findElementByXPath("//a[@class='switch-to-lightning']").click(); }
		driver.executeScript("arguments[0].click();",driver.findElementByXPath("//span[@class=\"uiImage\"]//img[@class=\"icon noicon\"]"));
		Thread.sleep(4000);
		driver.findElementByClassName("slds-icon-waffle").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//a[@title='Leads']"));	
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//a[@title='New']"));
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//input[@name='salutation']"));
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[@title='Mr.']"));
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@name='lastName' and @type='text']").sendKeys("LastName123");
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@name='Company']").sendKeys("XYZ");
		Thread.sleep(5000);
		driver.findElementByXPath("//button[@name='SaveEdit']").click();
		Thread.sleep(3000);
		String str = driver.findElementByXPath("//div[contains(@class, 'forceToastMessage') and @data-key='success']//span[contains(@class, 'forceActionsText')]").getText();		
		if(str.matches("Lead (.*) was created.")) {
			System.out.println("Test case Passed!!!");
		} else {
			System.out.println("Test case Failed!!!");
		}
		Thread.sleep(5000);
		//driver.close();
	}

}