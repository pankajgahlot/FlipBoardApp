package extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import base.screenBase;


public class ExtentManager {

	private static ExtentReports extent;
	
	
	

	    public static ExtentReports createInstance(String fileName) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	       
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Rahul Arora");
	        extent.setSystemInfo("Organization", "Way2Automation");
	        extent.setSystemInfo("Build no", "W2A-1234");
	        
	        
	        return extent;
	    }

	    
	    public static String screenshotPath;
		public static String screenshotName;
		
		public static void captureScreenshot() {

			File scrFile = ((TakesScreenshot) screenBase.driver).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			
			  
			try {
				Files.copy(scrFile, new File(System.getProperty("user.dir") + "\\target\\reports\\" + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

	}
