package HomePage;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import testBase.TestBase;

public class TC002 extends TestBase{
	
	  @Test
	  public void HomePage() throws Exception {
		  Reporter.log("Browser about to launch");
			loadProperties();
			InternetTicketing();
			}
}
