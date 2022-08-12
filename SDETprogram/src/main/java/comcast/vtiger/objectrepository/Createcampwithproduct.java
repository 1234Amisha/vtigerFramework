package comcast.vtiger.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcampwithproduct 
{
	public Createcampwithproduct(WebDriver driver)
	{
PageFactory.initElements(driver,this);
}
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement Productbutton;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductbutton;
	
	@FindBy(name="productname")
	private WebElement Productname;
	
	@FindBy(name="button")
	private WebElement Savebutton;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement Morebutton;
	
	
	@FindBy(name="Campaigns")
	private WebElement Campaignbutton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Plusbutton;
	
	@FindBy(name="campaignname")
	private WebElement Createcampaignfield;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement ProductPlusbutton;
	

	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement Poducttextfield;
	
	@FindBy(css="input[name='search']")
	private WebElement Searchnowbutton;
	
	//@FindBy(xpath="//a[text()='\"+proname+\"']")
	//private WebElement Productsaved;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebutton1;
	
	
	public WebElement getProductbutton() {
		return Productbutton;
	}

	public WebElement getCreateProductbutton() {
		return CreateProductbutton;
	}

	public WebElement getProductname() {
		return Productname;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}

	public WebElement getMorebutton() {
		return Morebutton;
	}

	public WebElement getCampaignbutton() {
		return Campaignbutton;
	}

	public WebElement getPlusbutton() {
		return Plusbutton;
	}

	public WebElement getCreatecampaignfield() {
		return Createcampaignfield;
	}

	public WebElement getProductPlusbutton() {
		return ProductPlusbutton;
	}

	public WebElement getPoducttextfield() {
		return Poducttextfield;
	}

	public WebElement getSearchnowbutton() {
		return Searchnowbutton;
	}

	//public WebElement getProductsaved()
	//{
		//return Productsaved;
	//}

	public WebElement getSavebutton1() {
		return Savebutton1;
	}

	
	 
	public void Productbutton()
	 {
   Productbutton.click();
	 }
			public void CreateProductbutton()
			{
				CreateProductbutton.click();
			}
			public void Productname(String proname)
			{
				Productname.sendKeys(proname);
			}
			public void Savebutton()
			{
				Savebutton.click();
			}
			public void Morebutton(WebDriver driver)
			{
			Morebutton.click();
			}
			public void Campaignbutton()
			{
				Campaignbutton.click();
			}
			public void Plusbutton()
			{
				Plusbutton.click();
			}
			public void Createcampaignfield(String campname)
			{
				Createcampaignfield.sendKeys(campname);
			}
			public void ProductPlusbutton()
			{
				ProductPlusbutton.click();
			}
			public void Poducttextfield(String proname)
			{
				Poducttextfield.sendKeys(proname);
			}
			public void Searchnowbutton(WebDriver driver,String proname)
			{
				Searchnowbutton.click();
				driver.findElement(By.xpath("//a[text()='"+proname+"']")).click();
			}
			
			
			public void Savebutton1()
			{
				Savebutton1.click();
			}
			
	 }
	
	
	
	
	

