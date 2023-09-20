package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyAccountPage;
import test_base.BaseClass;


public class Tc_002_LoginTest extends BaseClass{

	@Test(groups = {"Sanity", "Master"})
	public void test_login()
	{
		try
		{
		logger.info("**** Starting Tc_002_LoginTest ****");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickLogin();
		logger.info("Clicked on Login link");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Providing login details");
		
		lp.setEmailadd(rb.getString("email")); //get from config.properties
		lp.setPassword(rb.getString("password")); //get from config.properties
		lp.clicklogin();
		logger.info("Clicked on login button");
		
		MyAccountPage AP = new MyAccountPage(driver);
		boolean targetpage = AP.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true , "invaild login data");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** Finish Tc_002_LoginTest ****");
	}

}
