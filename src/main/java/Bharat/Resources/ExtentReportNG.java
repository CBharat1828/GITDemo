package Bharat.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	
	public static ExtentReports getReportObject()
	{
		
		{
			
			String path=System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("AutomationTestResults");
			reporter.config().setDocumentTitle("WebAutomationTesting");
			
			ExtentReports extent= new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Bharat");
			return extent;
			
			
			
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

