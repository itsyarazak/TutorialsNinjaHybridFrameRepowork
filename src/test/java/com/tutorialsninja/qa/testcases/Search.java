package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base {

	public Search() {

		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),
				"Valid Product HP is not displayed");

	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProdct() {

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p"))
				.getText();
		Assert.assertEquals(actualSearchMessage, "There is no product that matches the search criteria.",
				"No product is search results message is displayed");

	}

	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p"))
				.getText();
		Assert.assertEquals(actualSearchMessage, "There is no product that matches the search criteria.",
				"No product is search results message is displayed");

	}
}
