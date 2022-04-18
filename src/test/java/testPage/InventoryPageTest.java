package testPage;

import org.testng.annotations.AfterMethod;

import base.TestBase;
import pageObjects.InventoryPage;
import pageObjects.Login;

public class InventoryPageTest extends TestBase{
	
	public Login login;
	public InventoryPage inventorypage;
	
	public InventoryPageTest() {
		super();
	}
	
	public void setUp() throws Exception {
		initializeBrowser();
		inventorypage = new InventoryPage();
		login = new Login();
		login.aspireLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	public void verifyProductdd() throws Exception {
		inventorypage.clickOnProductdd();
		
	}
	
	public void verifyManufactPage() throws Exception {
		inventorypage.redirectManufactPage();
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
