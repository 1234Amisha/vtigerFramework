package Practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class vtiger {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./data/propertyfile.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String Url=p.getProperty("url");
		String UN=p.getProperty("un");
		String password=p.getProperty("pw");
		
		WebDriver driver=new ChromeDriver();
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		

	}

}
