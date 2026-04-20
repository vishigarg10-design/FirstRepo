package macron_testng;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.Test;

public class ILAB30521 extends BaseClass{
	
	@Test 
	
	
	public void LastMonth() throws InterruptedException, IOException {
		setup();
		login();
		
		driver.findElement(By.id("equipment_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='projects_list']/table/tbody/tr/td[2]/span/a[2]")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
        String originalTab = driver.getWindowHandle();
        
        System.out.println("originalTab");
        
        for (String handle : windowHandles) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                
                System.out.println("Current page title: " + driver.getTitle());
                Thread.sleep(2000);
                driver.findElement(By.xpath("//div[@class='ui top left pointing labeled icon button initialized dropdown date-selector '][1]")).click();
                driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Last month");
                
                TakesScreenshot scrShot1 =((TakesScreenshot)driver);
        		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
        		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\Institution_30521.png");
        		 FileUtils.copyFile(SrcFile1, DestFile1);
        		 
        		 
        		 Thread.sleep(2000);
        		 driver.findElement(By.id("mode-switch")).click();
        		 
        		 driver.findElement(By.xpath("//*[@id='mode-switch']/div[2]/a[2]")).click();
        		 
        		 driver.findElement(By.xpath("//div[@class='ui top left pointing labeled icon button initialized dropdown date-selector '][1]")).click();
                 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Last month");
                 Thread.sleep(2000);
                 Logs b = driver.manage().logs();
                 System.out.println(b);
                 
                
                 TakesScreenshot scrShot2 =((TakesScreenshot)driver);
         		File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
         		File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\Institution_30521-2.png");
         		 FileUtils.copyFile(SrcFile2, DestFile2);
         		 
        		 
        		 teardown();

		
		
		
		
		
		
	}
	
        }
	}

}
