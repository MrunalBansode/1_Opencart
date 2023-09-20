package page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath = "//div[@id='content']/div[3]//img") 
	List <WebElement> searchproducts;
	
	@FindBy(xpath = "//input[@id='input-quantity']") WebElement quantity;
	
	@FindBy(xpath = "//button[@id='button-cart']") WebElement addtocartbtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement confmsg;
	
	public boolean isproductexists(String productname) {
		boolean value = false;
		for(WebElement product : searchproducts)
		{
			if(product.getAttribute("title").equals(productname)) {
				 value = true;
				break;
			}
		}
		return value;
	}
	
	public void selectproduct(String produnname) {
		for(WebElement product : searchproducts)
		{
			if(product.getAttribute("title").equals(produnname))
			{
				product.click();
			}
		}
	}
	
	public void setquantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void clickonaddtocart() {
		addtocartbtn.click();
	}
	
	public boolean checkconfmsg() {
		try
		{
			return confmsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
