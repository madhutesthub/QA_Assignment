package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordpage extends BasePage {

	public ChangePasswordpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement Welcomearrowbutton;

	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
	WebElement lnkMyAccountoption;

	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	WebElement linkofchangePassword;

	@FindBy(id = "current-password")
	WebElement txtCurrentPassword;

	@FindBy(id = "password")
	WebElement txtNewPassword;

	@FindBy(id = "password-confirmation")
	WebElement txtConfirmNewPassword;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement pwdchangesuccessmsg;

	// Wait helper
	private WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// NEW: Hide ads/popups if present
	public void hideAdsIfPresent() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
				"document.querySelectorAll('[id*=ad], .ad, .ads, .popup, .modal, .overlay, .newsletter').forEach(e => e.style.display='none');"
			);
		} catch (Exception e) {
			System.out.println("No ads or error hiding ads: " + e.getMessage());
		}
	}

	public void clickusernameArrow() {
		//Hide ads before clicking the profile menu
		hideAdsIfPresent();
		getWait().until(ExpectedConditions.elementToBeClickable(Welcomearrowbutton)).click();
	}

	public void clickonMyAccount() {
		getWait().until(ExpectedConditions.elementToBeClickable(lnkMyAccountoption)).click();
	}

	public void clickchangepasswordlink() {
		getWait().until(ExpectedConditions.elementToBeClickable(linkofchangePassword)).click();
	}

	public void entercurrentpassword(String pwd) {
		getWait().until(ExpectedConditions.visibilityOf(txtCurrentPassword)).sendKeys(pwd);
	}

	public void setNewPassword(String pwd) {
		getWait().until(ExpectedConditions.visibilityOf(txtNewPassword)).sendKeys(pwd);
	}

	public void ConfirmNewPassword(String pwd) {
		getWait().until(ExpectedConditions.visibilityOf(txtConfirmNewPassword)).sendKeys(pwd);
	}

	public void clickonSave() {
		getWait().until(ExpectedConditions.elementToBeClickable(btnSave)).click();
	}

	public String changepwdsuccessmsg() {
		try {
			return getWait().until(ExpectedConditions.visibilityOf(pwdchangesuccessmsg)).getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
