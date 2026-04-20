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

public class ILAB26422 {
	

	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String url1="https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	
	@Test 
	
	public void Macron26422() throws IOException, InterruptedException {
		
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
			driver.findElement(By.id("quotation_title")).sendKeys("Macron1");
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
			Thread.sleep(2000);
			
			if(driver.findElement(By.id("apply_filters")).isDisplayed())
			{
				System.out.println("the search button is displayed");
			}else {
				System.out.println("the search button is not displayed");
				Thread.sleep(5000);	
			}
			
			driver.findElement(By.id("filters_keywords")).sendKeys("Macron1");
			Thread.sleep(3000);
			driver.findElement(By.id("apply_filters")).click();
			Thread.sleep(2000);
			TakesScreenshot scrShot1 =((TakesScreenshot)driver);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26422-Search and Clear button.png");
			 FileUtils.copyFile(SrcFile1, DestFile1);
			Thread.sleep(6000);
			
			driver.findElement(By.id("clear_search")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@id='quotation-search-table']/tbody[@class='result_entries']/tr[1]/td[6]/a[1]")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.close();
		
		
		}else {
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
			driver.findElement(By.xpath("//*[@id='settings_generate_external_quotes_tr']/td[2]/div/label[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-3']/div[2]/button[2]")).click();
			 driver.get(url);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
			driver.findElement(By.xpath("//*[@id='top_nav']/div[2]/span[2]")).click();
			Thread.sleep(1000);
			Thread.sleep(2000);
			driver.findElement(By.id("quotation_title")).sendKeys("Macron1");
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
			Actions act1 = new Actions(driver);
			act1.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("window.scrollBy(0,400)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(4000);
			Thread.sleep(2000);
			
			if(driver.findElement(By.id("apply_filters")).isDisplayed())
			{
				System.out.println("the search button is displayed");
			}else {
				System.out.println("the search button is not displayed");
				Thread.sleep(5000);	
			}
			
			driver.findElement(By.id("filters_keywords")).sendKeys("Macron1");
			Thread.sleep(3000);
			driver.findElement(By.id("apply_filters")).click();
			Thread.sleep(2000);
			TakesScreenshot scrShot1 =((TakesScreenshot)driver);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26422-Search and Clear button.png");
			 FileUtils.copyFile(SrcFile1, DestFile1);
			Thread.sleep(6000);
			
			driver.findElement(By.id("clear_search")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@id='quotation-search-table']/tbody[@class='result_entries']/tr[1]/td[6]/a[1]")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.close();
		
			
		}
	}


		
	}


