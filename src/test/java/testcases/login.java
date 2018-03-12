package testcases;


import org.testng.annotations.Test;
import pages.Login;
import testbase.testbase;

public class login extends testbase
{		
	@Test
	public void logincall()
	{
		Boolean Flag = false ;
		try
		{			
			Login lgin = new Login();
			String acctype = ReadfromPropertyFile("AccountType");
			Flag = lgin.accountlogin(acctype);	
			if (Flag)
			{
				UpdateResults("Pass");	
			}
			else 
			{
				UpdateResults("Fail");				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}	
}
