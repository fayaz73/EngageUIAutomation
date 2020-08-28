package scripts;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.ChannelSummaryPage;
import pom.OnsiteChannelEngageListPage;
import pom.OnsiteEngagementCreationPage;
import pom.OnsiteEngagementCreationPage.TextImageSlider;
import pom.SegmentPage;
import pom.OnsiteEngagementCreationPage.ImageNonClickable;
import pom.OnsiteEngagementCreationPage.TextOnImage;
import pom.OnsiteEngagementCreationPage.TextOnImageNonClickable;
import pom.OnsiteEngagementCreationPage.TimerONImage;
import pom.OnsiteEngagementCreationPage.ResponsiveImgNonClickable;
import pom.OnsiteEngagementCreationPage.ResponsiveImageSliderDynlp;
import utilities.ODFUtils;

public class OnsiteEngagementTest extends BaseTest {
	
	String username1 = "bank";
	String pwd1 = "123$Urbanladder";
	String passcode1 = "NA";
	String SegmentName3 = "callcenterAuto";
	SegmentPage sp;
	ChannelSummaryPage cp;
	OnsiteChannelEngageListPage Onsitel;
	OnsiteEngagementCreationPage Onsitec;
	TextImageSlider objTextImgSlider;
	ImageNonClickable objImgNonClickable;
	TextOnImageNonClickable objTextOnImageNonClickable;
	TextOnImage objTextOnImage;
	TimerONImage objTimerOnImage;
	ResponsiveImgNonClickable objResponsiveImgNonclick;
	ResponsiveImageSliderDynlp objResponsivesliderImg;
	String engageName = "emailenagement";
	String Templatename = "Text Image Slider";
	String Templatename2 = "Image Non-Clickable";
	String labelname = "Credit Cards";
	String url = "https://www.google.com";
	String title = "<script>alert()</script>";
	String message = "<script>alert()</script>";
	String cta = "<script>alert()</script>";
	String position = "50";
	String Templatename3 = "Text on Image";
	String msg = "<script>alert()</script>";
	String msg2 = "<script>alert()</script>";
	String Templatename4 = "Text on Image Non-clickable";
	String Templatename5 = "Timer on Image";
	String timer = "2020-12-10-10:10:10";
	String fbTitle = "<script>alert()</script>";
	String fbMessage  = "<script>alert()</script>";
	String fbCTA = "<script>alert()</script>";;
	String timer2 = "2020-12-10-10:10:10";
	
	@BeforeClass
	public void instances(){
		
		sp = new SegmentPage(driver);
		cp = new ChannelSummaryPage(driver);
		Onsitel = new OnsiteChannelEngageListPage(driver);
		Onsitec = new OnsiteEngagementCreationPage(driver);
		objTextImgSlider = Onsitec.new TextImageSlider(driver);
		objImgNonClickable = Onsitec.new ImageNonClickable(driver);
		objTextOnImage = Onsitec.new TextOnImage(driver);
		objTextOnImageNonClickable = Onsitec.new TextOnImageNonClickable(driver);
		objTimerOnImage = Onsitec.new TimerONImage(driver);
		objResponsiveImgNonclick = Onsitec.new ResponsiveImgNonClickable(driver);
		objResponsivesliderImg = Onsitec.new ResponsiveImageSliderDynlp(driver);
		login(username1,pwd1,passcode1);
		sp.FindandClickSegment(SegmentName3);
		sp.channelBtnClick();
		cp.clickOnsiteTab();
	}
	
	
	@Test(enabled=false, priority = 1, dataProvider="getData")
	public void TextImageSider(String engageName, String Templatename, String url, String labelname, String position, String title, String message, String cta, String fbTitle, String fbMessage, String fbCTA) throws InterruptedException {
		Onsitel.addEngagementBtnClick();
		Onsitec.EngageNameInputbox(engageName);
		Onsitec.selectNotificationBtn();
		Thread.sleep(5000);
		Onsitec.selectNotificationStyle(Templatename);
		Onsitec.EnterURL(url);
		Onsitec.labelBtnclick();
		Onsitec.selectLabel(labelname);
		Onsitec.expandTemplateSetting();
		Onsitec.clickNotificationplacement();
		Onsitec.inputNotificationPostion(position);
		objTextImgSlider.clickExpandTextSetting();
		objTextImgSlider.clickDynamicRadioButton();
		Thread.sleep(5000);
		objTextImgSlider.enterTitleInput(title);
		objTextImgSlider.enterMessageInput(message);
		objTextImgSlider.enterCTATextInput(cta);
		objTextImgSlider.enterFBTitle(fbTitle);
		objTextImgSlider.enterFBMessage(fbMessage);
		objTextImgSlider.enterFBCTATextInput(fbCTA);
		objTextImgSlider.clickExpandImageSetting();
		Onsitec.NotificationImageclick();
		Thread.sleep(5000);
		Onsitec.selectNotificationImage();
		Onsitec.fblabelBtnclick();
		Onsitec.selectfbLabel(labelname);
		Onsitec.saveEngageBtn();
		Onsitec.BackButtonClick();
	}
	
	@Test(enabled=false, priority = 2, dataProvider="getData")
	public void ImageNonClickable(String engageName,String Templatename2, String url, String labelname, String position) throws InterruptedException {
		
		Onsitel.addEngagementBtnClick();
		Onsitec.EngageNameInputbox(engageName);
		Onsitec.selectNotificationBtn();
		Thread.sleep(5000);
		Onsitec.selectNotificationStyle(Templatename2);
		Onsitec.EnterURL(url);
		Onsitec.labelBtnclick();
		Onsitec.selectLabel(labelname);
		Onsitec.expandTemplateSetting();
		Onsitec.clickNotificationplacement();
		Onsitec.inputNotificationPostion(position);
		Onsitec.NotificationImageclick();
		Thread.sleep(5000);
		Onsitec.selectNotificationImage();
		Onsitec.saveEngageBtn();
	}
	
	@Test(enabled=false, priority = 3, dataProvider="getData")
	public void TextOnImage(String engageName, String Templatename3, String url, String labelname, String position, String msg, String msg2) throws InterruptedException {
		Onsitel.addEngagementBtnClick();
		Onsitec.EngageNameInputbox(engageName);
		Onsitec.selectNotificationBtn();
		Thread.sleep(5000);
		Onsitec.selectNotificationStyle(Templatename3);
		Onsitec.EnterURL(url);
		Onsitec.labelBtnclick();
		Onsitec.selectLabel(labelname);
		Onsitec.expandTemplateSetting();
		Onsitec.clickNotificationplacement();
		Onsitec.inputNotificationPostion(position);
		objTextOnImage.clickExpandTextSetting();
		objTextOnImage.clickDynamicRadioButton();
		Thread.sleep(5000);
		objTextOnImage.enterTestOnImageMessage(msg);
		objTextOnImage.enterFBTestOnImageMessage(msg2);
		objTextOnImage.clickExpandImageSetting();
		Onsitec.NotificationImageclick();
		Thread.sleep(5000);
		Onsitec.selectNotificationImage();
		Onsitec.fblabelBtnclick();
		Onsitec.selectfbLabel(labelname);
		Onsitec.saveEngageBtn();
	}
	
	@Test(enabled=false, priority = 4, dataProvider="getData")
	public void TextOnImageNonClickable(String engageName, String Templatename3, String url, String labelname, String position, String msg, String msg2) throws InterruptedException {
		Onsitel.addEngagementBtnClick();
		Onsitec.EngageNameInputbox(engageName);
		Onsitec.selectNotificationBtn();
		Thread.sleep(5000);
		Onsitec.selectNotificationStyle(Templatename4);
		Onsitec.EnterURL(url);
		Onsitec.labelBtnclick();
		Onsitec.selectLabel(labelname);
		Onsitec.expandTemplateSetting();
		Onsitec.clickNotificationplacement();
		Onsitec.inputNotificationPostion(position);
		objTextOnImageNonClickable.clickExpandTextSetting();
		objTextOnImageNonClickable.clickDynamicRadioButton();
		Thread.sleep(5000);
		objTextOnImageNonClickable.enterTestOnImageNonClickMessage(msg);
		objTextOnImageNonClickable.enterFBTestOnImageNonClickMessage(msg2);
		objTextOnImageNonClickable.clickExpandImageSetting();
		Onsitec.NotificationImageclick();
		Thread.sleep(5000);
		Onsitec.selectNotificationImage();
		Onsitec.fblabelBtnclick();
		Onsitec.selectfbLabel(labelname);
		Onsitec.saveEngageBtn();	
	}
	
	@Test(enabled=false, priority = 5, dataProvider="getData")
	public void TimerOnImage(String engageName,String Templatename5, String labelname,String position,String title,String message,String cta,String timer,String fbTitle, String fbMessage, String fbCTA, String timer2) throws InterruptedException {
		Onsitel.addEngagementBtnClick();
		Onsitec.EngageNameInputbox(engageName);
		Onsitec.selectNotificationBtn();
		Thread.sleep(5000);
		Onsitec.selectNotificationStyle(Templatename5);
		Onsitec.EnterURL(url);
		Onsitec.labelBtnclick();
		Onsitec.selectLabel(labelname);
		Onsitec.expandTemplateSetting();
		Onsitec.clickNotificationplacement();
		Onsitec.inputNotificationPostion(position);
		objTimerOnImage.clickExpandTextSetting();
		objTimerOnImage.clickDynamicRadioButton();
		objTimerOnImage.enterTitleInput(title);
		objTimerOnImage.enterMessageInput(message);
		objTimerOnImage.enterCTATextInput(cta);
		objTimerOnImage.selectTimerCheckBox();
		objTimerOnImage.enterTimerEnd(timer);
		objTimerOnImage.enterFBTitle(fbTitle);
		objTimerOnImage.enterFBMessage(fbMessage);
		objTimerOnImage.enterFBCTATextInput(fbCTA);
		objTimerOnImage.selectFBTimerCheckBox();
		objTimerOnImage.enterTimerEndFB(timer2);
		objTimerOnImage.clickExpandImageSetting();
		Onsitec.NotificationImageclick();
		Thread.sleep(5000);
		Onsitec.selectNotificationImage();
		Onsitec.fblabelBtnclick();
		Onsitec.selectfbLabel(labelname);
		Onsitec.saveEngageBtn();	
	}
	
	@Test (enabled=false, priority=6, dataProvider="getData" )
	public void ResponsiveImgNonClickable(String engageName,String Templatename2, String url, String labelname, String position) throws InterruptedException {
		Onsitel.addEngagementBtnClick();
		Onsitec.EngageNameInputbox(engageName);
		Onsitec.selectNotificationBtn();
		Thread.sleep(5000);
		Onsitec.selectNotificationStyle(Templatename2);
		Onsitec.EnterURL(url);
		Onsitec.labelBtnclick();
		Onsitec.selectLabel(labelname);
		Onsitec.expandTemplateSetting();
		Onsitec.clickNotificationplacement();
		Onsitec.inputNotificationPostion(position);
		Onsitec.NotificationImageclick();
		Thread.sleep(5000);
		Onsitec.selectNotificationImage();
		Onsitec.saveEngageBtn();
	}
	
	@Test (enabled=true, priority=7, dataProvider="getData")
	public void ResponsiveImageSliderDynLp(String engageName, String Templatename3, String url, String labelname, String position, String actionname, String targetpage) throws InterruptedException {
		Onsitel.addEngagementBtnClick();
		Onsitec.EngageNameInputbox(engageName);
		Onsitec.selectNotificationBtn();
		Thread.sleep(5000);
		Onsitec.selectNotificationStyle(Templatename3);
		Onsitec.EnterURL(url);
		Onsitec.labelBtnclick();
		Onsitec.selectLabel(labelname);
		Onsitec.expandTemplateSetting();
		Onsitec.clickNotificationplacement();
		Onsitec.inputNotificationPostion(position);
		objResponsivesliderImg.clickExpandImageSetting();
		Onsitec.NotificationImageclick();
		Thread.sleep(5000);
		Onsitec.selectNotificationImage();
		objResponsivesliderImg.ExpandTargetSetting();
		objResponsivesliderImg.clickDynamicRadioButton();
		Onsitec.actionsBtnClick();
		Onsitec.selectActions(actionname);
		Onsitec.actionsFBBtnClick();
		Onsitec.selectFBActions(actionname);
		Onsitec.inputTargetPage(targetpage);
		Onsitec.inputFBTargetPage(targetpage);
		Onsitec.fblabelBtnclick();
		Onsitec.selectfbLabel(labelname);
		Onsitec.saveEngageBtn();
	}
	
	@Test (enabled=false, priority=8, dataProvider="getData")
	public void SliderImageWithDynlp() {
		
	}
	
	@DataProvider
	public  String[][] getData(Method method) throws Exception
	{
		String sheetname = null;
		if (method.getName().contentEquals("TextImageSider"))
		{
			sheetname = "Sheet1";
		}
		else if (method.getName().contentEquals("ImageNonClickable")) {
			sheetname = "Sheet2";
		}
		else if (method.getName().contentEquals("TextOnImage")) {
			sheetname = "Sheet3";
		}
		else if (method.getName().contentEquals("TextOnImageNonClickable")) {
			sheetname = "Sheet4";
		}
		else if (method.getName().contentEquals("TimerOnImage")) {
			sheetname = "Sheet5";
		}
		else if (method.getName().contentEquals("ResponsiveImageSliderDynLp")) {
			sheetname = "Sheet6";
		}
		
		String path = System.getProperty("user.dir")+"/testdata/OnsiteData.ods";
		int rownum = ODFUtils.getRowCount(path,sheetname);
		int colcount = ODFUtils.getCellCount(path,sheetname,1);
		String logindata[][] = new String[rownum-1][colcount];
		System.out.println("row count = "+rownum);
		System.out.println("column count =" +colcount);
		for (int i = 1; i<rownum; i++) {
			for (int j=0; j<colcount; j++) {
				logindata[i-1][j]=ODFUtils.getCellData(path,sheetname,i,j);
				System.out.println(logindata[i-1][j]);	
			}	
		}	
	return logindata;  
	}
	
}
