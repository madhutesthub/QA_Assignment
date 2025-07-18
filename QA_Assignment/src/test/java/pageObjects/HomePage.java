package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	 WebElement lnkCreateanAccount;
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	 WebElement lnsignin;
	
	
	
	//ActionMethods
	
	public void clickCreateAnAccount() 
	{
		lnkCreateanAccount.click();
	}
	
	public void clicksignin() 
	{
		lnsignin.click();
	}

}
