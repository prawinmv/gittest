package com.raq.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.raq.testbase.TestBase;

public class HomePage extends TestBase{
	//Page object repositories
	
	@FindBy(xpath="//img[@src='https://www.raqmiyat.com/front/img/logo.png']")
	public static WebElement companylogo;

	@FindBy(xpath="//a[@title='Join Us']")
	public static WebElement joinUslnk;
	
	
	//Page object initialization
	public HomePage() throws IOException{
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkImage() {
		return companylogo.isDisplayed();
	}
	
	public JoinUsPage checkLink() throws IOException {
		joinUslnk.click();
		return new JoinUsPage();
	}
	
	
}


