package appModule;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.ui.Select;

import pageObjects.*; 
import utility.*;

 
 public class HomePage_Action {


	 public static String accName(WebDriver driver)throws Exception{    
			String AccountName = ShiftPage.txt_MyAccount(driver).getText();
			System.out.println (AccountName);
			Log.info("Account name identification performed");
	        return AccountName;
	        
	              }
		public static boolean verifyAccName(WebDriver driver,String expAccountName) throws Exception{
			return accName(driver).contains(expAccountName);
			
		}

	
	public static void logOut(WebDriver driver)throws Exception{    
		Utility.Wait(ShiftPage.lnk_Logout(driver), 60); 
        ShiftPage.lnk_Logout(driver).click();
        Log.info("Logout img clicked");
        
     }

     
}