package pageObjects;
 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;

import utility.*;		


 public class ShiftPage {
	 
	//PAGE TITLE
	public static final String ShiftFormPageTitle="VAMAN-i2k : SHIFT FORM";
	
	static utility.RepositoryParser parser;
    private static WebElement element;

 public  static WebElement txt_MyAccount(WebDriver driver) throws Exception{
    	parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Account")));
    	Log.info("My Account name element found");
     	return element;

    }
 
 public  static WebElement lnk_Attendance(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Attendance")));
 	Log.info("Attendance link element found");
  	return element;

 }
 
 public  static WebElement ls_Empgroup(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Empgroup")));
	Log.info("Empgroup list element found");
	return element;

}
 
 public  static WebElement ls_EmpId(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("EmpId")));
	Log.info("EmpId list element found");
	return element;

}
 
 public  static WebElement btn_clear(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Clear")));
	Log.info("EmpId list element found");
	return element;

}
 
 
 
 
 public  static WebElement txt_StartDt(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("StartDt")));
	Log.info("StartDt element found");
	return element;

}
 
 public  static WebElement txt_EndDt(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("EndDt")));
	Log.info("EndDt element found");
	return element;

}
 
 public  static WebElement btn_Retrieve(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Retrieve")));
	Log.info("Log out element found");
	return element;

}
 
 public  static WebElement txt_Emp_code(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Emp_code")));
	Log.info("Emp_code element found");
	return element;

}
 
 public  static WebElement txt_Emp_Name(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Emp_Name")));
	Log.info("Emp_Name element found");
	return element;

}
 
 public  static WebElement txt_Date(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Date")));
	Log.info("Date element found");
	return element;

}
 
 public  static WebElement txt_Shift(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Shift")));
	Log.info("Shift element found");
	return element;

}
 
 public  static WebElement txt_Intime(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Intime")));
	Log.info("Intime element found");
	return element;

} 

 
 public  static WebElement lnk_Logout(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Logout")));
	Log.info("Log out element found");
	return element;

}

}