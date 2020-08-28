package scripts;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.DriverInit;
import TestBase.MySqlconnection;
import pom.LoginPage;
import utilities.ODFUtils;
import utilities.ReadConfig;

public class loginTest extends BaseTest {

	
	LoginPage lg;
	boolean flg, flg1, flg2;

	@BeforeMethod
	public void setup() {
		lg = new LoginPage(driver);
		driver.navigate().to(baseURL);
	}
	
	@AfterMethod
	public void clearTextfields(Method method) {
		String testName = method.getName(); 
	    System.out.println("Executing test: " + testName);
	    
	    if (!(testName.contentEquals("resetPassword"))) {
	    	lg.clearunTextbox();
			lg.clearpwTextbox();
	    }
	    
		
	}
	

	@Test (enabled=true, dataProvider="getData3")
	public void invalid_UN_Login(String usr, String pwd, String passcode1) throws IOException  {
		
			lg.setUserName(usr);
			logger.info("username entered");
			lg.setPassword(pwd);
			logger.info("password entered");
			lg.clickSignInButton();
			flg = lg.verifyErrorMsg();
			if (flg == false) {
				System.out.println("Entered in the capture module");
				captureScreen(driver, "invalid_UN_Login");
				Assert.assertTrue(false);
			}
			MySqlconnection cnt = MySqlconnection.getMysqlinstance();
			Connection conn = cnt.ConnectToDB();
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select RateLimit,IsTFAEnabled, Email from OAuthUser where Email like 'fayaz.ahamed@vizurycn.com'");
				while(rs.next()) {
					 System.out.println("RateLimit"+rs.getInt("RateLimit")+"::::"+"IsTFAEnabled:"+rs.getInt("IsTFAEnabled")+":::"+"Email:"+rs.getString("Email"));
				 }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
	}
	
	@Test (enabled=true, dataProvider="getData3")
	public void invalid_PW_Login(String usr1, String pwd1, String passcode1) throws IOException {
		{
			lg.setUserName(usr1);
			lg.setPassword(pwd1);
			lg.clickSignInButton();
			flg = lg.verifyErrorMsg();
			if (flg == false) {
				captureScreen(driver, "invalid_PW_Login");
				Assert.assertTrue(false);
			}
		}
	}
	
	@Test (enabled=true, dataProvider="getData3")
	public void invalid_UNPW_Login(String usrname, String Psswrd, String passcode1) throws IOException {
			lg.setUserName(usrname);
			lg.setPassword(Psswrd);
			lg.clickSignInButton();
			flg = lg.verifyErrorMsg();
			if (flg == false) {
				captureScreen(driver, "invalid_UNPW_Login");
				Assert.assertTrue(false);
			}
	}
	
	@Test (enabled=true, dataProvider="getData3")
	public void empty_UNPW_Login(String user, String pwd, String passcode1) throws IOException {
		
			lg.setUserName(user);
			lg.setPassword(pwd);
			lg.clickSignInButton();
			flg1 = lg.verifyEmailErrorMsg();
			flg2 = lg.verifyPasswordErrorMsg();
			if (flg1 == false && flg2 ==false) {
				captureScreen(driver, "empty_UNPW_Login");
				Assert.assertTrue(false);
			}
	}
	
	@Test (enabled=false, dataProvider="getData3")
	public void invalid_PassCode_login(String usn, String pwd, String passcode1) throws IOException {
			lg.setUserName(usn);
			lg.setPassword(pwd);
			lg.clickSignInButton();
			lg.setPassCode(passcode1);
			lg.clickVerifyButton();
			flg = lg.verifyPasscode();
			if (flg == false) {
				System.out.println("flag is flase so capture screen");
				captureScreen(driver, "invalid_PassCode_login");
				Assert.assertTrue(false);
			}
			driver.navigate().refresh();
	}
	
	@Test (enabled=false, dataProvider="getData3")
	public void valid_PassCode_login(String username, String pwd,  String passcode1) throws InterruptedException, IOException {
		lg.setUserName(username);
		lg.setPassword(pwd);
		lg.clickSignInButton();
		lg.PasscodeGenerator();
		flg = lg.verifyReportingtab();
		if (flg == false) {
			System.out.println("Entered in the capture module");
			captureScreen(driver, "invalid_UN_Login");
			Assert.assertTrue(false);
		}
	}
	

	@Test (enabled=true, dataProvider="getData3")
	public void No_PassCode_login(String username,String password, String passcode1) throws IOException {
		lg.setUserName(username);
		lg.setPassword(password);
		lg.clickSignInButton();
		flg = lg.verifyReportingtab();
		if (flg == false) {
			System.out.println("Entered in the capture module");
			captureScreen(driver, "invalid_UN_Login");
			Assert.assertTrue(false);
		}
		lg.hoverLogoutbtn();
		lg.clickLogoutbtn();
	}
	
	@Test (enabled = false)
	public void resetPassword() {
		lg.resetPasswordbtn();
		lg.resetCheckBox();
		lg.emailid("fayaz.ahamed@vizurycn.com");
		lg.Resetlinkbtn();
	}
	/*
	@DataProvider(name="LoginData")
	public  String[][] getData(Method method) throws Exception
	{
		
		String path = System.getProperty("user.dir")+"/testdata/LoginData.ods";
		int rownum = ODFUtils.getRowCount(path,"Sheet1");
		int colcount = ODFUtils.getCellCount(path,"Sheet1",1);
		String logindata[][] = new String[rownum][colcount-1];
		System.out.println("row count = "+rownum);
		System.out.println("column count =" +colcount);
		for (int i = 1; i<=rownum; i++) {
			for (int j=0; j<colcount-1; j++) {
				logindata[i-1][j]=ODFUtils.getCellData(path,"Sheet1",i,j);
				System.out.println(logindata[i-1][j]);
				
			}
			
		}
		
		
	return logindata;  
	}	
	
	*/

	@DataProvider
	public String[][] getData3(Method method) throws Exception {
		String path = System.getProperty("user.dir")+"/testdata/LoginData.ods";
		int rownum = ODFUtils.getRowCount(path,"Sheet6");
		int colcount = ODFUtils.getCellCount(path,"Sheet6",0);
		String data[][] = new String[1][rownum-2];
		int m = 0, n = 0;
		String tc[] = ODFUtils.getColumndata(path,"Sheet6");
		for (int k =0; k<tc.length; k++  )
			{
				for (int i = 2; i<rownum; i++) {
					if (method.getName().equals(tc[k])) {
						data[m][n]=ODFUtils.getCellData(path,"Sheet6",i,ODFUtils.testcases[k]);
						n = n+1;
					}
			
				}	
			
			}
		
		return data;
	}
	
/*	
	@DataProvider
	public String[][] getData2(Method method1){
		
		String data[][] = new String[1][2];
		 
		if (method1.getName().equals("invalid_UN_Login"))
		{
			data[0][0] = "fayaz.ahamed@vizurycn";
			data[0][1] = "123$Fayaz";
			
		}else if (method1.getName().equals("invalid_PW_Login"))
		{
			data[0][0] = "fayaz.ahamed@vizurycn.com";
			data[0][1] = "123$Fay";
		}
		else if (method1.getName().equals("empty_UNPW_Login"))
		{
			data[0][0] = "";
			data[0][1] = "";
		}
		
		return data;
	}
	*/
}
