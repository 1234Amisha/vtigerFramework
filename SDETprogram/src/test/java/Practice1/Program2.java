package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Program2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/Book3.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int l=sh.getLastRowNum();
		for(int i=0;i<l;i++)
		{
		Row row=sh.getRow(i);	
		//Row row=sh.getRow(1);
		Cell cell = row.getCell(1);
		Cell cell1 =row.getCell(2);
		String cellvalue=cell.getStringCellValue();
		String cellvalue1=cell.getStringCellValue();
		 System.out.println(cellvalue);
		 System.out.println(cellvalue1);
		}

	}

}
