package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EbayImageVerification  {

	static WebDriver driver;

	@BeforeClass
    public static void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\Docs\\seleinium\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
    	driver.get("http://www.ebay.com");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        }
 	
	 @Test
	    public void imageVerification() throws InterruptedException, FindFailed {
		 	Screen screen = new Screen();
	        Location wheelPoint = new Location(465,604);

	        Pattern img1 = new Pattern("D:/Selenium_Screenshots/eBay/1.PNG");
	        Pattern img2 = new Pattern("D:/Selenium_Screenshots/eBay/2.PNG");
	        Pattern img3 = new Pattern("D:/Selenium_Screenshots/eBay/3.PNG");
	        Pattern img4 = new Pattern("D:/Selenium_Screenshots/eBay/4.PNG");
	        Pattern img5 = new Pattern("D:/Selenium_Screenshots/eBay/5.PNG");
	        
		 
	        String img1_url_exp ="http://www.ebay.com/rpp/heart/?";
	        String img2_url_exp ="http://www.ebay.com/rpp/valentines-day/?";
	        String img3_url_exp ="http://www.ebay.com/rpp/fashion-events/fse-020116-p-se-fashion-finds/?";
	        String img4_url_exp ="http://csr.ebay.com/cse/start.jsf?";
	        String img5_url_exp ="http://www.ebay.com/rpp/zacbrownband/?";
   
	        for (int i=0;i<5;i++){
	        	
	        			if (screen.exists(img1)!=null){
	        				System.out.println("Image1 Displayed");
	        				screen.click();
	        				screen.wheel(wheelPoint,Button.WHEEL_DOWN,200);
	        				Wait(driver.findElement(By.cssSelector("a.thrd.gf-bar-a")),2000);
	        				String img1_url_act = driver.getCurrentUrl();
	        				Assert.assertTrue(img1_url_act.contains(img1_url_exp), img1_url_act);
	        				driver.navigate().back();
	        				
	        				for (int j=0;j<=i;j++){
	        					driver.findElement(By.cssSelector("button.arrow.arrow-right")).click();
	        					}
	        				}
	        			else if (screen.exists(img2)!=null){
	        				System.out.println("Image2 Displayed");
	        				screen.click();
	        				screen.wheel(wheelPoint,Button.WHEEL_DOWN,200);
	        				Wait(driver.findElement(By.cssSelector("a.thrd.gf-bar-a")),2000);
	        				String img2_url_act = driver.getCurrentUrl();
	        				Assert.assertTrue(img2_url_act.contains(img2_url_exp), img2_url_act);
	        				driver.navigate().back();
	        				for (int j=1;j<=i;j++){
	        					driver.findElement(By.cssSelector("button.arrow.arrow-right")).click();
	        					}
	        				}
	        			else if (screen.exists(img3)!=null){
	        				System.out.println("Image3 Displayed");
	        				screen.click();
	        				screen.wheel(wheelPoint,Button.WHEEL_DOWN,10);
	        				Wait(driver.findElement(By.cssSelector("span.refit-itemcard-more-options")),2000);
	        				String img3_url_act = driver.getCurrentUrl();
	        				Assert.assertTrue(img3_url_act.contains(img3_url_exp), img3_url_act);
	        				driver.navigate().back();
	        				for (int j=2;j<=i;j++){
	        					driver.findElement(By.cssSelector("button.arrow.arrow-right")).click();
	        					}
	        				}
	        			else if (screen.exists(img4)!=null){
	        				System.out.println("Image4 Displayed");
	        				screen.click();
	        				screen.wheel(wheelPoint,Button.WHEEL_DOWN,200);
	        				Wait(driver.findElement(By.cssSelector("#lnkLearnMoreQA")),2000);
	        				String img4_url_act = driver.getCurrentUrl();
	        				Assert.assertTrue(img4_url_act.contains(img4_url_exp), img4_url_act);
	        				driver.navigate().back();
	        				for (int j=3;j<=i;j++){
	        					driver.findElement(By.cssSelector("button.arrow.arrow-right")).click();
	        					}
	        				}
	        			else if (screen.exists(img5)!=null){
	        				System.out.println("Image5 Displayed");
	        				screen.click();
	        				screen.wheel(wheelPoint,Button.WHEEL_DOWN,100);
	        				Wait(driver.findElement(By.cssSelector("a.thrd.gf-bar-a")),2000);
	        				String img5_url_act = driver.getCurrentUrl();
	        				Assert.assertTrue(img5_url_act.contains(img5_url_exp), img5_url_act);
	        				driver.navigate().back();
	        				for (int j=1;j<=i;j++){
	        					driver.findElement(By.cssSelector("button.arrow.arrow-right")).click();
	        					}
	        				}
	        			else {
	        				System.out.println("Expected image not displayed in Screen:"+i+"");
	        				}
	        			
	        			driver.findElement(By.cssSelector("button.arrow.arrow-right")).click();
	        
	        }
	 
	 }
	 
public static void Wait(WebElement e,int t) {
	WebDriverWait wait = new WebDriverWait(driver,t);        
	wait.until(ExpectedConditions.visibilityOf(e));   
}


@AfterTest
public void tearDown() {
    driver.quit();
}

}
