package testPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.InventoryPage;
import pageObjects.Login;

public class InventoryPageTest extends TestBase{
	
	public Login login;
	public InventoryPage inventorypage;
	
	public InventoryPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initializeBrowser();
		inventorypage = new InventoryPage();
		login = new Login();
		login.aspireLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1,description="redirect to product page successfully")
	public void verifyProductdd() throws Exception {
		inventorypage.clickOnProductdd();
		
	}
	
	@Test(priority=2,description="redirect to manufactor page successfully")
	public void verifyManufactPage() throws Exception {
		inventorypage.redirectManufactPage();
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
