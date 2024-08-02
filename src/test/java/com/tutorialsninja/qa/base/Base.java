package com.tutorialsninja.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	WebDriver driver;
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equals("Chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equals("Firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equals("Edge")) {

			driver = new EdgeDriver();
		}

		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		return driver;
	}

}
