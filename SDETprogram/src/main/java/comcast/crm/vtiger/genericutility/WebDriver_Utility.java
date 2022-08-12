package comcast.crm.vtiger.genericutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	/**
	 * wait for page to load before identifying any synchronized element in POM
	 * @author Amisha
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 *After every actionit will wait fornext action to perform
	 *@author Amisha 
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element to be clickable in GUI, and check for specific element for every 500 milliseconds
	 * @author Amisha
	 */
	public void waitForElementTobeCickable(WebDriver driver,WebElement element)
	{
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to be clickable in GUI, and check for specific element for every 500 milliseconds
	 * @Amisha
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Window handling
	 */
	public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	{

		Set<String> idd = driver.getWindowHandles();
		Iterator<String> it = idd.iterator();
		while(it.hasNext())
		{
			String wid=it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Products&action")) 
			{
				break;
			}
		}
	}
		/**
		 * used to switch to frame window based on index
		 * @param driver
		 * @Amisha
		 */
		public void switchToFrame(WebDriver driver,int index)
		{
		driver.switchTo().frame(index);	
		}
		/**
		 * used to switch to alert window and accept(click on ok button)
		 * @param driver
		 * @Amisha
		 */
		public void switchToAlertandAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();	
		}
		/**
		 * used to switch to alert window and dismiss(click on cancel button)
		 * @param driver
		 * @Amisha
		 */
		public void switchToAlertandDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();	
		}
		/**
		 * used to frame window based on id or name attribute
		 * @param driver
		 * @param id_name_attribute
		 * @Amisha
		 */
		public void switchToFrame(WebDriver driver,String id_name_Attribute)
		{
			driver.switchTo().frame(id_name_Attribute);
		}
		/**
		 *used to select the value from the dropdown based on index
		 *@param element
		 *@param index
		 *@author Amisha 
		 */
		public void select(WebElement element,int index)
		{
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * used to select the value from the dropdown based on text
		 * @Amisha
		 */
		public void select(WebElement element,String text)
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(text);
		}
		/**
		 * used to place mouse cursor on specific element
		 * @param driver
		 * @param element
		 * @Amisha 
		 */
		public void mouseOverOnElement(WebDriver driver,WebElement element)
		{
			Actions a=new Actions(driver);
			a.moveToElement(element).perform();
		}
		/**
		 * used for right click
		 * @param driver
		 * @param element
		 * @Amisha
		 */
		public void rightClickOnElement(WebDriver driver,WebElement element)
		{
			Actions a=new Actions(driver);
			a.contextClick(element).perform();
		}
		/**
		 * used for double click
		 * @param driver
		 * @param element
		 * @Amisha
		  */
        public void doubleClick(WebDriver driver,WebElement element)
        {
        	Actions a=new Actions(driver);
			a.doubleClick(element).perform();
        }
		}
