package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateandDeleteproductpage {
	public CreateandDeleteproductpage(WebDriver driver)
	{
PageFactory.initElements(driver,this);
}
	
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductbutton;
	
	@FindBy(name="productname")
	private WebElement Productname;
	
	@FindBy(name="button")
	private WebElement Savebutton;
	
	@FindBy(name="Delete")
	private WebElement Deletebutton;
	


	public WebElement getCreateProductbutton() {
		return CreateProductbutton;
	}

	public WebElement getProductname() {
		return Productname;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}

	public WebElement getDeletebutton() {
		return Deletebutton;
	}

	//business logics
	/**
	 * 
	 * @param username
	 * @param password
	 * @param proname
	 */
	 
	public void CreateProductbutton()
	 {
		CreateProductbutton.click();
	 }
			public void Productname(String proname)
			{
				Productname.sendKeys(proname);
			}
			public void Deletebutton()
			{
				Deletebutton.click();
			}
			public void Savebutton()
			{
				Savebutton.click();
			}
			
	 }


