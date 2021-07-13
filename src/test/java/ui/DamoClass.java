package ui;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DamoClass {
@Test
	public void Test1() {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		

		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("--headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		
		String username = null;
		String password = null;
		String url = null;
		String path=System.getProperty("user.dir");
		 try (InputStream input = new FileInputStream(path+"/config.properties")) {

	            Properties prop = new Properties();

	        // load a properties file
	        prop.load(input);
	        username = prop.getProperty("username");
	        password = prop.getProperty("password");
            url = prop.getProperty("url");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		//driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("77298");
		//driver.findElement(By.xpath("//input[@name='login']")).sendKeys("gggg@ggg.com");
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("77298");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
               File DestFile=new File("screenshot.png");
                try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		driver.quit();
	}

	
	
}
