package Training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.DemoWebShopLoginPage;
import Pages.DemoWebShopPage;
import Pages.DemoWebShopRegisterPage;

public class TestTenPages {

	WebDriver driver;
	DemoWebShopPage welcomePage;
	DemoWebShopLoginPage loginPage;
	DemoWebShopRegisterPage registerPage;

	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		welcomePage=PageFactory.initElements(driver, DemoWebShopPage.class);
		loginPage=PageFactory.initElements(driver, DemoWebShopLoginPage.class);
		registerPage=PageFactory.initElements(driver, DemoWebShopRegisterPage.class);
				
	}
	@AfterTest
	public void afetrTest()
	{
		driver.close();
		welcomePage=null;
		loginPage=null;
		registerPage=null;
	}
	@Test(priority = 1)
	public void testRegisterLink() {
		String title=welcomePage.clickRegister();
		Assert.assertEquals(title,"Demo Web Shop. Register");
	}
	@Test(priority = 2)
	public void testLoginLink()
	{
		String url=welcomePage.clickLogin();
		Assert.assertTrue(url.contains("login"));
	}
	@Test(priority = 3)
	public void testLoginButton()
	{
		boolean logoutexists=loginPage.loginButtonClick();
		Assert.assertTrue(logoutexists);
	}
}
