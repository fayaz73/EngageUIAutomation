package scripts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import utilities.Reporting;

public class TestRunner {
	
	static TestNG testngRunner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file1 = new File(System.getProperty("user.dir")+"/Screenshots1");
		File file2 = new File(System.getProperty("user.dir")+"/test-data1");
		boolean value1 = file1.mkdir();
		boolean value2 = file2.mkdir();
		if (value1) {
			System.out.println("The new directory screenshot is created.");
		}
		else {
			System.out.println("The new directory screenshot already exists.");
		}
		
		if (value2) {
			System.out.println("The new directory testdata is created.");
		}
		else {
			System.out.println("The new directory testdata already exists.");
		}
		
		Reporting ext = new Reporting();
		
		testngRunner = new TestNG();
		XmlSuite suite = new XmlSuite();
		suite.setName("Suite");
		
		XmlTest test = new XmlTest(suite);
		test.setName("Test");
		test.addParameter("browsers","chrome");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("scripts.WPNEngagementTest"));
		classes.add(new XmlClass("scripts.SegmentTest"));
		test.setXmlClasses(classes);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setParallel(XmlSuite.ParallelMode.CLASSES);
		tng.setThreadCount(2);
		tng.addListener(ext);
		tng.setXmlSuites(suites);
		tng.run();
		
		//To run tests in Parallel mode
       // testngRunner.setParallel(XmlSuite.ParallelMode.CLASSES);
		//testngRunner.setTestClasses(new Class[] {WPNEngagementTest.class,SegmentTest.class});
		//testngRunner.addListener(ext);
		//testngRunner.setOutputDirectory(System.getProperty("user.dir"));
		
		//testngRunner.run();
		

	}

}
