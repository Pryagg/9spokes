package testbase;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Core.BaseFunctions;

public class testbase extends BaseFunctions
{
	public static WebDriver driver ;	
	
  @BeforeSuite	
	public void Init()
	{
		try
		{			
			// need to ask this, this is giving me an error as file rename
			/*Browser browser = new Browser();			
			driver = browser.get(Property.getPropertyValue("browser"));*/
			String browsername = ReadfromPropertyFile("Browser");
			if (browsername.equalsIgnoreCase("GoogleChrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");			
				driver = new ChromeDriver();	
			}
					
			navigate();
			SetBrowserSettings();	
			
		}
		catch(Exception e)
		{
			System.err.println("Got an error while initialising");
		}
}
	@Test
	public void testrun()
	{
		System.out.println("");
	}
	
	
	
	public void navigate()
	{
		try 
		{
			// get the value from property file
			//driver.get(Property.getPropertyValue("URL"));
			driver.get(ReadfromPropertyFile("Url"));
			//driver.get("https://login-example-app.firebaseapp.com/");			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());			
		}		
	}
	
	
	public void SetBrowserSettings()
	{
		try
		{
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		
	}
	
	//@AfterSuite
	public void TearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
	}
	
	
}

