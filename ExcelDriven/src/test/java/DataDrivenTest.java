import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public ArrayList<String> getData(String testname) throws IOException {

		ArrayList<String> list = new ArrayList();

		// Identify the Test cases column by scanning the first row
		//Once column is identified then scan entire "TestCases" column to identify "Purchase" row

		FileInputStream fis = new FileInputStream("C:\\Users\\guplokes\\Downloads\\selenium\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis); //FileInputStream argument needed to access the file

		//Accessing the sheet
		int numberOfSheets = workbook.getNumberOfSheets();

		for(int i=0;i<numberOfSheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testsheet")) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify the Test cases column by scanning the first row
				Iterator<Row> rows = sheet.iterator(); //sheet is a collection of rows	
				Row firstRow = rows.next();

				Iterator<Cell> cell = firstRow.cellIterator(); //row is collection of cells(to access every column in first row)
				int column=0,k=0;

				while(cell.hasNext()) {
					Cell cellValue = cell.next();
					//System.out.println(cellValue.getStringCellValue());
					if(cellValue.getStringCellValue().equalsIgnoreCase("testdata")) {
						column=k;
					}
					k++;
				}

				//System.out.println(column);
				//One column is identified then scan entire "TestCases" column to identify "Purchase" row

				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testname)) {

						//after u grab purchase test case row pull all the data of that row and feed into test
						Iterator<Cell> ce = r.cellIterator();
						while(ce.hasNext()){
							list.add(ce.next().getStringCellValue());


						}
					}
				}

				/* ******************************************
				 * For NUMERIC EXCEL VALUES************
				 * ********************
				 * 
				 * while(rows.hasNext()) { Row r = rows.next();
				 * if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testname)) {
				 * 
				 * //after u grab purchase test case row pull all the data of that row and feed
				 * into test Iterator<Cell> ce = r.cellIterator(); while(ce.hasNext()) { Cell c
				 * = ce.next(); //check for numeric cell type
				 * if(c.getCellType()==CellType.STRING) list.add(c.getStringCellValue()); else
				 * list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
				 * 
				 * } } }
				 */

			}


		}

		return list;

	}

	public static void main(String[] args) throws IOException {



	}

}


