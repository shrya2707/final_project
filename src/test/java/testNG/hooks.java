package testNG;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import base.baseClass;

public class hooks {

	static WebDriver driver;
	static Properties p;
	
	@BeforeTest
	@Parameters("browser")
	public  WebDriver setup(String br)throws IOException
	{
		
		switch(br.toLowerCase()) 
		{
		case "chrome":
	        driver=new ChromeDriver();
	        break;
	    case "edge":
	    	driver=new EdgeDriver();
	        break;
	    default:
	        System.out.println("No matching browser");
	        driver=null;
		} 
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 		p=baseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		return driver;	
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();	
	}
	
	
	
	
	
}

