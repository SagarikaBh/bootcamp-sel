package dataproviderexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UsingObjectData {
	public static Object[][] getTestData(String sheetName)
			throws EncryptedDocumentException, IOException, InvalidFormatException {
		XSSFWorkbook wbook = new XSSFWorkbook("./TestData/TC001_CreateTestLead.xlsx");
		// To enter a particular sheet either using sheet name or index
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		// number of active rows present in sheet
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row count= " + rowCount);
		// To find number of columns from header
		short colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(colCount);
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			// Iterate loop for columns
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				// Reading data from a particular cell

				Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				System.out.println(Arrays.toString(data));
				return data;

			}

		}
		  return null;
       }
	
	public static void main(String[] args) throws IOException, Exception, InvalidFormatException {
		UsingObjectData.getTestData("Sheet1");
}
}