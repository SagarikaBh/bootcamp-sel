package dataproviderexcel;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataDataProvider {

	public Object[][] excelRead(String ExcelFileName) throws IOException {
		System.out.println(Paths.get("./TestData/PracticeDataProvider.xlsx").toAbsolutePath().toFile().exists());
		System.out.println(Paths.get("./TestData/PracticeDataProvider.xlsx").toAbsolutePath());
		XSSFWorkbook wbook = new XSSFWorkbook("./TestData/PracticeDataProvider.xlsx");
		// To enter a particular sheet either using sheet name or index
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		// number of active rows present in sheet
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		// To find number of columns from header
		short colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(colCount);
		// if object then good
		// String[][] data = new String[rowCount][colCount];
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) { 
		XSSFRow row = sheet.getRow(i);
		// Iterate loop for columns
		for (int j = 0; j < colCount; j++) {
		XSSFCell cell = row.getCell(j);
		// Reading data from a particular cell
		// String value = cell.getStringCellValue();
		String value = cell.toString();
		data[i - 1][j] = value;
		System.out.println("value = " + value);
		System.out.println("data = " + data);
			}
		}
		return data;

	}

}
