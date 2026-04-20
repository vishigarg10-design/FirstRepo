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

public class ILAB25589 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String url1="https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	
	@Test 
	
	public void Macron25589() throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.get(url);
		Thread.sleep(2000);
		// Checking on VAR tab if Generate Quote button is already present or not 	
		if(driver.findElements(By.xpath("//a[@class='generate_quote']")).size()!=0)
		{
			driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("select2-chosen-1")).click();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			TakesScreenshot scrShot1 =((TakesScreenshot)driver);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB25589.png");
			 FileUtils.copyFile(SrcFile1, DestFile1);
			driver.findElement(By.xpath("//*[@id='quote_item_table']/tbody/tr/td[8]/img")).click();
		

	}else {
		driver.get(url1);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
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
		driver.findElement(By.id("select2-chosen-1")).click();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB25589-2.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);
		driver.findElement(By.xpath("//*[@id='quote_item_table']/tbody/tr/td[8]/img")).click();
	}
    driver.close();
}


		
	}


