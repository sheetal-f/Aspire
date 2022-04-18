package testPage;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.InventoryPage;
import pageObjects.Login;

public class LoginTest extends TestBase {

	public Login login;
	public InventoryPage inventoryPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser();

		login = new Login();
	}

	@Test(priority = 1, description = "Page title verified")
	public void pageTitleTest() {
		String title = login.verfiyPageTitle();
		Assert.assertEquals(title, "Odoo");
		
	}

	@Test(priority = 2, description = "Page logo verified")
	public void logoTest() {
		boolean flag = login.verifyOdooLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3, description = "login successfully")
	public void loginTest() throws Exception {
		inventoryPage = login.aspireLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login successfully into scom using below credentials");
		System.out.println("username: " + prop.getProperty("username"));
		System.out.println("password: " + prop.getProperty("password"));
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
