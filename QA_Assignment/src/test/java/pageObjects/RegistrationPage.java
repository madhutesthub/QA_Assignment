package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement btnCreateanAccount;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement msgConfirmation;
		
	
	//Action methods
	
		public void setFirstName(String fname) {
			txtFirstName.sendKeys(fname);
		}
		
		public void setLastName(String lname) {
			txtLastName.sendKeys(lname);
		}
		
		public void setEmail(String email) {
			txtEmail.sendKeys(email);
		}
		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}
		
		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);
		}
		public void clickCreateanAccount() {
			btnCreateanAccount.click();
		}
		
		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			}
			catch (Exception e) {
				return (e.getMessage());
				
			}
	}	
}
