package utilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// This is listener class used to generate Extent Report
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import scripts.BaseTest;

public class Reporting extends TestListenerAdapter 
{
	//public ExtentHtmlReporter htmlReporter;
	//public ExtentReports extent;
	/*
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Fayaz");
		
		htmlReporter.config().setDocumentTitle("Lemnisk Engage Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	*/
	
	public ExtentTest test;
	int i =  0;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentReports extent = ExtReport.getReport(); 
	public void onTestStart(ITestResult tr) 
	{	
		this.i = this.i+1;
		test = extent.createTest(tr.getName()+this.i);
		extentTest.set(test);
		extent.flush();
	}
	
	
	
	public void onTestSuccess(ITestResult tr)
	{
		//System.out.println(tr.getAttribute("engagaName").toString());
		//logger=extent.createTest(tr.getName()+this.i); // create new entry in th report
		extentTest.get().log(Status.PASS,MarkupHelper.createLabel(tr.getName()+this.i,ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		extent.flush();
	}
	
	public void onTestFailure(ITestResult tr)
	{
		//this.i = this.i+1;
		//logger=extent.createTest(tr.getName()+this.i); // create new entry in th report
		extentTest.get().log(Status.FAIL,MarkupHelper.createLabel(tr.getName()+this.i,ExtentColor.RED));// send the passed information to the report with GREEN color highlighted
	    test.error(tr.getThrowable());
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+this.i+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			extentTest.get().fail("Screenshot is below:" + extentTest.get().addScreenCaptureFromPath(screenshotPath));
			
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		extent.flush();
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		//logger=extent.createTest(tr.getName()); // create new entry in th report
		extentTest.get().log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		extent.flush();
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
		
	}
	
}