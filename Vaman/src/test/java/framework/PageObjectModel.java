/**
 * 
 */
/**
 * @author mvprawin
 *
 */
package framework;

import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.*;
import appModule.*;
import utility.*;

public class PageObjectModel  {


@BeforeClass
public void browserSetUp() throws Exception {
	System.out.println("Start of Script");
	    DOMConfigurator.configure("log4j.xml");
	    String browser = Constant.Browser;
	    Utility.openBrowser(browser);
	    Log.info("New driver instantiated");	    
}
@Test(priority =0)
public void loginPage_AssetVerification() throws Exception{
	// To go to Login page
	LandingPage_Action.clickLoginlnk(Utility.driver);
	//To verify if user is navigated to Log-in page
	Assert.assertTrue(LogInPage_Action.verifyLoginpageTitle(Utility.driver),"Login Page Title doesn't match");
	//To verify the header text in the page
	Assert.assertTrue(LogInPage_Action.verifyLoginPageHeader(Utility.driver),"Login Page Header doesn't match");
    //To verify the image in the page
	Assert.assertTrue(LogInPage_Action.loginImageVerification(Utility.driver),"Images are not same");
	
	//Using Snipping Tool
	//Assert.assertTrue(LogInPage_Action.verifyImageScreen(Utility.driver),"Image in the screen are not same");
}

@Test(priority=1,dataProvider="Data1",dataProviderClass=Dataprovider.class)
public void loginPage_errValidation (String sUsername,String sPassword,String Error_Message) throws Exception{
	LogInPage_Action.Execute1(Utility.driver, sUsername, sPassword);

		if (Utility.isAlertPresent()){	
		Assert.assertTrue(LogInPage_Action.verifyErrorMsg(Utility.driver, Error_Message),"Error message doesn't match");
		//Utility.pageRefresh();
	}	
	else{
		System.out.println("alert doesn't exist");	    
	}
	
}

@Test(priority=2,dataProvider="Data2",dataProviderClass=Dataprovider.class)
public void multipleUser_Validation(String sUsername,String sPassword,String expAccountName) throws Exception{
	LogInPage_Action.Execute2(Utility.driver, sUsername, sPassword);
    HomePage_Action.accName(Utility.driver);
    Assert.assertTrue(HomePage_Action.verifyAccName(Utility.driver,expAccountName), "Account name doesn't match");
    HomePage_Action.logOut(Utility.driver);
	
}


@Test(priority =3,dataProvider="Data3",dataProviderClass=Dataprovider.class)
public void shiftVerification(String sUsername,String sPassword,String empGroup,String empID,String from_date,String to_date) throws Exception{
	LogInPage_Action.Execute2(Utility.driver, sUsername, sPassword);
    Attendance_Action.shiftEntry(Utility.driver,empGroup,empID,from_date,to_date);
}

@Test(priority =3,dependsOnMethods={"shiftVerification"})
public void dbSetUp() throws Exception {
	Database.dbConnectionOpen();
	
}
@Test(priority =4,dependsOnMethods={"dbSetUp"},dataProvider="Data3",dataProviderClass=Dataprovider.class)
public void dbDataCheck(String empGroup,String empID,String from_date,String to_date) throws Exception {
	ShiftEntryDB_Action.shiftEntry(Utility.driver, empGroup, empID, from_date, to_date);
	HomePage_Action.logOut(Utility.driver);
	
}

@Test(priority =5,dependsOnMethods={"dbDataCheck"})
public void dbClose() throws Exception {
	Database.dbconnectionClose();	
}


@AfterClass
public void tearDown() throws Exception{
System.out.println("End of Script");
}
}