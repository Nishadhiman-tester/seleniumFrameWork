package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	public static  XSSFWorkbook wb;
	public static XSSFSheet ws;
    public static XSSFRow rw;
    public static XSSFCell cl;
    public static FileInputStream fn;
    
    public static int getRowCount(String filename,String Sheetname) throws Exception
    {
    	fn=new FileInputStream(filename);
    	wb=new XSSFWorkbook(fn);
    	ws=wb.getSheet(Sheetname);
    	int totalRow=ws.getLastRowNum();
    	return totalRow;
    	
    }
    public static int getColCount(String filename,String Sheetname) throws Exception
    {
    	fn=new FileInputStream(filename);
    	wb=new XSSFWorkbook(fn);
    	ws=wb.getSheet(Sheetname);
    	int totalCol=ws.getRow(0).getLastCellNum();
    	return totalCol;
    	
    }
    public static String getCellValue(String filename,String Sheetname,int r,int c) throws Exception
    {
    	fn=new FileInputStream(filename);
    	wb=new XSSFWorkbook(fn);
    	ws=wb.getSheet(Sheetname);
    	cl=wb.getSheet(Sheetname).getRow(r).getCell(c);
    	return cl.getStringCellValue();
    }
}
