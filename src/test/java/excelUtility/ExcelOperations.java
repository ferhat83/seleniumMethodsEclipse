package excelUtility;

public class ExcelOperations {
	public static void main(String[] args) {

		// get test data from excel:
		String path = "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice+Java\\src\\test\\java\\testData\\Book11.xlsx";
		XlsReader reader = new XlsReader(path);
		String sheetName = "crmTestData";


		// Add Sheet if it does not exist
		if( ! reader.isSheetExist("Contactss")) {
			reader.addSheet("Contactss");
			System.out.println("if the Registration sheet name doesn't exist, then add it" );
			}
		//	reader.addColumn(sheetName, "full name");
//			reader.removeColumn(sheetName, 5);
//			reader.addColumn(sheetName, "Age");
//			reader.setCellData(sheetName, "full name", 2, "Hamid Ouqaci");
//			String data = reader.getCellData(sheetName, 0, 2);
//			System.out.println(data);


		}


}
