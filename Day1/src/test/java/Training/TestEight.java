package Training;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestEight {
	public static Logger LOGGER= LogManager.getLogger(TestEight.class);
	@Test
	public void test1()
	{
		LOGGER.info("On test 1 Passed");
		
	}
	
	@Test
	public void test2()
	{
		LOGGER.info("On test 2 Passed");
	}
	
	@Test
	public void test3()
	{
		LOGGER.info("On test 3 Passed");
	}
	
	@Test
	public void test4()
	{
		LOGGER.info("On test 4 Passed");
	}
}
