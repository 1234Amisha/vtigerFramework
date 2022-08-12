package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	public Organizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationbutton;
	
	@FindBy(name="accountname")
	private WebElement Organizationnametextfield;
	
	@FindBy(name="button")
	private WebElement Savebutton;
	


	public WebElement getCreateOrganizationbutton() {
		return CreateOrganizationbutton;
	}

	public WebElement getOrganizationnametextfield() {
		return Organizationnametextfield;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}
//business logic
	/**
	 * 
	 * @param username
	 * @param password
	 * @param org
	 */
	
	

		 public void CreateOrganizationbutton()
		 {
			CreateOrganizationbutton.click();
		 }
		 public void Organizationnametextfield(String org)
		 {
			 Organizationnametextfield.sendKeys(org);
		 }
			public void Savebutton()
			{
				Savebutton.click();
			}
			
	 }
	

