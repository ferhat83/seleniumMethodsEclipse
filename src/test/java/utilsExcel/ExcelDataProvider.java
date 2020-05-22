package utilsExcel;

public class ExcelDataProvider {
	public static void main(String[] args) {
		String excelPath ="C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\excel\\data.xlsx";
		testData(excelPath,"sheet1");
	
	}
	public static void testData(String excelPath, String sheetName) {
		
		Excel excel1 = new Excel(excelPath,sheetName);
		
		int rowCount= excel1.getRowCount();
		int colCount = excel1.getColCount();
		for(int i=1; i<rowCount;i++) {
			for(int j=0;j<colCount;j++ ) {
				String cellData = excel1.getCellDataString(i, j);
				
				System.out.println(cellData);
			}
			
			
		}
		
	}

}
