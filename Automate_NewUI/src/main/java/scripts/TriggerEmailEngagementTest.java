package scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ChannelSummaryPage;
import pom.SegmentPage;
import pom.TriggerApiChannelsEngageCreationPage;
import pom.TriggerApiChannelsEngageListPage;

public class TriggerEmailEngagementTest extends BaseTest {
	String username1 = "fayaz.ahamed@vizurycn.com";
	String pwd1 = "123$Fayaz";
	String passcode1 = "NA";
	String SegmentName3 = "callcenterAuto";
	SegmentPage sp;
	ChannelSummaryPage cp;
	TriggerApiChannelsEngageListPage tp;
	TriggerApiChannelsEngageCreationPage tc;
	String engageName = "AppPushEngage1";
	String apiname = "DataFetcher";
	String labelname = "Personal Loan";
	String prodChecked = "prod1";
	String SubProductName = "subProd1";
	String offeramount = "1234567";
	String firstname = "fname";
	String lastname = "lname";
	String scheduleType1 = "On Trigger";
	String parameter1 = "Immediately";
	String scheduleType2 = "Later";
	String month1 = "Sep";
	String year1 = "2020";
	String day1 = "19";
	String hour1= "15";
	String minutes1 = "45";
	String seconds1 = "52";
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
	}
	
	@BeforeMethod
	public void segmentClick() {
		sp.FindandClickSegment(SegmentName3);
		sp.channelBtnClick();
		cp.triggerEmailClick();	
	}
	
	@Test(enabled=false)
	public void engageCreateOnTriggerTest() throws InterruptedException {
		engageName = engageName+"Trigger";
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
	
	@Test(enabled=true)
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
		//tc.DatePickerClick();
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

}
