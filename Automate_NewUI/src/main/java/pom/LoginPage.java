package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class LoginPage {

	@FindBy(id = "normal_login_username")
	private WebElement unTextBox;
	
	@FindBy (id = "normal_login_password")
	private WebElement pwTextBox;
	
	@FindBy (xpath = "//button/span[text()=\"Sign In\"]/../..")
	private WebElement SignInButton;
	
	@FindBy (id ="register_passcode")
	private WebElement PassCodeTextBox;
	
	@FindBy (xpath =  "//button/span[text()=\"Verify & Sign In\"]/../..")
	private WebElement VerifyButton;
	
	@FindBy (xpath = "//a/span/span[text()='Reporting']/..")
	private WebElement ReportButton;
	
	@FindBy (xpath = "//div/div/div/div[text()='Passcode Invalid. Please enter valid passcode']")
	private WebElement errorPasscodeMsg;
	
	@FindBy (xpath = "//div/div[text()='Invalid Username or Password']")
	private WebElement errorMsg;
	
	
	@FindBy (xpath = "//div/div[text()='Please input your E-mail!']")
	private WebElement errorEmailMsg;
	
	@FindBy (xpath = "//div/div[text()='Please input your Password!']")
	private WebElement errorPasswordMsg;
	
	@FindBy (xpath="//div/span/span[text()='B']/.././..")
	private WebElement logoutbtn;
	
	@FindBy (xpath="//div/div/div/ul/li/a[text()='Log out']/../../..")
	private WebElement logoutbtn2;
	
	@FindBy (xpath="//div/span[text()='Reset Password']")
	private WebElement resetpwdBtn;
	
	@FindBy (xpath="(//iframe)[1]")
	private WebElement resetIframe;
	
	@FindBy (id ="register_email")
	private WebElement emailTextbox;
	
	@FindBy (xpath="//button/..")
	private WebElement resetlinkBtn;
	
	@FindBy (xpath="//span[@id='recaptcha-anchor']/div")
    private WebElement reCaptchabtn;	
	
	
	WebDriverWait wait;	
	boolean flag = true;
	WebDriver driver1;
	
	

	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
		driver1 = driver;
	}
	
	public void resetPasswordbtn() {
		wait.until(ExpectedConditions.visibilityOf(resetpwdBtn));
		resetpwdBtn.click();
	}
	
	public void emailid(String emailid) {
		wait.until(ExpectedConditions.visibilityOf(emailTextbox));
		emailTextbox.sendKeys(emailid);
	}
	
	public void Resetlinkbtn() {
		wait.until(ExpectedConditions.visibilityOf(resetlinkBtn));
		resetlinkBtn.click();
	}
	
	public void resetCheckBox() {
		
		driver1.switchTo().frame(resetIframe);
		wait.until(ExpectedConditions.visibilityOf(reCaptchabtn));
		driver1.findElement(By.className("recaptcha-checkbox-border")).click();
		
	}
	public void hoverLogoutbtn() {
		logoutbtn.click();
	}
	
	public void clickLogoutbtn() {
		logoutbtn2.click();
	}
	
	public void setUserName(String un) {
		wait.until(ExpectedConditions.visibilityOf(unTextBox));
		unTextBox.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		wait.until(ExpectedConditions.visibilityOf(pwTextBox));
		pwTextBox.sendKeys(pw);
	}
	
	public void clickSignInButton() {
		SignInButton.click();
	}
	
	
	public void  PasscodeGenerator() throws InterruptedException
	{
		boolean flg01 = false;
		String otpKeyStr = "EVLTI6ZSPFPFASCRKMXGKRKQHEZV22B4JAUG4TJKIY2SKQJVGB5Q";
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now();
		setPassCode(twoFactorCode);
		clickVerifyButton();
		wait.until(ExpectedConditions.visibilityOf(errorPasscodeMsg));
		try {
			if (errorPasscodeMsg.isDisplayed()) {
			flg01 = true;
		}
		}
		catch (Exception e) {
			flg01 = false;
		}
		int count = 0;
		while (flg01) {
			while(totp.now().contentEquals(twoFactorCode)) {
				Thread.sleep(10);
				
				continue;
				}
			clearPasscode();
			twoFactorCode = totp.now();
			setPassCode(twoFactorCode);
			clickVerifyButton();
			try {
			wait.until(ExpectedConditions.visibilityOf(errorPasscodeMsg));
				if (errorPasscodeMsg.isDisplayed()) {
					flg01 = true;
					continue;
				}
			}
			catch(Exception e) {
				flag = false;
				break;
			}
			
		}
	}

	
	public void setPassCode(String pscode) {
		
		PassCodeTextBox.sendKeys(pscode);
	}
	
	public void clearPasscode() {
		PassCodeTextBox.clear();
	}
	
	public void clickVerifyButton() {
		VerifyButton.click();
	}
	
	public boolean verifyReportingtab() {
		wait.until(ExpectedConditions.visibilityOf(ReportButton));
		if (ReportButton.isDisplayed()) {
	
			Assert.assertTrue(true);
			
		} else {
			flag =false;
		}
		return flag;
	}
	
	public boolean verifyPasscode() {
		//flag = true;
	    wait.until(ExpectedConditions.visibilityOf(errorPasscodeMsg));
	   // boolean str = ReportButton.isDisplayed();
		System.out.println("Insside verifyLoggenIn");
		
		if(errorPasscodeMsg.getText().contentEquals("Passcode Invalid. Please enter valid passcode")) {
	  
	    	Assert.assertTrue(true);
	    }else {
	    	flag = false;
	    }
	    
	    return flag;
	}
	
	public boolean verifyErrorMsg() {
		//flag = true;
		
			wait.until(ExpectedConditions.visibilityOf(errorMsg));
			if (errorMsg.getText().contentEquals("Invalid Username or Password")) {
				Assert.assertTrue(true);
			}else {
				flag = false;
			//Assert.assertTrue(false);
			}
		 
		
		return flag;
	}
	
	public boolean verifyEmailErrorMsg() {
		//flag = true;
		
			  //  Block of code to try
				wait.until(ExpectedConditions.visibilityOf(errorEmailMsg));
				if (errorEmailMsg.getText().contentEquals("please input your E-mail!")) {
				Assert.assertTrue(true);
				}else {
				flag = false;
				//Assert.assertTrue(false);
			}
			
		return flag;
	}
	
	public boolean verifyPasswordErrorMsg() {
		//flag = true;
		wait.until(ExpectedConditions.visibilityOf(errorPasswordMsg));
		if (errorPasswordMsg.getText().contentEquals("please input your Password!")) {
			Assert.assertTrue(true);
		}else {
			flag = false;
			//Assert.assertTrue(false);
		}
		return flag;
	}
	
	public void clearunTextbox() {
	
		unTextBox.sendKeys(Keys.CONTROL,"a");
		unTextBox.sendKeys(Keys.DELETE);
	}
	
	public void clearpwTextbox() {
		pwTextBox.sendKeys(Keys.CONTROL,"a");
		pwTextBox.sendKeys(Keys.DELETE);
	}
	
	
}
