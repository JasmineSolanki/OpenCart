package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import BaseClass.BaseClass;
import utilities.DataProviders;
public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email,String password,String exp )                	
	{
	  logger.info("*****Starting TC_003_LoginDDT*****");
	  
	  try
	  {
		  //HomePage
		  HomePage hp=new HomePage(driver);
		  hp.clickMyAccount();
		  hp.clickLogin();
		  
		  //login page
		  LoginPage lp=new LoginPage(driver);
		  lp.setEmail(email);
		  lp.setPassword(password);
		  lp.clickLogin();
		  
		  //MyAccount Page
		  MyAccountPage macc=new MyAccountPage(driver);
		  boolean targetPage=macc.isMyAccountPageExists();
		  
		  if(exp.equalsIgnoreCase("valid"))	
		  {
			  if(targetPage==true)
		   {
			  macc.clickLogout();
			  Assert.assertTrue(true);
		   }
		  else
			{
				Assert.assertTrue(false);
			}
		  }  
		  
		  if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
	   }
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	 }
	 
	  
	}


