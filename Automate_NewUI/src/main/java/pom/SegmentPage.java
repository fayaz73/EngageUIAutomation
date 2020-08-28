package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SegmentPage {
	
	WebDriverWait wait;	
	boolean flag = true;
	boolean found;
	WebDriver driver1;
	
	
	
	public SegmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
	}
	
	@FindBy (xpath="//button/span[contains(text(),'Add Segment')]/..")
	private WebElement AddSegmentBtn;
	
	@FindBy (xpath="//h3[contains(text(),'Existing User')]/..")
	private WebElement ExistingUserBtn;
	
	
	@FindBy (xpath="//button/span[contains(text(),'Create Segment')]/..")
	private WebElement CreateSegmentBtn;
	
	@FindBy (xpath="(//div[contains(text(),'Select Dimension')]/../..)[1]")
	private  WebElement SelectDimensionBtnRule1;
	
	@FindBy(xpath="(//div[contains(text(),'Select Dimension')]/../..)[2]")
	private WebElement SelectDimensionBtnRule2;
	
	@FindBy (xpath="//div[2]/div/div/div/ul/li")
	private List<WebElement> SelectDimsionDropdownBtnRule1;
	
	@FindBy (xpath="(//div[4]/div/div/div/ul/li)")
	private List<WebElement> SelectDimsionDropdownBtnRule2;
	
	@FindBy(xpath ="(//div[contains(text(),'Select Attribute')]/../..)[1]")
	private WebElement SelectAttributeBtnRule1;
	
	@FindBy (xpath="(//div[contains(text(),'Select Attribute')]/../..)[2]")
	private WebElement SelectAtributeBtnRule2;
	
	@FindBy (xpath="//div[3]/div/div/div/ul/li")
	private List<WebElement> SelectAttributeDropdownBtnRule1;
	
	@FindBy (xpath="//div[5]/div/div/div/ul/li")
	private List<WebElement> SelectAttributeDropDownBtnRule2;
	
	@FindBy (xpath="(//input)[1]")
	private WebElement DimensionValue;
	
	
	@FindBy (xpath="(//input)[2]")
	private WebElement DimensionValue2;
	
	@FindBy (xpath= "//button/span[contains(text(),'Apply Rules')]/..")
	private WebElement ApplyruleBtn;
	
	@FindBy (xpath = "//button/span[contains(text(),'Save Segment')]/..")
	private WebElement SavesegmentBtn;
	
	@FindBy (id = "segmentDetailForm_name")
	private WebElement SegmentNameTextbox;
	
	@FindBy (id = "segmentDetailForm_description")
	private WebElement SegmentDescriptionTextbox;
	
	@FindBy (xpath = "//form/button/span[contains(text(),'Save')]/..")
	private WebElement SaveBtn;
	
	@FindBy (xpath = "//ul[@class='ant-pagination ant-table-pagination']/li")
	private List<WebElement> Pagination;
	
	@FindBy (xpath = "//div/table/tbody/tr/td[2]")
	private List<WebElement> SegmentList;
	
	@FindBy (xpath = "//li[@title='Next Page']")
	private WebElement NextButton;
	
	@FindBy (xpath = "//div[2]/div/div/ul/li[2]")
	private WebElement DuplicateBtn;
	
	@FindBy (xpath = "//div[2]/div/div/ul/li[1]")
	private WebElement ArchieveBtn;
	
	@FindBy (xpath="//button/span[text()='Add Rule']/..")
	private WebElement AddRuleBtn;
	
	@FindBy (xpath="//button/span[text()='Add Group']/..")
	private WebElement AddGroupBtn;
	
	@FindBy (xpath="//button/span[contains(text(),'Edit')]/..")
	private WebElement EditSegmentBtn;
	
	@FindBy (xpath="//input[@placeholder='Create new tag']")
	private WebElement AddNewTagNameBtn;
	
	
	@FindBy (xpath="//input[@placeholder='Create new tag']/../span")
	private WebElement EditTagNamebtn;
	
	@FindBy (xpath="(//textarea)[1]")
	private WebElement DescriptionTextbox;
	
	@FindBy (xpath="//button/span[contains(text(),'Save Changes')]/..")
	private WebElement SaveChangesbtn;
	
	@FindBy (xpath="//button/span[contains(text(),'Yes, archive it')]/..")
	private WebElement 	YesArchiveBtn;
	
	@FindBy (xpath="//button/span[contains(text(),'Yes, unarchive it')]/..")
	private WebElement YesUnArchiveBtn;
	
	@FindBy (xpath="//div[text()='Archived']")
	private WebElement ArchivedTab;
	
	@FindBy (xpath="//span[contains(text(),'The segment has been successfully archived')]")
	private WebElement SuccessfullArchiveMsg;
	
	@FindBy (xpath="//span[contains(text(),'The segment has been successfully unarchived')]")
	private WebElement SuccessfullUnArchiveMsg;
	
	
	
	@FindBy (xpath="//div/ul/li[contains(text(),'Unarchive')]")
	private WebElement UnarchieveBtn;
	
	@FindBy (xpath="//div[contains(text(),'Channels')]")
	private WebElement ChannelBtn;
	
	public void channelBtnClick() {
		
		ChannelBtn.click();
	}
	
	public String getUnArchiveSuccessMsg() {
		return SuccessfullUnArchiveMsg.getText().toString();
	}
	
	public String getArchiveSuccessMsg() {
		return SuccessfullArchiveMsg.getText().toString();
	}
	public void clickUnarchiveBtn() {
		UnarchieveBtn.click();
	}
	public void clickYesUnArchived() {
		YesUnArchiveBtn.click();
	}
	
	public void clickArchivedTab() {
		ArchivedTab.click();
	}
	
	public void clickYesArchiveBtn() {
		YesArchiveBtn.click();
	}
	
	public void clickEditSegmentBtn() {
		EditSegmentBtn.click();
	}
	
	public void inputAddNewTagName(String tagname) {
		AddNewTagNameBtn.sendKeys(tagname);
	}
	public void TagNameValue(String tagname1) {
		EditTagNamebtn.getText();
	}
	
	public void deleteTagNameBtn() {
		EditTagNamebtn.findElement(By.tagName("i")).click();
	}
	
	public void descriptionTextbox(String description)
	{
		DescriptionTextbox.sendKeys(description);
	}
	
	public void SaveChangesEditSeg() {
		SaveChangesbtn.click();
	}
	
	public void clickArchiveBtn() {
		ArchieveBtn.click();
	}
	
	public void AddRuleBtnClick() {
		AddRuleBtn.click();
	}
	
	public void AddGroupBtnClick() {
		AddGroupBtn.click();
		
	}
	public void DuplicateBtnClick() {
		DuplicateBtn.click();
	}

	public List<Object> SegmentWebElements(String SegmentName3) {
		String xpth;
		List<Object> WebElementXpath = new ArrayList<Object>();
		String nextButtonClassName = NextButton.getAttribute("class");
		//this.found =false;
		WebElement webelem = null;
		 do
		 {	
			int i =1;
			for (WebElement webelement : SegmentList) {
				
				if (webelement.findElement(By.tagName("span")).getText().contentEquals(SegmentName3)) {
				
					xpth = "//tr["+i+"]/td[last()]/div/i[last()-1]" ;
				
					//webelement.findElement(By.xpath(xpth)).click();
					webelem = webelement.findElement(By.xpath(xpth));
					
					WebElementXpath.add(webelem);
					WebElementXpath.add(webelement);
					this.found = true;
					break;
				}
				else {
					++i;
					this.found = false;
					continue;
				}	
			}
			if (this.found == true) {
				break;
			}
			else if(this.found == false) {
				NextButton.click();
				nextButtonClassName = NextButton.getAttribute("class");
			}
			
		}while (!nextButtonClassName.contains("disabled"));
		return WebElementXpath;
	}
	
	public boolean  findSegmentElipsis (String SegmentName2) {		
		List<Object> WebElementXpath = SegmentWebElements(SegmentName2);
		if (!WebElementXpath.isEmpty()) {
			WebElement webele = (WebElement)WebElementXpath.get(0);
			webele.click();
		}
			
	 return this.found;
	}
	
	
	public boolean FindandClickSegment(String SegmentName3) {
		List<Object> WebElementXpath = SegmentWebElements(SegmentName3);
		if (!WebElementXpath.isEmpty()) {
			WebElement webele  = (WebElement)WebElementXpath.get(1);
			webele.click();
		}		
	return this.found;
	}
	
	public boolean FindSegment(String SegmentName1) {
		List<Object> WebElementXpath = SegmentWebElements(SegmentName1);
	return this.found;	
	}

/*
	public boolean FindandClickSegment(String SegmentName3) {
		String nextButtonClassName = NextButton.getAttribute("class");
		boolean found =false;
		while (!nextButtonClassName.contains("disabled")) 
		{	
			int i =1;
			for (WebElement webelement : SegmentList) {
				
				if (webelement.findElement(By.tagName("span")).getText().contentEquals(SegmentName3)) {
					webelement.click();
					found = true;
					break;
				}
				else {
					++i;
					found = false;
					continue;
				}	
			}
			if (found == true) {
				break;
			}
			else if(found == false) {
				NextButton.click();
				nextButtonClassName = NextButton.getAttribute("class");
			}
			
		}	
		return found;
	}
	*/
	
/*	
	public boolean findSegmentElipsis (String SegmentName2) {
		String xpth;
		String nextButtonClassName = NextButton.getAttribute("class");
		boolean found =false;
		while (!nextButtonClassName.contains("disabled")) 
		{	
			int i =1;
			for (WebElement webelement : SegmentList) {
				
				if (webelement.findElement(By.tagName("span")).getText().contentEquals(SegmentName2)) {
				
					xpth = "//tr["+i+"]/td[last()]/div/i[last()-1]" ;
				
					webelement.findElement(By.xpath(xpth)).click();
					found = true;
					break;
				}
				else {
					++i;
					found = false;
					continue;
				}	
			}
			if (found == true) {
				break;
			}
			else if(found == false) {
				NextButton.click();
				nextButtonClassName = NextButton.getAttribute("class");
			}
			
		}	
		return found;
	}
	*/
	/*
	public boolean FindSegment1(String SegmentName1) {
		
		//SegmentList = driver1.findElements(By.xpath("//div/table/tbody/tr/td[2]"));
		
		//wait.until(ExpectedConditions.visibilityOf(SegmentList.get(0)));
		
		List<String> names = new ArrayList<String>();
		for (WebElement webelement : SegmentList) {
			names.add(webelement.findElement(By.tagName("span")).getText());
		}
		
		String nextButtonClassName = NextButton.getAttribute("class");
		
		while (!nextButtonClassName.contains("disabled")) {
			
			NextButton.click();
			//SegmentList = driver1.findElements(By.xpath("//div/table/tbody/tr/td[2]"));
			
			for (WebElement webelement : SegmentList) {
				names.add(webelement.findElement(By.tagName("span")).getText().trim());
			}
			
			nextButtonClassName = NextButton.getAttribute("class");
		}
		
		
		
		for (String name: names) {
			
			System.out.println(name);
			if (name.contentEquals(SegmentName1)) {
				flag = true;
				break;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}
	*/
	
	public void AddSegmentBtnClick() {
		wait.until(ExpectedConditions.visibilityOf(AddSegmentBtn));
		AddSegmentBtn.click();
	}
	
	public void ExistingUserBtnClick() {
		wait.until(ExpectedConditions.visibilityOf(ExistingUserBtn));
		ExistingUserBtn.click();
	}
	
	public void CreateSegmentBtnClick() {
		CreateSegmentBtn.click();
	}
	
	public void SelectDimensionBtn() {
		SelectDimensionBtnRule1.click();
		
	}
	
	public void SelectAttributeDropdownBtn() {
		SelectAttributeBtnRule1.click();
	}
	
	public void SelectDimension(String dimension) {
		for (WebElement webelement : SelectDimsionDropdownBtnRule1) {
			
			if (webelement.getText().contentEquals(dimension)) {
				webelement.click();
			}
		}
	}
	
	public void SelectAttributeDropdown(String attribute) {
		for (WebElement webelement : SelectAttributeDropdownBtnRule1) {
			
			if (webelement.getText().contentEquals(attribute)) {
				webelement.click();
			}
		}
		
	}
	
	
	public void SelectDimensionBtnRule2() {
		SelectDimensionBtnRule2.click();
	}
	
	public void SelectAttibuteDropdownBtnRule2() {
	    	SelectAtributeBtnRule2.click();
	    }
	
	public void SelectDimensionRule2(String dimension) {
		for (WebElement webelement : SelectDimsionDropdownBtnRule2) {
			
			if (webelement.getText().contentEquals(dimension)) {
				webelement.click();
			}
		}
	}
	
	public void SelectAttributeDropdownRule2(String attribute) {
		for (WebElement webelement : SelectAttributeDropDownBtnRule2) {
			
			if (webelement.getText().contentEquals(attribute)) {
				webelement.click();
			}
		}
		
	}
	
	public void DimensionValuesTextbox2(String input) {
		DimensionValue2.sendKeys(input);
	}
	
	public void DimensionValuesTextbox(String input) {
		DimensionValue.sendKeys(input);
	}
	
	public void ApplyBtnClick() {
		ApplyruleBtn.click();
	}
	
	public void SaveSegmenBtnClick() {
		SavesegmentBtn.click();
	}
	
	public void SegmentName(String SegmentName) {
		SegmentNameTextbox.sendKeys(SegmentName);
	}
	
	public void SegmentDescription(String Description) {
		SegmentDescriptionTextbox.sendKeys(Description);
	}
	public void SegmentSavebtn() {
		
		SaveBtn.click();
	}


}
