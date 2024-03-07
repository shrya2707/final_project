package stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import base.baseClass;
import io.cucumber.java.*;

public class hooks {

	static WebDriver driver;
	static Properties p;
	
	@Before
	public static void setup()throws IOException
	{
		driver=baseClass.initilizeBrowser();	
		p=baseClass.getProperties();
		try
		{
		driver.get(p.getProperty("appURL"));

		}catch(TimeoutException e) {
		
		}
		driver.manage().window().maximize();
		
		
		
	}
	
	@After
	public static void close()
	{
		driver.quit();	
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(!scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		
	}
	
	
	
}

