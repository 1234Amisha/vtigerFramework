package Practice1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.crm.vtiger.genericutility.Excel_Utility;
import comcast.crm.vtiger.genericutility.Java_Utility;
import comcast.crm.vtiger.genericutility.Propertyfile_Utility;
import comcast.crm.vtiger.genericutility.WebDriver_Utility;

public class MakemyTrip1 {

	public static void main(String[] args) throws Throwable {
		//using dynamic xpath
		String dateAndYear="December 2022";
		int date=7;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.get("https://www.makemytrip.com/");
	   // WebDriver_Utility wlib=new WebDriver_Utility();
       // wlib.moveByOffset(driver,10,10);
	    WebElement src = driver.findElement(By.id("fromCity"));
	    WebElement dest = driver.findElement(By.id("toCity"));
	    src.sendKeys("Mumbai");
	    driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();

		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		dest.sendKeys("delhi");
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		
		String requiredmonth = "November";
		String requiredYear = "2022";
		String requiredDate = "30";
		
		String currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
		String currentMonth = currentMonthYear.split(" ")[0];
		String currentYear = currentMonthYear.split(" ")[1];
		
		while(!(currentMonth.equalsIgnoreCase(requiredmonth)&& currentYear.equals(requiredYear)))
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			currentMonthYear= driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[2]")).getText();
			currentMonth = currentMonthYear.split(" ")[0];
			currentYear = currentMonthYear.split(" ")[1];
		}
	    
	    driver.findElement(By.xpath("(//p[.='"+requiredDate+"'])[1]")).click();
	    
	    
	}

}
