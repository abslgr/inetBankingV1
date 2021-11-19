package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties prop;

	public Readconfig() {

		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseurl");
		return url;
	}

	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public String getChromepath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxpath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getEdgepath() {
		String edgepath = prop.getProperty("edgepath");
		return edgepath;
	}

	public String getIEpath() {
		String iepath = prop.getProperty("iepath");
		return iepath;
	}
}
