package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.NewAccountPage;

public class TC_AddAccount_005 extends TC_AddCustomer_003 {

	String accountnumber;

	@Test(dependsOnMethods = "addNewCustomer")
	public void addAccount() throws IOException, InterruptedException {

		NewAccountPage na = new NewAccountPage(driver);

		na.getId();
		logger.info("got the customer id ");
		Thread.sleep(2000);
		na.clicknewAccount();
		logger.info("clicked on New Account");
		na.custID();
		logger.info("customer id is entered");
		na.selectaccType();
		logger.info("account type is selected");
		na.clickInDepo();
		logger.info("initial deposit amount entered");
		na.clickbutton();
		logger.info("clicked on submit button");

		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Account Generated Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			na.getAccNo();
			logger.info("got the account number");
			logger.info("test passed");
			logger.info("**************************");
		} else {
			captureScreen(driver, "addAccount");
			logger.warn("test failed");
			Assert.assertTrue(false);
		}
	}

}
