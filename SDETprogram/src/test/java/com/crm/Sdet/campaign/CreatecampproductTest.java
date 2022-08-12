package com.crm.Sdet.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.crm.vtiger.genericutility.BaseClass;
import comcast.crm.vtiger.genericutility.Excel_Utility;
import comcast.crm.vtiger.genericutility.Java_Utility;
import comcast.crm.vtiger.genericutility.Propertyfile_Utility;
import comcast.crm.vtiger.genericutility.WebDriver_Utility;
import comcast.vtiger.objectrepository.Campaignpage;
import comcast.vtiger.objectrepository.Createcampwithproduct;
import comcast.vtiger.objectrepository.Homepage;
import comcast.vtiger.objectrepository.LoginPage;
import comcast.vtiger.objectrepository.Productpage;

public class CreatecampproductTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})

	public void Createcamppro1() throws Throwable {
		
		
		//WebDriver driver=new ChromeDriver();
		WebDriver_Utility wlib=new WebDriver_Utility();
		//wlib.waitForPageToLoad(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Propertyfile_Utility plib=new Propertyfile_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
		
		
		Homepage homepage=new Homepage(driver);
		homepage.Productbutton();
		
		
		Productpage createproduct=new Productpage(driver);
		createproduct.CreateProductbutton();
		
		int ranNum=jlib.getRandomNum();
		String proname= elib.getDataFromExcel("Sheet1",13,13)+ranNum;
		
		Productpage productpage=new Productpage(driver);
		productpage.Productname(proname);
		productpage.Savebutton();
		
		
		homepage.Morebutton(driver);
		homepage.Campaignbutton();
		
		Campaignpage createcampaign=new Campaignpage(driver);
		createcampaign.Plusbutton();
		Createcampwithproduct products=new Createcampwithproduct(driver);
		
		
		 int ranNum1=jlib.getRandomNum();
			String campname= elib.getDataFromExcel("Sheet1",15,15)+ranNum1;
			createcampaign.Createcampaignfield(campname);
			//createcampaign.ProductPlusbutton();
			products.ProductPlusbutton();
		
		
		
			
		wlib.switchToWindow(driver,"Products&action");
		
       products.Poducttextfield(proname);
		products.Searchnowbutton(driver,proname);
		
		wlib.switchToWindow(driver,"Campaigns&action");
		createcampaign.Savebutton();
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(actdata.contains(campname))
		 {
		 	System.out.println("campaign created");
		 }
		 else
		 {
		 	System.out.println("campaign not created");
		 }
		 
		
		 Assert.assertEquals(actdata.contains(campname),true);
		 homepage.Signoutbutton(driver);
		 driver.close();
		
}

}
