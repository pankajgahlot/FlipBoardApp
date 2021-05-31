package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonUtils {

	private static AppiumDriver<MobileElement> driver;
	private static URL serverURL;
	private static DesiredCapabilities capabilities;
	private static Properties prop;
	private static FileInputStream fs;

	private static String APPIUM_PORT;
	private static int IMPLICIT_WAIT;
	private static int EXPLICIT_WAIT;
	private static String BASE_PKG;
	private static String APP_ACTIVITY;
	private static String APP_PATH;
	private static String BROWSER_NAME;
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String DEVICE_NAME;
	// specific to IOS
	private static String UDID;
	private static String BUNDLE_ID;
	private static String APP;

	public static void loadAndroidConfigProp(String loadPropertyFile) {
		// TODO Auto-generated method stub
		prop = new Properties();

		try {
			fs = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\" + loadPropertyFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		DEVICE_NAME = prop.getProperty("device.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		IMPLICIT_WAIT = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT = Integer.parseInt(prop.getProperty("explicit.wait"));
		APPIUM_PORT = prop.getProperty("appium.server.port");
		APP_PATH = prop.getProperty("application.path");

	}

	public static void setAndroidCapabilities() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, BROWSER_NAME);

		// app package and app activity works only in case of android
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);

	}

	public static AppiumDriver<MobileElement> getAndroidDriver() {
		try {

			serverURL = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new AndroidDriver<MobileElement>(serverURL, capabilities);
		return driver;

	}

	public static void loadIOSConfigProp(String loadPropertyFile) {
		// TODO Auto-generated method stub

	}

	public static void setIOSCapabilities() {

	}

	public static AppiumDriver<MobileElement> getIOSDriver() {
		return driver;

	}

}
