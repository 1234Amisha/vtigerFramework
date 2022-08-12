package com.crm.Sdet.product;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.crm.vtiger.genericutility.BaseClass;
import comcast.crm.vtiger.genericutility.Excel_Utility;
import comcast.crm.vtiger.genericutility.Java_Utility;
import comcast.crm.vtiger.genericutility.Propertyfile_Utility;
import comcast.crm.vtiger.genericutility.WebDriver_Utility;
import comcast.vtiger.objectrepository.Homepage;
import comcast.vtiger.objectrepository.LoginPage;
import comcast.vtiger.objectrepository.Productpage;

@Listeners(comcast.crm.vtiger.genericutility.listeners.class)
public class CreateProductTest extends BaseClass
{
	@Test(groups= {"smokeTest","regressionTest"})

	public void CreateProduct() throws Throwable
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
		
		Homepage homepage=new Homepage(driver);
		homepage.Productbutton();
		
		
		Productpage createproduct=new Productpage(driver);
		createproduct.CreateProductbutton();
		
		int ranNum=jlib.getRandomNum();
		String proname= elib.getDataFromExcel("Sheet1",16,16)+ranNum;
		
		Productpage productpage=new Productpage(driver);
		productpage.Productname(proname);
		productpage.Savebutton();
		
		
		 
		String actdata = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 if(actdata.contains(proname))
		 {
		 	System.out.println("match");
		 }
		 else
		 {
		 	System.out.println("not matched");
		 }
		 
		Assert.assertEquals(actdata.contains(proname),true);
		 //Assert.assertEquals(false, true);
		homepage.Signoutbutton(driver);
		 driver.close();
		

	}

	

}
