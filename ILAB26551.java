package macron_testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class ILAB26551 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String inst = "https://rf2.ilabx.com/institutions/35/semantic/settings";

	@Test 
	
	public void Macron25661() throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		// Login to application 
		driver.get(Login);
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.get(inst);
		driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("tax");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.xpath("//input[@name='settings[using_taxes]'][2]"))).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("settings-apply-action")).click();
		driver.get(url);
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("//*[@id='requests']/div[1]/div[1]/div[2]/a[1]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='top_nav']/div[2]/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("quotation_title")).sendKeys("Macron");
		Thread.sleep(1000);
		driver.findElement(By.id("quotation_customer_name")).sendKeys("Lola Paucek");
		Thread.sleep(1000);
		driver.findElement(By.id("quotation_customer_email")).sendKeys("vishal.garg@agilent.com");
		Thread.sleep(1000);
		driver.findElement(By.id("quotation_customer_organization")).sendKeys("School of science");
		Thread.sleep(1000);
		driver.findElement(By.id("quotation_billing_address")).sendKeys("Tokyo");
		Thread.sleep(1000);
		driver.findElement(By.id("quotation_expiration_date")).sendKeys("01/04/2024");
		Thread.sleep(1000);
		driver.findElement(By.id("quotation_notes")).sendKeys("The Hindu is an Indian English-language daily newspaper owned by The Hindu Group, headquartered in Chennai, Tamil Nadu. It began as a weekly in 1878 and became a daily in 1889. It is one of the Indian newspapers of record and the second most circulated English-language newspaper in India, after The Times of India.");
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='s2id_service_charge_id']/a/span[2]")).click();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		TakesScreenshot scrShot2 =((TakesScreenshot)driver);
		File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
		File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26436-Tax not displayed.png");
		 FileUtils.copyFile(SrcFile2, DestFile2);
		 Thread.sleep(2000);
		 driver.get(inst);
			driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("tax");
			Thread.sleep(3000);
			
			act.sendKeys(Keys.DOWN).build().perform();
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			act.moveToElement(driver.findElement(By.xpath("//input[@name='settings[using_taxes]'][2]"))).click().perform();
			Thread.sleep(2000);
			driver.findElement(By.id("settings-apply-action")).click();
			driver.get(url);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='requests']/div[1]/div[1]/div[2]/a[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("quotation_title")).sendKeys("Macron");
			Thread.sleep(1000);
			driver.findElement(By.id("quotation_customer_name")).sendKeys("Lola Paucek");
			Thread.sleep(1000);
			driver.findElement(By.id("quotation_customer_email")).sendKeys("vishal.garg@agilent.com");
			Thread.sleep(1000);
			driver.findElement(By.id("quotation_customer_organization")).sendKeys("School of science");
			Thread.sleep(1000);
			driver.findElement(By.id("quotation_billing_address")).sendKeys("Tokyo");
			Thread.sleep(1000);
			driver.findElement(By.id("quotation_expiration_date")).sendKeys("01/04/2024");
			Thread.sleep(1000);
			driver.findElement(By.id("quotation_notes")).sendKeys("The Hindu is an Indian English-language daily newspaper owned by The Hindu Group, headquartered in Chennai, Tamil Nadu. It began as a weekly in 1878 and became a daily in 1889. It is one of the Indian newspapers of record and the second most circulated English-language newspaper in India, after The Times of India.");
			Thread.sleep(1000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,400)", "");
			driver.findElement(By.xpath("//*[@id='s2id_service_charge_id']/a/span[2]")).click();
			Thread.sleep(1000);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			TakesScreenshot scrShot3 =((TakesScreenshot)driver);
			File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
			File DestFile3=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26436-Tax is displayed.png");
			 FileUtils.copyFile(SrcFile3, DestFile3);
			 Thread.sleep(2000);
		     driver.close();
		 
	}


		
	}


