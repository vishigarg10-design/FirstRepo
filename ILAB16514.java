package macron_testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;



public class ILAB16514 {
	@Test 

	public void AgilentILAB16514()throws IOException, InterruptedException {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		 
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rf2.ilabx.com");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		 driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		 driver.findElement(By.id("login_btn")).click();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		 driver.findElement(By.xpath("//div[@id='equipment_button']")).click();
		 driver.findElement(By.xpath("//a[@id='equipment-more-actions']")).click();
		 Thread.sleep(3000);
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\Permission_more.png");
			 FileUtils.copyFile(SrcFile, DestFile);
			 Thread.sleep(2000);
			 driver.quit();
			 
	}

}
