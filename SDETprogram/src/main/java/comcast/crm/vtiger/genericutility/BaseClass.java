package comcast.crm.vtiger.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import com.beust.jcommander.Parameters;

import comcast.vtiger.objectrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	
	Propertyfile_Utility plib=new Propertyfile_Utility();
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("database connection");
	}
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("execute script in parallel mode");
	}
	//@Parameters({"BROWSER"})
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void BC() throws Throwable
	{
		
		String Browser = plib.getPropertyKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
			if(Browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else
				if(Browser.equalsIgnoreCase("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
				}
				else
				{
					driver=new ChromeDriver();
				}
		sDriver=driver;
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		System.out.println("login to application");
		String Browser = plib.getPropertyKeyValue("browser");
		String Url = plib.getPropertyKeyValue("url");
		String Username = plib.getPropertyKeyValue("un");
		String Password = plib.getPropertyKeyValue("pw");
		
		driver.get(Url);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(Username, Password);
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void AM()
	{
		System.out.println("logout from application");
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void AC()
	{
		System.out.println("closing the browser");
	}
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("parallel execution is done");
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("database connection close");
	}
	
	

}
