/**
 * 
 */
/**
 * @author mvprawin
 *
 */
package utility;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


import org.testng.Assert;

public class ImageComparison {
	
	
	public static void imgScreenshot(WebDriver driver,String img) throws IOException, InterruptedException {  
    
    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Thread.sleep(3000);
            FileUtils.copyFile(screenshot, new File(img));
	}	
	
	

	
	public static void imgDownload(WebDriver driver,String img_url,String img_src, String img ) throws IOException, InterruptedException {  
         
		     URL url = new URL(img_url);
		     BufferedImage bufImgOne = ImageIO.read(url);
		     Thread.sleep(3000);
		     ImageIO.write(bufImgOne, "jpg", new File(img));	
		     Thread.sleep(3000);
	 		}
	
	public static Boolean imgScreen(WebDriver driver,String img) throws IOException, InterruptedException {  
		
		Screen screen = new Screen();
		Pattern pic = new Pattern(img);
	    
		Boolean match;
	
		if (screen.exists(pic)!=null){
			System.out.println("Image Displayed");
			screen.click();
			match = true;
			return match;
		}
		else {
			System.out.println("Image not Displayed");
			 match = false;
	         return match;
		}
			
		}
	
	public static Boolean imgCompare(WebDriver driver, File fileInput, File fileOutput) throws IOException, InterruptedException {  
        
            BufferedImage bufileInput = ImageIO.read(fileInput);
            DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
            int sizefileInput = dafileInput.getSize();   
              
            BufferedImage bufileOutput = ImageIO.read(fileOutput);
            DataBuffer dafileOutput = bufileOutput.getData().getDataBuffer();
            int sizefileOutput = dafileOutput.getSize();

            Boolean matchFlag = true;
            if(sizefileInput == sizefileOutput) {                         
               for(int j=0; j<sizefileInput; j++) {
                     if(dafileInput.getElem(j) != dafileOutput.getElem(j)) {
                    	   matchFlag = false;
                           break;
                     }
                }
               return matchFlag;
            }
            else                            
               matchFlag = false;
            return matchFlag;
         }
	

}