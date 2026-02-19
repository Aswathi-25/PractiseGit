package Testng_practice;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;

public class SampleTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void sample_m4()

	{
		System.out.println("-----create------");
	}
	
	@Test
	public void sample_m2()
	{
		System.out.println("------edit-----");
	}
	
	@Test
	public void sample_m3()
	{
		System.out.println("------delete----");
	}

	@Test(groups = "regression")
	public void sample_m1()
	{
		System.out.println("------test-------");
	}
}
