package appModule;
 
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.*; 
import utility.*;

 
 public class ShiftEntryDB_Action {



	
	public static void shiftEntry(WebDriver driver,String empGroup,String empID,String from_date,String to_date)throws Exception {
		
		Database.stmt = Database.con.createStatement();
		String query= "select A.EMP_CODE,B.EMP_NAME,A.ENTRY_DATE,A.SHIFT "
				+"from AD_PMS_SHIFT_DETAIL A,AD_PMS_EMP_MASTER B "
				+"WHERE A.EMP_CODE=B.EMP_CODE "
				+"AND A.EMP_CODE='"+empID+"'"
				+" order by A.ENTRY_DATE desc LIMIT 1";
		
		System.out.println(query);
		ResultSet  rs= Database.stmt.executeQuery(query);
		while (rs.next()) { 
			String db_EMP_CODE = rs.getString("EMP_CODE");
			String db_EMP_NAME = rs.getString("EMP_NAME");
			String db_ENTRY_DATE = rs.getString("ENTRY_DATE");
			String db_SHIFT = rs.getString("SHIFT");
		
			String[] ed = ShiftPage.txt_Date(driver).getText().split("/");
			String dd = ed[0];
			String mm = ed[1];
			String yy = ed[2];
			String page_date= yy+"-"+mm+"-"+dd ;
		
		Assert.assertEquals(ShiftPage.txt_Emp_code(driver).getText(),db_EMP_CODE);
		Assert.assertEquals(ShiftPage.txt_Emp_Name(driver).getText(),db_EMP_NAME);
		Assert.assertEquals(page_date,db_ENTRY_DATE);
		Assert.assertEquals(ShiftPage.txt_Shift(driver).getText(),db_SHIFT);

		}
	

    Database.stmt.close();
    rs.close();
		
	
	}
	
	
	
	
}