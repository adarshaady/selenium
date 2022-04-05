package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass;

public class TwoTest extends BaseClass
{
	public WebDriver driver;
	@Test
	public void twoTest() throws IOException, InterruptedException
	{
		System.out.println("second test");
		driver = initializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
	}

}
