package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement UsernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement PasswordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement Submitbutton;

	public WebElement getUsernameTextfield() {
		return UsernameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return PasswordTextfield;
	}

	public WebElement getSubmitbutton() {
		return Submitbutton;
	}
	
	//Business logic
	/**
	 * this method is used for login to app
	 * @param username
	 * @param password
	 * @author Amisha
	 */
	public void login(String username,String password)
	{
		UsernameTextfield.sendKeys(username);
		PasswordTextfield.sendKeys(password);
		Submitbutton.click();
	}

}
