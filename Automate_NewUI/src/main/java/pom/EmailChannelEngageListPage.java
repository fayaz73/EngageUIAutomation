package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailChannelEngageListPage extends GeneralWebElementsInAllPage{

	WebDriverWait wait;
	WebDriver driver1;
	public EmailChannelEngageListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
	}
}
