package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class TriggerApiChannelsEngageCreationPage extends GeneralWebElementsInAllPage {
	
	
	WebDriver driver1;
	WebDriverWait wait;
	boolean found;
	
	
	public TriggerApiChannelsEngageCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
		
	}
	
	
	@FindBy (xpath="//input[@label='Engagement Name']")
	private WebElement EngageName;
	
	@FindBy(xpath="//div/div[contains(text(),'Select API')]/../..")
	private WebElement selectApi;
	
	@FindBy (xpath="//label[contains(text(),'API')]/../..//ul/li")
	private List<WebElement> Api;
	
	@FindBy (xpath="//label[contains(text(),'Label')]/../..//ul/li")
	private List<WebElement> label;
	
	@FindBy (xpath="//label[contains(text(),'Label')]/../div/div")
	private WebElement labelbtn;
	
	@FindBy (xpath="//label[contains(text(),'Product checked')]/../div//input")
	private WebElement productCheckedInput;
	
	@FindBy (xpath="//label[contains(text(),'Sub Product Name')]/../div//input")
	private WebElement SubProductNameInput;
	
	@FindBy (xpath="//label[contains(text(),'Offer Amount')]/../div//input")
	private WebElement OfferAmountInput;
	
	@FindBy (xpath="//label/span[contains(text(),'First name')]/../input")
	private WebElement FirstName;
	
	@FindBy (xpath="//label/span[contains(text(),'Last name')]/../input")
	private WebElement LastName;
	
	@FindBy (xpath="//label/span[contains(text(),'First name')]/../../../..//div/input")
	private WebElement FirstNameInputbox;
	
	@FindBy (xpath="//label/span[contains(text(),'Last name')]/../../../..//div/input")
	private WebElement LastNameInputbox;
	
	@FindBy (xpath="//label[contains(text(),'Schedule')]/..//div[contains(text(),'Later')]/../..")
	private WebElement scheduleDropdown;
	
	@FindBy (xpath="//div[@id = 'area']/div[4]//ul/li")
	private List <WebElement> scheduleList;
	
	
	
	@FindBy (xpath="//div/span[contains(text(),'3. Schedule Settings')]/../a/i")
	private WebElement ExpandCollapseBtn;
	
	
	@FindBy (xpath="//div[contains(text(),'Back')]")
	private WebElement BackButton;
	
	public void BackButtonClick() {
		BackButton.click();
	}
	
	
	/*
	@FindBy (xpath="//input[@class='ant-calendar-picker-input ant-input']")
	private WebElement Date;
	
	@FindBy (xpath="//a[@class='ant-calendar-month-select']")
	private WebElement month;
	
	@FindBy (xpath="//a[@class='ant-calendar-year-select']")
	private WebElement year;
	
	
	@FindBy (xpath="//a[@class='ant-calendar-next-month-btn']")
	private WebElement nextMonth;
	
	@FindBy (xpath="//a[@class='ant-calendar-next-year-btn']")
	private WebElement nextYear;
	
	@FindBy (xpath="//a[@class='ant-calendar-prev-month-btn']")
	private WebElement previousMonth;
	
	@FindBy (xpath="//a[@class='ant-calendar-prev-year-btn']")
	private WebElement previousYear;
	
	@FindBy (xpath="//table/tbody/tr/td")
	private List<WebElement> dayslist;
	
	@FindBy (xpath="//a[contains(text(),'Ok')]")
	private WebElement DateOkbtn;
	*/
	
	
	@FindBy (xpath="(//div/div[@class='ant-select-selection-selected-value'])[1]")
	private WebElement verifySelectApi;
	
	@FindBy (xpath="(//div/div[@class='ant-select-selection-selected-value'])[2]")
	private WebElement verifyLabel;
	
	@FindBy (xpath="(//div/div[@class='ant-select-selection-selected-value'])[3]")
	private WebElement verifyScheduleTrigger;
	
	
	@FindBy (xpath="(//div/div[@class='ant-select-selection-selected-value'])[4]")
	private WebElement verifyTriggerOptions;
	
	@FindBy(xpath="//input[@placeholder='Select date']")
	private WebElement verifyLaterOptions;
	
	
	
	public void AssertFunction(String actual, String expected) {
		if (actual.contentEquals(expected)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void verifyLaterOptions(String Latervalue) {
		String str = verifyLaterOptions.getAttribute("value").toString();
		AssertFunction(str,Latervalue);
	}
	public void verifyEngagementName(String engagename) {
		String str = EngageName.getAttribute("value").toString();
		AssertFunction(str,engagename);
	}
	
	public void verifySelectedApi(String apiname1) {
		String str = verifySelectApi.getAttribute("title").toString();
		AssertFunction(str,apiname1);
	}
	
	public void verifyLabelValue(String label1) {
		String str = verifyLabel.getAttribute("title").toString();
		AssertFunction(str,label1);
	}
	
	public void verifyScheduleTriggerOption(String ScheduleOption) {
		String str = verifyScheduleTrigger.getAttribute("title").toString();
		AssertFunction(str,ScheduleOption);
	}
	
	public void verifyScheduleTriggerValue(String ScheduleValue) {
		String str = verifyTriggerOptions.getAttribute("title").toString();
		AssertFunction(str,ScheduleValue);
	}
	
	public void verifyproductCheckedInput(String ProductName) {
		String str = productCheckedInput.getAttribute("value").toString();
		AssertFunction(str,ProductName);
	}
	
	public void verifySubProductNameInput(String SubProductName) {
		String str  = SubProductNameInput.getAttribute("value").toString();
		AssertFunction(str,SubProductName);
	}
	
	public void verifyOfferAmountInput (String OfferAmountvalue) {
		String str  = OfferAmountInput.getAttribute("value").toString();
		AssertFunction(str,OfferAmountvalue);
	}
	
	public void verifyFirstNameInputbox (String FirstNameValue) {
		String str  = FirstNameInputbox.getAttribute("value").toString();
		AssertFunction(str,FirstNameValue);
	}
	
	public void verifyLastNameInputbox (String LastNameValue) {
		String str  = LastNameInputbox.getAttribute("value").toString();
		AssertFunction(str,LastNameValue);
	}
	
	
	
	
	
	
	
	//===================================================================
	/*
	public void DateOkBtn() {
		DateOkbtn.click();
	}
	
	public void DataPicker(String month1, String year1, String day1) {
		
		while (true) {
		
		if (month.getText().contentEquals(month1) && year.getText().contentEquals(year1)) {
			
			for (WebElement webelement: dayslist) {
				if (webelement.getText().toString().contentEquals(day1)) {
					webelement.click();
					break;
				}
			}
			break;
		}else {
			nextMonth.click();
			continue;
		}
		
		}
	}
	//====================================================================
	
	public void DatePickerClick() {
		Date.click();
	}
	
	*/
	public void getClassNameExpandCollapse() {
		String classname = ExpandCollapseBtn.getAttribute("class").toString().trim();
		if (classname.contentEquals("fa fa-plus"))
		{
			ExpandCollapseBtn.findElement(By.xpath("//div/span[contains(text(),'3. Schedule Settings')]/../..")).click();
		}
	}

	//===================================================================
	
	
	/*
	//================================================================
	public void ScheduleDropDown() {
		scheduleDropdown.click();
	}
	public void scheduleList(String scheduleType) {
		for (WebElement webelement: scheduleList) {
			if (webelement.getText().contentEquals(scheduleType)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	
	*/
	//================================================================
	public void FirstNameInputBox(String firstname) {
		FirstNameInputbox.sendKeys(firstname);
	}
	public void LastNameInputBox(String lastname) {
		LastNameInputbox.sendKeys(lastname);
	}
	
	public void FristNameCheckbox() {
		FirstName.click();
	}
	public void LastNameCheckbox() {
		LastName.click();
	}
	public void productCheckedInput(String prodChecked) {
		productCheckedInput.sendKeys(prodChecked);
	}
	
	public void SubProductNameInput(String SubProductName) {
		SubProductNameInput.sendKeys(SubProductName);
	}
	
	public void OfferAmountInput(String offeramount) {
		OfferAmountInput.sendKeys(offeramount);
	}
	
	public void labelBtnclick() {
		labelbtn.click();
	}
	
	public void EngageNameInputbox(String engageName) {
		EngageName.sendKeys(engageName);
	}
	
	public void selectApiDropDown() {
		selectApi.click();
	}
	
	public void selectApiList(String apiname) {
		
		for(WebElement webelement: Api) {
			if (webelement.getText().contentEquals(apiname)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	
	public void selectLabel(String labelname) {
		for (WebElement webelement: label) {
			
			if(webelement.getText().contentEquals(labelname)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	
}
