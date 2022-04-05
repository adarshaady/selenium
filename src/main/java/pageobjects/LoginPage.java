package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	@FindBy(id="input-password")
	WebElement passField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	public WebElement emailAdressField()
	{
		return emailField;
	}
	
	public WebElement passwordField()
	{
		return passField;
	}

	
	public WebElement clickOnLogin()
	{
		return loginbtn;
	}

}
