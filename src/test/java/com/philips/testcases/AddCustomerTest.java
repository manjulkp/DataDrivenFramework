package com.philips.testcases;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.philips.base.TestBase;
import com.philips.utility.TestUtil;


public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass =TestUtil.class,dataProvider="dp") //specify the dataprovider class and the dataprovider method name 
	
	public void addCustomerTest( Hashtable<String,String> data) throws InterruptedException{
		
//		if(!Runmode.equals("Y"))
//		{
//			throw new SkipException("skipping the test case with parameter is set to N");
//		}
		
		if(!data.get("Runmode").equals("Y"))
			{
				throw new SkipException("skipping the test case with parameter is set to N");
			}
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("addCustomerBtn"))).click();
		//driver.findElement(By.cssSelector(OR.getProperty("firstname_CSS"))).sendKeys(firstname);
		type("firstname_CSS",data.get("firstname"));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(OR.getProperty("lastname_CSS"))).sendKeys(data.get("lastname"));
		driver.findElement(By.cssSelector(OR.getProperty("postcode_CSS"))).sendKeys(data.get("postcode"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("addBtn_XPATH"))).click();
		Thread.sleep(2000);
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert1.getText().contains(data.get("alert")),"The test case is passed");
		alert1.accept();
		//Forcing a test case to fail 
		//Assert.fail("the login was not successful");
		
	}
	

}
