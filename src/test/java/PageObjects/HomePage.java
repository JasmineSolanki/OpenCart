package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyAccount;
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	public void clickRegister()
	{
		lnkRegister.click();
		
	}
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
}
