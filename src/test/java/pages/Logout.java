package pages;

import org.openqa.selenium.By;
import testbase.testbase;

public class Logout extends testbase
{
	public void account_logout(String accountType)
	{
		try
		{
			
			switch (accountType)			
			{
			
			case "personal":
				driver.findElement(By.xpath("//*[@id='root']")).click();				
				break;
				
			case "business" :
				driver.findElement(By.xpath("//*[@id='root']")).click();			
			break;

			default:
				System.out.println("Account does not exist");
				break;
			}
						
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
