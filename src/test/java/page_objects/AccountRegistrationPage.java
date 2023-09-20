package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	//Elements
	
	@FindBy(name = "firstname") WebElement txtfirstname;
	@FindBy(name = "lastname") WebElement txtlastname;
	@FindBy(name = "email") WebElement txtemail;
	@FindBy(name = "telephone") WebElement txtphone;
	@FindBy(name = "password") WebElement txtpass;
	@FindBy(name = "confirm") WebElement txtconfirmpass;
	@FindBy(name = "agree") WebElement chkpolicy;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btncontinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationmsg;
	
	//actions
	
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void setemail (String email){
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtphone.sendKeys(tel);
	}
	
	public void setPassword(String pass) {
		txtpass.sendKeys(pass);
	}
	
	public void setconfirmpassword(String pass) {
		txtconfirmpass.sendKeys(pass);
	}
	
	public void setprivacypolicy() {
		chkpolicy.click();
	}
	
	public void clickContinue() {
		btncontinue.click();
	}
	
	public String getmsgconfirmation() {
		try
		{
			return (confirmationmsg.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
