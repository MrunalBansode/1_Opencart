package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.HomePage;
import page_objects.SearchPage;
import test_base.BaseClass;


public class Tc_004_SearchProduct extends BaseClass {
	@Test
	public void searchproduct() {
		logger.info("Starting Tc_004_searchproducttest");
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.enterproductname("mac");
			hp.clickonsearchbtn();
			
			SearchPage sp = new SearchPage(driver);
			sp.isproductexists("MacBook Pro");
			
			Assert.assertEquals(sp.isproductexists("MacBook Pro"), true);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finishing Tc_004_searchproducttest");
	}
}
