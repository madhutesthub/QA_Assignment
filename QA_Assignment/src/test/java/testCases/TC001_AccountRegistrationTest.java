package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Master"})
	public void verify_account_registration() 
	{
		logger.info("****** TC001_AccountRegistrationTest started ********");
		logger.debug("This is a debug log message");
		try 
		{
		HomePage hp = new HomePage(driver); 
		logger.info("Clicked On  CreateAnAccount Link...");
		hp.clickCreateAnAccount();
	
		
		RegistrationPage regpage =new RegistrationPage(driver);
		logger.info("Providing Customer Details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		
		
		String password =randomeAlphaNumeric();
				 
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		
		regpage.clickCreateanAccount();
		
		logger.info("Validating Expected message....");
		
		String confmsg = regpage.getConfirmationMsg();
		if(confmsg.equals("Thank you for registering with Main Website Store."))
			{
				Assert.assertTrue(true);
			}
		else
			{
				logger.error("Test failed.........");
				logger.debug("Debug logs.........");
				Assert.assertTrue(false);
			}	
		} 
		catch(Exception e) 
		{
			Assert.fail();
		}
	     logger.info("********Finished TC001_AccountRegistrationTest ***********");
}
}