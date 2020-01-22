package Training;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestTwo {

	@Test
	public void test() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
		WebElement from =driver.findElement(By.xpath("//div[@id=\'ctl00_ContentPlaceholder1_RadTreeView1\']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement to = driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		Thread.sleep(2000);
		Actions act =new Actions(driver);
		act.clickAndHold(from).pause(2000).release(to).perform();
		//act.dragAndDrop(from,to).perform();
		
		WebDriverWait wait = new WebDriverWait(driver,9000);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		
		String message = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println(message);
		driver.close();
	}
}
