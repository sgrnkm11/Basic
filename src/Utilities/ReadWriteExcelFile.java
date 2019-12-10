package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
//How to read excel files using Apache POI
public class ReadWriteExcelFile {
 
                        
 FileInputStream fis;
 XSSFWorkbook workbook;
 XSSFSheet sheet;
     
 
 public void readCell(String path,int rowNum, int cellNum) throws IOException
 {
	 fis = new FileInputStream(path);
	 workbook = new XSSFWorkbook(fis);
	 sheet = workbook.getSheetAt(0);
	 Row row = sheet.getRow(rowNum);
	 Cell cell = row.getCell(cellNum);
	
	if(cell==null) {		 
	 System.out.println(cell+"is value");
	 }
	 else {
		 System.out.println(cell);
	 }
	// System.out.println(sheet.getRow(0).getCell(0));
 }
 

 public void WriteCell(String path,int rowNum, int cellNum,String result) throws IOException
 {
	 File src=new File(path);
	 
	  // Load the file
	 
	  fis=new FileInputStream(src);
	 
	   workbook=new XSSFWorkbook(fis);
	 
	  // get the sheet which you want to modify or create
	 
	   sheet= workbook.getSheetAt(0);
	
	   sheet.getRow(rowNum).createCell(cellNum).setCellValue(result);
	 
	// here we need to specify where you want to save file
	 
	 FileOutputStream fout=new FileOutputStream(new File(path));
	 
	// finally write content 
	 
	 workbook.write(fout);
	 
	// close the file
	 workbook.close();
	 fout.close();
	 
 }
 
 public static void main (String [] args) throws IOException, Exception{
	 
	 String path="D:\\Automation-Workspace\\claims.xlsx";
	 ReadWriteExcelFile obj=new ReadWriteExcelFile();
	 
	 String result="failed";
	 obj.WriteCell(path,4,5,result);
	 
	 Thread.sleep(8000);
	 obj.readCell(path,4,5);
 
 }
 } 
