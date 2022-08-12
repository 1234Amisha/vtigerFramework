package comcast.crm.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	public String getDataFromExcel(String sheetName,int RowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./data/data6.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(wb.getSheet(sheetName).getRow(RowNum).getCell(cellNum));
		
	}

}
