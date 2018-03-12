package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.testbase;

public class Login extends testbase
{
	
	
	
	public Boolean accountlogin(String accountType)
	{
		Boolean flag = false ;		
		try
		{
			String username = inputfromExcel("Username");
			String pass = inputfromExcel("Password");
			WebElement lgotbtn = driver.findElement(By.xpath("//*[@id='root']"));
								
			switch (accountType)
			{			
			case "personal":
				
				driver.findElement(By.id("login_type_personal")).click();
				driver.findElement(By.id("personal_username")).clear();		
				driver.findElement(By.id("personal_username")).sendKeys(username);
				driver.findElement(By.xpath("//*[@id='personal_password']")).clear();
				driver.findElement(By.xpath("//*[@id='personal_password']")).sendKeys(pass);									
				WebElement loginbtn = driver.findElement(By.xpath("//*[@id='login_button']")) ;	
				loginbtn.click();				
				if (lgotbtn.isDisplayed())
				{
					flag = true ;						
				}	
				
				break;
				
			case "business":
				
				driver.findElement(By.xpath("//*[@id='login_type_business']")).click();
	    		driver.findElement(By.xpath("//*[@id='business_username']")).clear();
	    		driver.findElement(By.xpath("//*[@id='business_username']")).sendKeys(username);
	    		driver.findElement(By.xpath("//*[@id='business_password']")).clear();
	    		driver.findElement(By.xpath("//*[@id='business_password']")).sendKeys(pass);
	    		WebElement loginbtn2 = driver.findElement(By.xpath("//*[@id='login_button']"));
	    		loginbtn2.click();
	    		if (lgotbtn.isDisplayed())
				{
					flag = true ;						
				}				    		
	    		break;
			default:
				
				System.out.println("Account not valid");
				break;				
			}
		}				
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return flag ;
	}	
}
