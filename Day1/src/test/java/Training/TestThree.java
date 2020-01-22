package Training;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestThree {
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement ToTag=driver.findElement(By.id("ToTag"));
		ToTag.sendKeys("hyd");
		WebDriverWait wait = new WebDriverWait(driver,9000);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("ui-id-2"), By.className("list")));
		
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		List<WebElement> list = ul.findElements(By.tagName("li"));
		Assert.assertEquals(list.size(), 3);
		
		for(WebElement e:list)
		{
			if(e.getText().contains("HYD"))
			{
				e.click();
			}
		}
		
	}
}
