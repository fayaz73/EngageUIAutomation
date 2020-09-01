package scripts;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.DriverInit;
import pom.ChannelSummaryPage;
import pom.EmailChannelEngageListPage;
import pom.EmailEngagementCreationPage;
import pom.SegmentPage;
import pom.WPNChannelEngageListPage;
import pom.WPNEngagementCreationPage;
import utilities.ODFUtils;

public class WPNEngagementTest extends BaseTest {

	String username1 = "bank";
	String pwd1 = "123$Urbanladder";
	String passcode1 = "NA";
	String SegmentName3 = "segment-exist-001";
	SegmentPage sp;
	ChannelSummaryPage cp;
	WPNChannelEngageListPage WPNl;
	WPNEngagementCreationPage WPNc;
	Logger logger;
	WebDriver driver;
	/*
	String engageName = "wpn_enagement";
	String labelname = "Personal Loan";
	String title = "title goes here";
	String message = "message goes here";
	String targetPage = "https://www.google.com/<script>alert()</script>";
	String text = "buttontext";
	String targetpage2 = "https://www.google.com/<script>alert()</script>";
	String fallbacktitle = "fallback title goes here";
	String fallbackMessage = "fallback message goes here";
	String fallbackTargetPage = "https://www.google.com/<script>alert()</script>";
	String scheduleType = "On Trigger";
	String parameter = "Immediately";
	*/
	int i = 0;
	boolean flg;
	int k = 0;
	String actualOutput;
	
	@Parameters("browsers")
	@BeforeClass
	public void instances(String br){
		//DriverInit instanceDriver = DriverInit.getInstance();
		driver = getDriver();
		System.out.println("Test1 thread is :"+Thread.currentThread().getId());
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get(baseURL);
		//WebDriver driver1 = driver;
		sp = new SegmentPage(driver);
		cp = new ChannelSummaryPage(driver);
		WPNl = new WPNChannelEngageListPage(driver);
		WPNc = new WPNEngagementCreationPage(driver);
		logger = Logger.getLogger("WPNEngagementTest");
		PropertyConfigurator.configure("log4j.properties");
		login(username1,pwd1,passcode1);
		logger.info("User logged in successfully");
		sp.FindandClickSegment(SegmentName3);
		logger.info("segment is found");
		sp.channelBtnClick();
		cp.clickWPNTab();
	}
	
	@Test(enabled=true, dataProvider= "getData")
	public void invalidWPNEngagement(String engageName, String title, String message, String targetPage, String labelname, String text, String targetpage2,String fallbacktitle, String fallbackMessage, String fallbackTargetPage, String scheduleType, String parameter, String expectedOutput) throws InterruptedException {
		try {
		     WPNl.addEngagementBtnClick();
		}
		catch(Exception e) {
			 WPNc.BackButtonClick();
			 WPNl.addEngagementBtnClick();
		}
		logger.info("startfirstTestmethod");
		WPNc.EngageNameInputbox(engageName);
		WPNc.NotificationTitleTextBox(title);
		WPNc.NotificationMessageBox(message);
		WPNc.TargetPage(targetPage);
		WPNc.NotificationImageBtn();
		//Thread.sleep(7000);
		WPNc.NotificationImage();
		Thread.sleep(3000);
		WPNc.labelBtnclick();
		WPNc.selectLabel(labelname);
		WPNc.expandCollapseGeneralSettings();
		WPNc.expandOptionalSettings();
		WPNc.ButtonImgageBtn();
		//Thread.sleep(8000);
		WPNc.ButtonIconImage();
		Thread.sleep(3000);
		WPNc.TextInputBox(text);
		WPNc.ButtonTargetPage(targetpage2);
		WPNc.expandOptionalSettings();
		WPNc.FallbackSetting();
		WPNc.fallbackTitle(fallbacktitle);
		WPNc.fallbackMessage(fallbackMessage);
		WPNc.fallbackTargetPage(fallbackTargetPage);
		WPNc.fallbackNotificationImageBTN();
		//Thread.sleep(8000);
		WPNc.fallbackNotificationImage();
		Thread.sleep(5000);
		WPNc.FBlabelBtnclick();
		WPNc.selectFBLabel(labelname);
		WPNc.scheduleExpandCollapse();
		WPNc.ScheduleDropDown();
		WPNc.scheduleList(scheduleType, parameter);
		WPNc.saveEngageBtn();
		
		try {
			flg = WPNc.isValidationMessageDisplayed();
			if(flg==true) {
				actualOutput = WPNc.getActualOutput();
				if(WPNc.getMessageType().contentEquals("ant-message-custom-content ant-message-error")) {
					WPNc.BackButtonClick();
				}
			}
		} catch (Exception e) {
			flg = false;
		}
		try {
			this.i =this.i +1;
			verification(actualOutput,expectedOutput,"invalidWPNEngagement"+this.i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WPNc.TextInputBox(text);
	}
	
	
	@Test(enabled=false, dataProvider= "getData")
	public void validInputWPNEngagement(String engageName, String title, String message, String targetPage, String labelname, String text, String targetpage2,String fallbacktitle, String fallbackMessage, String fallbackTargetPage, String scheduleType, String parameter, String expectedOutput) throws InterruptedException {
		WPNl.addEngagementBtnClick();
		WPNc.EngageNameInputbox(engageName);
		WPNc.NotificationTitleTextBox(title);
		WPNc.NotificationMessageBox(message);
		WPNc.TargetPage(targetPage);
		WPNc.NotificationImageBtn();
		//Thread.sleep(7000);
		WPNc.NotificationImage();
		Thread.sleep(3000);
		WPNc.labelBtnclick();
		WPNc.selectLabel(labelname);
		WPNc.expandCollapseGeneralSettings();
		WPNc.expandOptionalSettings();
		WPNc.ButtonImgageBtn();
		//Thread.sleep(8000);
		WPNc.ButtonIconImage();
		Thread.sleep(3000);
		WPNc.TextInputBox(text);
		WPNc.ButtonTargetPage(targetpage2);
		WPNc.expandOptionalSettings();
		WPNc.FallbackSetting();
		WPNc.fallbackTitle(fallbacktitle);
		WPNc.fallbackMessage(fallbackMessage);
		WPNc.fallbackTargetPage(fallbackTargetPage);
		WPNc.fallbackNotificationImageBTN();
		//Thread.sleep(8000);
		WPNc.fallbackNotificationImage();
		Thread.sleep(5000);
		WPNc.FBlabelBtnclick();
		WPNc.selectFBLabel(labelname);
		WPNc.scheduleExpandCollapse();
		WPNc.ScheduleDropDown();
		WPNc.scheduleList(scheduleType, parameter);
		WPNc.saveEngageBtn();
		
		
		try {
			flg = WPNc.isValidationMessageDisplayed();
			if(flg==true) {
				actualOutput = WPNc.getActualOutput();
				if(WPNc.getMessageType().contentEquals("ant-message-custom-content ant-message-error")) {
					WPNc.BackButtonClick();
				}
			}
			
		} catch(Exception e) {
			flg = false;
		}
		
		try {
			this.i =this.i +1;
			verification(expectedOutput,actualOutput,"validInputWPNEngagement"+this.i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@DataProvider
	public  String[][] getData(Method method) throws Exception
	{
		
		String sheetname = null;
		if (method.getName().contentEquals("invalidWPNEngagement"))
		{
			sheetname = "invalidWPNEngagement";
		}
		else if (method.getName().contentEquals("validInputWPNEngagement")) {
			sheetname = "validInputWPNEngagement";
		}
		
		String path = System.getProperty("user.dir")+"/testdata/WPNData.ods";
		int rownum = ODFUtils.getRowCount(path,sheetname);
		int colcount = ODFUtils.getCellCount(path,sheetname,1);
		String logindata[][] = new String[rownum-1][colcount];
		System.out.println("row count = "+rownum);
		System.out.println("column count =" +colcount);
		for (int i = 1; i<rownum; i++) {
			for (int j=0; j<colcount; j++) {
				logindata[i-1][j]=ODFUtils.getCellData(path,sheetname,i,j);
				//System.out.println(logindata[i-1][j]);	
			}	
		}	
	return logindata;  
	}
	
	public void verification(String actualOP, String expectedOP, String TestCaseName) throws IOException {
		if (actualOP.contentEquals(expectedOP)) {
			flg = true;
			System.out.println("flag is : " + flg);
			Assert.assertTrue(flg);
		}else {
			flg = false;
			captureScreen(driver, TestCaseName);
			System.out.println("flag is : " + flg);
			Assert.assertTrue(flg);
		}
	}
	
}
