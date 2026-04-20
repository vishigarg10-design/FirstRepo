package macron_testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class ILAB30291 extends BaseClass {
	
	@Test 
	
	public void ReportingOptions() throws InterruptedException, IOException {
		
		setup();
		login();
		
		driver.get("https://rf2.ilabx.com/sc_reporting/landing");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"wrapper_main\"]/div[1]/div/a")).click();
		driver.findElement(By.xpath("//input[@name='report[start_date]']")).sendKeys("Jul 01, 2024");
		Thread.sleep(1000);
		Enter();
		driver.findElement(By.xpath("//input[@name='report[end_date]']")).sendKeys("Jul 22, 2025");
		Thread.sleep(1000);
		Enter();
		driver.findElement(By.xpath("//*[@id='lab_checkboxes']/span/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@style='list-style-type:none;']//li[1]//input[@id='report_lab_3930']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,30000)", "");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='create_report_div']/form/input[2]")).click();
		Thread.sleep(2000);
		TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ReportGenerated.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[@style='text-align:left;']//span[@class='small']/a[2]")).click();
		 TakesScreenshot scrShot2 =((TakesScreenshot)driver);
			File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
			File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\OptionsLink.png");
			 FileUtils.copyFile(SrcFile2, DestFile2);
			 teardown();
		
		
		
		
		
		
		
		
		
	}
	

}
