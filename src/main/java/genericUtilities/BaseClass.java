package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of TestNG
 * @author Chaitra M
 *
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("------- Database Connection successful -------");
	}
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
//		driver = new EdgeDriver();
			
		//For Cross Browser execution
//		if(pValue.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(pValue.equals("firefox"))
//		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}
		

		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		//For Listeners
		sDriver = driver;
		
		System.out.println("------- Browser Launch successful -------");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("------- Login to Application successful -------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("------- Logout of Application successful -------");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("------- Browser Closure successful -------");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("------- Database Closure successful -------");
	}

}
