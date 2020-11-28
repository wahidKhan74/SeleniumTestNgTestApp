package com.ecom.test.SeleniumTestNgTestApp;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoadAmazonHomePage {

  WebDriver driver;
  final String siteUrl = "https://www.amazon.in/";
  final String driverPath = "/home/wahidkhan74gmai/selenium-workspace/driver/chromedriver";

  @BeforeTest
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
  	  driver = new ChromeDriver();	
  	  driver.get(siteUrl);		
  }
	
  @Test
  public void loadAmazonHomePage() {
	  assertEquals(siteUrl, driver.getCurrentUrl());
  }
  
  @Test
  public void verifyAmazonHomePageTitle() {
	  String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	  System.out.println(driver.getTitle());
	  assertEquals(expectedTitle, driver.getTitle());
  }
  
  @AfterTest
  public void terminateBrowser() {
	  driver.close();
  }
}
