package com.seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class incomplete {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys();
		driver.findElementById("password").sendKeys();	
		driver.findElementById("Login").click();
		driver.findElementByClassName("slds-icon-waffle").click();	
		driver.findElementByXPath("//button[text()='View All']").click();	
		driver.findElementByXPath("//p[text()='Sales']").click();	
		driver.findElementByLinkText("Leads").click();	
		driver.findElementByLinkText("New").click();
		driver.findElementByName("salutation").click();	
		driver.findElementByXPath("//span[@title='Mr.']").click();	
		driver.findElementByName("lastName").sendKeys();	
		driver.findElementByName("Company").sendKeys();	
		driver.findElementByName("SaveEdit").click();	
		driver.findElementByXPath("//div[contains(@class, 'forceToastMessage') and @data-key='success']//span[contains(@class, 'forceActionsText')]\r\n" + 
				"").getText();	
		
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
	
		

	}

}
