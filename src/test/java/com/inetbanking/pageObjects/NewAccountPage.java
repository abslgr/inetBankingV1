package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {

	// Account Generated Successfully!!!

	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[5]/a")
	@CacheLookup
	WebElement newAccount;

	@FindBy(name = "cusid")
	@CacheLookup
	WebElement customerid;

	@FindBy(xpath = "//select[@name='selaccount']")
	@CacheLookup
	WebElement accType;

	@FindBy(name = "inideposit")
	@CacheLookup
	WebElement inDeposit;

	@FindBy(name = "button2")
	@CacheLookup
	WebElement button;

	@FindBy(xpath = "//table[@id='customer']//tr[4]//td[2]")
	@CacheLookup
	WebElement cid;

	@FindBy(xpath = "//table[@id='Accmsg']//tr[4]//td[2]")
	@CacheLookup
	WebElement caccnumber;

	String caccno;
	String ids;

	public void getAccNo() {
		String txtaccno = caccnumber.getText();
		caccno = txtaccno;
		System.out.println(caccno);
	}

	public void getId() {
		String txtid = cid.getText();
		ids = txtid;
		System.out.println(ids);
	}

	public void clicknewAccount() {
		newAccount.click();
	}

	public void custID() {

		customerid.sendKeys(ids);
	}

	public void selectaccType() {
		Select sel = new Select(accType);
		sel.selectByIndex(0);
	}

	public void clickInDepo() {

		inDeposit.sendKeys("50000");
	}

	public void clickbutton() {

		button.click();
	}
}
