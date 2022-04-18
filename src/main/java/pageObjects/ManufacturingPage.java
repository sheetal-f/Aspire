package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ManufacturingPage extends TestBase{
	
	@FindBy(xpath = "//button[@class='btn btn-primary o_list_button_add']")
	WebElement createmanu;

	@FindBy(xpath = "//div[@name='product_id']//div//div//input")
	WebElement enterproduct;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement confirm;
	
	@FindBy(xpath="//div[@class='o_statusbar_buttons']//button[4]")
	WebElement done;
	
	@FindBy(xpath="//span[text()='Ok']")
	WebElement okbtn;
	
	@FindBy(xpath="//span[text()='Apply']")
	WebElement applybtn;
	
	@FindBy(xpath="//button[@title='Save record']")
	WebElement save;
	
	public ManufacturingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createmanufacture(String product) throws Exception {
		Thread.sleep(2000);
		createmanu.click();
		
		Thread.sleep(2000);
		enterproduct.sendKeys(product);
		enterproduct.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		confirm.click();
		
		Thread.sleep(2000);
		done.click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		okbtn.click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		applybtn.click();
		Thread.sleep(2000);
		
		save.click();
	}
}
