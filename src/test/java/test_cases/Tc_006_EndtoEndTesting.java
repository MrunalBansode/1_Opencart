package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.AccountRegistrationPage;
import page_objects.CheckoutPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyAccountPage;
import page_objects.SearchPage;
import page_objects.ShoppingCartPage;
import test_base.BaseClass;



public class Tc_006_EndtoEndTesting extends BaseClass {

	@Test
	public void EndtoEndTest() throws InterruptedException {
		//	SoftAssert sa = new SoftAssert();
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage ar = new AccountRegistrationPage(driver);
			
	        ar.setFirstName(randomString().toUpperCase()); 
			
			ar.setLastName("xyz");
			
			ar.setemail(randomString()+"@gmail.com"); 
			
			ar.setTelephone(randomNumber());  
			
			String password =  randomAlphaNumeric(); 
			ar.setPassword(password);
			ar.setconfirmpassword(password);
			
			ar.setprivacypolicy();
			
			ar.clickContinue();
			
			String confmsg = ar.getmsgconfirmation();
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			Thread.sleep(2000);
			hp.clickMyAccount();
			
			MyAccountPage AP = new MyAccountPage(driver);
			AP.clickLogout();
			Thread.sleep(3000);
			
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setEmailadd(rb.getString("email")); 
			lp.setPassword(rb.getString("password")); 
			lp.clicklogin();
			
			boolean targetpage = AP.isMyAccountPageExists();
			Assert.assertEquals(targetpage, true );
			
			hp.clickMyAccount();
			AP.clickLogout();
			
			Thread.sleep(3000);
			
			hp.enterproductname("mac");
			hp.clickonsearchbtn();
			
			SearchPage sp = new SearchPage(driver);
			sp.isproductexists("MacBook Pro");
			
			Thread.sleep(2000);
			if(sp.isproductexists("MacBook Pro"))
			{
				sp.selectproduct("MacBook Pro");
				sp.setquantity("2");
				sp.clickonaddtocart();
			}
			Assert.assertEquals(sp.checkconfmsg(), true);
			Thread.sleep(2000);
			ShoppingCartPage scp = new ShoppingCartPage(driver);
			
			scp.clickonitemsbtn();
			
			scp.clickonviewcart();
			
			scp.clickoncheckoutbtn();
			
			CheckoutPage cp = new CheckoutPage(driver);
			
			cp.clickonguest();
			
			cp.clickconti();
			
		//	cp.addnewaddr();
			
			cp.addfirstname(randomString().toUpperCase());
			
			cp.addlastname(randomString().toUpperCase());
			
			cp.addemail(randomString()+"@gmail.com");
			
			cp.addphone(randomNumber());
			
			cp.setadd1("Address 1");
			
			cp.setadd2("Address 2");
			
			cp.addcity("Pune");
			
			cp.addpostcode("123456");
			Thread.sleep(3000);
			cp.addcountrydrp("India");
			Thread.sleep(3000);
			cp.addstate("Maharashtra");
			
			cp.clickoncontinuebtn();
			Thread.sleep(3000);		
			cp.clickoncontinuebtn2();
			Thread.sleep(3000);
		//	cp.addtextdeliverymth("Testing....");
			cp.clickonagreecheckbox();
			cp.clickoncontinuebtn3();
			Thread.sleep(3000);
			
			
			cp.clickonconforderbtn();
			
			Thread.sleep(5000);
			
			boolean orderconf = cp.isorderplaced();
			System.out.println("is order placed?  " + orderconf);
			
			Thread.sleep(5000);
			
		//	Assert.assertEquals(cp.isorderplaced(), true);
		//	Thread.sleep(5000);
			
			
		}
}
