package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TriggerApiChannelsEngageListPage  extends GeneralWebElementsInAllPage {
	
	WebDriverWait wait;
	boolean flag = true;
	boolean found;
	WebDriver driver1;

	
	public TriggerApiChannelsEngageListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		this.driver1 = driver;
	}
	
	
	
}
