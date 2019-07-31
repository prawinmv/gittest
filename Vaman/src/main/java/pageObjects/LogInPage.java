package pageObjects;
 
 import utility.*;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
 
 public class LogInPage {

	 
//PAGE TITLE
public static final String LoginPageTitle="VAMAN-i2k : Login page";

//PAGE HEAERS
public static final String LoginHeader="User Authentication";
//IMAGE NAMES
public static final String actLoginPage_IMAGE1 = "SHIFT_IMAGE.jpg";
public static final String expLoginPage_IMAGE1 = "SHIFT_IMAGE.jpg";

static utility.RepositoryParser parser;
private static WebElement element;
//ELEMENTS
public static WebElement txtbx_UserName(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
      element = driver.findElement(parser.getbjectLocator(("sUsername")));
      Log.info("Username text box found");
      return element;
      
      //System.out.println("Login change message");

      }

  public static WebElement txtbx_Password(WebDriver driver) throws Exception{
	  parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
	  element = driver.findElement(parser.getbjectLocator(("sPassword")));
      Log.info("Password text box found");
      return element;

      }

  public static WebElement btn_LogIn(WebDriver driver)throws Exception{
	  parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
	  element= driver.findElement(parser.getbjectLocator(("Login")));
      Log.info("Login button found");
      return element;

      }
  public static WebElement txt_Header(WebDriver driver)throws Exception{
	  parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
	  element= driver.findElement(parser.getbjectLocator(("Header")));
      Log.info("header text button found");
      return element;

      }
  
  public static WebElement img(WebDriver driver)throws Exception{
	  parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
	  element= driver.findElement(parser.getbjectLocator(("Image")));
      Log.info("Submit button found");
      return element;

      } 
  
  public static WebElement label_Userid(WebDriver driver)throws Exception{
	  parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
	  element= driver.findElement(parser.getbjectLocator(("UserID")));
      Log.info("Submit button found");
      return element;

      }
  
  public static WebElement label_Passwd(WebDriver driver)throws Exception{
	  parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
	  element= driver.findElement(parser.getbjectLocator(("Pass")));
      Log.info("Submit button found");
      return element;

      }
  

}