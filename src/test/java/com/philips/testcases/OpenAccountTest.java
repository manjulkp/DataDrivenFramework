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


public class OpenAccountTest extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	
	public void openAccountTest( Hashtable<String,String> data) throws InterruptedException{
		
		if( !TestUtil.isTestRunnable("openAccountTest", excel))
		{
			throw new SkipException("Skipping the test as the run mode is N"+"OpenAccountTest".toUpperCase());
		}
		
		
		click("openAccount_XPATH");
		select("customer_XPATH",data.get("customer"));
		select("currency_XPATH",data.get("currency"));
		click("process_XPATH");
		
		Thread.sleep(2000);
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		//Assert.assertTrue(alert1.getText().contains(alert),"The test case is passed");
		alert1.accept();

	}
}
