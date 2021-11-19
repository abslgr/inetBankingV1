package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addNewCustomer;

	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(name = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(id = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(name = "city")
	@CacheLookup
	WebElement txtcity;

	@FindBy(name = "state")
	@CacheLookup
	WebElement txtstate;

	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtpin;

	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txttelephone;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtemail;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement btnsubmit;

	public void clickAddnewcustomer() {
		addNewCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void custGender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm, String dd, String yyyy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}

	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custCity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custPinno(String cpin) {
		txtpin.sendKeys(cpin);
	}

	public void custTelephone(String ctel) {
		txttelephone.sendKeys(ctel);
	}

	public void custEmail(String cemail) {
		txtemail.sendKeys(cemail);
	}

	public void custPassword(String cpass) {
		txtpassword.sendKeys(cpass);
	}

	public void custSubmit() {

		btnsubmit.click();
	}

}
