/**
 * 
 */
/**
 * @author mvprawin
 *
 */
package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Utility {
	public static WebDriver driver = null;
	
		public static void openBrowser(String browser) throws IOException{
			
			
			System.out.println(browser);
		/*Comparing the value of parameter name if this is FF then It would launch Firefox and script that would run is as follows */
		
	
		if(browser.equalsIgnoreCase("ff")) {
			
			System.setProperty("webdriver.gecko.driver", "resources/Drivers/geckodriver.exe");
		    driver = new FirefoxDriver();
		    System.out.println("Firefox is invoked successfully");
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(Constant.URL);
							}
		
		else if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome is invoked successfully");
			System.setProperty("webdriver.chrome.driver", "resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver.manage().window().maximize();  
			driver.get(Constant.URL);
			
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.out.println("Internet Explorer is invoked successfully");
			System.setProperty("webdriver.ie.driver","resources/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver.manage().window().maximize(); 
			driver.get(Constant.URL);

		}

		driver.get(Constant.URL);
		
	}
	
	public static String getProperty(String fileName,String prop_val) throws IOException {
		String url_val;
		Properties p=new Properties();
		FileInputStream f=new FileInputStream(fileName);
		p.load(f);
		url_val=p.getProperty(prop_val);
		return url_val;		
	}
	public static String curl(WebDriver driver) throws Exception {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static void pageAssert(String actVal,String expVal) {	
		Assert.assertEquals(actVal, expVal);
	}
	
	public static void Wait(WebElement e,int t) {
		WebDriverWait wait = new WebDriverWait(driver,t);        
		wait.until(ExpectedConditions.visibilityOf(e));   
	}

	public static void waitForUrlNotTobe(String url,int t) {
		WebDriverWait wait = new WebDriverWait(driver,t);        
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));   
	}

	
	public static void waitForClickable(WebElement e,int t){
		WebDriverWait wait = new WebDriverWait(driver,t); 
             wait.until(ExpectedConditions.elementToBeClickable(e));
 }
	
	
	public static void doubleClick(WebElement element) {
		try {
			Actions action = new Actions(driver).doubleClick(element);
			action.build().perform();

			System.out.println("Double clicked the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable "
					+ e.getStackTrace());
		}
	
}
	
	public static String getErrorMsg(WebDriver driver) throws Exception {
		Alert simpleAlert = driver.switchTo().alert();
		String actVal = simpleAlert.getText();
		System.out.println(actVal);
		simpleAlert.accept();
		return actVal;		
	}
	
	public static void pageRefresh(){
	driver.navigate().refresh();
	}
	
	
	public static void waitforAlert() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,60);        
		wait.until(ExpectedConditions.alertIsPresent());
		}
	
	public static boolean isAlertPresent()throws Exception{
		 try{
		  driver.switchTo().alert();
		  return true;
		 }catch(NoAlertPresentException ex){
		  return false;
		 }
		}
	
	public static void backBtn(){
	driver.navigate().back();
	}
	
}