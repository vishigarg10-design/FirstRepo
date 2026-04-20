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

public class ILAB26298 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String url1="https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	
	@Test 

	
	public void Macron26298() throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(3000);
		// Checking on VAR tab if Generate Quote button is already present or not 
		if(driver.findElements(By.xpath("//a[@class='generate_quote']")).size()!=0)
		{
			driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
			//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
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
			driver.findElement(By.id("select2-chosen-1")).click();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("window.scrollBy(0,400)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(4000);
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("window.scrollBy(0,900)", "");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@id='quotation-search-table']/tbody/tr[1]/td[6]/a[5]")).click();
			Thread.sleep(2000);
			TakesScreenshot scrShot3 =((TakesScreenshot)driver);
			File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
			File DestFile3=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26318.png");
			 FileUtils.copyFile(SrcFile3, DestFile3);
			 Thread.sleep(2000);
		     driver.close();
		
		}	else {
			driver.get(url1);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
			driver.findElement(By.xpath("//*[@id='edit_other_settings_title_tag']/a")).click();
			driver.findElement(By.id("settings-searchbox")).sendKeys("Enable ability to generate external quotes");
			Actions act = new Actions(driver);
			act.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='settings_generate_external_quotes_tr']/td[2]/div/label[1]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-3']/div[2]/button[2]")).click();
			Thread.sleep(2000);
			driver.get(url);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
			driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
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
			driver.findElement(By.id("select2-chosen-1")).click();
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("window.scrollBy(0,400)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(4000);
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("window.scrollBy(0,900)", "");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//table[@id='quotation-search-table']/tbody/tr[1]/td[6]/a[5]")).click();
			Thread.sleep(2000);
			TakesScreenshot scrShot3 =((TakesScreenshot)driver);
			File SrcFile3=scrShot3.getScreenshotAs(OutputType.FILE);
			File DestFile3=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26318.png");
			 FileUtils.copyFile(SrcFile3, DestFile3);
			 Thread.sleep(2000);
		     driver.close();
		}

	}


		
	}
