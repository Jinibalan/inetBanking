package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String Username = readconfig.getUsename();
	public String password = readconfig.getPasssword();
	public static WebDriver driver;

	public static Logger logger;

	
	

	@SuppressWarnings("deprecation")
	@Parameters({"browser"})

	@BeforeClass
	
	public void setup(String br) {
		
		
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		
		
		
		if (br.equals("chromepath")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();
		} else

		{
			System.setProperty("webdriver.gecko.driver", readconfig.Getfiredox());
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String  randomstring()
	{
		//In java we have Pre-defined class random string 
		String genereatesdString=RandomStringUtils.randomAlphabetic(5);
		return genereatesdString;
	}
	
	public String  randomnumber()
	{
		//In java we have Pre-defined class random string 
		String genereatesdString2=RandomStringUtils.randomNumeric(5);
		return genereatesdString2;
	}
	
}