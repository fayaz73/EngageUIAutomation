package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnsiteChannelEngageListPage extends GeneralWebElementsInAllPage {
	
	WebDriver driver1;
	WebDriverWait wait;
	boolean found;
	
	public OnsiteChannelEngageListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
		
	}

}
