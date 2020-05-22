package excelUtility;

import java.util.ArrayList;

public class GetTestDataFromXl {
	static XlsReader reader;
	static String path = "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice+Java\\src\\test\\java\\testData\\Book11.xlsx";
	static String sheetName = "crmTestData";

	public static ArrayList<Object[]> getExcelData() {

	ArrayList<Object[]> myData = new ArrayList<Object[]>();

	try {
	reader = new XlsReader(path);
	} catch (Exception e) {
	e.printStackTrace();
	}

	int rowCount = reader.getRowCount(sheetName);

	//reader.addColumn(sheetName, "status");

	for(int rowNum=2; rowNum<=rowCount; rowNum++) {
	String fname = reader.getCellData(sheetName, "firstName", rowNum);
	String lname = reader.getCellData(sheetName, "lastName", rowNum);
	String company = reader.getCellData(sheetName, "company", rowNum);
	String category = reader.getCellData(sheetName, "category", rowNum);

	Object ob[] = {fname, lname, company, category};
	myData.add(ob);
	}return myData;
	} 


}
