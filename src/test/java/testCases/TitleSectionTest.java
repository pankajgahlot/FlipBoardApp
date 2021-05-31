package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.suiteBase;
import screens.HomeScreen;
import screens.loginScreen;
import utilities.ScrollUtil;

public class TitleSectionTest extends suiteBase {

	loginScreen login;
	HomeScreen homescrn;

	@BeforeTest
	public void init() {
		log.info("call init");
		setup();
		log.info("call init");
		login = new loginScreen(driver);
		homescrn = new HomeScreen(driver);

	}

	@Test
	public void validateTitle() {

		login.clickGetStarted().selectTopics(3).clickContinue().skipLogin();
		homescrn.titleSelect(0);
		ScrollUtil.scrollUp(2, driver);
		

	}

	@AfterTest
	public void driverQuit() throws InterruptedException {
		log.info("call quit");

		quit();
	}
}
