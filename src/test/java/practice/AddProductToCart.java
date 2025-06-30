package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {
	
	public static void main(String[] args) {
		
		//Launch the Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the URL
		driver.get("https://www.saucedemo.com/");
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		
		//Click on a Product And Add To Cart
		driver.findElement(By.xpath("//div[.='Sauce Labs Bike Light']")).click();
		driver.findElement(By.name("add-to-cart")).click();
		
		//Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validate for the product in Cart
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		
		if(productInCart.equals("Sauce Labs Bike Light"))
		{
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}

}
