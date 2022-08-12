package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import comcast.crm.vtiger.genericutility.Excel_Utility;
import comcast.crm.vtiger.genericutility.Java_Utility;
import comcast.crm.vtiger.genericutility.Propertyfile_Utility;

public class Createcampwithproduct {

	public static void main(String[] args) throws Throwable {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Propertyfile_Utility plib=new Propertyfile_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
		String Url=plib.getPropertyKeyValue("url");
		String UN=plib.getPropertyKeyValue("un");
		String password=plib.getPropertyKeyValue("pw");
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		 //Random r=new Random();
			//int random=r.nextInt(1000);
		int ranNum=jlib.getRandomNum();
			WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
			 Actions a=new Actions(driver);
			 a.moveToElement(element).perform();
			 driver.findElement(By.name("Campaigns")).click();
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			 
			 String campname= elib.getDataFromExcel("Sheet1",1,1)+ranNum;
			
			//FileInputStream fis3=new FileInputStream("./data/data6.xlsx");
			//Workbook wb=WorkbookFactory.create(fis3);
			//Sheet sh=wb.getSheet("Sheet1");
			//Row row=sh.getRow(19);
			//Cell cell =row.getCell(19);
			 //String campname=cell.getStringCellValue();
			 System.out.println(campname);
			 
			 driver.findElement(By.name("campaignname")).sendKeys(campname);
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			
			Set<String> ele= driver.getWindowHandles();
			Iterator<String> itr = ele.iterator();
			String par=itr.next();
			String child = itr.next();
			driver.switchTo().window(child);
			
						
			driver.findElement(By.id("search_txt")).sendKeys("mobile99");
			driver.findElement(By.name("search")).click();
				driver.switchTo().window(par);
			driver.findElement(By.name("button")).click();
			
			String actdata= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if(actdata.contains(campname))
			 {
			 	System.out.println("campaign created");
			 }
			 else
			 {
			 	System.out.println("campaign not created");
			 }
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			 driver.close();
			}
	}


