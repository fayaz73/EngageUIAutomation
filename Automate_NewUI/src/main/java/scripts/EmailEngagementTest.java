package scripts;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.ChannelSummaryPage;
import pom.EmailChannelEngageListPage;
import pom.EmailEngagementCreationPage;
import pom.SegmentPage;
import utilities.ODFUtils;

public class EmailEngagementTest extends BaseTest{
	
	String username1 = "bank";
	String pwd1 = "123$Urbanladder";
	String passcode1 = "NA";
	String SegmentName3 = "callcenterAuto";
	SegmentPage sp;
	ChannelSummaryPage cp;
	EmailChannelEngageListPage Emaill;
	EmailEngagementCreationPage Emailc;
	String engageName = "emailenagement";
	String msg = "message goes here";
	String labelname = "Product";
	String FromContact1= "faiyazahamed73@gmail.com";
	String ReplyToContact1="maxwell.arackal@lemnisk.co";
	String preview1="preview goes ehre";
	String subject1 = "subject text goes here";
	String scheduleType1 = "On Trigger";
	String parameter1 = "Immediately";

	@BeforeClass
	public void instances(){
		
		sp = new SegmentPage(driver);
		cp = new ChannelSummaryPage(driver);
		Emaill = new EmailChannelEngageListPage(driver);
		Emailc = new EmailEngagementCreationPage(driver);
		login(username1,pwd1,passcode1);
		sp.FindandClickSegment(SegmentName3);
		sp.channelBtnClick();
		cp.clickEmailTab();
	}
	
	@Test (enabled=true, dataProvider="getData")
	public void createEmailEngagement(String engageName,String msg,String labelname, String FromContact1, String ReplyToContact1,String preview1,String subject1,String scheduleType1, String parameter1) throws InterruptedException {
		Emaill.addEngagementBtnClick();
		Emailc.EngageNameInputbox(engageName);
		Emailc.enterMessage(msg);
		Emailc.labelBtnclick();
		Emailc.selectLabel(labelname);
		Emailc.fromDropDown();
		Emailc.selectFrom(FromContact1);
		Emailc.ReplyToDropDown();
		Emailc.selectReplyTo(ReplyToContact1);
		Emailc.enterTextPreview(preview1);
		Emailc.enterSubjectTextBox(subject1);
		Emailc.scheduleExpandCollapse();
		Emailc.ScheduleDropDown();
		Emailc.scheduleList(scheduleType1, parameter1);
		Emailc.saveEngageBtn();
		Emailc.messageTextBoxClear();
		Emailc.enterMessage("message text goes here");
		Emailc.previewtTextBoxClear();
		Emailc.enterTextPreview("preview text goes here");
		Emailc.subjectTextBoxClear();
		Emailc.enterSubjectTextBox("subject text goes here");
		Emailc.saveEngageBtn();
	}
	
	@DataProvider
	public  String[][] getData(Method method) throws Exception
	{
		
		String path = System.getProperty("user.dir")+"/testdata/EmailData.ods";
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
