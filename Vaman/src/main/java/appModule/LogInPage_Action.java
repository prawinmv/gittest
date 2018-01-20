package appModule;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;

import pageObjects.*; 
import utility.*;

 
 public class LogInPage_Action {
	 
	 
	 public static String getLoginpageTitle(WebDriver driver)throws Exception {
		String act_LoginPageTitle = driver.getTitle();
		return act_LoginPageTitle;
	 }
	 
	public static boolean verifyLoginpageTitle(WebDriver driver)throws Exception{
			String LoginpageTitle = LogInPage.LoginPageTitle;
     		return getLoginpageTitle(driver).equalsIgnoreCase(LoginpageTitle);
			
		}
	 
	public static String getLoginPageHeader(WebDriver driver)throws Exception {
			 String  act_headerText = LogInPage.txt_Header(driver).getText();
				return act_headerText;
			 }
		
	public static boolean verifyLoginPageHeader(WebDriver driver)throws Exception{			
			String pageHeaderText = LogInPage.LoginHeader;
			return getLoginPageHeader(driver).equalsIgnoreCase(pageHeaderText);
	
		}
	
	public static boolean loginImageVerification (WebDriver driver) throws Exception {
		String img_src = LogInPage.img(driver).getAttribute("src");
		String img_url =""+Constant.imgServer+""+img_src+"";   
		String img = "resources/Images/Actual/"+LogInPage.actLoginPage_IMAGE1+"";
			
		ImageComparison.imgDownload(driver,img_url,img_src,img); //Only for Specific Image
		//ImageComparison.imgScreenshot(driver, img);  //Full Screen
		
		File fileInput = new File("resources/Images/Expected/"+LogInPage.expLoginPage_IMAGE1+"");
	    File fileOutput = new File("resources/Images/Actual/"+LogInPage.actLoginPage_IMAGE1+"");	        
		return ImageComparison.imgCompare(Utility.driver,fileInput,fileOutput );
			
		}
	
	public static boolean verifyLoginPageImage(WebDriver driver)throws Exception{
		return loginImageVerification(driver);
		
	}
	
	public static boolean verifyImageScreen(WebDriver driver)throws Exception{
		String img ="resources/Images/Expected/Capture.png";
		return ImageComparison.imgScreen(driver, img);
		
	}
	
	public static void Execute1(WebDriver driver,String sUsername, String sPassword)throws Exception{ 
	
		Utility.Wait(LogInPage.txtbx_UserName(driver), 60);    	
		LogInPage.txtbx_UserName(driver).clear();
        LogInPage.txtbx_UserName(driver).sendKeys(sUsername);
        Log.info("Username entered in the Username text box");
        
        LogInPage.txtbx_Password(driver).clear();
		LogInPage.txtbx_Password(driver).sendKeys(sPassword);		
        Log.info("Password entered in the Password text box");
		
		Utility.waitForClickable(LogInPage.btn_LogIn(driver), 200);
        LogInPage.btn_LogIn(driver).click();
        Log.info("Login button clicked");
        Utility.waitforAlert();
        
     }
	
	
	public static void Execute2(WebDriver driver,String sUsername, String sPassword)throws Exception{ 
		
		Utility.Wait(LogInPage.txtbx_UserName(driver), 60);    	
		LogInPage.txtbx_UserName(driver).clear();
        LogInPage.txtbx_UserName(driver).sendKeys(sUsername);
        Log.info("Username entered in the Username text box");
        
        LogInPage.txtbx_Password(driver).clear();
		LogInPage.txtbx_Password(driver).sendKeys(sPassword);		
        Log.info("Password entered in the Password text box");
		
		Utility.waitForClickable(LogInPage.btn_LogIn(driver), 200);
        LogInPage.btn_LogIn(driver).click();
        Log.info("Login button clicked");
        
     }
		
	    	public static boolean verifyErrorMsg(WebDriver driver, String Error_Message)throws Exception{			
	   
			return Utility.getErrorMsg(driver).contains(Error_Message);	    
	}


    
}