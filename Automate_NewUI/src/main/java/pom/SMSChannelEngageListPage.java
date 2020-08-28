package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SMSChannelEngageListPage extends GeneralWebElementsInAllPage{

	WebDriverWait wait;
	boolean flag = true;
	boolean found;
	WebDriver driver1;
	
	public SMSChannelEngageListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
		
	}

}
