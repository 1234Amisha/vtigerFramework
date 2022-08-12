package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comcast.crm.vtiger.genericutility.WebDriver_Utility;

public class Homepage 
{
 public Homepage(WebDriver driver)
 {
	 PageFactory.initElements(driver,this);
 }
 
 @FindBy(xpath="//a[text()='Organizations']")
 private WebElement Organizationbutton;
 
 @FindBy(xpath="//a[text()='Products']")
 private WebElement Productbutton;
 
 @FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
 private WebElement Morebutton;
 
 @FindBy(name="Campaigns")
 private WebElement Campaignbutton;
 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
 private WebElement signoutImg;
 
 
 @FindBy(xpath="//a[text()='Sign Out']")
 private WebElement Signoutbutton;

public WebElement getOrganizationbutton() {
	return Organizationbutton;
}

public WebElement getProductbutton() {
	return Productbutton;
}

public WebElement getMorebutton() {
	return Morebutton;
}

public WebElement getCampaignbutton() {
	return Campaignbutton;
}

public WebElement getSignoutImg() 
{
	return signoutImg;
}


public WebElement getSignoutbutton() {
	return Signoutbutton;
}
 //Business logics
/**
 * this method is used for homepage of the app
 * @author Amisha
 */

public void Organizationbutton()
{
	Organizationbutton.click();
}
public void Productbutton()
{
	Productbutton.click();
}
public void Morebutton(WebDriver driver) {
	WebDriver_Utility wlib=new WebDriver_Utility();
	wlib.mouseOverOnElement(driver,Morebutton);
}
	public void Campaignbutton()
	{
		Campaignbutton.click();
	}
	//public void signoutImg()
	//{
		//signoutImg.click();
	//}
	public void Signoutbutton(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(signoutImg).click().perform();
		Signoutbutton.click();
}


}
