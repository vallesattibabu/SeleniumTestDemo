package ui;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DamoClass {
@Test
	public void Test1() {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "${WORKSPACE}\\chromedriver.exe");
		

		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("77298");
		//driver.findElement(By.xpath("//input[@name='login']")).sendKeys("gggg@ggg.com");
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("77298");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
               File DestFile=new File("B:\\fff.png");
                try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		driver.quit();
	}

	
	
}
