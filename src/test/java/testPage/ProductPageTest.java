package testPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.TestBase;
import pageObjects.InventoryPage;
import pageObjects.Login;
import pageObjects.ProductPage;
import util.TestUtil;

public class ProductPageTest extends TestBase {
	public Login login;
	public InventoryPage inventorypage;
	public ProductPage productpage;

	String sheetName = "productdata";

	@BeforeMethod
	public void setUp() throws Exception {
		initializeBrowser();
		login = new Login();
		inventorypage = new InventoryPage();
		productpage = new ProductPage();
		login.aspireLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		inventorypage.clickOnProductdd();
		// inventorypage.redirectManufactPage();
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getData")
	public void verifyCreateProduct(String name, String producttype, String salep, String c, String intref, String barc)
			throws Exception {

		// productpage.createProduct("testsheetu17-22","","2","10","testingpurpose28","6789","testing
		// purpose only");
		productpage.createProduct(name, producttype, salep, c, intref, barc);
		productpage.updateQuantity("20");
		productpage.replenish("20");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
