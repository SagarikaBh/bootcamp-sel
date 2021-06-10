package dataproviderexcel;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase10 extends BaseClass {
	
	@BeforeTest
	public void setData()
	{
    excelFileName="./TestData/PracticeDataProvider.xlsx";

	}
		
   //19/12/2016
	@Test(dataProvider = "fetchData")
	public void testCase (String streetName, String cityName, String state,String zip,String country) throws InterruptedException
	{
		////span[@class="uiImage"]//img[contains(@class,"icon noicon")]
		Random random = new Random();
		
		driver.findElementByXPath("//span[@class=\"uiImage\"]//img[contains(@class,\"icon noicon\")]").click();
		driver.findElementByXPath("//div[@class=\"profile-card-footer\"]//a[contains(text(),'Switch')]").click();
		Thread.sleep(10000);
		driver.executeScript("arguments[0].click();",driver.findElementByXPath("//span[@id=\"createNewLabel\"]"));	
		driver.findElementByXPath("//div[@id=\"createNewMenu\"]//a[text()='Account']").click();
		Thread.sleep(8000);
		String accountName = "Boot Camp Puppeteer Sagarika " + random.nextInt(10000);
		driver.findElementByXPath("//input[@id=\"acc2\"]").sendKeys(accountName);
		driver.findElementByXPath("//textarea[@id=\"acc17street\"]").sendKeys(streetName);
		driver.findElementByXPath("//input[@id=\"acc17city\"]").sendKeys(cityName);
		driver.findElementByXPath("//input[@id=\"acc17state\"]").sendKeys(state);
		driver.findElementByXPath("//input[@id=\"acc17zip\"]").sendKeys(zip);
		driver.findElementByXPath("//input[@id=\"acc17country\"]").sendKeys(country);
		driver.findElementByXPath("//a[contains(text(),\"Copy Billing Address to Shipping Address\")]").click();
		driver.findElementByXPath("//span[starts-with(@class,\"dateInput\")]//input").click();
		//*****************need to validate field**************

		// get date 10 days from now
		LocalDate date = LocalDate.now().plus(10, ChronoUnit.DAYS);
		
		// Get expiryDate string
		String expirationDateString = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		System.out.println("expirationDateString : " + expirationDateString);
		//dynamic or customize xpath

		driver.findElementByXPath("//span[contains(@class, 'dateInput')]//input").sendKeys(expirationDateString);
		
		driver.findElementByXPath("//input[@name=\"save\"]").click();
		Thread.sleep(3000);
		
		WebElement recentItemEntry = driver.findElementByXPath("//div[@class=\"mruList individualPalette\"]/div[@class=\"accountBlock\"]//a[@class=\"accountMru\"]/span[text()=\""+accountName+"\"]");
		
		driver.findElementByXPath("//a[text()=\"Accounts\"]").click();
		
		String str1 = driver.findElementByXPath("//div[@class=\"pbBody\"]//table[@class=\"list\"]").getText();		
		if(str1.matches("(.*)Sagarika")) {
			System.out.println("Test case Passed!!!");
		} else {
			System.out.println("Test case Failed!!!");
		}
		List<WebElement> lightningSwitch1 = driver.findElementsByXPath("//a[@class='switch-to-lightning']"); if(lightningSwitch1.size() !=0) { driver.findElementByXPath("//a[@class='switch-to-lightning']").click(); }
	
		}

	
	}


