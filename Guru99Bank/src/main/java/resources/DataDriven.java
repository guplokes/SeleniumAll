package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public String[][] getData() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\guplokes\\selenium\\Guru99Bank\\src\\main\\java\\resources\\dataXcel.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("logindump");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		String[][] array = new String[4][2];
		int j;
		
		for(int i=1;i<=rowCount;i++) {
			j=0;
			Iterator<Cell> cell = sheet.getRow(i).cellIterator();
			while(cell.hasNext()) {
				array[i-1][j++]  = cell.next().getStringCellValue();
			}
		}
		
		//System.out.println(array);
		return array;
		
		
	
		
	}
}
