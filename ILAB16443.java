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



public class ILAB16443 {
	@Test 

	public  void AgilentILAB16443() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//div[@id='admin_button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("edit_other_settings_title_tag")).click();
		driver.findElement(By.xpath("//input[@id='settings-searchbox']")).sendKeys("duration");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Equipment duration threshold")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ui-id-3")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='settings_equipment_duration_threshold']")).clear();
		driver.findElement(By.xpath("//input[@id='settings_equipment_duration_threshold']")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-4']/div[2]/button[2]")).click();
		Thread.sleep(2000);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\Duration.png");
		 FileUtils.copyFile(SrcFile, DestFile);
		 driver.findElement(By.xpath("//input[@id='settings_equipment_duration_threshold']")).clear();
		 driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-4']/div[2]/button[2]")).click();
		 Thread.sleep(3000);
		 driver.quit();
	}

}
