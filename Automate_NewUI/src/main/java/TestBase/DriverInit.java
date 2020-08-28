package TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInit {
	
	private static DriverInit instanceDriver = null;
	//private WebDriver driver;
	
	protected static ThreadLocal<ChromeDriver> driver;
	
	
	private DriverInit() {
		
	}

	
	public WebDriver openBrowser(String br) {
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
			//driver = new ChromeDriver();
			driver = new ThreadLocal<>();
			driver.set(new ChromeDriver());
		}
		else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
			//driver = new FirefoxDriver();
		}
		
		driver.get().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		return driver.get();	
	}
	
	public static DriverInit getInstance() {
		if (instanceDriver== null) {
			instanceDriver = new DriverInit();
		}
	return instanceDriver;
	}
}
	
