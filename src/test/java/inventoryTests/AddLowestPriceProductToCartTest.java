package inventoryTests;

import java.io.IOException;

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
public class AddLowestPriceProductToCartTest extends BaseClass{

	@Test(groups = {"RegressionSuite","SmokeSuite"})
	public void tc_002_AddLowestPriceProductToCartTest() throws IOException
	{

		// Read the Test Data from Excel file
		String SORTOPTION = fUtil.readDataFromExcelFile("Products", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 3);

		// Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver,SORTOPTION,PRODUCTNAME);

		// Add Product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddcartBtn();

		// Navigate to Cart
		ip.clickOnCartContainerBtn();

		// Validate for the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.captureItemName();
		Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		System.out.println(productInCart);

		
	}

}
