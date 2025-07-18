package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//span[@class='base']")// MyAccount Page heading
	WebElement msgMyAccountHeading;
	
	/*@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement lnksignOut;*/
	
	public boolean isMyAccountPageExists()
	{
		try 
		{
			return (msgMyAccountHeading.isDisplayed());
		}
		catch(Exception e) 
		{
			return false;
		}
	}
	/*public void clickLogout() 
	{
		lnksignOut.click();
	}*/
}
