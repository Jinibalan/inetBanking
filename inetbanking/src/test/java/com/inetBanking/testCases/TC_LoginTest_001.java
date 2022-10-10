package com.inetBanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001  extends BaseClass


{

	
	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Username);
		logger.info("Entered username"+Username);
		
		lp.setPassword(password);
		logger.info("Entered password -"+password);
		
		
		try {
			lp.clickSubmit();
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}
		try{
		    System.out.println("Waiting for Alert");
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
		   wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		    //System.out.println("Alert Displayed");
		}
		catch (Exception e){
		    System.out.println("Alert not Displayed");
		}
		
		if(driver.getTitle().equals("Guru99 Bank Home Page"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}
