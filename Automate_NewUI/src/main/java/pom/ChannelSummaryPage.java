package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChannelSummaryPage {
	
	WebDriverWait wait;
	boolean flag = true;
	boolean found;
	WebDriver driver1;

	public ChannelSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
	}
	
	@FindBy (xpath="//div[contains(text(),'Call Center')]")
	private WebElement callcenterTab;
	
	@FindBy (xpath="//div[contains(text(),'App Push')]")
	private WebElement AppPushTab;
	
	@FindBy (xpath="//div[contains(text(),'Trigger Email')]")
	private WebElement TriggerEmailTab;
	
	@FindBy (xpath="//div[contains(text(),'Trigger SMS')]")
	private WebElement TriggerSMSTab;
	
	@FindBy (xpath="//div[contains(text(),'SMS')]")
	private WebElement SMSTab;
	
	@FindBy (xpath="//div[contains(text(),'Email')]")
	private WebElement EmailTab;
	
	@FindBy (xpath="//div[contains(text(),'Web Push Notification')]")
	private WebElement WPNTab;
	
	@FindBy (xpath="//div[contains(text(),'Onsite Notification')]")
	private WebElement OnsiteTab;
	
	
	public void clickWPNTab() {
		WPNTab.click();
	}
	
	public void clickOnsiteTab() {
		OnsiteTab.click();
	}
	
	
	public void clickEmailTab() {
		EmailTab.click();
	}
	
	public void clickSMSTab() {
		SMSTab.click();
	}
	
	
	public void callCenterTabClick() {
		callcenterTab.click();
	}
	
	public void appPushTabClick() {
		AppPushTab.click();
	}
	
	public void triggerEmailClick() {
		TriggerEmailTab.click();
	}
	
	public void triggerSMSClick() {
		TriggerSMSTab.click();
	}
	
}
