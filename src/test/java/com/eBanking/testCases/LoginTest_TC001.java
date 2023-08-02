/**
 * 
 */
package com.eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.Base.BaseClass;
import com.eBanking.pageObjects.LoginPage;

import Data.TestData;

/**
 * @author Admin
 *
 */
public class LoginTest_TC001 extends BaseClass{
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		
		lp.setuserName(username);
		logger.info("User name is entered");
		
		lp.setuserPassword(password);
		logger.info("User password is entered");
		
		lp.clickSubmit();
		logger.info("Clicked on submit button");
		
		if(driver.getTitle().contentEquals(TestData.homePageTitle)) {
			Assert.assertTrue(true);
			logger.info("Login test case passed");
		}
		else
		{
			CaptureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test case failed");
		}
	}
}
