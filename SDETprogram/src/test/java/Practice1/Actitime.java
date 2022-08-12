package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actitime {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/dataproperties1.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String Url2=p.getProperty("url2");
		String UN2=p.getProperty("un2");
		String password2=p.getProperty("pw2");
		
		WebDriver driver=new ChromeDriver();
		driver.get(Url2);
		driver.findElement(By.id("username")).sendKeys(UN2);
		driver.findElement(By.name("pwd")).sendKeys(password2);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		

	}

}
