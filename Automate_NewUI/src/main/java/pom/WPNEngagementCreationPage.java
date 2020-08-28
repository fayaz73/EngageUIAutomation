package pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WPNEngagementCreationPage extends GeneralWebElementsInAllPage{

	WebDriver driver1;
	WebDriverWait wait;
	boolean flag;
	
	public WPNEngagementCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,60);
		this.driver1 = driver;
	}
	
	@FindBy(xpath="//label[contains(text(),'Notification Title')]/../div/div/div/input")
	private WebElement NotificationTitle;
	
	@FindBy(xpath="//label[contains(text(),'Title')]/../input")
	private WebElement fallbackTitle;
	
	@FindBy(xpath="//label[contains(text(),'Message')]/../textarea")
	private WebElement fallbackMsg;
	
	@FindBy(xpath="(//label[contains(text(),'Target Page')])/../input")
	private WebElement fallbackTargetpage;
	
	@FindBy(xpath="//label[contains(text(),'Notification Message')]/../div/div/div/textarea")
	private WebElement NotificationMsg;
	
	@FindBy(xpath="//label[contains(text(),'Target Page')]/../div/div/div/input")
	private WebElement TargetPage;
	
	@FindBy(xpath="//label[contains(text(),' Notification Image')]/../div/div/button")
	private WebElement NotificationImgbtn;
	
	@FindBy(xpath="(//label[contains(text(),' Notification Image')]/../div/div/button)")
	private WebElement fallbckNotificationImgbtn;
	
	@FindBy(xpath="//div/span[contains(text(),'All Images')]/../div/div/div[5]")
	private WebElement NotificationImage;
	
	@FindBy(xpath="//div/span[contains(text(),'All Images')]/../div/div/div[4]")
	private WebElement fallbackNotificationImage;
	
	@FindBy(xpath="//label[contains(text(),'Button Icon Image')]/../div/div/button")
	private WebElement ButtonIconImageBtn;
	
	
	@FindBy(xpath="//div/span[contains(text(),'All Images')]/../div/div/div[2]")
	private WebElement ButtonIconImage;
	
	@FindBy(xpath="(//label[contains(text(),'Text')]/..//input)")
	private WebElement TextInput;
	
	@FindBy(xpath="//div/span[contains(text(),'2. Optional Settings')]/../..")
	private WebElement OptionalSettings;
	
	@FindBy (xpath="(//label[contains(text(),'Target Page')]/../div/div/div/input)")
	private WebElement BtnTargetPage;
	
	@FindBy (xpath="//span[contains(text(),'Use Big Size Image')]/../input")
	private WebElement BigImageCheckbox;
	
	@FindBy (xpath="//div/span[contains(text(),'3. Fallback Settings')]/../..")
	private WebElement FallbackSettings;
	
	@FindBy (xpath="(//label[contains(text(),'Label')])/../div/div")
	private WebElement FBlabelbtn;
	
	@FindBy (xpath="(//label[contains(text(),'Label')])/../div/div/div")
	private WebElement fblabel;
	
	@FindBy(xpath="//div/span[contains(text(),'1. General Settings')]/../..")
	private WebElement GeneralSettings;
	
	@FindBy (xpath="//div[@class='ant-message-notice-content']/div/span")
	private WebElement validationMessage;
	
	@FindBy (xpath="//div[@class='ant-message-notice-content']/div")
	private WebElement messageType;
	
	@FindBy (xpath="//div[@class='ant-message-custom-content ant-message-success']/span")
	private WebElement successMessage;
	
	public String getMessageType() {
		
		return messageType.getAttribute("class").toString();
	}
	
	public boolean isSuccessMessageDisplayed() throws InterruptedException {
		flag = false;
		Thread.sleep(2000);
		flag = successMessage.isDisplayed();
		if (flag) {
			flag = true;
		}
		else {
			flag = false;
		}
		return flag;
	}
	
	public boolean isValidationMessageDisplayed() throws InterruptedException {
		flag = false;
		/*
		try {
			wait.until(ExpectedConditions.visibilityOf(errorMessage));
		}catch(Exception e) {
			wait.until(ExpectedConditions.visibilityOf(successMessage));
		}
		*/
		/*
		if (errorMessage.getText().contentEquals("Some error occurred!")||errorMessage.getText().contentEquals("Only English characters allowed in title")) {
			flag = true;
		}else if (successMessage.getText().contentEquals("Engagement created Successfully")) {
			flag = false;
			//Assert.assertTrue(false);
		}
		
		*/
		Thread.sleep(2000);
		flag = validationMessage.isDisplayed();
		if (flag) {
			flag = true;
		}
		else {
			flag = false;
		}
		/*
		try {
			flag = errorMessage.isDisplayed();
			flag = true;
		}catch(Exception e) {
			flag = false;
			//e.printStackTrace();
		}
		*/
		return flag;
	}
	
	public String getActualOutput() throws InterruptedException {
		String actualOutput = validationMessage.getText();
		//String expectedOutput = "Insecure content detected. Please verify and try again.";
		//String expectedOutput = "Some error occurred!";
		return actualOutput;
	}
	
	public boolean validateSuccessMessage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		String actualOutput = successMessage.getText();
		String expectedOutput = "Engagement created Successfully";
		if(actualOutput.contentEquals(expectedOutput)) {
			flag = true;
	    }else {
	    	flag = false;
	    }
		return flag;
	}
	public void expandCollapseGeneralSettings() {
		GeneralSettings.click();
	}
	
	
	public void FBlabelBtnclick() {
		FBlabelbtn.click();
	}
	
	public void selectFBLabel(String labelname) {
		
		String labelid = fblabel.getAttribute("aria-controls").toString();
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
	
	public void FallbackSetting() {
		FallbackSettings.click();
	}
	
	public void fallbackTitle(String fallbacktitle) {
		fallbackTitle.sendKeys(fallbacktitle);
	}
	public void fallbackMessage(String fallbackMessage) {
		fallbackMsg.sendKeys(fallbackMessage);
	}
	
	public void fallbackTargetPage(String fallbackTargetPage) {
		fallbackTargetpage.sendKeys(fallbackTargetPage);
	}
	
	public void fallbackNotificationImageBTN() {
		fallbckNotificationImgbtn.click();
	}
	
	public void fallbackNotificationImage() {
		
		wait.until(ExpectedConditions.visibilityOf(fallbackNotificationImage));
		fallbackNotificationImage.click();
	}
	public void BigImagecheckBox() {
		BigImageCheckbox.click();
	}
	
	public void ButtonTargetPage(String targetpage2) {
		BtnTargetPage.sendKeys(targetpage2);
	}
	
	public void expandOptionalSettings() {
		OptionalSettings.click();
	}
	
	public void TextInputBox(String text) {
		TextInput.click();
		TextInput.sendKeys(text);
	}
	
	public void NotificationTitleTextBox(String title) {
		NotificationTitle.sendKeys(title);
	}
	
	public void NotificationMessageBox(String message) {
		NotificationMsg.sendKeys(message);
	}
	
	public void TargetPage(String targetPage) {
		TargetPage.sendKeys(targetPage);
	}
	
	public void NotificationImageBtn() {
		NotificationImgbtn.click();
	}
	public void NotificationImage() {
		wait.until(ExpectedConditions.visibilityOf(NotificationImage));
		NotificationImage.click();
	}
	public void ButtonImgageBtn() {
		ButtonIconImageBtn.click();
	}
	public void ButtonIconImage() {
		//wait.until((ExpectedConditions.elementToBeClickable(ButtonIconImage)));
		wait.until(ExpectedConditions.visibilityOf(ButtonIconImage));
		ButtonIconImage.click();
	}
	
}
