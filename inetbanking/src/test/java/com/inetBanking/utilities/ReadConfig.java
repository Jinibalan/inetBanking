package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("/Users/jiniab/eclipse-selenium/inetBankingV2/Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL()

	{
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsename()

	{
		String uname = pro.getProperty("Username");
		return uname;
	}

	public String getPasssword()

	{
		String pwd = pro.getProperty("password");
		return pwd;
	}

	public String getChromepath() {
		String Cpath = pro.getProperty("chromepath");
		return Cpath;
	}

	public String Getfiredox() {
		String Cpath = pro.getProperty("firefox");
		return Cpath;
	}

}
