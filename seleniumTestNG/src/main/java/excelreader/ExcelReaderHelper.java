package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderHelper {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;

	private String filepath;
	
	private LinkedHashMap<String, ArrayList<ArrayList<String>>> xlCache;

	public ExcelReaderHelper(String filepath) {
		this.filepath = filepath;
		xlCache = new LinkedHashMap<String, ArrayList<ArrayList<String>>>();
	}

	public String getDataFromExcel(String sheetname, int row, int cell) {
		if(xlCache.containsKey(sheetname))
			return getDatafromCache(sheetname, row, cell);
		else 
			return getData(sheetname, row, cell);
	}

	private String getDatafromCache(String sheetname, int row, int column) {
		ArrayList<ArrayList<String>> rowdata = xlCache.get(sheetname);
		ArrayList<String> columndata  = rowdata.get(row);
		return columndata.get(column);
	}

	private XSSFWorkbook getWorkBook() {
		if(workbook == null){
			try {
				if(new File(filepath) != null)
				{
					FileInputStream fileInputStream = new FileInputStream(filepath);
					workbook = new XSSFWorkbook(fileInputStream);
				}
			} catch (FileNotFoundException e) {
				System.out.println("Excel file is not available");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return workbook;
	}

	private String getData(String sheetname, int row, int column) {
		ArrayList<ArrayList<String>> rowdata = getRowDatafromxlandUpdateCache(sheetname);
		ArrayList<String> columndata = rowdata.get(row);
		return columndata.get(column);
	}

	private ArrayList<ArrayList<String>> getRowDatafromxlandUpdateCache(String sheetname) {

		ArrayList<ArrayList<String>> rowdata = new ArrayList<ArrayList<String>>();
		ArrayList<String> columndata =null;
		sheet = getSheet(sheetname);

		for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			columndata = new ArrayList<String>();
			columndata = getColumnData(row);
			rowdata.add(columndata);
		}
		xlCache.put(sheetname, rowdata);
		return rowdata;
	}

	private ArrayList<String> getColumnData(XSSFRow row) {
		ArrayList<String> columndata = new ArrayList<String>();
		for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
			cell = row.getCell(j);
			switch (cell.getCellType()) {
			case 0:
				columndata.add(Double.toString(cell.getNumericCellValue()).trim());
				break;
			default:
//				case 1:
				columndata.add(cell.getStringCellValue().trim());
				break;
			}
		}
		return columndata;
	} 

	private XSSFSheet getSheet(String sheet) {
		XSSFWorkbook book = getWorkBook();
		return book.getSheet(sheet);
	}
}
