package com.crm.Sdet.organization;

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
import comcast.vtiger.objectrepository.Homepage;
import comcast.vtiger.objectrepository.LoginPage;
import comcast.vtiger.objectrepository.Organizationpage;

public class CreateOrganizationTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})

	public void CreateOrganization1() throws Throwable
	{
		//WebDriver driver=new ChromeDriver();
		 WebDriver_Utility wlib=new WebDriver_Utility();
		//wlib.waitForPageToLoad(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Propertyfile_Utility plib=new Propertyfile_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
	
		
		Homepage homepage=new Homepage(driver);
		homepage.Organizationbutton();
		
	
		
		Organizationpage organizationpages=new Organizationpage(driver);
		organizationpages.CreateOrganizationbutton();
		
		int ranNum=jlib.getRandomNum();
		String org = elib.getDataFromExcel("Sheet1",1,1)+ranNum;
		
		organizationpages.Organizationnametextfield(org);
		organizationpages.Savebutton();
		
		
		String actdata= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(actdata.contains(org))
		 {
		 	System.out.println("pass");
		 }
		 else
		 {
		 	System.out.println("fail");
		 }
Assert.assertEquals(actdata.contains(org),true);
		 homepage.Signoutbutton(driver);
		 driver.close();
		
		

	}

	}
