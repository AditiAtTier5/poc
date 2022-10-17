package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLibrary {

	public static Object[][] readExcelData(String excelfileName) throws IOException {
		XSSFWorkbook wbook = new XSSFWorkbook("./data/" + excelfileName + ".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				DataFormatter formatter = new DataFormatter();
				XSSFCell cell = row.getCell(j);
				String cellValue = formatter.formatCellValue(cell);
				data[i - 1][j] = cellValue;
			}
		}
		wbook.close();
		return data;
	}
}
