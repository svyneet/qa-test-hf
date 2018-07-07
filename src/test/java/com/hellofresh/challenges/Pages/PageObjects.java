package com.hellofresh.challenges.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.challenges.Actions.Actions;

public class PageObjects extends Actions {

	// Common Page Elements
	@FindBy(css = "h1")
	public WebElement	heading;

	// Landing Page Objects
	@FindBy(className = "login")
	public WebElement	buttonSignIn;

	// Sign In page Objects
	@FindBy(id = "email_create")
	public WebElement	inputEmailCreate;

	@FindBy(id = "SubmitCreate")
	public WebElement	buttonSubmitCreate;

	@FindBy(id = "email")
	public WebElement	inputEmailExisting;

	@FindBy(id = "passwd")
	public WebElement	inputPasswordExisting;

	@FindBy(id = "SubmitLogin")
	public WebElement	buttonSubmitLogin;

	// Create New Page Objects
	@FindBy(id = "id_gender2")
	public WebElement	radioMrs;

	@FindBy(id = "customer_firstname")
	public WebElement	inputCustomerFirstName;

	@FindBy(id = "customer_lastname")
	public WebElement	inputCustomerLastName;

	@FindBy(id = "passwd")
	public WebElement	inputPassword;

	@FindBy(id = "days")
	public WebElement	selectDays;

	@FindBy(id = "months")
	public WebElement	selectMonths;

	@FindBy(id = "years")
	public WebElement	selectYears;

	@FindBy(id = "company")
	public WebElement	inputCompany;

	@FindBy(id = "address1")
	public WebElement	inputAddress1;

	@FindBy(id = "address2")
	public WebElement	inputAddress2;

	@FindBy(id = "city")
	public WebElement	inputCity;

	@FindBy(id = "id_state")
	public WebElement	selectState;

	@FindBy(id = "postcode")
	public WebElement	inputPostCode;

	@FindBy(id = "other")
	public WebElement	inputOther;

	@FindBy(id = "phone")
	public WebElement	inputPhone;

	@FindBy(id = "phone_mobile")
	public WebElement	inputPhoneMobile;

	@FindBy(id = "alias")
	public WebElement	inputAlias;

	@FindBy(id = "submitAccount")
	public WebElement	buttonSubmitAccount;

	@FindBy(className = "account")
	public WebElement	textAccountName;

	@FindBy(className = "info-account")
	public WebElement	textaccountInfo;

	@FindBy(className = "logout")
	public WebElement	textSignOut;

	// Page Elements for checkout flow
	@FindBy(linkText = "Women")
	public WebElement	linkWomen;

	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	public WebElement	linkFadedShortSleeve;

	@FindBy(name = "group_1")
	public WebElement	selectSize;
	
	@FindBy(name = "Submit")
	public WebElement	buttonAddToCart;

	@FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	public WebElement	linkProceedToCheckout;

	@FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	public WebElement	linkProceedToCheckoutInSummary;

	@FindBy(name = "processAddress")
	public WebElement	linkProceedToCheckoutInAddress;

	@FindBy(id = "uniform-cgv")
	public WebElement	checkboxTerms;

	@FindBy(name = "processCarrier")
	public WebElement	linkProceedToCheckoutInShipping;

	@FindBy(className = "bankwire")
	public WebElement	linkPayByBankWire;

	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	public WebElement	buttonOrderConfirm;

	@FindBy(xpath = "//li[@class='step_done step_done_last four']")
	public WebElement	tabShipping;

	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	public WebElement	tabPayment;

	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	public WebElement	textConfirmOrder;

	//Page Factory
	public PageObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static class Messages {

		public static String	MYACCOUNT			= "MY ACCOUNT";
		public static String	ORDERCONFIRMATION	= "ORDER CONFIRMATION";
		public static String	WELCOMETOACCOUNT	= "Welcome to your account.";
		public static String	ORDERCOMPLETE		= "Your order on My Store is complete.";
	}
}
