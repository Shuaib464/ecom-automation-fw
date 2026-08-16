package generic_utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	private Workbook workbook;
	
	public void getExcelFile(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(fis);
	}
	
	public void getExcelFile() throws EncryptedDocumentException, IOException {
		String filePath = FileUtility.getDataFromPropertiesFile("excelFile");
		FileInputStream fis = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(fis);
	}
	
	// return cell data in String 
	public String getData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		getExcelFile();
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}
	
	public int getRowCount(String sheetName) {
		return workbook.getSheet(sheetName).getLastRowNum();       // return last row index number
	}
	
	// Data Provider method
	public Object[][] getDataForDataProvider(String sheetName){
		Sheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][cellCount];
		
		DataFormatter formatter = new DataFormatter();
		
		for(int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for(int j = 0; j < cellCount; j++) {
				data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
			}
		}
		
		return data;
	}
	
	// close workbook
	public void closeWorkbook() throws IOException {
		workbook.close();
	}
	
	
	public String getStringDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		// Get the Java Representation Object of Excel file
				FileInputStream fis = new FileInputStream("./src/test/resources/testdata/TestScriptData.xlsx");
				
				// Open excel file in Read Mode
				Workbook wb = WorkbookFactory.create(fis);
				
				// get the Sheet
				Sheet sh = wb.getSheet(sheetName);
				
				//get the row
				Row rw = sh.getRow(rowNum);
				
				// Get The cell
				Cell cell = rw.getCell(cellNum);
				
				// Fetch the Cell data
				String data = cell.getStringCellValue();
				
				wb.close();
				
				return data;
				
	}
	
	/**
	public double getNumericDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		// Get the Java Representation Object of Excel file
				FileInputStream fis = new FileInputStream("./src/test/resources/testdata/TestScriptData.xlsx");
				
				// Open excel file in Read Mode
				Workbook wb = WorkbookFactory.create(fis);
				
				// get the Sheet
				Sheet sh = wb.getSheet(sheetName);
				
				//get the row
				Row rw = sh.getRow(rowNum);
				
				// Get The cell
				Cell cell = rw.getCell(cellNum);
				
				// Fetch the Cell data
				double data = cell.getNumericCellValue();
				
				wb.close();
				
				return data;
				
	}
	**/
	public void setDataIntoExcelFile(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		// Get the Java Representation Object of Excel file
				FileInputStream fis = new FileInputStream("./src/test/resources/testdata/TestScriptData.xlsx");
				
				// Open excel file in Read Mode
				Workbook wb = WorkbookFactory.create(fis);
				
				// get the Sheet
				Sheet sh = wb.getSheet(sheetName);
				
				 // Get ROW without destroying previous cells
			    Row rw = sh.getRow(rowNum);
			    if (rw == null) {
			        rw = sh.createRow(rowNum);
			    }
				
				// Get The cell
				Cell cell = rw.createCell(cellNum);
				
				// set the Cell data
				cell.setCellValue(data);
				
				// close the input stream before writing
				fis.close();
				
				FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata/TestScriptData.xlsx");
				wb.write(fos);
				
				fos.close();
				wb.close();
				
	}
	
}
