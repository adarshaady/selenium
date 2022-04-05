package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.BaseClass;

public class FourTest extends BaseClass
{
	public WebDriver driver;
	@Test
	public void fourTest() throws IOException, InterruptedException
	{
		System.out.println("four test");
		
	    driver = initializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		Assert.assertTrue(false);
		
	
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
	}

}
