package Training;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSix {
	
	@Test
	public void test() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.hdfcbank.com/");
	driver.manage().window().maximize();
		
	WebElement prodtype=driver.findElement(By.xpath("//li[contains(text(),'Deposits')]"));
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()",new Object[] {prodtype});
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,1000)");
}
}
	
