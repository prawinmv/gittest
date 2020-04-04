package com.raq.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.raq.utils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {	
	prop = new Properties();
	FileInputStream file= new FileInputStream("src/main/java/com/raq/config/config.properties");
	prop.load(file);
	}
	
	public void initialize() {
		String BrowserName= prop.getProperty("browser");
		
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();			
			}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITY_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
		
	
}
