package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnsiteEngagementCreationPage extends OnsiteGeneralTemplatesWebElements{
	WebDriverWait wait;
	WebDriver driver1;
	
	public OnsiteEngagementCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
	}
	
	@FindBy (xpath="(//label[contains(text(),'Label')]/../div/div)[2]")
	private WebElement fblabel;
	
	@FindBy (xpath="(//label[contains(text(),'Label')]/../div/div/div)[2]")
	private WebElement label;
	
	@FindBy (xpath="(//label[contains(text(),'Action')])[1]/../div/div/div")
	private WebElement Actions;
	
	@FindBy (xpath="(//label[contains(text(),'Action')])[2]/../div/div/div")
	private WebElement fbActions;
	
	
	@FindBy (xpath="(//label[contains(text(),'Target Page')])[1]/../div/div/div/input")
	private WebElement TargetPage1;
	
	@FindBy (xpath="(//label[contains(text(),'Target Page')])[2]/../input")
	private WebElement FBTargetPage1;
	
	public void inputTargetPage(String targetpage) {
		TargetPage1.click();
		TargetPage1.sendKeys(Keys.CONTROL,"a");
		TargetPage1.sendKeys(Keys.DELETE);
		TargetPage1.sendKeys(targetpage);
	}
	
	public void inputFBTargetPage(String targetpage) {
		FBTargetPage1.click();
		FBTargetPage1.sendKeys(Keys.CONTROL,"a");
		FBTargetPage1.sendKeys(Keys.DELETE);
		FBTargetPage1.sendKeys(targetpage);
	}
	
	public void fblabelBtnclick() {
		fblabel.click();
	}
	
    public void selectfbLabel(String labelname) {
		
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
    
    
    public void actionsBtnClick() {
    	Actions.click();
    }
    
    public void actionsFBBtnClick() {
    	fbActions.click();
    }
	
    public void selectActions(String actionname) {
		
		String labelid = Actions.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			
			if(webelement.getText().contentEquals(actionname)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
    
    public void selectFBActions(String actionname) {
		
		String labelid = fbActions.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			
			if(webelement.getText().contentEquals(actionname)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	

	// Template specific webelements are defined below in each separate class for each template
	public class TextImageSlider{
		
		public TextImageSlider(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//span[contains(text(),'Text Setting')]/../../..")
		private WebElement TextSettings;
		
		@FindBy(xpath="//span[contains(text(),'Image Setting')]/../..")
		private WebElement ImageSettings;
		
		@FindBy (xpath="//span[contains(text(),'Static')]/../span/input")
		private WebElement StaticRadioButton;
		
		
		@FindBy (xpath="//span[contains(text(),'Dynamic')]/../span/input")
		private WebElement DynamicRadioButton;
		
		@FindBy (xpath="(//label[contains(text(),'Title')])[1]/../div/div/div/input")
		private WebElement TitleTextBox;
		
		@FindBy(xpath="(//label[contains(text(),'Title')])[2]/../input")
		private WebElement fbTitleTextBox;
		
		@FindBy(xpath="(//label[contains(text(),'Message')])[2]/../textarea")
		private WebElement fbMessageTextBox;
		
		@FindBy (xpath="(//label[contains(text(),'Message')])[1]/../div/div/div/textarea")
		private WebElement MessageTexbox;
		
		@FindBy (xpath="(//label[contains(text(),'CTA Text')])[1]/../div/div/div/input")
		private WebElement CTAText;
		
		@FindBy (xpath="(//label[contains(text(),'CTA Text')])[2]/../input")
		private WebElement FBCTAText;
		
		
		
		public void enterFBTitle(String fbTitle) {
			fbTitleTextBox.click();
			fbTitleTextBox.sendKeys(Keys.CONTROL,"a");
			fbTitleTextBox.sendKeys(Keys.DELETE);
			fbTitleTextBox.sendKeys(fbTitle);
		}
		
		public void enterFBMessage(String fbMessage) {
			fbMessageTextBox.click();
			fbMessageTextBox.sendKeys(Keys.CONTROL,"a");
			fbMessageTextBox.sendKeys(Keys.DELETE);
			fbMessageTextBox.sendKeys(fbMessage);
		}
		
		public void enterFBCTATextInput(String fbCTA) {
			FBCTAText.click();
			FBCTAText.sendKeys(Keys.CONTROL,"a");
			FBCTAText.sendKeys(Keys.DELETE);
			FBCTAText.sendKeys(fbCTA);
		}
		public void enterCTATextInput(String cta) {
			CTAText.click();
			CTAText.sendKeys(Keys.CONTROL,"a");
			CTAText.sendKeys(Keys.DELETE);
			CTAText.sendKeys(cta);
		}
		
		public void enterMessageInput(String message) {
			MessageTexbox.click();
			MessageTexbox.sendKeys(Keys.CONTROL,"a");
			MessageTexbox.sendKeys(Keys.DELETE);
			MessageTexbox.sendKeys(message);
		}
		
		public void enterTitleInput(String title) {
			TitleTextBox.click();
			TitleTextBox.sendKeys(Keys.CONTROL,"a");
			TitleTextBox.sendKeys(Keys.DELETE);
			TitleTextBox.sendKeys(title);
		}
		
		
		public void clickExpandTextSetting() {
			TextSettings.click();
		}
		public void clickExpandImageSetting() {
			ImageSettings.click();
		}
		
		public void clickStaticRadioButton(){
			StaticRadioButton.click();
			}
		public void clickDynamicRadioButton(){
			DynamicRadioButton.click();
			}
		
		
		}
	
	//==================================================================
	public class ImageNonClickable extends TextImageSlider{
		
		public ImageNonClickable(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		
	}
	
	
	//===============================================================
	public class TextOnImage extends TextImageSlider{
		
		public TextOnImage(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver, this);
		}
		@FindBy (id="addAnswerArea_ifr")
		private WebElement iframe1;
		
		@FindBy (id="secondOne_ifr")
		private WebElement iframe2;
		
		@FindBy(xpath="//div")
		private WebElement message;
		
		
		
		public void enterTestOnImageMessage(String msg) {
			driver1.switchTo().frame(iframe1);
			message.click();
			message.clear();
			message.sendKeys(msg);
			driver1.switchTo().defaultContent();	
		}
		
		public void enterFBTestOnImageMessage(String msg2) {
			driver1.switchTo().frame(iframe2);
			message.click();
			message.clear();
			message.sendKeys(msg2);
			driver1.switchTo().defaultContent();
		}
	}
	
	
	//===============================================================
	public class ResponsiveImageSliderDynlp extends TextImageSlider{
		
		@FindBy(xpath="//span[contains(text(),'Target Settings')]/../..")
		private WebElement TargetSettings;
		
		public ResponsiveImageSliderDynlp(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public void ExpandTargetSetting() {
			TargetSettings.click();
		}
	}
	
	
	//=============================================================
	public class ResponsiveImgNonClickable extends TextImageSlider {
		
		public ResponsiveImgNonClickable(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver, this);
		}
	}
	
	//=============================================================
	public class SliderImageDynamiclp extends TextImageSlider {
		
		public SliderImageDynamiclp(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
	}
	
	
	//=============================================================
	public class TimerONImage extends TextImageSlider {
		
		public TimerONImage(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="(//span[contains(text(),'Select, if below date is Date of Birth')])[1]/../input")
		private WebElement dobCheckbox;
		
		@FindBy(xpath="(//span[contains(text(),'Select, if below date is Date of Birth')])[2]/../input")
		private WebElement dobFBCheckbox;
		
		@FindBy(xpath="(//label[contains(text(),'Timer End')])[1]/../input")
		private WebElement TimerEndInput;
		
		@FindBy(xpath="(//label[contains(text(),'Timer End')])[2]/../input")
		private WebElement TimerEndFBInput;
		
		public void selectTimerCheckBox() {
			dobCheckbox.click();
		}
		
		public void selectFBTimerCheckBox() {
			dobFBCheckbox.click();
		}
		
		public void enterTimerEnd(String timer) {
			TimerEndInput.sendKeys(timer);
		}
		
		public void enterTimerEndFB(String timer2) {
			TimerEndFBInput.sendKeys(timer2);
		}
		
	}
	
	
	//============================================================
	public class TextOnImageNonClickable extends TextImageSlider {
		
		public TextOnImageNonClickable(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (id="addAnswerArea_ifr")
		private WebElement iframe1;
		
		@FindBy (id="secondOne_ifr")
		private WebElement iframe2;
		
		@FindBy(xpath="//div")
		private WebElement message;
		
		
		
		public void enterTestOnImageNonClickMessage(String msg) {
			driver1.switchTo().frame(iframe1);
			message.click();
			message.clear();
			message.sendKeys(msg);
			driver1.switchTo().defaultContent();	
		}
		
		public void enterFBTestOnImageNonClickMessage(String msg2) {
			driver1.switchTo().frame(iframe2);
			message.click();
			message.clear();
			message.sendKeys(msg2);
			driver1.switchTo().defaultContent();
		}
	}
	
	
	//=============================================================
    public class LeadFormTemplate {
		
		public LeadFormTemplate(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
	}

}
