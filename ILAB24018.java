package macron_testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;


public class ILAB24018 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/332/?tab=equipment";
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	static String url1= "https://rf2.ilabx.com/service_center/show_external/332";
	WebDriver driver;
	@Test 
	
	public void ExternalLanding() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		// Login to application 
		driver.get(Login);
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='azlist_table']/tbody/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='left_sticky_wrapper']/div/div[4]/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='public_visibility']/div[1]/div/div/div/div/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='menu transition visible']/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='public_visibility']/div[3]/input[1]")).click();
		driver.findElement(By.id("sign_out_btn")).click();
	    driver.get(url1);
	    JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		WebElement C = driver.findElement(By.xpath("//table[@id='equipment_list']/tbody/tr[2]/td[1]"));
		String actual = C.getText();
		System.out.println("the calendar name is " + actual);
		String Expected = "Aria2_Sample - Trained and Untrained";
		Assert.assertEquals(actual, Expected, "Text does not match!");
		Thread.sleep(2000);
		TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB24018.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);
		
		driver.quit();
		
		
	}

		
		
	
	
		}	

