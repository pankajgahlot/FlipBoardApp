package screens;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import base.screenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends screenBase {

	@AndroidFindBys({ 
		@AndroidBy(id = "flipboard.app:id/sliding_title_strip_container"),			
		@AndroidBy(id = "flipboard.app:id/sliding_title_text_view"),
			})
	public List<AndroidElement> title;

	@AndroidFindBy(id = "flipboard.app:id/bottom_nav_view_icon")
	public List<AndroidElement> bottomNavigation;

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void titleSelect(int titleIndex) {
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		title.get(titleIndex).click();

	}

	public void bottomOptionSelect(int bottomIndex) {
		bottomNavigation.get(bottomIndex).click();

	}

}
