package TestCaseFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import UtilitiesFile.ReadConfig;

public class Base {
	public static WebDriver driver;
	public static Logger lg;
	ReadConfig rc=new ReadConfig();
	String Bro=rc.getBrowser();
	String url=rc.geturl();
	@BeforeClass
	void browserLaunch()
	{
	switch(Bro.toLowerCase())
	{
	      case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			default:
				driver=null;
				break;
	}
	lg=LogManager.getLogger("/seleniumFramework");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

public void ScreenShot() throws IOException
{
File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File f2=new File("C:\\Users\\TSL\\Desktop\\java\\core java workspace\\seleniumFramework\\ScreenShot\\hello4.png");
FileUtils.copyFile(f1,f2);
}
	}
	
