package scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestBase.DriverInit;
import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.LoginPage;
import utilities.ReadConfig;

public class BaseTest {
	
	private static final String priority = null;
	WebDriver driver;
	public static Logger logger;
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	//public String baseURL = "http://app.lemnisk.co:8080";
	
	//protected static ThreadLocal<ChromeDriver> driver1 = new ThreadLocal<>();
	protected static ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();
	
	
	public WebDriver getDriver() {
		//driver1.get().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		return driver1.get();	
	}
	
	@Parameters("browsers")
	@BeforeClass
	public void setUp(String br) {
		if (br.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//exefiles/chromedriver");
			
			//WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
			//driver = new ChromeDriver();
			//driver1 = new ThreadLocal<>();
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
   		 	capabilities.setBrowserName("chrome");
   		 	capabilities.setPlatform(org.openqa.selenium.Platform.LINUX);
   		    //capabilities.setVersion("84.0");
   		 
   		 
			 ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("--no-sandbox");
	            chromeOptions.addArguments("--headless");
	            chromeOptions.addArguments("disable-gpu");
                chromeOptions.addArguments("window-size=1400,2100");
			//driver1.set(new ChromeDriver(chromeOptions));
			
               // capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                chromeOptions.merge(capabilities);
                 
               	 try {
					driver1.set(new RemoteWebDriver(new URL("http://192.168.43.74:4444/wd/hub"),
							chromeOptions));
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
		}
		else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
			//driver = new FirefoxDriver();
		}
	}

	//DriverInit instanceDriver;
	LoginPage lp;
	
	/*
	@Parameters("browsers")
	@BeforeClass
	public void precondition(String br) {
		//instanceDriver = DriverInit.getInstance(); 
		//driver = instanceDriver.openBrowser(br);
		//driver.get(baseURL);
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		logger = Logger.getLogger("Automate_NewUI");
		PropertyConfigurator.configure("log4j.properties");
		
		}
	*/

	@AfterClass (enabled=false)
	public void postcondition() {
		driver.quit();
	}
	
	 public void captureScreen(WebDriver driver, String tname) throws IOException {
		 TakesScreenshot ts= (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		 FileUtils.copyFile(source, target);
		 System.out.println("Screenshot taken");
	 }
	 
	 public void getPassCodeFromUser()  {
		 
		
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("var a = prompt('Enter the passcode')");
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 js.executeScript("document.getElementById('register_passcode').value = a;");
		// System.out.println(passcode);
		/* 
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval("print('welcome to javascript execution using java')");
			engine.eval(new FileReader(System.getProperty("user.dir") + "/javascript/passcode.js"));
			Invocable invocable = (Invocable)engine;
			String kk = (String)invocable.invokeFunction("s");
			System.out.println(kk);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		*/		 
	 }
	 
	 public void login(String username, String password, String passcode) {
		    lp = new LoginPage(getDriver());
		    if (passcode.contentEquals("NA")) {
		    	lp.setUserName(username);
				lp.setPassword(password);
				lp.clickSignInButton();
				// getPassCodeFromUser();
				//System.out.println(pscode);
			/*	try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				//lp.setPassCode(pscode);
				//lp.clickVerifyButton();
		    }		
		}
	
}
