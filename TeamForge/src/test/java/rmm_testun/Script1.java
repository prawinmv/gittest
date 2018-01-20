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

public class Script1  {
	
static WebDriver driver;


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
	driver.findElement(By.id("pwd")).sendKeys("April@2017");
	
	driver.findElement(By.id("login_submit")).click();
	}


@Test(priority=2)
public void TrackerPage() throws Exception{

	

	driver.findElement(By.xpath("//*[@id='filter']/td[4]/div/div/input")).click();
	driver.findElement(By.xpath("//*[@id='filter']/td[4]/div/div/input")).sendKeys("sudheer");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[contains(.,'Sudheer Padigi Reddy')]")).click();
	driver.findElement(By.xpath("//*[@id='filter']/td[4]/div/div/input")).click();
	driver.findElement(By.cssSelector("#applyfilterbutton > #applyfilterbutton")).click();
	}

@Test(priority=3)
public void name() throws Exception{
		Thread.sleep(2000);
	//robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	//robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	driver.findElement(By.xpath("//*[@id='_SfButton_Export']/div/a")).click();
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
