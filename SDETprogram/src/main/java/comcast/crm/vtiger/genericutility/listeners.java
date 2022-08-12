package comcast.crm.vtiger.genericutility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;

//import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class listeners implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		String testname=result.getMethod().getMethodName();
		System.out.println(testname+"execute and i am listening");
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			File dest=new File("./data/screenshot"+testname+".png");
			FileUtils.copyFile(src, dest);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
