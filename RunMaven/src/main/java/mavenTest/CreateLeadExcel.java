package mavenTest;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CreateLeadExcel {
	public Object[][] readExcel() throws IOException {
		 
		 //open 
		 XSSFWorkbook wBook= new XSSFWorkbook("./data/TC003_CreateLeadData.xlsx");
		 
		 XSSFSheet sheet = wBook.getSheetAt(0);
		 
		 int rowCount = sheet.getLastRowNum();
		 System.out.println(rowCount);
		 
		 XSSFRow rowHeader = sheet.getRow(0);
		 
		 int columnCount = rowHeader.getLastCellNum();
		 
		 Object[][] data= new Object[rowCount][columnCount];
		 System.out.println(columnCount);
		 
		 for (int i = 1; i <= rowCount; i++) {
			XSSFRow firstRow = sheet.getRow(i);
			
			
			for (int j = 0; j < columnCount; j++) {
				XSSFCell firstColumn = firstRow.getCell(j);
				String stringCellValue = firstColumn.getStringCellValue();
				data[i-1][j] = stringCellValue;
				System.out.println(stringCellValue);
			}
		}
		 
		 return data;
		 
		 
	 }
	
	

}
