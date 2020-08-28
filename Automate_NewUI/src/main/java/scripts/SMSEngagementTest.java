package scripts;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.ChannelSummaryPage;
import pom.SMSChannelEngageListPage;
import pom.SMSEngagementCreationPage;
import pom.SegmentPage;
import utilities.ODFUtils;

public class SMSEngagementTest extends BaseTest {
	
	String username1 = "bank";
	String pwd1 = "123$Urbanladder";
	String passcode1 = "NA";
	String SegmentName3 = "callcenterAuto";
	SegmentPage sp;
	ChannelSummaryPage cp;
	SMSChannelEngageListPage smsl;
	SMSEngagementCreationPage smsc;

	@BeforeClass
	public void instances(){
		
		sp = new SegmentPage(driver);
		cp = new ChannelSummaryPage(driver);
		smsl = new SMSChannelEngageListPage(driver);
		smsc = new SMSEngagementCreationPage(driver);
		login(username1,pwd1,passcode1);
		sp.FindandClickSegment(SegmentName3);
		sp.channelBtnClick();
		cp.clickSMSTab();
	}
	
	@Test (enabled=true, dataProvider="getData")
	public void createSMSEngagement(String engageName, String promote, String labelname, String message, String scheduleType1, String parameter1) throws InterruptedException {
		smsl.addEngagementBtnClick();
		smsc.EngageNameInputbox(engageName);
		smsc.selectMessageTypeDown();
		//smsc.selectMessageType(promote);
		smsc.labelBtnclick();
		smsc.selectLabel(labelname);
		smsc.NotificationMessage(message);
		smsc.scheduleExpandCollapse();
		smsc.ScheduleDropDown();
		smsc.scheduleList(scheduleType1, parameter1);
		smsc.saveEngageBtn();
		Thread.sleep(5000);
		smsc.messageBoxClear();
		smsc.NotificationMessage("Valid message goes here");
		try {
			smsc.saveEngageBtn();
		}
		catch(Exception e) {
			smsc.BackButtonClick();
		}
		
		//smsc.BackButtonClick();
		
	}
	
	
	@DataProvider
	public  String[][] getData(Method method) throws Exception
	{
		
		String path = System.getProperty("user.dir")+"/testdata/SMSData.ods";
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
