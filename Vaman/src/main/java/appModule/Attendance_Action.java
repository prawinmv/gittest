package appModule;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.ui.Select;

import pageObjects.*; 
import utility.*;

 
 public class Attendance_Action {


public static String accName(WebDriver driver)throws Exception{    
		String AccountName = ShiftPage.txt_MyAccount(driver).getText();
		Log.info("Account name identification performed");
        return AccountName;
        
              }

	
	public static boolean verifyAccName(WebDriver driver,String expAccountName) throws Exception{
		return accName(driver).contains(expAccountName);
		
	}

	
	public static void shiftEntry(WebDriver driver,String empGroup,String empID,String from_date,String to_date)throws Exception {
		
		String curl1= Utility.curl(driver);
		System.out.println(curl1);
		Utility.Wait(ShiftPage.lnk_Attendance(driver), 100);
		ShiftPage.lnk_Attendance(driver).click();
		Utility.waitForUrlNotTobe(curl1, 120);
		
		Utility.Wait(ShiftPage.ls_Empgroup(driver), 100);
		Select emp_grp_list = new Select(ShiftPage.ls_Empgroup(driver));
		emp_grp_list.selectByValue(empGroup);	
		
		Utility.Wait(ShiftPage.ls_EmpId(driver), 60);
		Select emp_id_list = new Select(ShiftPage.ls_EmpId(driver));
		emp_id_list.selectByValue(empID);
		
		ShiftPage.txt_StartDt(driver).click();
		Utility.Wait(ShiftPage.btn_clear(driver), 120);
		String[] fparts = from_date.split("/");
	    String fdate = fparts[0];
	    String fmonth = fparts[1];
	    String fyear  = fparts[2];
		
	    Select mm =new Select(driver.findElement(By.xpath("//select[@id='scwMonths']")));
	    mm.selectByValue(fmonth);
	    Select yy =new Select(driver.findElement(By.xpath("//select[@id='scwYears']")));
	    yy.selectByValue(fyear);
		int FromDate = Integer.parseInt(fdate) + 4;
		driver.findElement(By.xpath("//td[contains(@id,'"+FromDate+"')]")).click();
		 
		
		ShiftPage.txt_EndDt(driver).click();
		String[] tparts = to_date.split("/");
	    String tdate = tparts[0];
	    String tmonth = tparts[1];
	    String tyear  = tparts[2];
		
	    mm.selectByValue(tmonth);
	    yy.selectByValue(tyear);
		int ToDate = Integer.parseInt(tdate) + 4;
				
		String curl2= Utility.curl(driver);
        driver.findElement(By.xpath("//td[contains(@id,'"+ToDate+"')]")).click();
        ShiftPage.btn_Retrieve(driver).click();	
        Utility.waitForUrlNotTobe(curl2, 120);
	}
	
	
	
	
}