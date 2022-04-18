package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(xpath = "//button[@title='Create record']")
	WebElement createbtn;

	@FindBy(xpath = "//input[@name='name']")
	WebElement productname;

	@FindBy(xpath = "//select[@name='detailed_type']")
	WebElement producttypedd;

	@FindBy(xpath = "//div[@name='list_price']")
	WebElement salesprice;

	@FindBy(xpath = "//div[@name='standard_price']")
	WebElement cost;

	@FindBy(xpath = "//input[@name='default_code']")
	WebElement internalref;

	@FindBy(xpath = "//input[@id='o_field_input_24']")
	WebElement barcode;

	@FindBy(xpath = "//button[@title='Save record']")
	WebElement savebtn;
	// 1px solid var(--o-input-border-color)

	@FindBy(xpath = "//button[@name='action_update_quantity_on_hand']")
	WebElement updatequantity;

	@FindBy(xpath = "//button[@class='btn btn-primary o_list_button_add']")
	WebElement createquanity;

	@FindBy(xpath = "//input[@name='inventory_quantity']")
	WebElement countendquantity;

	@FindBy(xpath = "//button[@class='btn btn-primary o_list_button_save']")
	WebElement updatesave;

	@FindBy(xpath = "//li[@class='breadcrumb-item o_back_button']")
	WebElement previousmenu;

	@FindBy(xpath = "//button[@name='208']")
	WebElement replenishtab;

	@FindBy(xpath = "//input[@name='quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@name='launch_replenishment']")
	WebElement replenishconfirm;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void createProduct(String name, String producttype, String salep, String c, String intref, String barc)
			throws Exception {

		Thread.sleep(4000);
		// createbtn
		createbtn.click();

		Thread.sleep(4000);
		// product name
		productname.sendKeys(name);

		Thread.sleep(4000);
		// select value from dropdown
		Select prodtype = new Select(producttypedd);
		prodtype.selectByVisibleText(producttype);

		Thread.sleep(4000);
		// salesprice

		String js = "arguments[0].setAttribute('value','" + salep + "')";
		((JavascriptExecutor) driver).executeScript(js, salesprice);

		// salesprice.sendKeys(salep);

		Thread.sleep(4000);
		// cost
		// cost.clear();
		// cost.sendKeys(c);
		String js1 = "arguments[0].setAttribute('value','" + c + "')";
		((JavascriptExecutor) driver).executeScript(js1, cost);

		Thread.sleep(4000);
		// internal reference
		internalref.sendKeys(intref);

		Thread.sleep(4000);
		// barcode
		barcode.sendKeys(barc);

		Thread.sleep(4000);
		// click on save button
		savebtn.click();
		Thread.sleep(4000);
	}

	public void updateQuantity(String countedq) throws Exception {

		// update quantity
		updatequantity.click();

		Thread.sleep(4000);
		// create update quantity
		// createquanity.clear();
		createquanity.click();

		Thread.sleep(4000);
		countendquantity.clear();
		countendquantity.sendKeys(countedq);

		Thread.sleep(4000);
		// save btn
		updatesave.click();

		Thread.sleep(4000);
		// back to previous menu
		previousmenu.click();

	}

	public void replenish(String quan) throws Exception {
		Thread.sleep(4000);

		replenishtab.click();

		driver.switchTo().activeElement();
		
		Thread.sleep(2000);
		quantity.clear();
		Thread.sleep(2000);
		quantity.sendKeys(quan);
		Thread.sleep(2000);
		replenishconfirm.click();

	}
}
