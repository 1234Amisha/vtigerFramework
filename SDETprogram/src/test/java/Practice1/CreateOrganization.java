package Practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

public class CreateOrganization {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		 DriverManager.registerDriver(driverRef);
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/");
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();


driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
driver.findElement(By.name("accountname")).sendKeys("testyantra1");
driver.findElement(By.name("button")).click();
String actdata = driver.findElement(By.className("dvHeaderText")).getText();

if(actdata.equals("testyantra1"))
{
	System.out.println("pass");
}
else
{
	System.out.println("fail");
}
	}

}
