package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BaseClass
{
	Logger log;
	public WebDriver driver;
	
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException
	{
		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAdressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.clickOnLogin().click();
		log.debug("Clicked on Login Button");
		
		AccountPage accountPage = new AccountPage(driver);
		String actualResult = null;
		
		
		try 
		{
			if(accountPage.editAccountInfo().isDisplayed())
			{
				log.debug("User got logged in");
				actualResult="Sucessfull";
			}
			
		}
		catch (Exception e)
		{
			log.debug("User didn't log in");
			actualResult="Failure";
		}
			
		Assert.assertEquals(actualResult, expectedResult);
		log.info("Login Test got passed");
	}
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver=initializeDriver();
		log.debug("Browser got launched");
		driver.get(p.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data= {{"adarsh640@gmail.com","12345","Sucessfull"}};
		
		return data;
	}
}
