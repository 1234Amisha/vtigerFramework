package Practice1;

import org.testng.annotations.Test;

public class Sample1 {
	public void createContact()
	{
		System.out.println("contact created");
		int[] arr= {1,2,3};
		System.out.println(arr[5]);
	}
	@Test(priority=2)
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	@Test(priority=1)
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}
	@Test(priority=-1)
	public void searchContact()
	{
		System.out.println("search the contact");
	}

}


