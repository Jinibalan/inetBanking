package com.inetBanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddnewcustomerPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003  extends BaseClass{
	
	@Test
	public void AddnewCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Username);
		logger.info("Username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
	AddnewcustomerPage addcustomer=new AddnewcustomerPage(driver);
	logger.info("Providing the customer details");
	addcustomer.clcikAddnewcutomer();
	addcustomer.Customername("Jini");
	addcustomer.custumergender("Female");
	addcustomer.Cutomerdob("04", "08", "1985");
	Thread.sleep(3000);
	addcustomer.customerAddress("macintosh street");
	addcustomer.customercity("mascot");
	addcustomer.customerstate("NSW");
	addcustomer.customerpinno("202020");
	addcustomer.customertelephoneno("6769489");
	//addcustomer.customeremailid("");
	String email=randomstring()+"@gmail.com";
	addcustomer.customeremailid(email);
	addcustomer.customerpassword("Tani14");
	addcustomer.customersubmit();
	
	Thread.sleep(3000);
	boolean result=driver.getPageSource().contains("Customer Registered Successfully");
	
	if(result==true)
	{
		Assert.assertTrue(true);
	logger.info("testcase is passed.....");
	}
	else
	{
		Assert.assertTrue(false);
		
	}
	
	}

	
	
	}


