package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {
	
	SearchPage searchPage;
	HomePage homePage;

	public SearchTest() {

		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {

		//HomePage homePage = new HomePage(driver);
		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		//homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
		//searchPage = homePage.clickOnSearchButton();

		//SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "Valid Product HP is not displayed");

		// driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("validProduct"));
		// driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();
		// Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),
		// "Valid Product HP is not displayed");

	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProdct() {

		//HomePage homePage = new HomePage(driver);
		searchPage = homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		//homePage.enterProductIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
		//searchPage = homePage.clickOnSearchButton();
		//SearchPage searchPage = new SearchPage(driver);
		//String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		// driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("invalidProduct"));
		// driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();
		// String actualSearchMessage =
		// driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p"))
		// .getText();
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"),
				"No product is search results message is displayed");

	}

	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {

		//HomePage homePage = new HomePage(driver);
		searchPage = homePage.clickOnSearchButton();
		//SearchPage searchPage = new SearchPage(driver);
		//String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		// driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();
		// String actualSearchMessage =
		// driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p"))
		// .getText();
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"),
				"No product is search results message is displayed");

	}
}
