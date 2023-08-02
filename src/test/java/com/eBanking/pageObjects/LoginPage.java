/**
 * 
 */
package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Admin
 *
 */
public class LoginPage {

	WebDriver ldriver;
		
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@name='uid']")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement btnLogin;
	
	@FindBy(linkText = "Log out")
	WebElement logoutLnk;
	
	public void setuserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setuserPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickOnLogout() {
		logoutLnk.click();
	}
}
