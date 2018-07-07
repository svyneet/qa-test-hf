package com.hellofresh.challenges.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	protected WebDriver		driver			= null;
	public WebDriverWait	wait			= null;
	public Properties		settingsProp	= null;

	
	public void configureBrowser() {
		settingsProp = this.readPropertyValues("data\\settings.properties");
		if ((settingsProp.getProperty("browser").trim()).equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver");
			driver = new ChromeDriver();
		}
		if ((settingsProp.getProperty("browser").trim()).equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10, 50);
		if ((settingsProp.getProperty("environment").trim()).equalsIgnoreCase("prod")) {
			driver.navigate().to(settingsProp.getProperty("URL_PROD"));
		}
		if ((settingsProp.getProperty("environment").trim()).equalsIgnoreCase("test")) {
			driver.navigate().to(settingsProp.getProperty("URL_TEST"));
		}
	}

	public void closeAndQuitBrowser() {
		driver.close();
		driver.quit();
	}


	public void refreshPage() {
		driver.navigate().refresh();
	}

	public Properties readPropertyValues(String path) {
		Properties properties = new Properties();
		// load properties file
		try {
			properties.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	 public void takeScreenShot(String methodName) {

		String filePath = "target//surefire-reports//";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	    }
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static class Messages {
		public static String	URLMYACCOUNT			= "controller=my-account";
		public static String	URLORDERCONFIRMATION	= "controller=order-confirmation";
	}

}
