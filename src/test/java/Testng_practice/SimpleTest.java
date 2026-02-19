package Testng_practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;

@Listeners(Generic_Utilities.ListenerImplementationClass.class)
public class SimpleTest extends BaseClass {
	
	
	
	@Test(groups = "smoke")
	public void simplest_m1()

	{
		System.out.println("------demotest_m1----");
		
	}
	
	@Test
	public void simplest_m2()
	{
		System.out.println("---------demotest_m2-----");
	}
	
}
