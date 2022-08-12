package com.crm.Sdet.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import comcast.vtiger.objectrepository.Homepage;
import comcast.vtiger.objectrepository.LoginPage;
import comcast.vtiger.objectrepository.Productpage;

public class CreatecampaignTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})
	public void Createcampaign() throws Throwable 
	{

		 WebDriver_Utility wlib=new WebDriver_Utility();
		
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
	
		
		Homepage homepage=new Homepage(driver);
		homepage.Morebutton(driver);
		
		homepage.Campaignbutton();
		Campaignpage createcampaign=new Campaignpage(driver);
		createcampaign.Plusbutton();
		
		int ranNum=jlib.getRandomNum();
		String campname= elib.getDataFromExcel("Sheet1",14,14)+ranNum;
		createcampaign.Createcampaignfield(campname);
		createcampaign.Savebutton();
		
			
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
