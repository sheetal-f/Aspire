package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public Properties prop;
	public TestUtil testUtil;
	
	String sheetName = "productdata";
	
	public TestBase() {
		try {
		prop = new Properties();
		
		FileInputStream fip = new FileInputStream("D:\\SamcoTestProject\\Aspire_Automation\\src\\main\\java\\resources\\config.properties");
		
			prop.load(fip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initializeBrowser() {
		 String browserName = prop.getProperty("browser");
		 
		 if(browserName.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		 }
		 
		 else if(browserName.equalsIgnoreCase("firefox")){
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		 
		 driver.get(prop.getProperty("url"));
	}
	

}
