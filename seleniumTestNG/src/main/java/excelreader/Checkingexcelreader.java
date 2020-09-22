package excelreader;

public class Checkingexcelreader {

	
	public static void main(String[] args) {
		
		
//		Xls_Reader reader = new Xls_Reader("F:\\SeleniumTestData.xlsx");
		
		ExcelReaderHelper erh = new ExcelReaderHelper("F:\\SeleniumTestData.xlsx");
		System.out.println(erh.getDataFromExcel("MailPass", 0, 0));
		System.out.println(erh.getDataFromExcel("MailPass", 1, 0));
		System.out.println(erh.getDataFromExcel("MailPass", 2, 0));
		
	}
}
