package Practice1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderpgm {
	@Test(dataProvider="dataProviders")
	public void bookTicket(String src,String dest)
	{
		System.out.println("Book ticket from "+src+" to "+dest+"");
	}
	@DataProvider
	public Object[][] dataProviders()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Bangalore";
		objArr[0][1]="goa";
		objArr[1][0]="Bangalore";
		objArr[1][1]="mangalore";
		objArr[2][0]="Bangalore";
		objArr[2][1]="bhatkal";
		objArr[3][0]="Bangalore";
		objArr[3][1]="karwar";
		objArr[4][0]="Bangalore";
		objArr[4][1]="mumbai";
		
	return objArr;
		
	}

}
