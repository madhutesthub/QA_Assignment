package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC004_LogoutTest extends BaseClass{
	
	@Test(groups= {"Master"})
	public void verify_logout() {
		
		logger.info("**********TC004_Logout started**********");
		
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clicksignin();
		
		//Login Page
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//Logout page
		LogOutPage lg= new LogOutPage(driver);
		lg.clickwelcomeArrow();
		lg.clickonsignout();
		logger.info("***********TC004_Logout succefully***********");
	
	}
}
