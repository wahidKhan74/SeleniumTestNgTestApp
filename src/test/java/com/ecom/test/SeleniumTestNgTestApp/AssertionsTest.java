package com.ecom.test.SeleniumTestNgTestApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

	SoftAssert soft = new SoftAssert();
	final String siteUrl = "https://www.facebook.com/";
	final String driverPath = "/home/wahidkhan74gmai/selenium-workspace/driver/chromedriver";
	WebDriver driver ;
	
  @Test
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
  	  driver = new ChromeDriver();	
  	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }
  
  @Test(dependsOnMethods= {"launchBrowser"})
  public void verifyfaceBookTitle() {
  	  driver.get(siteUrl);	
  	  soft.assertEquals("FB Title", driver.getTitle());
  	 try {
 		Thread.sleep(3000);
 	} catch (InterruptedException e) {
 		e.printStackTrace();
 	}
  }
  
  @Test(dependsOnMethods= {"verifyfaceBookTitle"})
  public void loginFaceBook() {
  	  driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
  	  driver.findElement(By.id("pass")).sendKeys("abc123");
  	  driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
  	  soft.assertTrue(true);
  	 try {
 		Thread.sleep(3000);
 	} catch (InterruptedException e) {
 		e.printStackTrace();
 	}
  }
}
