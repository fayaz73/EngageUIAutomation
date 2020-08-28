package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestBase.DriverInit;
import pom.LoginPage;
import pom.SegmentPage;

public class SegmentTest extends BaseTest {
	
	String username1 = "bank";
	String pwd1 = "123$Urbanladder";
	String passcode1 = "NA";
	String dimension = "Taxonomy";
	String attribute = "CONTAINS";
	String inputValue = "Bangalore";
	String Segname = "SegmentYellow";
	String SegDescription="SegmentDescription for SegmentA";
	SegmentPage segPage;
	LoginPage lp;
	boolean flg;
	
	
	@Parameters("browsers")
	@BeforeClass
	public void segmentPreCondtion(String br) throws IOException {
		//DriverInit instanceDriver = DriverInit.getInstance();
		WebDriver driver = getDriver();
		System.out.println("Test2 thread is :"+Thread.currentThread().getId());
		//WebDriver driver1 = driver;
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get(baseURL);
		login(username1,pwd1,passcode1);
		segPage = new SegmentPage(driver);
		 
	}
	
	
	@Test (enabled=true, priority=1)
	public void segmentCreationTest() throws IOException, InterruptedException {
		segPage.AddSegmentBtnClick();
		segPage.ExistingUserBtnClick();
		segPage.CreateSegmentBtnClick();
		segPage.SelectDimensionBtn();
		segPage.SelectDimension(dimension);
		segPage.SelectAttributeDropdownBtn();
		segPage.SelectAttributeDropdown(attribute);
		segPage.DimensionValuesTextbox(inputValue);
		segPage.ApplyBtnClick();
		segPage.SaveSegmenBtnClick();
		segPage.SegmentName(Segname);
		segPage.SegmentDescription(SegDescription);
		segPage.SegmentSavebtn();
		Thread.sleep(15000);
		flg = segPage.FindSegment(Segname);
		verification(flg,"segmentCreationTest");
		//segPage.SegmentSavebtn();
	
	}
	
	@Test (enabled=false)
	public void duplicateSegmentTest() throws InterruptedException, IOException {
		flg = segPage.findSegmentElipsis(Segname);
		if(flg) {
			segPage.DuplicateBtnClick();
			segPage.SelectDimensionBtn();
			segPage.SelectDimension(dimension);
			segPage.SelectAttributeDropdownBtn();
			segPage.SelectAttributeDropdown(attribute);
			segPage.DimensionValuesTextbox(inputValue);
			segPage.AddRuleBtnClick();
			segPage.SelectDimensionBtnRule2();
			segPage.SelectDimensionRule2(dimension);
			segPage.SelectAttibuteDropdownBtnRule2();
			segPage.SelectAttributeDropdownRule2(attribute);
			segPage.DimensionValuesTextbox2(inputValue);
			segPage.ApplyBtnClick();
			segPage.SaveSegmenBtnClick();
			Segname = Segname+"dup";
			segPage.SegmentName(Segname);
			segPage.SegmentDescription(SegDescription);
			segPage.SegmentSavebtn();
			flg = segPage.FindSegment(Segname);
			verification(flg,"duplicateSegmentTest");
		}
		else {
			System.out.println(Segname + " Not Found");
			verification(flg,"duplicateSegmentTest");
		}	
	}
	
	@Test (enabled=false)
	public void editSegmentTest() throws IOException {
		flg = segPage.FindandClickSegment("SegmentMangodfdfdfdfd");
		if(flg) {
			segPage.clickEditSegmentBtn();
			segPage.inputAddNewTagName("tagname1");
			segPage.descriptionTextbox("description while editing");
			segPage.SaveChangesEditSeg();
		}else {
			System.out.println(Segname + " Not Found");
			verification(flg,"editSegmentTest");
		}
		
	}
	
	@Test (enabled=false, priority=2)
	public void archieveSegmentTest() throws IOException {
		flg = segPage.findSegmentElipsis(Segname);
		if(flg) {
			segPage.clickArchiveBtn();
			segPage.clickYesArchiveBtn();
			String msg = segPage.getArchiveSuccessMsg();
			if (msg.contentEquals("The segment has been successfully archived"))
			{
				flg = true;
			}
			else {
				flg = false;
			}
			verification(flg,"archieveSegmentTest");
		}else
		{
			System.out.println(Segname + " Not Found");
			verification(flg,"archieveSegmentTest");
		}
	}
	
	@Test(enabled=false, priority=3)
	public void unarchiveSegmentTest() throws IOException {
		segPage.clickArchivedTab();
		flg = segPage.findSegmentElipsis(Segname);
		if (flg) {
			segPage.clickUnarchiveBtn();
			segPage.clickYesUnArchived();
			String msg = segPage.getUnArchiveSuccessMsg();
			if (msg.contentEquals("The segment has been successfully unarchived"))
			{
				flg = true;
			}
			else {
				flg = false;
			}
			verification(flg,"unarchiveSegmentTest");
			
		}else
		{
			System.out.println(Segname + " Not Found");
			verification(flg," unarchiveSegmentTest");
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
