package com.raq.test;

import java.io.IOException;

import com.raq.pages.HomePage;
import com.raq.pages.JoinUsPage;
import com.raq.testbase.TestBase;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;


public class HomePageTest extends TestBase {
	
	HomePage homePage;
	JoinUsPage joinUsPage;
	

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	
@BeforeClass
public void setUp() throws IOException {	
		initialize();
		homePage= new HomePage();	
	
}

@Test(priority=1)
public void titleValidation() throws IOException, InterruptedException {

	String ptitle = homePage.pageTitle();
	System.out.println("pagetitle is:"+ ptitle);
	Assert.assertEquals(ptitle,"Raqmiyat | IT Consulting Services Companies Dubai UAE & KSA");
}


@Test(priority=2)
public void imageValidation() {
	boolean Flag = homePage.checkImage();
	Assert.assertTrue(Flag,"Home Page logo not displayed");
}

@Test(priority=3)
public void linkValidation() throws IOException {
	joinUsPage = homePage.checkLink() ;
}


@AfterClass
public void tearDown() {
	driver.quit();
}




}
