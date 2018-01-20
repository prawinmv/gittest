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
import java.util.concurrent.TimeUnit;

public class EBG_PROFILE  {
	
static WebDriver driver;


@BeforeClass
public void browserSetUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
    driver = new FirefoxDriver();	
	driver.manage().window().maximize();
	driver.get("C:\\Users\\mvprawin\\Desktop\\Profile_Page.html");
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	System.out.println("chrome is invoked successfully");
}
@Test(priority=1)
public void loginPage() throws Exception{

	//waitForClickable(driver.findElement(By.xpath("//a[@id='login_submit']")),200);
	driver.findElement(By.name("email")).sendKeys("prawinmv@yahoo.com");
	driver.findElement(By.name("altemail")).sendKeys("prawinmv@gmail.com");
	
	driver.findElement(By.name("fname")).sendKeys("prawin");
	driver.findElement(By.name("lname")).sendKeys("mattool");
	driver.findElement(By.name("add1")).sendKeys("103/32");
	driver.findElement(By.name("add2")).sendKeys("EAST MADA ST.,");
	driver.findElement(By.name("city")).sendKeys("vlk");
	driver.findElement(By.name("state")).sendKeys("NEWYORK");
	driver.findElement(By.name("coname")).sendKeys("lister");
	driver.findElement(By.name("title")).sendKeys("testing");
	driver.findElement(By.name("dob")).sendKeys("05/04/2017");
	driver.findElement(By.name("mphone")).sendKeys("12345");

	Select COUNTRY = new Select(driver.findElement(By.cssSelector(".T20>tbody>tr>td>div>form>font>dl>dd>select")));
	COUNTRY.selectByIndex(1);
	
		driver.findElement(By.name("zip")).sendKeys("12345");
		
		Select GENDER = new Select(driver.findElement(By.cssSelector("#gender")));
		GENDER.selectByIndex(2);
		
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	
	
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
@AfterMethod
@AfterClass
public void tearDown() throws Exception{
	//driver.quit();
//System.out.println("End of Script");
}
}
