package com.eBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.Base.BaseClass;
import com.eBanking.Utilities.XLUtils;
import com.eBanking.pageObjects.LoginPage;

public class LoginDDTest_TC002 extends BaseClass{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Test(dataProvider="eBankingLoginData")
	private void LoginDDT(String uName, String pwd) throws IOException, InterruptedException{
		LoginPage lp = new LoginPage(driver);
		
		lp.setuserName(uName);
		logger.info("User name entered");
		lp.setuserPassword(pwd);
		logger.info("User password entered");
		lp.clickSubmit();
		logger.info("Clicked on submit button");
		Thread.sleep(3000);
		
		
		if (isAlertPresent()== true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			CaptureScreen(driver,"LoginDDT");
			logger.warn("Login Failed");
			assertTrue(true);
		}
		else {
			assertTrue(false);
			logger.info("Login Passed");
			js.executeScript("window.scrollBy(0,250)", "");
			lp.clickOnLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	@DataProvider(name = "eBankingLoginData")
	String[][] getData() throws IOException{
		String filePath = System.getProperty("user.dir") + "/src/test/java/com/eBanking/testData/TestData.xlsx";
		int rowNum = XLUtils.getRowCount(filePath, "LoginData");
		int colCount = XLUtils.getCellCount(filePath, "LoginData", 1);
		String logindata [][] = new String[rowNum][colCount];
		
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				logindata[i-1][j] = XLUtils.getCellData(filePath, "LoginData", i, j);
			}
		}
		return logindata;
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
		return false;
		}
	}
}