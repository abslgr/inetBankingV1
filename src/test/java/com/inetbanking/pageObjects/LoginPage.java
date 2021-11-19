package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtusername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement button;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;

	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		button.click();
	}

	public void clickLogout() {
		logout.click();
	}
}
