package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Login extends TestBase{
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-block']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//img[@alt='Logo']")
	WebElement aspirelogo;
	
	@FindBy(xpath="//a[@id='result_app_1']")
	WebElement inventory;
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public String verfiyPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyOdooLogo() {
		return aspirelogo.isDisplayed();
	}
	
	public InventoryPage aspireLogin(String un, String pwd) throws Exception {
		Thread.sleep(2000);
		userName.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginbtn.click();
		
		Thread.sleep(2000);
		inventory.click();
		
		Thread.sleep(2000);
		
		return new InventoryPage();
		
	}

}
