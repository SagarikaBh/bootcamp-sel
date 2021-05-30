package com.seleniumbootcamp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC23  extends BaseClass  {

	    @Test(threadPoolSize=2,invocationCount=2)
	    public void testCase23()throws InterruptedException, Exception {
		System.out.println("1st title"+driver.getTitle());
		Thread.sleep(13000);
		driver.findElementByXPath("//span[text()='Learn More']").click();
		Thread.sleep(8000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		// This will scroll down the page by 1000 pixel vertical
//		js.executeScript("arguments[0].scrollIntoView();", resourseLink);
		String ParentHandle = driver.getWindowHandle();
		System.out.println("Parent handle: " + ParentHandle);
//
//		// Get all Handles
//		Set<String> handles = driver.getWindowHandles();
//		// Switching between handles
//		for (String handle : handles) {
//			System.out.println("handles are" + handle);
//
//			if (!handle.equals(ParentHandle)) {
//				driver.switchTo().window(handle);
//				
//				}
//
//		}
		

        Set<String> allWindows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<>();
		windowsList.addAll(allWindows);
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowsList.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		Actions act=new Actions(driver);
		WebElement resourseLink = driver.findElementByXPath("//li[@id='solutions_menu_item']");
		act.moveToElement(resourseLink).perform();
		//driver.findElementByXPath("//li[@class='nav-item']//span[text()='Salesforce Certification ']").click();
		//li[@class='nav-item']//span[text()='Salesforce Certification ']
		driver.findElementByXPath("//span[@class='icon-sfdc-icon-offsite']/preceding-sibling::span[text()='Salesforce Certification ']/parent::a").click(); 
		 Set<String> allWindows1 = driver.getWindowHandles();
		List<String> windowsList1 = new ArrayList<>();
		windowsList1.addAll(allWindows1);
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowsList1.get(2));
		Thread.sleep(10000);
		driver.findElementByXPath("//div[text()='Salesforce Architect']//parent::a").click();
		//driver.findElementByXPath("//div[text() = 'Salesforce Architect']").click();
		//driver.findElementByXPath("//img[@alt = 'Example image of Salesforce Architect']").click();
		String str = driver.findElementByXPath("//div[contains (text(), 'Salesforce Architects are the most trusted digital')]").getText();
        System.out.println(str);
        driver.findElementByXPath("//div[contains (text(), 'Salesforce Architects are the most trusted digital')]").click();
        WebElement TechnicalArcitech=driver.findElementByXPath("(//img[contains (@alt, 'Salesforce Architect Journey certification path')])[1]");
        Actions act1 = new Actions(driver);
        act1.contextClick(TechnicalArcitech).perform();
        Robot robot = new Robot();
    
         robot.keyPress(KeyEvent.VK_DOWN);
         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_DOWN);
         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_ENTER);
         Thread.sleep(2000);
//         robot.keyPress(KeyEvent.VK_T);
//         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_ENTER);
         Thread.sleep(4000);
         
         WebElement solutionArcitech=driver.findElementByXPath("(//img[contains(@alt,'Salesforce Architect Journey certification path suggesting')])[2]");
         Actions act2 = new Actions(driver);
         act2.contextClick(solutionArcitech).perform();
        
         robot.keyPress(KeyEvent.VK_DOWN);
         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_DOWN);
         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_ENTER);
         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_ENTER);
         Thread.sleep(4000);
         
         for(int i = 1;i<=6;i++)
         {
        	 
     			String listOfSalesforceArchitectCertif = driver.findElementByXPath("//div[text() = 'Certification']/following:: a[contains(text(),'Architect')] ["+i+"]").getText();
     			System.out.println(listOfSalesforceArchitectCertif);
     			Thread.sleep(2000);
     		
//        	 String listOfSalesforceArchitectCertif=driver.findElementByXPath("//div[text() = 'Certification']/following-sibling::div/a["+i+"]").getText();
//        	 System.out.println("list Of Salesforce Architect Certif:"+listOfSalesforceArchitectCertif);
//        	 Thread.sleep(2000);
         }
        
         driver.findElementByXPath("//a[contains(text(),'Application Architect')]").click();
         for(int i = 1;i<=7;i++)
         {
     			String text2 = driver.findElementByXPath("//div[text() = 'Certification']/following:: a ["+i+"]").getText();
     			System.out.println(text2);
     			i++;
         }
		
	}

}
