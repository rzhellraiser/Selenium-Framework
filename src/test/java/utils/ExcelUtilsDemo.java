package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		
		//Call excel functions
		ExcelUtils excel = new ExcelUtils(projectPath + "/excel/data.xlsx", "test-data");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}
}
