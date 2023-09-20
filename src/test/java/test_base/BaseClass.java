package test_base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

public static WebDriver driver;
	
	public Logger logger;  //for logging
	
	public ResourceBundle rb;  //import java utile

	@BeforeClass(groups = {"Regression", "Sanity", "Master"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb = ResourceBundle.getBundle("config");  //load config.properties file
		
		logger = LogManager.getLogger(this.getClass());  //logging
		
		//for disabling the statement which is showing when we automate the test cases that is 
		//chrome is being controlled by automated software 
		
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		//driver = new ChromeDriver(options); 
		
		if(br.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if (br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));
	//	driver.get("http://localhost/opencart/upload/");
	//  driver.get("https://demo.opencart.com/");	
		
		driver.manage().window().maximize();
	}
	
    @AfterClass(groups = {"Regression", "Sanity", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
    
    public String randomString() {
    	String generatedString = RandomStringUtils.randomAlphabetic(5);
    	return (generatedString);
    }
    
    public String randomNumber() {
    	String generatedString2 = RandomStringUtils.randomNumeric(10);
    	return (generatedString2);
    }
    
    public String randomAlphaNumeric() {
    	String st = RandomStringUtils.randomAlphabetic(4);
    	String num = RandomStringUtils.randomNumeric(3);
    	
    	return (st+"*"+num);
    }

	public String captureScreen(String tname) throws IOException {
	/*	
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String timestamp = df.format(dt);
	*/  //combine statement	
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + " " + timeStamp + ".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
