package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filpkart {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/dataproperties1.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String Url1=p.getProperty("url1");
		String UN1=p.getProperty("un1");
		String password1=p.getProperty("pw1");
		
		WebDriver driver=new ChromeDriver();
		driver.get(Url1);
		driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']/../..//input")).sendKeys(UN1);
		driver.findElement(By.xpath("//span[text()='Enter Password']/../..//input")).sendKeys(password1);
		driver.findElement(By.xpath("//span[text()='Login']/../..//button")).click();

	}

}
