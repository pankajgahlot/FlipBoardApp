package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.AppiumServer;
import utilities.commonUtils;

public class suiteBase {

	public AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "Android_Flipboard.properties";
	public static Logger log = Logger.getLogger(suiteBase.class);

	public void setup() {

		if (driver == null) {
			PropertyConfigurator
					.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
			if (loadPropertyFile.startsWith("Android_")) {
				AppiumServer.start();
				log.info("Appium server Started");
				commonUtils.loadAndroidConfigProp(loadPropertyFile);
				log.info(loadPropertyFile + "Property File Loaded");

				commonUtils.setAndroidCapabilities();
				log.info("Loading Android Capabilities");

				driver = commonUtils.getAndroidDriver();
			} else if (loadPropertyFile.startsWith("IOS_")) {

			}
		}

	}

	public void quit() throws InterruptedException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		log.info("Testcase Excecution complted");
		AppiumServer.stop();
		log.info("Appium Server stoped");

	}
	
	/*
	 * public void takeScreenshot() {
	 * 
	 * Date d = new Date(); String
	 * fileName=d.toString().replace(":","_").replace(" ", "_")+".jpg"; File
	 * screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try {
	 * FileUtils.copyFile(screenshot, new
	 * File(System.getProperty("user.dir")+"\\Reports\\"+fileName)); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

}
