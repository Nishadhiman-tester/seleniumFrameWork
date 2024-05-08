package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectFile.LoginClass;
import UtilitiesFile.DataDriven;

public class TestCase extends Base {
	
	
	@Test(dataProvider="DataPro")
	void openUrl(String user,String pass)
	{
	lg.info("URL Opened");
	driver.get(url);
	lg.info("Browser Opened");
LoginClass lc=new LoginClass(driver);
lg.info("Enter username");
lc.username1(user);
lg.info("Enter password");
lc.password1(pass);
lg.info("Submit button clicked");
lc.submit1();
	}
	@DataProvider(name="DataPro")
	
    public Object[][] setData() throws Exception
		{
			String filename="C:\\Users\\TSL\\Desktop\\sheet1.xlsx";
			int row=DataDriven.getRowCount(filename,"Sheet1");
			int col= DataDriven.getColCount(filename,"Sheet1");
			Object[][] s1=new Object [row][col];
			
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
				s1[i][j]=DataDriven.getCellValue(filename, "Sheet1", i, j);
			}
		}
	  return s2;
	}
}
