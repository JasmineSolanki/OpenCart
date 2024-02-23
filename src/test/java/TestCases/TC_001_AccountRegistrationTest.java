package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import BaseClass.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("*****Starting TC_00_AccountRegistrationTest *****");
		
		try
		{	
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on My Account Link");
		
		hp.clickRegister();
		logger.info("Clicked on registration link");
		
		logger.info("Entering customer's Details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(((String) randomString()).toUpperCase());
		regpage.setLastName(((String) randomString()).toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPolicy();
		regpage.clickContinue();
		
		logger.info("Clicked on Continue");
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		
		if(confmsg.equals("Your Account Has Been Created!"))
	   {
			logger.info("Test Pass");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.info("Test Fail");
			Assert.fail();
		}
		
		}
	
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();		
	    }
		
		logger.info("******finished TC_00_AccountRegistrationTest *****");
		
	}
	

}
