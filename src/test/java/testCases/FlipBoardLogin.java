package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.suiteBase;
import screens.loginScreen;
import screens.selectTopicScreen;

public class FlipBoardLogin extends suiteBase {

	loginScreen login;
	selectTopicScreen selectTopic;

	@BeforeTest
	public void init() {
		log.info("call init");
		setup();
		log.info("call init");
		login = new loginScreen(driver);
		selectTopic = new selectTopicScreen(driver);

	}

	@Test(priority = 1)
	public void validateContinueButton() {

		login.clickGetStarted();

	}

	@Test(priority = 2)
	public void chooseTopicTest() {

		selectTopic.selectTopics(3).clickContinue().skipLogin();

	}

	@AfterTest
	public void driverQuit() throws InterruptedException {
		log.info("call quit");

		quit();
	}

}
