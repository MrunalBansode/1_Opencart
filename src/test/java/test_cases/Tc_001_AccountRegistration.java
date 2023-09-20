package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.AccountRegistrationPage;
import page_objects.HomePage;
import test_base.BaseClass;


public class Tc_001_AccountRegistration extends BaseClass {

       @Test(groups = {"Regression", "Master"})
		public void test_account_registration()
		{
			logger.debug("application logs......");
			logger.info("**** Starting TC_001_AccountRegistrationTest ****");
			try
			{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickRegister();
			logger.info("Clicked on register link");
			
			AccountRegistrationPage rp = new AccountRegistrationPage(driver);
			
			logger.info("Providing customer data");
			
			rp.setFirstName(randomString().toUpperCase()); //randomly generated
			
			rp.setLastName("xyz");
			
			rp.setemail(randomString()+"@gmail.com");  //randomly generated
			
			rp.setTelephone(randomNumber());  //randomly generated
			
			String password =  randomAlphaNumeric(); //randomly generated
			rp.setPassword(password);
			rp.setconfirmpassword(password);
			
			rp.setprivacypolicy();
			
			rp.clickContinue();
			logger.info("Clicked on continued");
			
			String confmsg = rp.getmsgconfirmation();
			
			logger.info("Validation expected message");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!" , "Test failed");
			}
			
			catch(Exception e)
			{
				logger.error("Test Failed");
				Assert.fail();
			}
			
			logger.info("**** Finished TC_001_AccountRegistrationTest ****");
		}
		
}

