package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngPractice {
	
	@Test
	public void create() //create a customer - failed
	{
		Assert.fail(); //fail
		System.out.println("create");
	}
	
	@Test(dependsOnMethods = "create")
	public void modify() // update a customer
	{
		System.out.println("modify");
	}
	
	@Test
	public void delete() //delete a customer
	{
		System.out.println("delete");
	}

}
