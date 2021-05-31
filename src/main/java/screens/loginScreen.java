package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.screenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginScreen extends screenBase {

	@AndroidFindBy(id = "flipboard.app:id/first_launch_cover_continue")
	public WebElement getStartedButton;

	public loginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public selectTopicScreen clickGetStarted() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getStartedButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * int size =
		 * driver.findElements(By.id("flipboard.app:id/icon_button_text")).size();
		 * driver.findElement(By.id("flipboard.app:id/icon_button_text")).click();
		 */

			return new selectTopicScreen(driver);
	}

}
