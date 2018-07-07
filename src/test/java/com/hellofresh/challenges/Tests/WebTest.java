package com.hellofresh.challenges.Tests;


import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hellofresh.challenges.Actions.Actions;
import com.hellofresh.challenges.Pages.PageObjects;
import com.hellofresh.challenges.config.TestBase;

import java.util.Date;
import java.util.Properties;

public class WebTest extends TestBase {

	public PageObjects	pageObjects		= null;
	public Actions		actions			= null;

	
	public Properties	testData		= null;
	private static Logger Log;

	@BeforeMethod
	public void setUp() {
		testData = this.readPropertyValues("data\\testdata.properties");
		Log = Logger.getLogger(Log.class.getName());
		//
		this.configureBrowser();
		pageObjects = new PageObjects(driver);
		actions = new Actions(driver);
	}

	@AfterMethod
	public void cleanUp(ITestResult testResult) {
		String methodName=testResult.getName().toString().trim();
		if (testResult.getStatus() == ITestResult.FAILURE)
			takeScreenShot(methodName);
		this.closeAndQuitBrowser();
	}

	@Test
	public void signInTest() {
		Log.info("--signInTest--");
		//Test Data
		String timestamp = String.valueOf(new Date().getTime());
		String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		String name = testData.getProperty("name");
		String surname = testData.getProperty("surname");
		String password = testData.getProperty("password");
		String days = testData.getProperty("days");
		String months = testData.getProperty("months");
		String years = testData.getProperty("years");
		String company = testData.getProperty("company");
		String address1 = testData.getProperty("address1");
		String address2 = testData.getProperty("address2");
		String city = testData.getProperty("city");
		String state = testData.getProperty("state");
		String postcode = testData.getProperty("postcode");
		String other = testData.getProperty("other");
		String phone = testData.getProperty("phone");
		String phoneMobile = testData.getProperty("phoneMobile");
		String alias = testData.getProperty("alias");
		//Actions
		actions.waitForElementToBeVisible(pageObjects.buttonSignIn, wait);
		actions.click(pageObjects.buttonSignIn);
		actions.clearAndType(pageObjects.inputEmailCreate, email);
		actions.click(pageObjects.buttonSubmitCreate);
		actions.waitForElementToBeVisible(pageObjects.radioMrs, wait);
		actions.click(pageObjects.radioMrs);
		actions.clearAndType(pageObjects.inputCustomerFirstName, name);
		actions.clearAndType(pageObjects.inputCustomerLastName, surname);
		actions.clearAndType(pageObjects.inputPassword, password);
		actions.selectValueFromDropdownByValue(pageObjects.selectDays, days);
		actions.selectValueFromDropdownByValue(pageObjects.selectMonths, months);
		actions.selectValueFromDropdownByValue(pageObjects.selectYears, years);
		actions.clearAndType(pageObjects.inputCompany, company);
		actions.clearAndType(pageObjects.inputAddress1, address1);
		actions.clearAndType(pageObjects.inputAddress2, address2);
		actions.clearAndType(pageObjects.inputCity, city);
		actions.selectValueFromDropdownByText(pageObjects.selectState, state);
		actions.clearAndType(pageObjects.inputPostCode, postcode);
		actions.clearAndType(pageObjects.inputOther, other);
		actions.clearAndType(pageObjects.inputPhone, phone);
		actions.clearAndType(pageObjects.inputPhoneMobile, phoneMobile);
		actions.clearAndType(pageObjects.inputAlias, alias);
		actions.click(pageObjects.buttonSubmitAccount);
		actions.waitForElementToBeVisible(pageObjects.heading, wait);
		//Validations
		Assert.assertEquals(actions.getText(pageObjects.heading), PageObjects.Messages.MYACCOUNT);
		Log.info("My account message verified");
		Assert.assertEquals(actions.getText(pageObjects.textAccountName), name + " " + surname);
		Log.info("Account name verified");
		Assert.assertTrue(actions.getText(pageObjects.textaccountInfo).contains(PageObjects.Messages.WELCOMETOACCOUNT));
		Log.info("Account info verified");
		Assert.assertTrue(actions.isDisplayed(pageObjects.textSignOut));
		Log.info("Sign Out text verified");
		Assert.assertTrue(getCurrentUrl().contains(TestBase.Messages.URLMYACCOUNT));
		Log.info("URL My account verified");

	}

	
	public void logInTest() {
		Log.info("--logInTest--");
		//Test Data
		String fullName = testData.getProperty("fullName");
		String existingUserEmail = testData.getProperty("existingUserEmail");
		String existingUserPassword = testData.getProperty("existingUserPassword");
		//Actions
		actions.waitForElementToBeVisible(pageObjects.buttonSignIn, wait);
		actions.click(pageObjects.buttonSignIn);
		actions.clearAndType(pageObjects.inputEmailExisting, existingUserEmail);
		actions.clearAndType(pageObjects.inputPasswordExisting, existingUserPassword);
		actions.click(pageObjects.buttonSubmitLogin);
		actions.waitForElementToBeVisible(pageObjects.heading, wait);
		//Validations
		Assert.assertEquals(actions.getText(pageObjects.heading), PageObjects.Messages.MYACCOUNT);
		Log.info("My account message verified");
		Assert.assertEquals(actions.getText(pageObjects.textAccountName), fullName);
		Log.info("Account name verified");
		Assert.assertTrue(actions.getText(pageObjects.textaccountInfo).contains(PageObjects.Messages.WELCOMETOACCOUNT));
		Log.info("Account info verified");
		Assert.assertTrue(actions.isDisplayed(pageObjects.textSignOut));
		Log.info("Sign Out text verified");
		Assert.assertTrue(getCurrentUrl().contains(TestBase.Messages.URLMYACCOUNT));
		Log.info("URL My account verified");
	}

	
	public void checkoutTest() {
		Log.info("--checkoutTest--");
		//Test Data
		String existingUserEmail = testData.getProperty("existingUserEmail");
		String existingUserPassword = testData.getProperty("existingUserPassword");
		//Actions
		actions.waitForElementToBeVisible(pageObjects.buttonSignIn, wait);
		actions.click(pageObjects.buttonSignIn);
		actions.clearAndType(pageObjects.inputEmailExisting, existingUserEmail);
		actions.clearAndType(pageObjects.inputPasswordExisting, existingUserPassword);
		actions.click(pageObjects.buttonSubmitLogin);
		actions.waitForElementToBeVisible(pageObjects.linkWomen, wait);
		actions.click(pageObjects.linkWomen);
		actions.click(pageObjects.linkFadedShortSleeve);
		actions.click(pageObjects.linkFadedShortSleeve);
		actions.waitForElementToBeVisible(pageObjects.buttonAddToCart, wait);
		actions.click(pageObjects.buttonAddToCart);
		actions.waitForElementToBeVisible(pageObjects.linkProceedToCheckout, wait);
		actions.click(pageObjects.linkProceedToCheckout);
		actions.waitForElementToBeVisible(pageObjects.linkProceedToCheckoutInSummary, wait);
		actions.click(pageObjects.linkProceedToCheckoutInSummary);
		actions.waitForElementToBeVisible(pageObjects.linkProceedToCheckoutInAddress, wait);
		actions.click(pageObjects.linkProceedToCheckoutInAddress);
		actions.waitForElementToBeVisible(pageObjects.checkboxTerms, wait);
		actions.click(pageObjects.checkboxTerms);
		actions.click(pageObjects.linkProceedToCheckoutInShipping);
		actions.waitForElementToBeVisible(pageObjects.linkPayByBankWire, wait);
		actions.click(pageObjects.linkPayByBankWire);
		actions.waitForElementToBeVisible(pageObjects.buttonOrderConfirm, wait);
		actions.click(pageObjects.buttonOrderConfirm);
		actions.waitForElementToBeVisible(pageObjects.heading, wait);
		//Validations
		Assert.assertEquals(actions.getText(pageObjects.heading), PageObjects.Messages.ORDERCONFIRMATION);
		Log.info("Order confirmation message verified");
		Assert.assertTrue(actions.isDisplayed(pageObjects.tabShipping));
		Log.info("Presence of tab shipping verified");
		Assert.assertTrue(actions.isDisplayed(pageObjects.tabPayment));
		Log.info("Presence of tab payment verified");
		Assert.assertTrue(actions.getText(pageObjects.textConfirmOrder).contains(PageObjects.Messages.ORDERCOMPLETE));
		Log.info("Order complete message verified");
		Assert.assertTrue(getCurrentUrl().contains(TestBase.Messages.URLORDERCONFIRMATION));
		Log.info("URL order confirmation verified");
	}
}
