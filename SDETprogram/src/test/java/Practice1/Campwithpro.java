package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import comcast.crm.vtiger.genericutility.WebDriver_Utility;


public class Campwithpro {

	public static void main(String[] args) throws Throwable {
		//FileInputStream fis=new FileInputStream("./data/propertyfile.properties");
				//Properties p=new Properties();
				//p.load(fis);
				
				//String Url=p.getProperty("url");
				//String UN=p.getProperty("un");
				//String password=p.getProperty("pw");
				
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				Propertyfile_Utility plib=new Propertyfile_Utility();
				Java_Utility jlib=new Java_Utility();
				Excel_Utility elib=new Excel_Utility();
				WebDriver_Utility wlib=new WebDriver_Utility();
				
				String Url=plib.getPropertyKeyValue("url");
				String Username=plib.getPropertyKeyValue("un");
				String password=plib.getPropertyKeyValue("pw");
				
				driver.get(Url);
				driver.findElement(By.name("user_name")).sendKeys(Username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				//Random r=new Random();
				//int ran = r.nextInt(1000);
				int ranNum=jlib.getRandomNum();
				String proname= elib.getDataFromExcel("Sheet1",14,14)+ranNum;
				
				//FileInputStream fiss=new FileInputStream("./data/data6.xlsx");
				//Workbook wb = WorkbookFactory.create(fiss);
				//Sheet sh = wb.getSheet("Sheet1");
				//Row row = sh.getRow(13);
				//Cell cell = row.getCell(13);
				//String proname = cell.getStringCellValue()+r;
				System.out.println(proname);
				
				driver.findElement(By.xpath("//a[text()='Products']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.name("productname")).sendKeys(proname);
				driver.findElement(By.name("button")).click();
				
				
				WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
				 Actions a=new Actions(driver);
				 a.moveToElement(element).perform();
				 driver.findElement(By.name("Campaigns")).click();
				 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				//Random r1=new Random();
				//int random=r1.nextInt(1000);
				 int ranNum1=jlib.getRandomNum();
					String campname= elib.getDataFromExcel("Sheet1",14,14)+ranNum1;
				
				//FileInputStream fis2=new FileInputStream("./data/data6.xlsx");
				//Workbook wb1=WorkbookFactory.create(fis2);
				//Sheet sh1 = wb1.getSheet("Sheet1");
				//Row row1 = sh1.getRow(15);
				//Cell cell1 = row1.getCell(15);
				//String campname = cell1.getStringCellValue()+r1;
				System.out.println(campname);
				driver.findElement(By.name("campaignname")).sendKeys(campname);
				driver.findElement(By.xpath("//img[@title='Select']")).click();
				
				wlib.switchToWindow(driver,"Products&action");
				//Set<String> idd = driver.getWindowHandles();
				//Iterator<String> it = idd.iterator();
				//while(it.hasNext())
				//{
					//String wid=it.next();
					//driver.switchTo().window(wid);
					//if(driver.getTitle().contains("Products&action")) 
					//{
					//	break;
					//}
				//}
				driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(proname);
				driver.findElement(By.cssSelector("input[name='search']")).click();
				driver.findElement(By.xpath("//a[text()='"+proname+"']")).click();
				//driver.findElement(By.id("search_txt")).sendKeys("mobile4567");
				//driver.findElement(By.name("search")).click();
				
				wlib.switchToWindow(driver,"Campaigns&action");
				//Set<String> idd1= driver.getWindowHandles();
				//Iterator<String> it1= idd1.iterator();
				//while(it1.hasNext())
				//{
					//String wid1=it1.next();
					//driver.switchTo().window(wid1);
					//if(driver.getTitle().contains("Campaigns&action")) 
					//{
					//	break;
					//}
				//}
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
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
