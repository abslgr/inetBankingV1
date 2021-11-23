package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;

public class TC_EditCustomer_004 extends TC_AddCustomer_003 {

	@Test(dependsOnMethods = "addNewCustomer")
	public void editCustomer() throws IOException, InterruptedException {

		EditCustomerPage ed = new EditCustomerPage(driver);
		ed.getId();
		Thread.sleep(2000);
		ed.clickEditCustomer();
		logger.info("clicked on edit customer");
		ed.custID();
		logger.info("cust id is entered");
		ed.clickSubmit();
		Thread.sleep(2000);
		logger.info("clicked on submit");
		ed.newAddress();
		logger.info("new address is added");
		ed.newSubmit();
		logger.info("clicked on submit button");

		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer details updated Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test passed");
			logger.info("**************************");
		} else {
			captureScreen(driver, "editCustomer");
			logger.warn("test failed");
			Assert.assertTrue(false);
		}
	}

}
