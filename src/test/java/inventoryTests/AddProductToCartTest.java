package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenerImplementationUtility.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException
	{
		// Read the Test Data from Excel file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 1, 2);

		// Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);
		
		//Add Product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddcartBtn();
		
		// Navigate to Cart
		ip.clickOnCartContainerBtn();//fail

		// Validate for the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureItemName();
		Assert.assertEquals(productInCart, PRODUCTNAME);
		System.out.println(productInCart);
		

	}
	
	
	@Test
	public void sample()
	{
		
		System.out.println("Demo");
	}

}
