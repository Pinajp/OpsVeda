package com.WebReusabilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDatareader {
	public XSSFWorkbook xsw;
	
	public TestDatareader() {
		File path = new File("C:\\Users\\Pinaj\\Automation\\OpsVeda\\TestData\\TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(path);
			 xsw = new XSSFWorkbook(fis);
		}  catch (IOException e) {
			System.out.println("TestData file not loading" + e.getMessage());
		}
	}
	
	public String getstringcelldata(String Sheetname,int rownum,int columnnum) {
		return xsw.getSheet(Sheetname).getRow(rownum).getCell(columnnum).getStringCellValue();}

}
