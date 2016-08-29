package Framework;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSX implements Reader {

	public List<HashMap<String,Double>> readXMLFile(String xlsxPath, String sheetName) throws IOException{
		List<HashMap<String,Double>> list = new ArrayList<HashMap<String,Double>>(); 
		FileInputStream fis = new FileInputStream(xlsxPath);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheet(sheetName);
		Iterator<Row> rowIterator = mySheet.iterator();
		Row row = rowIterator.next();
		Iterator<Cell> cellIterator = row.cellIterator();
		List<String> header = new ArrayList<String>();
		while (cellIterator.hasNext()){
			Cell cell = cellIterator.next(); 
			switch (cell.getCellType()) { 
			case Cell.CELL_TYPE_STRING: header.add(cell.getStringCellValue());
			default:
				break;
			}
		}

		//Traversing over each row of XLSX file 
		while (rowIterator.hasNext()) { 
			int count = 0;
			HashMap<String,Double> map = new HashMap<String,Double>();
			row = rowIterator.next();
			//For each row, iterate through each columns
			cellIterator = row.cellIterator();
			while (cellIterator.hasNext() && count < header.size()) { 			
				Cell cellrow = cellIterator.next(); 
				if(cellrow.getColumnIndex() != 0) {
					count++;
					switch (cellrow.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC: map.put(header.get(count) , cellrow.getNumericCellValue());
					break; 
					default:
						break;
					}
				}

			}
			list.add(map);
		}
		return list;
	}

	@Override
	public List<HashMap<String, Double>> read(ArrayList<String> parameters) {
		
		try {
			return readXMLFile(parameters.get(0), parameters.get(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
