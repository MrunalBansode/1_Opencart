package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyAccountPage;
import test_base.BaseClass;
import utilities.Dataprovider;

public class Tc_003_LoginDataDriven extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = Dataprovider.class)
	public void test_loginddt(String email, String password, String exp)
	{
		 logger.info("**** Starting Tc_002_LoginTest ****");
		 
		try
		{
        
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickLogin();
		logger.info("Clicked on Login link");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmailadd(email);
		lp.setPassword(password);
		lp.clicklogin();
		
		MyAccountPage AP = new MyAccountPage(driver);
		boolean targetpage = AP.isMyAccountPageExists();
		
		if(exp.equals("valid"))
		{
			if(targetpage==true)
			{
				AP.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				AP.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finish Tc_002_LoginTest ****");
		
	}
}
