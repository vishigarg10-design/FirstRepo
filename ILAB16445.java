package macron_testng;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class ILAB16445 {
@Test 
	public void AgilentILAB16445() throws InterruptedException, IOException {
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
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='settings_equipment_duration_threshold']")).sendKeys("10");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-4']/div[2]/button[2]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@id='equipment_button']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='service_project_template_91324']/td[3]/a[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@data-section='usage_types']")).click();
		 driver.findElement(By.xpath("//input[@id='duration_discount_price_560323']")).clear();
		driver.findElement(By.xpath("//input[@id='duration_discount_price_560323']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@id='duration_discount_price_560324']")).clear();
		driver.findElement(By.xpath("//input[@id='duration_discount_price_560324']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@id='duration_discount_price_560325']")).clear();
		driver.findElement(By.xpath("//input[@id='duration_discount_price_560325']")).sendKeys("15");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='ui button blue false_form_submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='top_nav']/div[2]/span[2]")).click();
		Thread.sleep(2000);
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='equipment_button']")).click();
		driver.findElement(By.id("schedule_button_91324")).click();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//div[@class='dhx_scale_hour'][3]"));
		act.doubleClick(ele).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='select2-chosen-8']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("s2id_autogen8_search")).sendKeys("ste");
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ui primary button']")).click();
		driver.findElement(By.id("notes")).sendKeys("duration pricing");
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(5000);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\Duration resevation details.png");
		 FileUtils.copyFile(SrcFile, DestFile);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='cancel_charges_btn']")).click();
		 Thread.sleep(2000);
		 driver.quit();
		
		
		
		

	}

}
