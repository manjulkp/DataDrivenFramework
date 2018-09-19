package com.philips.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.philips.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	
	public void loginAsBankManager() throws InterruptedException, IOException
	{
    //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		//		Assert.assertEquals("aaaa","aaaa");
		verifyEquals("hhh","kjjk");
	click("bmlBtn_CSS");
	log.debug("The First Test case was executed");
	Thread.sleep(3000);
	Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomerBtn"))),"Login was not successful");
	}

	
}
