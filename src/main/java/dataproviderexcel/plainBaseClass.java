package dataproviderexcel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class plainBaseClass {
	public ChromeDriver driver ;
	public ChromeOptions options;
	
	@BeforeTest
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
//	List<WebElement> lightningSwitch = driver.findElementsByXPath("//a[@class='switch-to-lightning']"); 
//	if(lightningSwitch.size() !=0) 
//	{
//		driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
}
}