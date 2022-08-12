package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Makemytrip {
	public static void main(String args[]) throws IOException
	{
		String dateAndYear="December 2022";
		int date=7;
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.id("fromCity")).sendKeys("new delhi");
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		
		driver.findElement(By.id("toCity")).sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		//driver.findElement(By.xpath("//p[text()='7']")).click();
		
		String requiredmonth = "November";
		String requiredYear = "2022";
		String requiredDate = "29";
		
		//driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		
		String currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
		//driver.findElement(By.xpath("//p[text()='7']")).click();
		String currentMonth = currentMonthYear.split(" ")[0];
		String currentYear = currentMonthYear.split(" ")[1];
		
		while(!(currentMonth.equalsIgnoreCase(requiredmonth)&& currentYear.equals(requiredYear)))
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			//driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[2]")).click();
			currentMonthYear= driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
			//driver.findElement(By.xpath("(//p[text()='7'])[2]")).click();
			currentMonth = currentMonthYear.split(" ")[0];
			currentYear = currentMonthYear.split(" ")[1];
		}
	    
	    driver.findElement(By.xpath("(//p[.='"+requiredDate+"'])[1]")).click();
	}   
	    
	}
		
		



