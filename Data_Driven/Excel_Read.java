package Data_Driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_Read {
	public static void readThroughout() throws Exception {
		File fl = new File("C:\\Users\\Chidambaram\\eclipse-workspace\\Adactin.com\\ExcelSheet\\oneStar.xlsx");

		FileInputStream flips = new FileInputStream(fl);

		Workbook workbook = new XSSFWorkbook(flips);

		Sheet sheet = workbook.getSheetAt(2);

		int allrow = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < allrow; i++) {

			Row row = sheet.getRow(i);

			int allcolumns = row.getPhysicalNumberOfCells();

			for (int j = 0; j < allcolumns; j++) {

				Cell cell = row.getCell(j);

				CellType cellType = cell.getCellType();

				if (cellType.equals(CellType.STRING)) {
					String string = cell.getStringCellValue();
					System.out.println(" " + string);
				} else {
					double inte = cell.getNumericCellValue();
					System.out.println(" " + inte);
				}
			}
			workbook.close();
		}
	}

	public static void readRow() throws Exception {
		File fl = new File("C:\\Users\\Chidambaram\\eclipse-workspace\\Adactin.com\\ExcelSheet\\oneStar.xlsx");

		FileInputStream flips = new FileInputStream(fl);

		Workbook wb = new XSSFWorkbook(flips);

		Sheet sheet = wb.getSheetAt(2);

		int allrows = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < allrows; i++) {

			Row row = sheet.getRow(i);

			int cells = row.getPhysicalNumberOfCells();

			for (int j = 3; j < cells; j++) {

				Cell cell = row.getCell(2);

				CellType celltype = cell.getCellType();

				if (celltype.equals(CellType.STRING)) {
					String string = cell.getStringCellValue();
					System.out.println(" " + string);
				} else {
					double inte = cell.getNumericCellValue();
					System.out.println(" " + inte);
				}

			}
			wb.close();
		}
	}

	public static void readParticular() throws Exception {
		File fl = new File("C:\\Users\\Chidambaram\\eclipse-workspace\\Adactin.com\\ExcelSheet\\oneStar.xlsx");
		
		FileInputStream flips=new FileInputStream(fl);
		
		Workbook wb=new XSSFWorkbook(flips);
		
		Sheet sheet = wb.getSheetAt(1);
		
		Row row = sheet.getRow(10);
		
		Cell cell = row.getCell(1);
		
		CellType cellType = cell.getCellType();
		
		if(cellType.equals(CellType.STRING)) {
			String string = cell.getStringCellValue();
			System.out.println(string);
		}
		else {
			double inte = cell.getNumericCellValue();
			System.out.println(inte);
		}
		wb.close();
	}

	public static void main(String[] args) throws Exception {
		// readThroughout();
		//readRow();
		readParticular();
	}
}
