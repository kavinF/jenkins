package org.steprunner;

import org.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.pom.LoginPage;
import org.pom.POMManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepAction extends BaseClass {
	 private Scenario scenario;
	private POMManager l = POMManager.getPomManager();
	    @Before
	    public void setScenario(Scenario scenario) {
	        this.scenario = scenario; // Initialize the Scenario object before each scenario
	        lauchChromeDriver();
	    }
	
	@Given("lauch url")
	public void lauchUrl() {   
		
		driver.get("https://www.facebook.com/login.php");
	}
	@Then("login facebook using {string} {string}")
	public void loginFacebookUsing(String username, String password) throws InterruptedException {
Thread.sleep(2000);
		
		LoginPage l1 = l.getLoginPage();
		textValue(l1.getUsername(), username);
		textValue(l1.getPassword(), password);
		clickAction(l1.getLogin());

	}
	public void captureAndAttachScreenshot( String screenshotName, Scenario scenario) {
        // Capture screenshot
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario = scenario; 
        // Attach screenshot to the report
        scenario.attach(screenshot, "image/png", screenshotName);
    }
	@Then("get screenshot")
	public void getScreenshot() {
    captureAndAttachScreenshot( "screenshots",scenario);
	}
	@After
	public void afterClass() {
		 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	        // Attach screenshot to the report
	        scenario.attach(screenshot, "image/png", "final screenshot");
	       
	        driver.manage().deleteAllCookies();
	        
driver.quit();

	}
	
}
