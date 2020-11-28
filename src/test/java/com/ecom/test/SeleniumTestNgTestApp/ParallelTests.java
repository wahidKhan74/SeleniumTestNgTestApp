package com.ecom.test.SeleniumTestNgTestApp;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParallelTests {

	WebDriver driver;
	final String amazonSiteUrl = "https://www.amazon.in/";
	final String facebookSiteUrl = "https://www.facebook.com/";
	final String chromeDriverPath = "/home/wahidkhan74gmai/selenium-workspace/driver/chromedriver";
	final String firefoxDriverPath = "/home/wahidkhan74gmai/selenium-workspace/driver/geckodriver";
	
	@Test(groups="Chrome")
	public void lauchChromeTest() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(amazonSiteUrl);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(groups="Chrome",dependsOnMethods="lauchChromeTest")
	void verifyAmazonHomePage() {
		System.out.println(Thread.currentThread().getId());
		assertEquals(driver.getCurrentUrl(), amazonSiteUrl);
		driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
	}
	
	@Test(groups="FireFox")
	public void lauchFireFoxTest() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		driver = new ChromeDriver();
		driver.get(facebookSiteUrl);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(groups="FireFox",dependsOnMethods="lauchFireFoxTest")
	void verifyFaceBookHomePage() {
		System.out.println(Thread.currentThread().getId());
		assertEquals(driver.getCurrentUrl(), facebookSiteUrl);
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	}
}
