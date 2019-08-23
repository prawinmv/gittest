package framework;


import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;


public class PVM {
	
 WebDriver driver;
String pageTitle;
static String practice;
static String date ;
static String date_Up;
static String loc_name;
static String pname;
int i,m,n,j,k,l;
static File dir1,dir2;


@BeforeClass()
public void setUp() throws Exception {
System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
System.out.println("Test Git");
//ChromeOptions options = new ChromeOptions();

Map<String, Object> prefs = new HashMap<String, Object>();
prefs.put("download.default_directory","C:/Downloads");
ChromeOptions options = new ChromeOptions();
options.setExperimentalOption("prefs", prefs);
driver = new ChromeDriver(options);


System.out.println("Chrome is invoked successfully");		
driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);		
String url="https://pvpm.practicevelocity.com";
driver.get(url);
driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
}

@Test(priority=1)
public void formPage() throws Exception {
String pageurl1= driver.getCurrentUrl();
driver.findElement(By.id("txtLogin")).clear();
driver.findElement(By.id("txtLogin")).sendKeys("Marsh@listr");
driver.findElement(By.id("txtPassword")).clear();
driver.findElement(By.id("txtPassword")).sendKeys("Lister@123");
driver.findElement(By.id("btnSubmit")).click();
waitForUrlNotTobe(pageurl1,300);
		}

@Test(priority =2)
public void AnnouncementPage() throws Exception{	

Wait(driver.findElement(By.xpath("//*[@id='tdMenuBarItemAdmin1']")),200);
String pageurl2= driver.getCurrentUrl();
driver.findElement(By.xpath("//*[@id='tdMenuBarItemAdmin1']")).click();
Wait(driver.findElement(By.xpath("//*[@id='divMenuAdmin1']/div[2]/a")),80);
driver.findElement(By.xpath("//*[@id='divMenuAdmin1']/div[2]/a")).click();	
waitForUrlNotTobe(pageurl2,200);;
}
	
@Test(priority=3)
public void ChargeSummaryPage1() throws Exception{	
Wait(driver.findElement(By.name("ddlPractice")),200);
//practice = JOptionPane.showInputDialog("Enter a Practice Value");
practice ="DRXMD";
Select dropdown = new Select(driver.findElement(By.name("ddlPractice")));
driver.findElement(By.name("ddlPractice")).click();
dropdown.selectByVisibleText(practice);
driver.findElement(By.id("txtDate")).clear();
//date = JOptionPane.showInputDialog("Enter a Date Value in MM/DD/YYYY format: ");	
date = "01/15/2018";	
driver.findElement(By.id("txtDate")).sendKeys(date);	
driver.findElement(By.id("btnGo")).click();	
String str = date;
String [] arrOfStr = str.split("/");
date_Up = arrOfStr[0]+"-"+arrOfStr[1]+"-"+arrOfStr[2];

}

@Test(priority =4)
public void ChargeSummaryPage2() throws Exception {	
	
List<WebElement> locations = driver.findElements(By.cssSelector(".Table-Main>tbody>tr>td>b"));
for (i=3;i<=locations.size()+1;i++){
String loc_id= "//*[@id='frmCrgSummary']/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[1]/b";
String Enter_id="//*[@id='frmCrgSummary']/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]/input[1]";
loc_name = driver.findElement(By.xpath(loc_id)).getText();
folderCreation();			
WebElement Enter_btn = driver.findElement(By.xpath(Enter_id));
Enter_btn.click();
Wait(driver.findElement(By.xpath("//*[@id='log-book']/div[3]/table/tfoot/tr/td[4]")),200);
logBookPage();	
driver.get("https://pvpm.practicevelocity.com/17_5/CrgSummary.aspx");
} 
}


public void downloadProcess() throws InterruptedException, IOException {	
if (driver.findElements(By.id("btnViewPivotDocs")).size()!= 0){
System.out.println("Medical Record exist");			
driver.findElement(By.id("btnViewPivotDocs")).click();
waitForFileDownload();
fileRenameProcess();
windowHandling();	
} 
else {
System.out.println("Medical Record missing or doesn't exist");
}
}


public void logBookPage() throws Exception {
List<WebElement> pnames = driver.findElements(By.cssSelector(".table>tbody>tr>td"));
int s= pnames.size()/12;
System.out.println(s);		

Select list = new Select(driver.findElement(By.id("ddlClinic")));
String ddClinic=list.getFirstSelectedOption().getText();
System.out.println(ddClinic);

for (m=2; m<=s ;m++){		
		
if (ddClinic.equalsIgnoreCase("PHOENIX")) {
j=7; k=8; l=10; n=4;
} 
else {
j=8; k=9; l=11; n=5;
}
		
pname = driver.findElement(By.xpath("//*[@id='log-book']/div[3]/table/tbody/tr["+m+"]/td["+n+"]")).getText();
									  
String stat_id1= "//*[@id='log-book']/div[3]/table/tbody/tr["+m+"]/td["+j+"]/span/span/span";
String stat_id2= "//*[@id='log-book']/div[3]/table/tbody/tr["+m+"]/td["+k+"]/span/span/span";
String stat_id3= "//*[@id='log-book']/div[3]/table/tbody/tr["+m+"]/td["+l+"]/span/span/span";
					
WebElement Status1 = driver.findElement(By.xpath(stat_id1));
String Status_name1= Status1.getText();			
WebElement Status2 = driver.findElement(By.xpath(stat_id2));
String Status_name2= Status2.getText();		
WebElement Status3 = driver.findElement(By.xpath(stat_id3));
String Status_name3= Status3.getText();
		
					
				if (!Status_name1.isEmpty()){
					System.out.println(" Status1 -  Name:"+ pname+" & Status:"+ Status_name1);
					 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Status1);
						Status1.click();
						downloadProcess();
					} 
				else if(Status_name1.isEmpty() && !Status_name2.isEmpty()) {
						System.out.println("Status3 - Name:"+ pname+" & Status:"+ Status_name2);		
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Status2);
							Status2.click();		
							downloadProcess();
					} 
				else if (Status_name1.isEmpty() && Status_name2.isEmpty()){
						System.out.println("Status1 - Name:"+ pname+" & Status:"+ Status_name3);
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Status3);
						Status3.click();
						downloadProcess();		
					} 
				else {
						System.out.println("Status exist in EPS Section");
					}						
		driver.get("https://pvpm.practicevelocity.com/17_5/LogBook2.aspx");
	}

}


public void folderCreation(){
File dir1 = new File("C:/PVM/"+loc_name );
dir1.mkdir();
File dir2 = new File("C:/PVM/"+loc_name+"/"+date_Up );
dir2.mkdir();
}

public void waitForFileDownload() throws InterruptedException{
File destinationDir = new File("C:\\Downloads");
do {
Thread.sleep(5000L);
} while(!org.apache.commons.io.FileUtils.listFiles(destinationDir, new String[]{"crdownload"}, false).isEmpty());
}

public void windowHandling()throws InterruptedException {
String MainWindow=driver.getWindowHandle();
Set<String> s1=driver.getWindowHandles();		
Iterator<String> i1=s1.iterator();	
    
while(i1.hasNext())	{		
String ChildWindow=i1.next();		
if(!MainWindow.equalsIgnoreCase(ChildWindow))			
{       
// Switching to Child window
driver.switchTo().window(ChildWindow);		
driver.close();		
}		
}
driver.switchTo().window(MainWindow);
}


public void fileRenameProcess() throws IOException{
InputStream inStream = null;
OutputStream outStream = null;
File folder = new File("C:\\Downloads");
File[] listOfFiles = folder.listFiles();
//wait.until(function);
for (int f = 0; f < listOfFiles.length; f++) {    		
if (listOfFiles[f].isFile()) {
File afile =new File("C:\\Downloads\\"+listOfFiles[f].getName());
File bfile =new File("C:\\PVM\\"+loc_name+"\\"+date_Up+"\\"+pname+".tif");
inStream = new FileInputStream(afile);
outStream = new FileOutputStream(bfile);
byte[] buffer = new byte[1024];
int length;
//copy the file content in bytes
while ((length = inStream.read(buffer)) > 0){
outStream.write(buffer, 0, length);
 }
inStream.close();
outStream.close();
//delete the original file
afile.delete();
System.out.println("File is copied successfully!");
}
}
}


public  void waitForUrlNotTobe(String url,int t) {
WebDriverWait wait = new WebDriverWait(driver,t);        
wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));   
}

public void Wait(WebElement e,int t) {
WebDriverWait wait = new WebDriverWait(driver,t);        
wait.until(ExpectedConditions.visibilityOf(e));   
}

public void waitForTitle(String e,int t) {
WebDriverWait wait = new WebDriverWait(driver,t);        
wait.until(ExpectedConditions.titleContains(e));

}

@AfterClass()
public void tearDown() {
//driver.quit();	
}

}



