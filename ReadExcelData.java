package utility;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {



public static String[][] readdata(String ExcelFileName) throws IOException {
	XSSFWorkbook book=new XSSFWorkbook("./testData/"+ExcelFileName+".xlsx");
	XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		XSSFRow headerRow = sheet.getRow(0);
		short colCount = headerRow.getLastCellNum();
		System.out.println(colCount);
		String[][] data=new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++) {
			//XSSFRow eachRow = sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
			
			data[i-1][j]=value;
			}
			System.out.println();
		}
	return data;
		}
	}


