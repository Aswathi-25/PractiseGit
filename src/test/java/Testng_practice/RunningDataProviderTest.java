package Testng_practice;

import org.testng.annotations.Test;

public class RunningDataProviderTest {

	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "staff_subjects")
	public void getData(String trainers, String subjects)
	{
		System.out.println(trainers+"------> "+subjects);
	}
}
