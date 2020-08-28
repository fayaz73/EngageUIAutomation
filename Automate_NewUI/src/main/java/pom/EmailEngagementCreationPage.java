package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailEngagementCreationPage extends GeneralWebElementsInAllPage{

	WebDriverWait wait;
	WebDriver driver1;
	public EmailEngagementCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
	}
	
	@FindBy(xpath="//label[contains(text(),'Code Area')]/../div/div/div/textarea")
	private WebElement messageBox;
	
	@FindBy(xpath="//label[contains(text(),'Subject')]/../div/div/div/textarea")
	private WebElement subjectTextBox;
	
	
	@FindBy (xpath="//label[contains(text(),'Label')]/../div/div")
	private WebElement labelbtn;
	
	@FindBy (xpath="//label[contains(text(),'Preview Text')]/../input")
	private WebElement previewTextBox;
	
	
	
	@FindBy (xpath="//label[contains(text(),'From')]/../div/div/div")
	private WebElement from;
	
	@FindBy (xpath="//label[contains(text(),'Reply To')]/../div/div/div")
	private WebElement ReplyTo;
	
	@FindBy (xpath="//label[contains(text(),'From')]/../div/div/div")
	private WebElement fromSelect;
	
	@FindBy (xpath="//label[contains(text(),'Reply To')]/../div/div/div")
	private WebElement ReplyToSelect;
	
	public void fromDropDown() {
		fromSelect.click();
	}
	public void ReplyToDropDown() {
		ReplyToSelect.click();
	}
	
	public void enterTextPreview(String preview) {
		previewTextBox.sendKeys(preview);
	}
	
	public void enterSubjectTextBox(String subject) {
		subjectTextBox.sendKeys(subject);
	}
	
	public void enterMessage(String message) {
		messageBox.sendKeys(message);
	}
	
	public void labelBtnclick() {
		labelbtn.click();
	}
	
	public void messageTextBoxClear() {
		messageBox.sendKeys(Keys.CONTROL,"a");
		messageBox.sendKeys(Keys.DELETE);
	}
	
	public void previewtTextBoxClear() {
		previewTextBox.sendKeys(Keys.CONTROL,"a");
		previewTextBox.sendKeys(Keys.DELETE);
	}
	
	public void subjectTextBoxClear() {
		subjectTextBox.sendKeys(Keys.CONTROL,"a");
		subjectTextBox.sendKeys(Keys.DELETE);
	}
	
	
	
	public void selectFrom(String FromContact) {
		
		String labelid = from.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			
			if(webelement.getText().contentEquals(FromContact)) {
				webelement.click();
				break;
			}else {
				continue;
				}
			}
		}
	public void selectReplyTo(String ReplyToContact) {
		
		String labelid = ReplyTo.getAttribute("aria-controls").toString();
		List<WebElement> labels = driver1.findElement(By.id(labelid)).findElements(By.xpath("ul/li"));
		for (WebElement webelement: labels) {
			
			if(webelement.getText().contentEquals(ReplyToContact)) {
				webelement.click();
				break;
			}else {
				continue;
				}
			}
		}


}
