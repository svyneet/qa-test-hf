package com.hellofresh.challenges.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

	WebDriver driver;

	public Actions(WebDriver driver) {
		this.driver = driver;
	}

	// explicit waits
	public void waitForElementToBeVisible(WebElement element, WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception ex) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public void waitForElementToBeClickable(WebElement webElement, WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception ex) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	// actions
	public void click(WebElement element) {
		element.click();
	}
	

	public void clearAndType(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}

	public void selectValueFromDropdownByText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectValueFromDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getAttributeValue(WebElement element) {
		return element.getAttribute("value");
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

}
