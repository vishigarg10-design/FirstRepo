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

public class ILAB26318 {
	
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String url1="https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	
	@Test 
	public void Macron26318() throws IOException, InterruptedException {
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
			driver.findElement(By.id("quote_item_note_0")).sendKeys("this is working fine as notes are getting added");
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


