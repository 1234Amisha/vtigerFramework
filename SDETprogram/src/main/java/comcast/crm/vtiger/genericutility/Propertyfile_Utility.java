package comcast.crm.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Propertyfile_Utility
{
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fisss = new FileInputStream("./data/propertydata.properties");
		Properties ppp=new Properties();
		ppp.load(fisss);
		String value=ppp.getProperty(Key);
		return value;
	}
}
