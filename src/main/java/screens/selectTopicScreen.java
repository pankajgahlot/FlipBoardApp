package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.screenBase;
import extentlisteners.ExtentListeners;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class selectTopicScreen extends screenBase {

	@AndroidFindBy(id = "flipboard.app:id/topic_picker_topic_row_topic_tag")
	public List<WebElement> alltopiclist;

	@AndroidFindBy(id = "flipboard.app:id/topic_picker_continue_button")
	public WebElement continueButton;
	
	@AndroidFindBy(id = "flipboard.app:id/icon_button_text")
	public WebElement SkipButton;

	public selectTopicScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public selectTopicScreen selectTopics(int noOftopicToSelect) {
		for (int i = 0; i < noOftopicToSelect; i++) {
			alltopiclist.get(i).click();
			ExtentListeners.testReport.get().log(Status.INFO, "Slecting Value :"+alltopiclist.get(i).getText()+"\n");
		}
		return this;
	}

	public selectTopicScreen clickContinue() {
		continueButton.click();
		
		return this ;

	}
	
	public HomeScreen skipLogin() {
		SkipButton.click();
		
		return new HomeScreen(driver);
		
		
	}

}
