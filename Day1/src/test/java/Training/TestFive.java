package Training;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestFive {
	WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void beforetest(String browservalue) 
	{
		if (browservalue.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browservalue.contentEquals("ie"))
		{
			System.setProperty("webdriver.ie.driver","src/test/resources/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.close();
	}
	
	@Test(dataProvider="dp1")
	public void testing(String username, String Password)
	{
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.linkText("Log out")).click();
		driver.findElement(By.linkText("Log in")).click();
		
		
	}
	
	@DataProvider(name="dp1")
	public Object[][] data() {
		return TestFour.test();
	}
}
