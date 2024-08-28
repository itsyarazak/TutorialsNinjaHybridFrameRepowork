package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	
	LoginPage loginPage;

	public LoginTest() {

		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToLoginPage();
		//homePage.clickOnMyAccount();
		//loginPage = homePage.selectLoginOption();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Login")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validCredentialsSuppier")
	public void verifyLoginWithValidCredentials(String email, String password) {

		//LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = loginPage.login(email, password);
		//loginPage.enterEmailAddress(email);
		//loginPage.enterPassword(password);
		//AccountPage accountPage = loginPage.clickOnLoginButton();
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		// driver.findElement(By.xpath("//input[@type='submit']")).click();

		//AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(),
				"Edit your account information is not displayed");

	}

	@DataProvider(name = "validCredentialsSuppier")
	public Object[][] supplyTestData() {

		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {

		//LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		//loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		//loginPage.clickOnLoginButton();
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		// String actualWarningMessage =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWartning");
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWartning")),
				"Expected warning message is not displayed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {

		//LoginPage loginPage = new LoginPage(driver);
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		//loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginPage.enterPassword(prop.getProperty("validPassword"));
		//loginPage.clickOnLoginButton();
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		// driver.findElement(By.xpath("//input[@type='submit']")).click();

		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		// String actualWarningMessage =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWartning");
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWartning")),
				"Expected warning message is not displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {

		//LoginPage loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		//loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		//loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		//loginPage.clickOnLoginButton();

		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		// String actualWarningMessage =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWartning");
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWartning")),
				"Expected warning message is not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {

		//LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		// String actualWarningMessage =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWartning");
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWartning")),
				"Expected warning message is not displayed");
	}

}
