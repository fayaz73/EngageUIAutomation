package scripts;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.ChannelSummaryPage;
import pom.SegmentPage;
import pom.TriggerApiChannelsEngageCreationPage;
import pom.TriggerApiChannelsEngageListPage;
import utilities.ODFUtils;

public class CallCenterEngagementTest extends BaseTest {
	String username1 = "bank";
	String pwd1 = "123$Urbanladder";
	String passcode1 = "NA";
	String SegmentName3 = "callcenterAuto";
	SegmentPage sp;
	ChannelSummaryPage cp;
	TriggerApiChannelsEngageListPage tp;
	TriggerApiChannelsEngageCreationPage tc;
	String engageName;
	String apiname;
	String labelname;
	String prodChecked;
	String SubProductName;
	String offeramount;
	String firstname;
	String lastname;
	String scheduleType1;
	String parameter1;
	String scheduleType2 = "Later";
	String month1 = "Sep";
	String year1 = "2020";
	String day1 = "19";
	String hour1= "10";
	String minutes1 = "24";
	String seconds1 = "32";
	String parameter2 = month1+","+year1+","+day1+","+hour1+","+minutes1+","+seconds1;
	String parameter3 = month1+","+year1+","+day1+","+hour1+","+minutes1;
	boolean flg;
	
	@BeforeClass
	public void instances(){
		
		sp = new SegmentPage(driver);
		cp = new ChannelSummaryPage(driver);
		tp = new TriggerApiChannelsEngageListPage(driver);
		tc = new TriggerApiChannelsEngageCreationPage(driver);
		login(username1,pwd1,passcode1);
		sp.FindandClickSegment(SegmentName3);
		sp.channelBtnClick();
		cp.callCenterTabClick();
	}
	
	/*
	@BeforeMethod
	public void segmentClick() throws InterruptedException {
		Thread.sleep(5000);
		sp.FindandClickSegment(SegmentName3);
		sp.channelBtnClick();
		cp.callCenterTabClick();	
	}
	*/
	@Test(enabled=true, dataProvider="getData")
	public void engageCreateOnTriggerTest(String engageName, String apiname, String labelname, String prodChecked, String SubProductName, String offeramount, String firstname, String lastname, String scheduleType1, String parameter1) throws InterruptedException {
		//engageName = engageName+"Trigger";
		tp.addEngagementBtnClick();
		tc.EngageNameInputbox(engageName);
		tc.selectApiDropDown();
		Thread.sleep(5000);
		tc.selectApiList(apiname);
		tc.labelBtnclick();
		tc.selectLabel(labelname);
		tc.productCheckedInput(prodChecked);
		tc.SubProductNameInput(SubProductName);
		tc.OfferAmountInput(offeramount);
		tc.FristNameCheckbox();
		tc.FirstNameInputBox(firstname);
		tc.LastNameCheckbox();
		tc.LastNameInputBox(lastname);
		tc.getClassNameExpandCollapse();
		tc.ScheduleDropDown();
		tc.scheduleList(scheduleType1,parameter1);
		tc.saveEngageBtn();
		Thread.sleep(10000);
		flg = tp.FindandClickEngagement(engageName);
		if (flg) {
			tc.verifyEngagementName(engageName);
			tc.verifySelectedApi(apiname);
			tc.verifyLabelValue(labelname);
			tc.verifyproductCheckedInput(prodChecked);
			tc.verifySubProductNameInput(SubProductName);
			tc.verifyOfferAmountInput(offeramount);
			tc.verifyLastNameInputbox(lastname);
			tc.getClassNameExpandCollapse();
			tc.verifyScheduleTriggerOption(scheduleType1);
			tc.verifyScheduleTriggerValue(parameter1);
			tc.BackButtonClick();
			Thread.sleep(10000);
		}
	}
	
	@Test(enabled=false)
	public void engageCreateLaterTest() throws InterruptedException {
		engageName = engageName+"Later";
		tp.addEngagementBtnClick();
		tc.EngageNameInputbox(engageName);
		tc.selectApiDropDown();
		Thread.sleep(5000);
		tc.selectApiList(apiname);
		tc.labelBtnclick();
		tc.selectLabel(labelname);
		tc.productCheckedInput(prodChecked);
		tc.SubProductNameInput(SubProductName);
		tc.OfferAmountInput(offeramount);
		tc.FristNameCheckbox();
		tc.FirstNameInputBox(firstname);
		tc.LastNameCheckbox();
		tc.LastNameInputBox(lastname);
		tc.getClassNameExpandCollapse();
		tc.ScheduleDropDown();
		tc.scheduleList(scheduleType2,parameter2);
		tc.saveEngageBtn();
		flg = tp.FindandClickEngagement(engageName);
		if (flg) {
			tc.verifyEngagementName(engageName);
			tc.verifySelectedApi(apiname);
			tc.verifyLabelValue(labelname);
			tc.verifyproductCheckedInput(prodChecked);
			tc.verifySubProductNameInput(SubProductName);
			tc.verifyOfferAmountInput(offeramount);
			tc.verifyLastNameInputbox(lastname);
			tc.getClassNameExpandCollapse();
			tc.verifyScheduleTriggerOption(scheduleType2);
			tc.verifyLaterOptions(parameter3);
			
		}
		
	}
	
	public void verification(boolean flag, String TestCaseName) throws IOException {
		if (flag) {
			System.out.println("flag is : " + flg);
			Assert.assertTrue(flg);
		}else {
			captureScreen(driver, TestCaseName);
			System.out.println("flag is : " + flg);
			Assert.assertTrue(flg);
		}
	}
	
	/*
	@DataProvider
	public String[][] getData3(Method method) throws Exception {
		String path = System.getProperty("user.dir")+"/testdata/CallCentreData.ods";
		int rownum = ODFUtils.getRowCount(path,"Sheet1");
		int colcount = ODFUtils.getCellCount(path,"Sheet1",0);
		String data[][] = new String[2][rownum-2];
		int m = 0, n = 0;
		String tc[] = ODFUtils.getColumndata(path,"Sheet1");
		for (int k =0; k<tc.length; k++  )
			{
			
				for (int i = 2; i<rownum; i++) {
					if (method.getName().equals(tc[k])) {
						data[m][n]=ODFUtils.getCellData(path,"Sheet1",i,ODFUtils.testcases[k]);
						n = n+1;
					}
			
				}	
			m = m+1;
			n=0;
			}
		
		return data;
	}
	*/
	
	@DataProvider
	public  String[][] getData(Method method) throws Exception
	{
		
		String path = System.getProperty("user.dir")+"/testdata/CallCentreData.ods";
		int rownum = ODFUtils.getRowCount(path,"Sheet1");
		int colcount = ODFUtils.getCellCount(path,"Sheet1",1);
		String logindata[][] = new String[rownum-1][colcount];
		System.out.println("row count = "+rownum);
		System.out.println("column count =" +colcount);
		for (int i = 1; i<rownum; i++) {
			for (int j=0; j<colcount; j++) {
				logindata[i-1][j]=ODFUtils.getCellData(path,"Sheet1",i,j);
				System.out.println(logindata[i-1][j]);
				
			}
			
		}
		
		
	return logindata;  
	}
	
	
	
}
