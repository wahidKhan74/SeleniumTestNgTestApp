package com.ecom.test.SeleniumTestNgTestApp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgAnnotationsTest {
	
  @Test
  public void testOne() {
	  System.out.println("Test 1 is Exicuted");
  }
  
  @Test
  public void testTwo() {
	  System.out.println("Test 2 is Exicuted");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");  
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite"); 
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite"); 
  }

}
