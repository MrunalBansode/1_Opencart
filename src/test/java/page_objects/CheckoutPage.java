package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath = "//input[@value='guest']") WebElement asaguest;
	
	@FindBy(xpath = "//input[@id='button-account']") WebElement conti;
	
	//@FindBy(xpath = "//input[@value='new']") WebElement newadd;
	
	@FindBy(id = "input-payment-firstname") WebElement firstname ;
	
	@FindBy(id = "input-payment-lastname") WebElement lastname;
	
	@FindBy(xpath = "//input[@id='input-payment-email']") WebElement email;
	
	@FindBy(xpath = "//input[@id='input-payment-telephone']") WebElement phone;
	
	@FindBy(id = "input-payment-address-1") WebElement address1 ;
	
	@FindBy(id = "input-payment-address-2") WebElement address2;
	
	@FindBy(id = "input-payment-city") WebElement cityname ;
	
	@FindBy(id = "input-payment-postcode") WebElement postcode;
	
	@FindBy(id = "input-payment-country") WebElement drpcountryname;
	
	@FindBy(id = "input-payment-zone") WebElement drpstatename;
	
	@FindBy(xpath = "//input[@id='button-guest']") WebElement continuebtn ;
	
	@FindBy(xpath = "//input[@id='button-shipping-method']") WebElement continuebtn2 ;
	
	@FindBy(xpath = "//textarea[name='comment'][2]") WebElement textdeliverymth ;
	
	@FindBy(xpath = "//input[@name='agree']") WebElement agreecheckbox;
	
	@FindBy(id = "button-payment-method") WebElement continuebtn3;
	
	@FindBy(xpath = "//input[@id='button-confirm']") WebElement conforderbtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	WebElement confordermsg ;
	
	
	public void clickonguest() {
		asaguest.click();
		}
	
	public void clickconti() {
		conti.click();
	}
	
/*	public void addnewaddr() {
		newadd.click();
	}
*/	
	public void addfirstname(String firstN) {
		firstname.sendKeys(firstN);
	}
	
	public void addlastname(String lastN) {
		lastname.sendKeys(lastN);
	}
	
	public void addemail(String Email) {
		email.sendKeys(Email);
	}
	
	public void addphone(String tel) {
		phone.sendKeys(tel);
	}
	public void setadd1(String add) {
		address1.sendKeys(add);
	}
	
	public void setadd2(String add2) {
		address2.sendKeys(add2);
	}
	
	public void addcity(String city) {
		cityname.sendKeys(city);
	}
	
	public void addpostcode(String pin) {
		postcode.sendKeys(pin);
	}
	
	public void addcountrydrp(String country) {
		new Select(drpcountryname).selectByVisibleText(country);
	}
	
	public void addstate(String state) {
		new Select(drpstatename).selectByVisibleText(state);
	}
	
	public void clickoncontinuebtn() {
		continuebtn.click();
	}
	
	public void clickoncontinuebtn2() {
		continuebtn2.click();
	}
	
	public void addtextdeliverymth(String text) {
		textdeliverymth.sendKeys(text);
	}
	
	public void clickoncontinuebtn3() {
		continuebtn3.click();
	}
	
	public void clickonagreecheckbox() {
		agreecheckbox.click();
	}
	
	public void clickonconforderbtn() {
		conforderbtn.click();
	}
	
	public boolean isorderplaced() throws InterruptedException {
		try
		{
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			conforderbtn.click();
			Thread.sleep(3000);
			if(confordermsg.getText().equals("Your order has been placed!"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
