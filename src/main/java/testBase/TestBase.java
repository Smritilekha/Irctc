package testBase;
/////import java.math;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	 public  Properties prop = new Properties();

	  WebDriver driver; 
	 File file =new File("C:\\Users\\smrity\\workspace\\Irctc\\src\\main\\java\\locaters\\Common.properties");
	  File file1= new File("C:\\Users\\smrity\\workspace\\Irctc\\src\\main\\java\\locaters\\Homepage.properties");

	public  void loadProperties() throws Exception{
	
	try {
		FileInputStream f1 = new FileInputStream(file);
		prop.load(f1);
		System.out.println(prop.getProperty("commom.url"));
		browserURL();

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	}
	
	public  WebElement getWebElementLocators(String locator) throws Exception
	{
		String locatorType=locator.split("_")[0];
		String locatorValue=locator.split("_")[1];
		
		if(locatorType.equalsIgnoreCase("id"))
			return driver.findElement(By.id(locatorValue));
		
		else if(locatorType.equalsIgnoreCase("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else 
			throw new Exception("Unknown Locators");
	}
	
	public  WebElement getLocator(String locator) throws Exception
	{
		return getWebElementLocators(prop.getProperty(locator));
	}
	
	public  void browserURL()
	{
		driver= new FirefoxDriver();
		System.out.println("Launching url");
		System.out.println(prop.getProperty("commom.url"));
		driver.get(prop.getProperty("commom.url"));
		System.out.println("Launched url");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Maximized");
	}
	
	public  void InternetTicketing() throws Exception
	{
		
		FileInputStream f2 = new FileInputStream(file1);
		prop.load(f2);
		getLocator(prop.getProperty("InternetTicketing"));
		System.out.println(prop.getProperty("InternetTicketing"));
	}
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Closed Browser");
	}
	
/*	public  class main{
	public void main(String args[]) throws Exception 
	{
		TestBase tb = new TestBase();
		tb.InternetTicketing();
		System.out.println("Ticketing");

		}
	}*/
}

