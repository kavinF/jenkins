package org.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	public void textValue(WebElement e, String value) {
		e.clear();
		e.sendKeys(value);
	}
	
	public void clickAction(WebElement e) {
      e.click();
	}
	
	public WebDriver lauchChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;

	}
	
	public void screenshot() throws IOException {
		TakesScreenshot t= (TakesScreenshot) driver;
		File screenshotAs = t.getScreenshotAs(OutputType.FILE);
		File f= new File("C:\\Users");
		f.createNewFile();
		FileUtils.copyFile(screenshotAs, f);

	}
	
}
