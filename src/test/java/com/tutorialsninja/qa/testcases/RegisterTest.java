package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	public RegisterTest() {

		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();
		//homePage.clickOnMyAccount();
		//registerPage = homePage.selectRegisterOption();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		//RegisterPage registerPage = new RegisterPage(driver);
		
		accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		//registerPage.enterFirstName(dataProp.getProperty("firstName"));
		//registerPage.enterLastName(dataProp.getProperty("lastName"));
		//registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		//registerPage.enterPassword(prop.getProperty("validPassword"));
		//registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		//registerPage.selectPrivacyPolicy();
		//accountSuccessPage = registerPage.clickOnContinueButton();

		// driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		// driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		// driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		// driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		// driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		// driver.findElement(By.name("agree")).click();
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		//String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();

		// String actualSuccessHeading =
		// driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"),
				"Account Success Page Not displayed");

	}

	@Test(priority = 2)
	public void VerifyRegisteringAccountByProvidingAllFields() {

		//RegisterPage registerPage = new RegisterPage(driver);
		
		accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		//registerPage.enterFirstName(dataProp.getProperty("firstName"));
		//registerPage.enterLastName(dataProp.getProperty("lastName"));
		//registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		//registerPage.enterPassword(prop.getProperty("validPassword"));
		//registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		//registerPage.selectYesNewsletterOption();
		//registerPage.selectPrivacyPolicy();
		//accountSuccessPage = registerPage.clickOnContinueButton();

		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty(
		 * "firstName"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty(
		 * "lastName")); driver.findElement(By.id("input-email")).sendKeys(Utilities.
		 * generateEmailWithTimeStamp());
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty(
		 * "telephoneNumber"));
		 * driver.findElement(By.id("input-password")).sendKeys(prop.getProperty(
		 * "validPassword"));
		 * driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty(
		 * "validPassword"));
		 * driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click
		 * (); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 */

		//accountsuccessPage = new AccountSuccessPage(driver);
		//String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();

		// String actualSuccessHeading =
		// driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"),
				"Account Success Page Not displayed");

	}

	@Test(priority = 3)
	public void verifyRegisteringWithExistingEmailAddress() {

		//RegisterPage registerPage = new RegisterPage(driver);
		registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		//registerPage.enterFirstName(dataProp.getProperty("firstName"));
		//registerPage.enterLastName(dataProp.getProperty("lastName"));
		//registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		//registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		//registerPage.enterPassword(prop.getProperty("validPassword"));
		//registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		//registerPage.selectYesNewsletterOption();
		//registerPage.selectPrivacyPolicy();
		//accountSuccessPage = registerPage.clickOnContinueButton();
		//String actualWarning = registerPage.retriveDuplicateEmailAddressWarning();

		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty(
		 * "firstName"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty(
		 * "lastName"));
		 * driver.findElement(By.id("input-email")).sendKeys(prop.getProperty(
		 * "validEmail"));
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty(
		 * "telephoneNumber"));
		 * driver.findElement(By.id("input-password")).sendKeys(prop.getProperty(
		 * "validPassword"));
		 * driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty(
		 * "validPassword"));
		 * driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click
		 * (); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 * 
		 * String actualWarning =
		 * driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).
		 * getText();
		 */

		Assert.assertTrue(registerPage.retriveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")),
				"Warning Message regarding duplicate account is not displayed.");

	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {

		//RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		//String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarning();
	/*	Assert.assertTrue(registerPage.retrievePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")),
				"Privacy Policy message is not displayed");
		//String actualfirstNameWarning = registerPage.retrieveFirstNameWarning();
		Assert.assertEquals(registerPage.retrieveFirstNameWarning(), dataProp.getProperty("firstNameWarning"),
				"First Name Warning message not disiplayed");
		//String actuallastNameWarning = registerPage.retrieveLastNameWarning();
		Assert.assertEquals(registerPage.retrieveLastNameWarning(), dataProp.getProperty("lastNameWarning"),
				"Last Name Warning message not disiplayed");
		//String actualemailWarning = registerPage.retrieveEmailWarning();
		Assert.assertEquals(registerPage.retrieveEmailWarning(), dataProp.getProperty("emailWarning"),
				"Email Warning message not disiplayed");
		//String actualTelephoneWarning = registerPage.retrieveTelephoneWarning();
		Assert.assertEquals(registerPage.retrieveTelephoneWarning(), dataProp.getProperty("telphoneWarning"),
				"Telephone Warning message not disiplayed");
		//String actualPasswordWarning = registerPage.retrievePasswordWarning();
		Assert.assertEquals(registerPage.retrievePasswordWarning(), dataProp.getProperty("passwordWarning"),
				"Password Warning message not disiplayed");
		*/
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telphoneWarning"), dataProp.getProperty("passwordWarning")) ,
				"Warning message(s) are not displayed");

		/*
		 * //driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 * 
		 * String actualPrivacyPolicyWarning =
		 * driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
		 * .getText();
		 * Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty(
		 * "privacyPolicyWarning")), "Privacy Policy message is not displayed");
		 * 
		 * String actualfirstNameWarning = driver
		 * .findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"
		 * )).getText(); Assert.assertEquals(actualfirstNameWarning,
		 * dataProp.getProperty("firstNameWarning"),
		 * "First Name Warning message not disiplayed");
		 * 
		 * String actuallastNameWarning = driver
		 * .findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")
		 * ).getText(); Assert.assertEquals(actuallastNameWarning,
		 * dataProp.getProperty("lastNameWarning"),
		 * "Last Name Warning message not disiplayed");
		 * 
		 * String actualemailWarning = driver.findElement(By.xpath(
		 * "//input[@id='input-email']/following-sibling::div")) .getText();
		 * Assert.assertEquals(actualemailWarning, dataProp.getProperty("emailWarning"),
		 * "Email Warning message not disiplayed");
		 * 
		 * String actualTelephoneWarning = driver
		 * .findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"
		 * )).getText(); Assert.assertEquals(actualTelephoneWarning,
		 * dataProp.getProperty("telphoneWarning"),
		 * "Telephone Warning message not disiplayed");
		 * 
		 * String actualPasswordWarning = driver
		 * .findElement(By.xpath("//input[@id='input-password']/following-sibling::div")
		 * ).getText(); Assert.assertEquals(actualPasswordWarning,
		 * dataProp.getProperty("passwordWarning"),
		 * "Password Warning message not disiplayed");
		 */
	}
}
