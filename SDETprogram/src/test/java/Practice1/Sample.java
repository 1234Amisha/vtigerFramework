package Practice1;

import org.testng.annotations.Test;

public class Sample {
	@Test
	public void createContact()
	{
		System.out.println("contact created");
	}
	@Test
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	@Test
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}
	@Test
	public void searchContact()
	{
		System.out.println("search the contact");
	}

}
