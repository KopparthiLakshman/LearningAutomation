package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GenessysExcelReader {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	@Test
	public void excel() throws IOException {
		
		FileInputStream fis = new FileInputStream("F:\\SeleniumTestData.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("MailPass");
		
		int rownum = workbook.getSheet("MailPass").getLastRowNum();
		int col =0;
		List<String> pass = new ArrayList<String>();
		for (int i = 0; i < rownum; i++) {
			int cellperRow = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellperRow; j++) {
				if(sheet.getRow(i).getCell(j).getStringCellValue().equals("Password"))
				{
					col = j; 
			
				}
			}
			if(i>0)
			pass.add(sheet.getRow(i).getCell(col).getStringCellValue());
		}
		System.out.println(pass);
		
		sheet.createRow(5).createCell(5).setCellValue("NewAddition");

		FileOutputStream out = new FileOutputStream(new File("F:\\SeleniumTestDatacreate.xlsx")); 
        workbook.write(out); 
        out.close();
		
		
	}
}
