package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {

	
//	static XSSFWorkbook wb;
//	static XSSFSheet sheet1;
//	public Row row;
//	public  FileInputStream fis;
//	public  String src;
//	private Cell cell;
//	
//	public ExcelDataProvider(String excelPath) // a constructor is created to load all the files that are required every time by calling this constructor
//	{
//			try 
//			{
//				
//				File src=new File(excelPath);
//				FileInputStream fis=new FileInputStream(src);
//				wb = new XSSFWorkbook(fis);
//				sheet1 = wb.getSheetAt(0);
//			
//			} catch (Exception e) {
//				
//				System.out.println(e.getMessage());
//			}
//			
//		}
//	
//	   public static void setExcelFile(String Path,String SheetName) throws Exception {
//           try {
//               // Open the Excel file
//            FileInputStream ExcelFile = new FileInputStream(Path);
//            // Access the required test data sheet
//            wb = new XSSFWorkbook(ExcelFile);
//            sheet1 = wb.getSheet(SheetName);
////           Log.info("Excel sheet opened");
//            } catch (Exception e){
//                throw (e);
//            }
//    }
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src = new File("./ApplicationTestData/AppData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			 wb = new XSSFWorkbook(fis);
			
			
		} catch (Exception e) {
			
			System.out.println("Exception is :"+e.getMessage());
		}
	}
	
	public String getData(int sheetIndex,int row,int column) {
		
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetName,int row,int column) {
		
		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
