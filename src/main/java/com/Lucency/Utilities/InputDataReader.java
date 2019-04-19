package com.Lucency.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.opencsv.CSVReader;

public class InputDataReader {
	
	//parameterize this
	private static final String SAMPLE_CSV_FILE_PATH = AutomationConfiguration.getConfigurationValueForProperty("DataInputFile");
	
	public static String getData(String pathname,String sheetname, int row, int col) {
		try {
//			to create and read the file
			FileInputStream file=new FileInputStream(new File(pathname));
			
//			to get the workbook
//			Here we need apache poi
			Workbook wb=WorkbookFactory.create(file);
			String data=wb.getSheet(sheetname).getRow(row).getCell(col).toString();
			return data;
			
		}
		
		catch(Exception e) {
			return "";
			
		}
		
	}
	
//	to get row count
	
	public static int getRowCount(String pathname, String sheetname)
	{
		try {
			
		
		FileInputStream file=new FileInputStream(new File(pathname));
		Workbook wb=WorkbookFactory.create(file);
		int rc=wb.getSheet(sheetname).getLastRowNum();
		return rc;
		
		}
		catch(Exception e) {
			return 0;
		}
		
	}
//	to get the cell count
	
	
	public static int getCellCount(String pathname, String sheetname, int rc)
	{
		try {
			
		
		FileInputStream file=new FileInputStream(new File(pathname));
		Workbook wb=WorkbookFactory.create(file);
		int cc=wb.getSheet(sheetname).getRow(rc).getLastCellNum();
		return cc;
		
		}
		catch(Exception e) {
			return 0;
		}
		
	}
	
	
	
	/*public static void main (String[]args)
	//getDataFromCSV() 
	{
		try {
			
			// Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
			// CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("options").withIgnoreHeaderCase().withTrim());
			 
			String value = null;
			

	             CSVReader reader2=new CSVReader(new FileReader(SAMPLE_CSV_FILE_PATH));
	             String[]nextline;
	             while((nextline=reader2.readNext()) !=null) 
	             {
	            	 if(nextline !=null) {
	            		 System.out.println(Arrays.toString(nextline));
	            		value = Arrays.toString(nextline);
	            	 }
	            //	 }
	         //    csvParser.close();
	             
			 }
			 
			
			//return value;
			
		}
		
		catch(Exception e){
			//return "";
			
		}
		
		
		
	}
	*/

}
