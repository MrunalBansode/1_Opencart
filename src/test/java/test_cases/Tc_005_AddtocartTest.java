package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.HomePage;
import page_objects.SearchPage;
import test_base.BaseClass;



public class Tc_005_AddtocartTest extends BaseClass {

	@Test
	public void addtocarttest(){
		logger.info("Starting Tc_005_addtocartTest");
		
		try {
			HomePage hp = new HomePage(driver);
			
			hp.enterproductname("mac");
			
			hp.clickonsearchbtn();
			
			SearchPage sp = new SearchPage(driver);
			
			if(sp.isproductexists("MacBook Pro"))
			{
				sp.selectproduct("MacBook Pro");
				sp.setquantity("2");
				sp.clickonaddtocart();
			}
			Assert.assertEquals(sp.checkconfmsg(), true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("Starting Tc_005_addtocartTest");
	}
}
