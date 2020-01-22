package Training;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNine {

	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest tests;

	@BeforeTest
	public void beforetest() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss-ms");
		String filepath = System.getProperty("user.dir") + "/extent-report/" + sdf.format(new Date()) + ".html";
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		htmlreporter = new ExtentHtmlReporter(filepath);
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);

		htmlreporter.config().setReportName("Report Result");
		htmlreporter.config().setDocumentTitle("Custom Report");
		htmlreporter.config().setTheme(Theme.DARK);

		reports.setSystemInfo("Environment", "Test Environment");
		reports.setSystemInfo("User Name", "Gokulapriya Periannan");

	}

	@AfterTest
	public void aftertest() {
		reports.flush();
	}

	@BeforeMethod
	public void beforemethod(ITestResult result) {

		tests = reports.createTest(result.getMethod().getMethodName());
	}

	 @AfterMethod 
	 public void aftermethod(ITestResult result) throws IOException {
		 if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 
		 }
		 else if(result.getStatus()==ITestResult.FAILURE)
		 {
			 TakesScreenshot screenshot=(TakesScreenshot) driver;
			 File srcfile=screenshot.getScreenshotAs(OutputType.FILE);
			 String destfile = System.getProperty("user.dir")+ "/extent-report/screenshots"+ result.getMethod().getMethodName()+".png";
			 try
			 {
				 FileUtils.copyFile(srcfile, new File(destfile));
				 tests.log(Status.FAIL, "The test is failed");
				 tests.addScreenCaptureFromPath(destfile);
				 tests.log(Status.FAIL,result.getThrowable().getMessage() );
				 
			 }
			 catch(IOException e)
			 {
				 e.printStackTrace();
			 }
		 }
	 }
	 
	@Test
	public void testextentreport() {
		tests.log(Status.PASS, "The test is passed");
	}

	@Test
	public void demotest() {
		
	
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("Email")).sendKeys("askme@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("test123$$");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
	}

}
