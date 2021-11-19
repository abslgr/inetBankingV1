package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider = "logindata")
	public void loginDDT(String us, String pd) throws InterruptedException {
		logger.info("url is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setusername(us);
		logger.info("username entered");
		lp.setpassword(pd);
		logger.info("password entered");
		lp.clickSubmit();
		logger.info("clicked on login button");
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			logger.warn("Login Failed");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "logindata")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/TestData.xlsx";
		XLUtils xl = new XLUtils(path);
		int rownum = xl.getRowCount("Sheet1");
		int colnum = xl.getCellCount("Sheet1", rownum);

		String logindata[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}

}
