package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ChangePasswordpage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC003_ChangePasswordTest extends BaseClass {
	@Test(groups= {"Master"})
	public void verify_changePassword(){
		
		logger.info("**********TC003_changepassword initiated**********");
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clicksignin();
			
		//Login Page
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();	
		
		//changePasswordpage
		ChangePasswordpage cp=new ChangePasswordpage(driver);
		cp.clickusernameArrow();
		cp.clickonMyAccount();
		cp.clickchangepasswordlink();
		cp.entercurrentpassword(p.getProperty("password"));
		
		String password =randomeAlphaNumeric();
		cp.setNewPassword(password);
		cp.ConfirmNewPassword(password);
		cp.clickonSave();
		
		logger.info("Validating Expected message....");

        String successmsg = cp.changepwdsuccessmsg();
        if(successmsg.equalsIgnoreCase("You saved the account information.")) {
            logger.info("Password changed successfully");
            Assert.assertTrue(true);
        } else {
            logger.error("Change password failed. Expected message not found.");
            Assert.fail("Expected success message not found. Actual: " + successmsg);
        }

     } catch(Exception e) {
        logger.error("Exception occurred: " + e.getMessage());
        e.printStackTrace();
        // Optional: capture screenshot
        // captureScreen(driver, "verify_changePassword");
        Assert.fail("Test failed due to exception: " + e.getMessage());
    }

		
		
		logger.info("***********TC003_changepasswordCompleted***********");

	
}

}


