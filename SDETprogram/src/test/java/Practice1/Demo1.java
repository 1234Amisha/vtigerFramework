package Practice1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1 {
	@Test(retryAnalyzer=comcast.crm.vtiger.genericutility.Retryclass.class)
	public void createContact()
	{
		Assert.assertEquals(false, true);
		System.out.println("contact created");
	}
	@Test(retryAnalyzer=comcast.crm.vtiger.genericutility.Retryclass.class)
	public void modifyContact()
	{
		System.out.println("contact modified");
	}

}
