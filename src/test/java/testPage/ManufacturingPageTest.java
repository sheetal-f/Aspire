package testPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.InventoryPage;
import pageObjects.Login;
import pageObjects.ManufacturingPage;
import pageObjects.ProductPage;

public class ManufacturingPageTest extends TestBase{
	public Login login;
	public InventoryPage inventorypage;
	public ProductPage productpage;
	public ManufacturingPage manufacpage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initializeBrowser();
		login = new Login();
		inventorypage = new InventoryPage();
		productpage = new ProductPage();
		manufacpage = new ManufacturingPage();
		login.aspireLogin(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage.redirectManufactPage();
	}
	
	@Test
	public void verifycreatemanufact() throws Exception {
		manufacpage.createmanufacture("test-18-22");
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
