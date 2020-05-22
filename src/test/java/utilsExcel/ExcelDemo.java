package utilsExcel;

public class ExcelDemo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		
		Excel excl = new Excel(projectPath+"/excel/data.xlsx","sheet1");
		
		excl.getRowCount();
		excl.getCellDataString(0, 0);
		excl.getCellDataNumber(1,1);
	}
}
