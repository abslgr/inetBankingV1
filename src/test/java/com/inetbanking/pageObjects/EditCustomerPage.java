package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver driver;

	public EditCustomerPage(WebDriver driver) {
		driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement editCustomer;

	@FindBy(name = "cusid")
	@CacheLookup
	WebElement customerid;

	@FindBy(name = "AccSubmit")
	@CacheLookup
	WebElement submit;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement newaddress;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement butnsubmit;

	@FindBy(xpath = "//table[@id='customer']//tr[4]//td[2]")
	@CacheLookup
	WebElement cid;

	String ids;

	public void getId() {
		String txtid = cid.getText();
		ids = txtid;
	}

	public void clickEditCustomer() {
		editCustomer.click();
	}

	public void custID() {

		customerid.sendKeys(ids);

	}

	public void clickSubmit() {
		submit.click();
	}

	public void newAddress() {
		newaddress.clear();

		newaddress.sendKeys("goa");
	}

	public void newSubmit() {

		butnsubmit.click();
	}

}
