package com.inetBanking.testCases;

import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.utilities.XLUtils;

@SuppressWarnings("unused")
public class TC_LoginDDT_002 extends BaseClass {

	//@SuppressWarnings("deprecation")
	@Test(dataProvider = "LoginData")
	public void loginDDT(String Username, String password) throws  InterruptedException
	{

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(Username);
//System.out.println(User name);
		logger.info("username provided - "+Username);

		lp.setPassword(password);
		logger.info("password provided - "+password);
		lp.clickSubmit();
		
			//Thread.sleep(3000);
		
		
		if (IsAlertPresent() == true) 
		
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		} 
		
		else 
		{

			Assert.assertTrue(true);
			
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			logger.info("Login Passed");
			lp.clickLogout();
			
           //Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}

	// user defined the function to check the alert is present or not

	public boolean IsAlertPresent()

	{
		try {
			driver.switchTo().alert();
			
			return true;
			
		} 
		catch (NoAlertPresentException e)
		{
			return false;
		}
		
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") +"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		//System.out.println(path);
		int rowNum = XLUtils.getRowCount(path,"Sheet1");
	//System.out.println(rowNum);
		int columncount = XLUtils.getCellcount(path,"Sheet1", 1);
		//System.out.println(columncount);
		String LoginData[][] = new String[rowNum][columncount];
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < columncount; j++)

			{

				
				System.out.println(LoginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j));
					
				
			}
		}
		

		return LoginData;

	}

}
