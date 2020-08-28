package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralWebElementsInAllPage {
	
	
	WebDriver driver1;
	WebDriverWait wait;
	boolean found;

	public GeneralWebElementsInAllPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,120);
		this.driver1 = driver;
	}
	
	
	@FindBy (xpath="//label[contains(text(),'Schedule')]/..//div[contains(text(),'Later')]/../..")
	private WebElement scheduleDropdown;
	
	@FindBy (xpath="//label[contains(text(),'Schedule')]/../div/div/div")
	private WebElement scheduleOptions;
	
	@FindBy (xpath="//a[contains(text(),'Ok')]")
	private WebElement DateOkbtn;
	
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
	
	@FindBy(xpath="//button/span[contains(text(),'Add Engagement')]/..")
	private WebElement AddEngagementBtn;
	
	@FindBy (xpath = "//div/table/tbody/tr/td[2]")
	private List<WebElement> EngagementList;
	
	@FindBy (xpath = "//li[@title='Next Page']")
	private WebElement NextButton;
	
	@FindBy (xpath="//label[contains(text(),'When to trigger')]/../div")
	private WebElement WhentoTriggerBtn;
	
	@FindBy (xpath="//label[contains(text(),'When to trigger')]/../div/div/div")
	private WebElement OnTriggerOptions;
	
	
	@FindBy (xpath="//div/span/a[contains(text(),'select time')]")
	private WebElement selectTime;
	
	@FindBy (xpath="//div/span/a[contains(text(),'Now')]")
	private WebElement TimeNow;
	
	@FindBy (xpath="//div[@class='ant-calendar-time-picker-combobox']/div[1]/ul/li")
	private List<WebElement> Hours;
	
	@FindBy (xpath="//div[@class='ant-calendar-time-picker-combobox']/div[2]/ul/li")
	private List<WebElement> Minutes;
	
	@FindBy (xpath="//div[@class='ant-calendar-time-picker-combobox']/div[3]/ul/li")
	private List<WebElement> Seconds;
	
	@FindBy (xpath="//div/span[contains(text(),'Schedule Settings')]/../..")
	private WebElement scheduleSettingExpandCollpase;
	
	@FindBy (xpath="//button[contains(text(),'Save')]")
	private WebElement saveEngageBtn;
	
	@FindBy (xpath="//div[contains(text(),'Back')]")
	private WebElement BackButton;
	
	@FindBy (xpath="//label[contains(text(),'Engagement Name')]/../input")
	private WebElement EngageName;
	
	@FindBy (xpath="//label[contains(text(),'Label')]/../div/div")
	private WebElement labelbtn;
	
	
	@FindBy (xpath="//label[contains(text(),'Label')]/../div/div/div")
	private WebElement label;
	
	
	
    public void selectLabel(String labelname) {
		
		String labelid = label.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			
			if(webelement.getText().contentEquals(labelname)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	
    public void labelBtnclick() {
		labelbtn.click();
	}
	
	
	public void EngageNameInputbox(String engageName) {
		EngageName.sendKeys(engageName);
	}
	
	public void BackButtonClick() {
		BackButton.click();
	}
	
	public void saveEngageBtn() {
		saveEngageBtn.click();
	}
	
	public void scheduleExpandCollapse() {
		scheduleSettingExpandCollpase.click();
	}
	
	
	public void WhentoTriggerBtn() {
		WhentoTriggerBtn.click();
	}
	
	public void whenToTriggerOptions(String param) {
		String labelid = OnTriggerOptions.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			if(webelement.getText().toString().contentEquals(param)) {
				webelement.click();
			}
		}
	}
	
	public void DateOkBtn() {
		DateOkbtn.click();
	}
	
	public void TimePicker(String hour, String minute, String second) {
		selectTime.click();
		Actions actions = new Actions(driver1);
		
		for (WebElement webelement1: Hours) {
			actions.moveToElement(webelement1).perform();
			//System.out.println(webelement.getText().toString());
			if (webelement1.getText().toString().contentEquals(hour)) {
				//System.out.println(webelement.getText().toString());
				actions.moveToElement(webelement1).build().perform();
				webelement1.click();
				break;
			}
			
		}
		
		for (WebElement webelement2: Minutes) {
			actions.moveToElement(webelement2).perform();
			if (webelement2.getText().toString().contentEquals(minute)) {
				//System.out.println(webelement.getText().toString());
				actions.moveToElement(webelement2).build().perform();
				webelement2.click();
				break;
			}
			
		}
		for (WebElement webelement3: Seconds) {
			actions.moveToElement(webelement3).perform();
			if (webelement3.getText().toString().contentEquals(second)) {
				//System.out.println(webelement.getText().toString());
				actions.moveToElement(webelement3).build().perform();
				webelement3.click();
				break;
			}
			
		}
		
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
	
	public void ScheduleDropDown() {
		scheduleDropdown.click();
	}
	public void scheduleList(String scheduleType, String parameter) throws InterruptedException {
		
		String labelid = scheduleOptions.getAttribute("aria-controls").toString();
		List<WebElement> scheduleList = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		
		WebElement webelement;
		int i =0;
		String[] str = new String[6];
		String month, year, day, hour, minute, seconds;
		for(int j=0;j< scheduleList.size(); j++) {
			webelement = scheduleList.get(j);
			System.out.println(webelement.getText().toString());
		}
		
		webelement = scheduleList.get(i);
		if (webelement.getText().toString().contentEquals(scheduleType)) {
			webelement.click();
			Thread.sleep(2000);
			DatePickerClick();
			str = parameter.split(",");
			month = str[0];
			year = str[1];
			day = str[2];
			hour = str[3];
			minute = str[4];
			seconds = str[5];
			DataPicker(month,year,day);
			TimePicker(hour,minute,seconds);
			DateOkBtn();
		}else {
			i++;
			webelement = scheduleList.get(i);  
			webelement.click();
			WhentoTriggerBtn();
			whenToTriggerOptions(parameter);
			
		}
		
	}
	
	public void addEngagementBtnClick() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(AddEngagementBtn));
		Thread.sleep(3000);
			AddEngagementBtn.click();
	}
	
	public List<Object> EngagementWebElements(String EngagementName1) {
		String xpth;
		List<Object> WebElementXpath = new ArrayList<Object>();
		String nextButtonClassName = NextButton.getAttribute("class");
		//this.found =false;
		WebElement webelem = null;
		do 
		{	
			int i =1;
			for (WebElement webelement : EngagementList) {
				
				if (webelement.findElement(By.tagName("div")).getText().contentEquals(EngagementName1)) {
				
					xpth = "//tr["+i+"]/td[last()]/div/i" ;
				
					//webelement.findElement(By.xpath(xpth)).ick();
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
	
	public boolean  FindEngagementElipsis (String EngagementName) {		
		List<Object> WebElementXpath = EngagementWebElements(EngagementName);
		if (!WebElementXpath.isEmpty()) {
			WebElement webele = (WebElement)WebElementXpath.get(0);
			webele.click();
		}
			
	 return this.found;
	}
	
	
	public boolean FindandClickEngagement(String EngagementName) {
		List<Object> WebElementXpath = EngagementWebElements(EngagementName);
		if (!WebElementXpath.isEmpty()) {
			WebElement webele  = (WebElement)WebElementXpath.get(1);
			webele.click();
		}		
	return this.found;
	}
	
	public boolean FindEngagement(String EngagementName) {
		List<Object> WebElementXpath = EngagementWebElements(EngagementName);
	return this.found;	
	}

}

class OnsiteGeneralTemplatesWebElements extends GeneralWebElementsInAllPage{
	
	WebDriver driver1;
	WebDriverWait wait;
	boolean found;
	
	public OnsiteGeneralTemplatesWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;		
	}
	
	
	@FindBy (xpath="//label[contains(text(),'Select Notification Style')]/../div/div/div")
	private WebElement selectNotificationStylebtn;
	
	@FindBy (xpath="//label[contains(text(),'Enter URL')]/../input")
	private WebElement EnterURLTextBox;

	@FindBy (xpath="//label[contains(text(),'Select Notification Style')]/../div/div/div")
	private WebElement NotificationStyle;
	
	@FindBy (xpath="//div[contains(text(),'Top Left')]/../..")
	private WebElement Notificationplacement;
	
	@FindBy (xpath="//label[contains(text(),'Position')]/../input")
	private WebElement NotificationPostionTextbox;
	
	@FindBy (xpath="//label[contains(text(),'Initial State')]/../div/div/div")
	private WebElement InitialState;
	
	@FindBy (xpath="//label[contains(text(),'Upload Image')]/../div/div/button")
	private WebElement NotificationImageBtn;
	
	@FindBy (xpath="//div/span[contains(text(),'All Images')]/../div/div/div[3]")
	private WebElement selectNotificationImage;
	
	@FindBy (xpath="//span[contains(text(),'Template Setting')]/../..")
	private WebElement TemplateSettings;
	
	
	public void expandTemplateSetting() {
		TemplateSettings.click();
	}
	
	public void InitialStateclick() {
		InitialState.click();
	}
	
	public void selectInitialState(String initialstate) {
		
		String labelid = InitialState.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			
			if(webelement.getText().contentEquals(initialstate)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	
	public void clickNotificationplacement() {
		Notificationplacement.click();
	}
	
	public void inputNotificationPostion(String position) {
		NotificationPostionTextbox.sendKeys(position);
	}
	
	
    public void selectNotificationStyle(String labelname) {
		
		String labelid = NotificationStyle.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			
			if(webelement.getText().contentEquals(labelname)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
    public void selectNotificationBtn() {
		selectNotificationStylebtn.click();
	}
    																																																																																																																																																																																																																																																																																																																						
	public void EnterURL(String url) {
		EnterURLTextBox.sendKeys(url);
	}
	
	public void NotificationImageclick() {
		NotificationImageBtn.click();
	}
	
	public void selectNotificationImage() {
		selectNotificationImage.click();
	}
	
}





