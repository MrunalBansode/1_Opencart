package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath = "//div[@id='cart']") WebElement itemsbtn;
	
	@FindBy(xpath = "//strong[normalize-space()='View Cart']") WebElement viewcart;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']") WebElement checkoutbtn;
	
	public void clickonitemsbtn() {
		itemsbtn.click();
	}
	
	public void clickonviewcart() {
		viewcart.click();
	}
	
	public void clickoncheckoutbtn() {
		checkoutbtn.click();
	}
}
