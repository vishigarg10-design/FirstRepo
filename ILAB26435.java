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

public class ILAB26435 {

	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String url1="https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	

	@Test 
	public void Macron26435() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url1);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id='edit_other_settings_title_tag']/a")).click();
		driver.findElement(By.id("settings-searchbox")).sendKeys("Enable ability to generate external quotes");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26435.png");
		 FileUtils.copyFile(SrcFile, DestFile);
		 driver.findElement(By.xpath("//*[@id='settings_generate_external_quotes_tr']/td[2]/div/label[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-3']/div[2]/button[2]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='settings_generate_external_quotes_tr']/td[2]/div/label[2]")).click();
		 Thread.sleep(2000);
		 TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		 File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		 File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26435.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);
		driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-3']/div[2]/button[2]")).click();
	}


		
	}

