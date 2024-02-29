package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	
	   WebDriver driver;
	
	public screenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String ScreenShots(String fileName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String target=System.getProperty("user.dir")+"\\screenShot\\"+ fileName+".png";
		File trg= new File(target);
		FileUtils.copyFile(src, trg);
		return target;
		
		

}

}
