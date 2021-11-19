package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class BaseClass {
	Readconfig readconfig = new Readconfig();
	public String baseurl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
			driver = new EdgeDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseurl);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileHandler.copy(source, dest);
		System.out.println("Screenshot taken");
	}

	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}

	public String randomNum() {
		String generatednum = RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
}
