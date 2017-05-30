package HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class TC001 extends TestBase {
  @Test
  public void HomePage() throws Exception {
	  Reporter.log("Browser about to launch");
		loadProperties();
		}

	  
@AfterMethod
		
public void testDown()
		{
			closeBrowser();
		}
}

