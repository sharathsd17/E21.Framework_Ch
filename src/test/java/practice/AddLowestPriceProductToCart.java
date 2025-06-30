package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductToCart {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//Create Object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		// Read the Common data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// Read the Test Data from Excel file
		String SORTOPTION = fUtil.readDataFromExcelFile("Products", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 3);

		// Launch the Browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// Load the URL
		driver.get(URL);

		// Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login-button")).click();

		// Choose the sort option from dropdown
		WebElement dropdownFilter = driver.findElement(By.className("product_sort_container"));
		sUtil.handleDropdown(dropdownFilter, SORTOPTION);

		// Click on the product and add to cart
		driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).click();
		driver.findElement(By.id("add-to-cart")).click();

		// Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();

		// Validate for the product in Cart
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();

		if (productInCart.equals(PRODUCTNAME)) {
			System.out.println(productInCart);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
