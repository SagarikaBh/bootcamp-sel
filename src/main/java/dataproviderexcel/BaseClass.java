package dataproviderexcel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public ChromeDriver driver ;
	public ChromeOptions options;
	public String excelFileName;

	
    @Parameters({ "username", "password" })
	@BeforeClass(alwaysRun=true)
	public void lunchBrowser(String username, String password) throws InterruptedException {
    	System.out.println("username : " + username);
    	System.out.println("password : " + password);
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
		List<WebElement> lightningSwitch = driver.findElementsByXPath("//a[@class='switch-to-lightning']"); 
		if(lightningSwitch.size() !=0) 
		{
			driver.findElementByXPath("//a[@class='switch-to-lightning']").click();
			Thread.sleep(5000);
		}
		//driver.findElementByXPath("//div[@class=\"profile-card-footer\"]//a[contains(text(),'Switch')]").click();
		//Thread.sleep(10000);
	}
    
    @DataProvider(name="fetchData")
    public Object[][]sendData() throws IOException 
    {
    ReadExcelDataDataProvider excel=new ReadExcelDataDataProvider();
    return excel.excelRead(excelFileName);
    }

//	@AfterClass(alwaysRun=true)
//
//	public void closeApp() {
//		driver.close();
//	}
}
