package UtilitiesFile;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCaseFile.TestCase;

public class ExtentReportList extends TestCase implements ITestListener
{
	 
		  
		 
			ExtentSparkReporter createReport;
			ExtentReports createTest;
			ExtentTest createLog;
			
			void setup1()
			{
				createReport =new ExtentSparkReporter("Report1.html");
				createTest=new ExtentReports();
				createTest.attachReporter(createReport);
				
				createTest.setSystemInfo("OPERATING SYSTEM", "WINDOW");
				createTest.setSystemInfo("TESTER NAME", "BHAVIN");
				createTest.setSystemInfo("ENV", "TESTING");
				createTest.setSystemInfo("BROWSER", "CHROME");

				createReport.config().setDocumentTitle("My Project Report1");
				createReport.config().setReportName(" First Report");
				createReport.config().setTheme(Theme.DARK);
			}
			public void onStart(ITestContext Result)
			{
				setup1();
				System.out.println("On Start");
			}
			public void onFinish(ITestContext Result)
			{
				createTest.flush();
				System.out.println("On Finish call");
			}

			public void onTestStart(ITestResult Result)
			{
				System.out.println("OnTestStart");
			}
			public void onTestSuccess(ITestResult Result)
			{
				createLog=createTest.createTest(Result.getName());
				createLog.log(Status.PASS,MarkupHelper.createLabel("This test case is pass",ExtentColor.GREEN));
			}
			public void onTestFailure(ITestResult Result)
			{
				try {
					ScreenShot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				createLog=createTest.createTest(Result.getName());
					createLog.log(Status.FAIL,MarkupHelper.createLabel("This test case is Fail",ExtentColor.RED));
					String path="C:\\Users\\TSL\\Desktop\\java\\core java workspace\\seleniumFramework\\ScreenShot\\hello4.png";
					createLog.addScreenCaptureFromPath(path);
			}
			public void onTestSkipped(ITestResult Result)
			{

				createLog=createTest.createTest(Result.getName());
				createLog.log(Status.SKIP,MarkupHelper.createLabel("This test case is skipped",ExtentColor.YELLOW));
			}
		}



