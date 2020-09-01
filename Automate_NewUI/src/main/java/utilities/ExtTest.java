package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtTest {
	
	private static ExtentReports extent = ExtReport.getReport(); 
	   public static ThreadLocal<ExtentTest>  extentTestThreadSafe = new ThreadLocal<ExtentTest>(); 
	   public static synchronized ExtentTest getTest() 
	{ 
	  return extentTestThreadSafe.get(); 
	}
	public static void setTest(ExtentTest tst) 
	{ 
	   extentTestThreadSafe.set(tst); 
	}

}
