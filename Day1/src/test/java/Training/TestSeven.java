package Training;

import org.testng.annotations.Test;

public class TestSeven {

	@Test(groups = {"dry"})
	public void google()
	{
		System.out.println("in google");
	}
	
	@Test(groups = {"smoke"})
	public void citi()
	{
		System.out.println("in citi");
	}
	
	@Test(groups = {"dry1"})
	public void hdfc()
	{
		System.out.println("in hdfc");
	}
}
