package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage  extends SeleniumUtility{

	// Declaration
	@FindBy(className = "product_sort_container")
	private WebElement sortDropDown;

	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;

	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;

	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;

	// Intialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getSortDropDown() {
		return sortDropDown;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}

	// Business Library
	
	/**
	 * This method will perform logout operation
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLnk.click();
	}
	
	/**
	 * This method will click on Cart container button
	 */
	public void clickOnCartContainerBtn()
	{
		cartContainerBtn.click();
	}
	
	/**
	 * This method will click on a product 
	 * @param driver
	 * @param ProductName
	 */
	public void clickOnAProduct(WebDriver driver, String ProductName)
	{
		driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
	}
	
	/**
	 * This method will sort the product for Lowest Price then click on it
	 * @param driver
	 * @param sortoption
	 * @param ProductName
	 */
	public void clickOnLowestPriceProduct(WebDriver driver, String sortoption, String ProductName)
	{
		handleDropdown(sortDropDown, sortoption);
		driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
	}
	
	
	
	
	
	
	
	

}
