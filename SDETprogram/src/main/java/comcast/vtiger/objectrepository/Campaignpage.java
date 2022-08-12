package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignpage 
{
	public Campaignpage(WebDriver driver)
	{
PageFactory.initElements(driver,this);
}

	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Plusbutton;
	
	@FindBy(name="campaignname")
	private WebElement Createcampaignfield;
	
	@FindBy(name="button")
	private WebElement Savebutton;
	

	

	public WebElement getPlusbutton() {
		return Plusbutton;
	}

	public WebElement getCreatecampaignfield() {
		return Createcampaignfield;
	}

	public WebElement getSavebutton() {
		return Savebutton;
		
		
	}
	//business logics
	/**
	 * 
	 * @param username
	 * @param password
	 * @param campname
	 */
	

	
		public void Plusbutton()
		{
			Plusbutton.click();
		}
			public void Createcampaignfield(String campname)
			{
				Createcampaignfield.sendKeys(campname);
			}
			public void Savebutton()
			{
				Savebutton.click();
			
	 }
	
}
