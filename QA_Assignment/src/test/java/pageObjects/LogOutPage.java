package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {

	public LogOutPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement Welcomearrowbutton;
	
	@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement lnksignout;
	
	
	//Action methods
		public void clickwelcomeArrow() {
			Welcomearrowbutton.click();
		}
		public void clickonsignout() {
			lnksignout.click();
		}
}
