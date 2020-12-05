package com.ecom.test.SeleniumTestNgTestApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GridTest {
	
  WebDriver driver ;
  String baseUrl,nodeUrl;
  
  @BeforeTest
  public void setUp() throws MalformedURLException {
	  baseUrl = "https://www.amazon.in/";
	  nodeUrl = "http://172.17.0.1:4444/wd/hub";
	  DesiredCapabilities cap = new DesiredCapabilities();	  
	  cap.setBrowserName("chrome");
	  cap.setPlatform(Platform.LINUX);
	  driver =  new RemoteWebDriver(new URL(nodeUrl), cap);
  }
  
  @Test
  public void loadAmazoneHomePageTest() {
	  driver.get(baseUrl);
	  Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
