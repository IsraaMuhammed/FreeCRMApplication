package com.freecrm.uilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.base.TestBase;

public class TestUtils extends TestBase {
	
	
	public TestUtils() throws IOException {
		super();
	}

	public static void TakePicture(String name) throws IOException {
		
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcfile, new File("D:\\FreeCRMApplication\\Snapshots\\" + name +".png"));
		
		
	}
	
public static Object[][] GetDataFromExcelSheet(String sheetname) throws IOException {
		
		File file=new File("D:\\FreeCRMApplication\\FreeCrmTestData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		fis.available();
		//apache poi
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet("ContactPageData");
		int rows=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		Object data[][]=new Object[rows][col];
		for(int x=0;x<rows;x++) {
			for(int y=0;y<col;y++) {
				data[x][y]=sheet.getRow(x).getCell(y).toString();
				//System.out.println(data[x][y]);
			}
		}
		workbook.close();
		
		return data;
		
		
	}
	
	
	
	
	
	
	

}
