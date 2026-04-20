package macron_testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class ILAB30304 extends BaseClass {
	
	@Test 
	
	public void KeywordSearch() throws InterruptedException, IOException {
		setup();
		login();
		Thread.sleep(2000);
		driver.get("https://rf2.ilabx.com/institutions/35/semantic/dashboard");
		driver.findElement(By.xpath("//a[@class='item billing_tab']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("filters_keywords")).sendKeys("Cell Imaging Center");
		driver.findElement(By.id("submit_customer_search")).click();
		Thread.sleep(2000);
		String A = driver.findElement(By.id("header_message")).getText();
		System.out.println(A);
		Thread.sleep(2000);
		TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\Institution_30304.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);
		teardown();
	}

}
