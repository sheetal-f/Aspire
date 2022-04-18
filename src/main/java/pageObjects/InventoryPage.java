package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class InventoryPage extends TestBase{

	@FindBy(xpath="//button[@title='Products'] ")
	WebElement productdd;
	
	@FindBy(xpath="/html/body/header/nav/div[1]/div[2]/div/a[1]")
	WebElement products;
	
	@FindBy(xpath="//a[@class='fa o_menu_toggle fa-th'] ")
	WebElement homemenu;
	
	@FindBy(xpath="//a[@id='result_app_2'] ")
	WebElement manufact;
	
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage clickOnProductdd() throws Exception {
		productdd.click();
		Thread.sleep(2000);
		products.click();
		
		return new ProductPage();
	}
	
	public ManufacturingPage redirectManufactPage() throws Exception {
		homemenu.click();
		Thread.sleep(2000);
		manufact.click();
		
		return new ManufacturingPage();
	}
	
}
