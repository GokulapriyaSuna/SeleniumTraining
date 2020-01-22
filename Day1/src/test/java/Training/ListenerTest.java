package Training;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ListenerTest {
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("on before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("on after Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("on before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("on after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("on before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("on after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("on before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("on after suite");
  }


  @Test
  public void onFinishTest() {
    
	  System.out.println("on Finish Test");
  }

  @Test
  public void onStartTest() {
	  System.out.println("on Start Test");
  }

  @Test
  public void onTestFailedButWithinSuccessPercentageTest() {
	  System.out.println("on Test Failed But Within Success Percentage Test");
  }

  @Test
  public void onTestFailedWithTimeoutTest() {
	  System.out.println("on Test Failed With Timeout Test");
  }

  @Test
  public void onTestFailureTest() {
	  System.out.println("on Test Failure Test");
  }

  @Test
  public void onTestSkippedTest() {
    System.out.println("on Test Skipped Test");
  }

  @Test
  public void onTestStartTest() {
    System.out.println("on Test Start Test");
  }

  @Test
  public void onTestSuccessTest() {
	  System.out.println("on Test Success Test");
  }
}
