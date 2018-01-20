/**
 * 
 */
/**
 * @author mvprawin
 *
 */
package framework;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




















import pageObjects.ShiftPage;
import appModule.*;
import utility.*;

public class attendance  {

	private WebDriver driver;
	
	 @BeforeClass
	  public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("http://acxiomoffshore.listertech.in/shift_mgmt/pam-login.php");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 
	  @Test
	  public void testMytrip() throws Exception {
		  WebDriverWait wait = new WebDriverWait(driver,120);
		  
		  String s1= driver.findElement(By.xpath("html/body/table/tbody/tr/td[2]/form/div/table/tbody/tr[1]/td/b")).getText();
		  
		  System.out.println(s1);
	    driver.findElement(By.id("uid")).sendKeys("202");
	    driver.findElement(By.id("pwd")).sendKeys("202");
	    String curl1 = driver.getCurrentUrl();
	    
	    
	    /*driver.findElement(By.name("login")).click();	    
	    wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(curl1)));
	  
	    driver.findElement(By.id("Attendance")).click();
    	
	    
	    Select emp_grp_list = new Select(driver.findElement(By.name("emp_grp_form")));
	    emp_grp_list.selectByValue("LEAD");
	    
	    Select emp_id_list = new Select(driver.findElement(By.name("emp_id_form")));
	    emp_id_list.selectByValue("202");
	    
	    
	      driver.findElement(By.name("p_st_dt_form")).click();
	    
	      String string = "19-Oct-2016";
	      String[] parts = string.split("-");
	      String date  = parts[0];
	      String month = parts[1];
	      String year  = parts[2];	      
	
	      Select mm =new Select(driver.findElement(By.xpath("//select[@id='scwMonths']")));
	      Select yy =new Select(driver.findElement(By.xpath("//select[@id='scwYears']")));
	      
	      mm.selectByValue(month);
	      yy.selectByValue(year);	      
	      int FromDate = Integer.parseInt(date) + 4;
	      driver.findElement(By.xpath("//td[contains(@id,'"+FromDate+"')]")).click();
	      
	       String curl2=driver.getCurrentUrl();
	      
	      driver.findElement(By.xpath("//input[@value='Retrieve']")).click();
	      
	      
	      wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(curl2)));
	         	 
	      String s= driver.findElement(By.xpath("//*[@id='user_css']/table[3]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]")).getText();
	      
	      System.out.println(s);*/
	      
	      
	     // driver.findElement(By.xpath("//input[@value='Clear']")).click();
	      //driver.findElement(By.name("p_st_dt_form")).click();
    /* Calendar currentDate = Calendar.getInstance();
	      currentDate.add(Calendar.DATE, 4);
	  	  DateFormat dateFormat = new SimpleDateFormat("dd"); 
          String today = dateFormat.format(currentDate.getTime()); 
          System.out.println(today);
          driver.findElement(By.xpath("//td[contains(@id,'"+today+"')]")).click();*/
      	
		
	  }
	  
	  @AfterClass
	  public void tearDown() throws Exception {
	 System.out.println("End of Script");
	  }

}