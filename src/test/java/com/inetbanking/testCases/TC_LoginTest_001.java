package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("url is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setusername(username);
		logger.info("username entered");
		lp.setpassword(password);
		logger.info("password entered");
		lp.clickSubmit();
		logger.info("clicked on login button");

		if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login successful");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("login failed");

		}
	}

}
