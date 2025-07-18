package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups= {"Master"})
	public void verify_login() {
		
		logger.info("**********TC002_LoginTest started**********");
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
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***********TC002_Logintest finished***********");

}
}