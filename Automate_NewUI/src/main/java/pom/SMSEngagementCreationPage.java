package pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SMSEngagementCreationPage extends GeneralWebElementsInAllPage {
	
	WebDriver driver1;
	WebDriverWait wait;
	boolean found;
	
	public SMSEngagementCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
	}
	
	
	
	@FindBy(xpath="//div/div[contains(text(),'PROMOTIONAL')]/../..")
	private WebElement promotional;
	
	@FindBy (xpath="//label[contains(text(),'PROMOTIONAL')]/../..//ul/li")
	private List<WebElement> promotionlist;
	
	@FindBy (xpath="//textarea")
	private WebElement messageBox;
	
	@FindBy (xpath="//textarea/../../div[2]/ul/li")
	private List<WebElement> dynamiclist;
	
	
	public void messageBoxClear() {
		messageBox.sendKeys(Keys.CONTROL,"a");
		messageBox.sendKeys(Keys.DELETE);
	}
	
	public void selectDynamicParameter(String DynamicMacro) {
		for (WebElement webelement: dynamiclist) {
			
			if(webelement.getText().contentEquals(DynamicMacro)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	
	public void NotificationMessage(String message) {
		messageBox.sendKeys(message);
	}
	
	public void selectMessageTypeDown() {
		promotional.click();
	}
	
	public void selectMessageType(String promote) {
		
		for(WebElement webelement: promotionlist) {
			if (webelement.getText().contentEquals(promote)) {
				webelement.click();
				break;
			}else {
				continue;
			}
		}
	}
	
	
	
	
	
	

}
