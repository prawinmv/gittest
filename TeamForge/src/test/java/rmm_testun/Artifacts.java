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

public class Artifacts  {
	
static WebDriver driver;
Sheet s;
	
@BeforeClass
public void browserSetUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
    driver = new ChromeDriver();	
	driver.manage().window().maximize();
	driver.get("https://zeta.collab.net/sf/tracker/do/listArtifacts/projects.impact/tracker.technology_services_tracker");
	
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	System.out.println("chrome is invoked successfully");
}
@Test(priority=1)
public void loginPage() throws Exception{

	waitForClickable(driver.findElement(By.xpath("//a[@id='login_submit']")),200);
	driver.findElement(By.id("username")).sendKeys("pmatto");
	driver.findElement(By.id("pwd")).sendKeys("July@2017");
	
	driver.findElement(By.id("login_submit")).click();
	//System.out.println(driver.getTitle());
	//Thread.sleep(2000);
	}


@Test(priority=2)
public void TrackerPage() throws Exception{

	
	
	
	{
//read
		FileInputStream fi = new FileInputStream("C:\\Users\\mvprawin\\Desktop\\Report\\Input\\week.xls");
		Workbook w = Workbook.getWorkbook(fi);
		s = w.getSheet(0);
		int row_count = s.getRows();
	    int i=0;
	     System.out.println(row_count);
	     
	   //write
	 	FileOutputStream fo = new FileOutputStream("C:\\Users\\mvprawin\\Desktop\\Report\\Oct\\report-week.xls");
	 	WritableWorkbook wwb = Workbook.createWorkbook(fo);
	 	WritableSheet s1 = wwb.createSheet("Artifacts",0); 
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
		
	     for(int j=0;j<row_count-1;j++)
	{
	    	 String artifact = s.getCell(i,j+1).getContents();
	    	 System.out.println("Artifact : "+artifact);
	    	 
	    	 driver.get("https://zeta.collab.net/sf/go/artf"+artifact);
	    	 String url = "https://zeta.collab.net/sf/go/artf"+artifact;
	
	Thread.sleep(3000);
	
		String Artifact_title = driver.findElement(By.xpath("//*[@id='main']/table[1]/tbody/tr[1]/td")).getText();
  		 //System.out.println(Artifact_title);
  		String textStr[] = Artifact_title.split("\\r\\n|\\n|\\r");
  		//System.out.println(textStr[0]);
  		String textStr1[] = textStr[0].split(":");
  		//System.out.println(textStr1[0]);
  		String textStr2[] = textStr1[0].split("\\s");
  		System.out.println(textStr2[1].trim());
  	 
  		Label c0= new Label(0,j+1,textStr2[1].trim());
  		s1.addCell(c0);
  		//System.out.println(textStr1[1].trim()+" :"+textStr1[2]);
  		Label c1= new Label(1,j+1,textStr1[1].trim());
  		s1.addCell(c1);
  		 
  		 String Assigned_To = driver.findElement(By.xpath("//*[@id='assignedTo']/div/div/label")).getText();
  		 System.out.println(Assigned_To);
  		Label c2= new Label(2,j+1,Assigned_To);
  		s1.addCell(c2); 
  		 
  		 
  		 Select se2=new Select(driver.findElement(By.id("selectedStatus")));
  		 WebElement option2 = se2.getFirstSelectedOption();
  		 String Status=option2.getText();
  		 System.out.println(Status);
  		Label c3= new Label(3,j+1,Status);
  		s1.addCell(c3);
  		 
  		 Select se3=new Select(driver.findElement(By.id("customer")));
  		 WebElement option3 = se3.getFirstSelectedOption();
  		 String Customer=option3.getText();
  		 System.out.println(Customer);
  		Label c4= new Label(4,j+1,Customer);
  		s1.addCell(c4);
  		 
  		 Select se4=new Select(driver.findElement(By.id("category")));
  		 WebElement option4= se4.getFirstSelectedOption();
  		 String Category=option4.getText();
  		 System.out.println(Category);
  		Label c5= new Label(5,j+1,Category);
  		s1.addCell(c5);
  		 
  		 Select se5=new Select(driver.findElement(By.id("fv_id_fild36654")));
  		 WebElement option5= se5.getFirstSelectedOption();
  		 String CE=option5.getText();
  		 System.out.println(CE);
  		Label c6= new Label(6,j+1,CE);
  		s1.addCell(c6);	
	
  		Label c7= new Label(7,j+1,url);
  		s1.addCell(c7);	
	
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
	driver.quit();
System.out.println("End of Script");
}
}
