package com.seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallel {
	public ChromeDriver driver;
  @Test(threadPoolSize=5,invocationCount=5)
  public void one() 
  {
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		
  }
  
  @Test
  public void two() 
  {
	System.out.println("two");  
  }
  
  @Test
  public void three() 
  {
	System.out.println("three");  
  }
  
  @Test
  public void four() 
  {
	System.out.println("four");  
  }
  
  @Test
  public void five() 
  {
	System.out.println("five");  
  }
  
  @Test
  public void six() 
  {
	System.out.println("six");  
  }
  
  @Test
  public void seven() 
  {
	System.out.println("seven");  
  }
  
  @Test
  public void eight() 
  {
	System.out.println("eight");  
  }
  
  @Test
  public void nine() 
  {
	System.out.println("nine");  
  }
}
