package Core;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class BaseFunctions 
{
	public void SetText(WebElement TextWebelement,  String Text)
	{
		try
		{
			TextWebelement.sendKeys(Text);			
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public void ClickLink(WebElement ClickWebelement)
	{
		try
		{			
			ClickWebelement.click();			
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public String ReadfromPropertyFile(String parameter)
	{		
		String valuestr = null;
		try
		{			
			Properties prop = new Properties();	
			FileInputStream input = new FileInputStream(new File("./src/test/java/config/config.properties"));			
			prop.load(input);				
			valuestr = prop.getProperty(parameter);				
		}
		catch(Exception e )
		{
			e.printStackTrace();			
		}
		return valuestr ;
	}	
	
	public String inputfromExcel(String returnField)
	{
		String fieldValue = null ;
		try
		{			
		Fillo fillo = new Fillo();
		//Connection connection=fillo.getConnection("D:\\accountType.xlsx");		
		Connection connection=fillo.getConnection("./src/test/resources/DataTables/accountType.xlsx");				
		String acctype = ReadfromPropertyFile("AccountType");		
		String strquery = "Select *from Sheet1 where AccountType=" + "'" + acctype + "'" ;
		Recordset recordset = connection.executeQuery(strquery);		
		
		while (recordset.next()) 
		{
		    fieldValue = recordset.getField(returnField);						
		}			
		recordset.close();
		connection.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();			
		}	
		return fieldValue ;		
	}
	
	public void UpdateResults(String texttobeUpdated)
	{
		try
		{
			
		Fillo fillo = new Fillo();
		Connection connection=fillo.getConnection("./src/test/resources/DataTables/accountType.xlsx");		
		String acctype = ReadfromPropertyFile("AccountType");		
		String strquery = "Update Sheet1 set Results = '" + texttobeUpdated + "'"+ " where AccountType=" + "'" + acctype + "'" ;				
		connection.executeUpdate(strquery);		
		connection.close();
		}		
		catch(Exception e)
		{
			e.printStackTrace();			
		}		
	}	
	
}
