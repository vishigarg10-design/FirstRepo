package macron_testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class ILAB22210 {
	@Test 

	public  void AgilentILAB22210() throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		// Login to application 
		
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		driver.findElement(By.id("equipment_button")).click();
		driver.findElement(By.xpath("//*[@id='service_project_template_91324']/td[3]/a[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='search-settings']/div[1]/input")).sendKeys("buffer");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='result'][1]")).click();
		
		// taking screenshot
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\buffer.png");
		FileUtils.copyFile(SrcFile, DestFile);
		driver.findElement(By.xpath("//*[@id='buffer-times']/div[1]/div/div/div/label")).click();
		Thread.sleep(1000);
		boolean b = driver.findElement(By.xpath("//input[@id='equipment_settings_block_buffer_before']")).isEnabled();
		System.out.println("the toogle is enable or disable=" +b);
		
		// Entering buffer time values
		
		driver.findElement(By.xpath("//input[@id='equipment_settings_block_time_before_buffer']")).clear();
		driver.findElement(By.xpath("//input[@id='equipment_settings_block_time_before_buffer']")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='buffer-times']/div[3]/div/div/div/label")).click();
		 driver.findElement(By.id("equipment_settings_block_time_after_buffer")).clear();
		driver.findElement(By.id("equipment_settings_block_time_after_buffer")).sendKeys("10");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='search-settings']/div[1]/input")).sendKeys("buffer");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='result'][1]")).click();
		Thread.sleep(2000);
		
		// Removing the Values of buffer times
		
		driver.findElement(By.xpath("//*[@id='buffer-times']/div[1]/div/div/div/label")).click();
		driver.findElement(By.xpath("//*[@id='buffer-times']/div[3]/div/div/div/label")).click();
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.SPACE).build().perform();
		driver.quit();	

	}

}
