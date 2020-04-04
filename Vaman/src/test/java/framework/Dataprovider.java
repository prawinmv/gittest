package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Dataprovider {
	static String TestData= "C:\\Users\\prawi\\Desktop\\RO.xls";

	//public static void main (String args[]) throws IOException{
		@Test
		public void data() throws IOException {
		FileInputStream fis = new FileInputStream(TestData);
		@SuppressWarnings("resource")
		Workbook workbook = new HSSFWorkbook(fis);
		
		Sheet sheet= workbook.getSheet("Sheet1");
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		int RowCount=sheet.getLastRowNum();
		int ColCount=sheet.getRow(0).getLastCellNum();
		
		for(int i=0; i<RowCount;i++) {
			for(int j=0;j<ColCount;j++) {
				data[i][j]=sheet.getRow(i).getCell(j).toString();
				System.out.println(data[i][j]);
			}
			
			
		}
		
	}
	 
	

}
