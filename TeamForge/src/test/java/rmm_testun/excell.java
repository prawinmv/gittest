/**
 * 
 */
/**
 * @author mvprawin
 *
 */
package rmm_testun;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class excell  {
	
static WebDriver driver;
Sheet s;

@BeforeClass
public void browserSetUp() throws Exception {

	System.out.println("chrome is invoked successfully");
}

@Test(priority=1)
public void TrackerPage() throws Exception{

	
	
	{

		FileInputStream fi = new FileInputStream("C:\\Users\\mvprawin\\Desktop\\week.xls");
		Workbook w = Workbook.getWorkbook(fi);
		s = w.getSheet(0);
		int row_count = s.getRows();
	    int i=0;
	     System.out.println(row_count);
		
	 	FileOutputStream fo = new FileOutputStream("C:\\Users\\mvprawin\\Desktop\\report.xls");
		WritableWorkbook wwb = Workbook.createWorkbook(fo);
		WritableSheet s1 = wwb.createSheet("Artifacts",0); 
		
	     for(int j=0;j<row_count-1;j++)
	{
	    	 String artifact = s.getCell(i,j+1).getContents();
	    	 System.out.println("Artifact"+"== "+j+" ==>"+artifact);
	    	 
	    	
	    		
	    		
	    		Label p1=new Label(0,0,"Artifact_ID");
	    	  	s1.addCell(p1);
	    		Label p2=new Label(1,0,"Description");
	    		s1.addCell(p2);
	    		Label p3=new Label(2,0,"Assigned_To");
	    		s1.addCell(p3);
	    		Label p4=new Label(3,0,"Status");
	    		s1.addCell(p4);
	    		Label p5=new Label(4,0,"Customer");
	    		s1.addCell(p5);
	    		Label p6=new Label(5,0,"Category");
	    		s1.addCell(p6);
	    		Label p7=new Label(6,0,"CE");
	    		s1.addCell(p7);
	    		Label p8=new Label(7,0,"URL");
	    		s1.addCell(p8);
	    		
	    		
	    		Label c0= new Label(0,j+1,"testing1");
	      		s1.addCell(c0);
	      		Label c1= new Label(1,j+1,"testing2");
	      		s1.addCell(c1);
 
	      				
	}
	     wwb.write();
     	wwb.close(); 
	     
	}
 
	}



public static void Wait(WebElement e,int t) {
	WebDriverWait wait = new WebDriverWait(driver,t);        
	wait.until(ExpectedConditions.visibilityOf(e));   
}

public static void waitForClickable(WebElement e,int t){
	WebDriverWait wait = new WebDriverWait(driver,t); 
         wait.until(ExpectedConditions.elementToBeClickable(e));
}

public static void waitForTitle(String e,int t) {
	WebDriverWait wait = new WebDriverWait(driver,t);        
	wait.until(ExpectedConditions.titleContains(e));

}
@AfterClass
public void tearDown() throws Exception{
	//driver.quit();
System.out.println("End of Script");
}
}
