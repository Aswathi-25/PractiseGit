package Testng_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	/*even though exception comes it will not stop, it will continue with the exception
	 * it will not fail the execution
	 *
	 * */
	 
	@Test
	public void m1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("-------step-1--------");
		System.out.println("-------step-2--------");
		sa.assertEquals("A", "B");
		sa.assertAll();
		/*if u use this assertAll() inbetween execution will be stopped at the line of exception
		 * assertAll affects only the concerned @Test remaining @Test will execute
		 * *
		 */

		System.out.println("-------step-3--------");
		System.out.println("-------step-4-------");
		//sa.assertAll();
	}
	
	@Test
	public void m2()

	{
		int a = 5;
	SoftAssert sa = new SoftAssert();
	System.out.println("-----step-1-----");
	System.out.println("-----step-2-----");
	sa.assertNull(a);
	//sa.assertAll();
	System.out.println("----step-3----");
	System.out.println("-----step-4-----");
	sa.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
