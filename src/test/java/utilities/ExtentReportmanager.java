package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import test_base.BaseClass;



public class ExtentReportmanager implements ITestListener{

	public ExtentSparkReporter sparkReporter;  //UI of the report
	public ExtentReports extent; //populate common info of the report
	public ExtentTest test; //creation test case entries in the report and update status of the test methods
	
	String repName;
	
	public void onStart(ITestContext testcontext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		
		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		sparkReporter.config().setReportName("opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Custormers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.PASS, "Test case PASSED "); //update status
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED ");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
			String imPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imPath);
			}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test SKIPPED");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
