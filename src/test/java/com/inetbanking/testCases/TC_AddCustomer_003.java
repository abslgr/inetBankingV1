package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		logger.info("url is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setusername(username);
		logger.info("username entered");
		lp.setpassword(password);
		logger.info("password entered");
		lp.clickSubmit();
		logger.info("clicked on login button");
		Thread.sleep(3000);

		AddCustomerPage adcust = new AddCustomerPage(driver);
		adcust.clickAddnewcustomer();
		logger.info("clicked on new customer");
		adcust.custName("abhi");
		logger.info("custname is added");
		adcust.custGender("male");
		logger.info("gender is selected");
		adcust.custdob("11", "11", "2000");
		Thread.sleep(3000);
		logger.info("dob is added");

		adcust.custAddress("pune");
		logger.info("address is added");
		adcust.custCity("nagar");
		logger.info("city is added");
		adcust.custState("MH");
		logger.info("state is added");
		adcust.custPinno("411042");
		logger.info("pinno is added");
		String num = randomNum();
		adcust.custTelephone(num);
		logger.info("telephone no is added");
		String email = randomstring() + "@gmail.com";
		adcust.custEmail(email);
		logger.info("email id is added");
		adcust.custPassword("abcd1234");
		logger.info("passord is added");
		adcust.custSubmit();
		logger.info("clicked on submit");

		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test passed");
		} else {
			captureScreen(driver, "addNewCustomer");
			logger.warn("test failed");
			Assert.assertTrue(false);
		}
	}

}
