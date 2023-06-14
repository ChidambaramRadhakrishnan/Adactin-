package Data_Driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.reporters.jq.Main;

public class ExcelWrite {

	
	public static void ExcelWrite() throws Exception {
		
		File fl=new File("C:\\Users\\Chidambaram\\eclipse-workspace\\Adactin.com\\ExcelSheet\\oneStar.xlsx");
		
		FileInputStream flips=new FileInputStream(fl);
		
		Workbook wb=new XSSFWorkbook(flips);
		
		Sheet sheet = wb.createSheet("RockStar");
		
		
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Name");
		sheet.getRow(0).createCell(1).setCellValue("Age");
		sheet.getRow(0).createCell(2).setCellValue("Job");
		
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("Messi");
		sheet.getRow(1).createCell(1).setCellValue(45000);
		sheet.getRow(1).createCell(2).setCellValue("Soccer");
		
		sheet.createRow(2);
		sheet.getRow(2).createCell(0).setCellValue("Ronaldo");
		sheet.getRow(2).createCell(1).setCellValue(32000);
		sheet.getRow(2).createCell(2).setCellValue("Soccer");
		
		sheet.createRow(3);
		sheet.getRow(3).createCell(0).setCellValue("Chidambaram R");
		sheet.getRow(3).createCell(1).setCellValue(45000000.005546546E232);
		sheet.getRow(3).createCell(2).setCellValue("SuperMan");
		
		
		sheet.createRow(4);
		sheet.getRow(4).createCell(0).setCellValue("Chidambaram R");
		sheet.getRow(4).createCell(1).setCellValue(89000.56560E203);
		sheet.getRow(4).createCell(2).setCellValue("Developer and Enterpreneur.");
		
		FileOutputStream flops=new FileOutputStream(fl);
		
		wb.write(flops);
		
		wb.close();
		
	}
	public static void main(String[] args) throws Exception {
		ExcelWrite();
	}
}
