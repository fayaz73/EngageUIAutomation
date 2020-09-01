package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtReport {

	 public static String timeStamp;
	 public static String repName;
	 public static ExtentHtmlReporter htmlReporter;
	
	public synchronized static ExtentReports getReport() 
    {          
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		ExtentReports Reportextent=new ExtentReports();
		
		Reportextent.attachReporter(htmlReporter);
		Reportextent.setSystemInfo("Host name","localhost");
		Reportextent.setSystemInfo("Environemnt","QA");
		Reportextent.setSystemInfo("user","Fayaz");
		

		htmlReporter.config().setDocumentTitle("Lemnisk Engage Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
      return Reportextent;   
    } 
    
      

}
