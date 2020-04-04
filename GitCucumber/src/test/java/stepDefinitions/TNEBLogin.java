package stepDefinitions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import cucumber.api.java.en.Then;

@Features("Login Test")
public class TNEBLogin {
	
	WebDriver driver;
	
	
	@Before
	public void setUp() throws Throwable{
		        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
	}  
	
	
    @Given("^Navigate to TNEB Login page$")
    @Test
    public void navigate_to_tneb_login_page() throws Throwable {
         driver.get("https://www.facebook.com/n");
    }

    @Description("Test Description: Login test with valid username and password.")
    @When("^User enters username and password$")
    @Test
    public void user_enters_username_and_password() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("prawinmv");
        driver.findElement(By.id("pass")).sendKeys("Prince@30");
        driver.findElement(By.xpath("//*[@value='Log In']")).click();
    }

    @Then("^User redirected to Home Page$")
    @Test
    public void user_redirected_to_home_page() throws Throwable {
     String ptitle = driver.getTitle();
     Assert.assertEquals(ptitle,"Facebook");
    }
	
      
    @After
    public void user_close_the_browser() throws Throwable{	
    	driver.quit();
    }

	
}
