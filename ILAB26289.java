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

public class ILAB26289 {
	
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String inst = "https://rf2.ilabx.com/institutions/35/semantic/settings";

	
	@Test 
	public void Macron26289() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		// Login to application 
		driver.get(Login);
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.get(url);
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//a[@class='generate_quote']")).size()!=0) {
			driver.get(inst);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("Prevent cores from adding free entry charges to request");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='result']")).click();
			Thread.sleep(3000);
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//input[@id='settings_cores_can_not_add_charges_to_request']"))).click().perform();
			driver.findElement(By.id("settings-apply-action")).click();
			Thread.sleep(2000);
			driver.get(url);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("s2id_service_charge_id")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("s2id_autogen1_search")).sendKeys("custom");
			Thread.sleep(2000);
			act.sendKeys(Keys.ENTER).build().perform();
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26289.png");
			 FileUtils.copyFile(SrcFile, DestFile);
			 driver.get(inst);
				Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("Prevent cores from adding free entry charges to request");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='result']")).click();
				Thread.sleep(3000);
				act.moveToElement(driver.findElement(By.xpath("//input[@id='settings_cores_can_not_add_charges_to_request']"))).click().perform();
				driver.findElement(By.id("settings-apply-action")).click();
				Thread.sleep(2000);
				driver.get(url);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(2000);
				driver.findElement(By.id("s2id_service_charge_id")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("s2id_autogen1_search")).sendKeys("custom");
				act.sendKeys(Keys.ENTER).build().perform();	
				TakesScreenshot scrShot1 =((TakesScreenshot)driver);
				File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
				File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26289-2.png");
				 FileUtils.copyFile(SrcFile1, DestFile1);
		}else {
			driver.get(inst);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
			driver.findElement(By.xpath("//*[@id='edit_other_settings_title_tag']/a")).click();
			driver.findElement(By.id("settings-searchbox")).sendKeys("Enable ability to generate external quotes");
			Actions act = new Actions(driver);
			act.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			driver.get(inst);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("Prevent cores from adding free entry charges to request");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='result']")).click();
			Thread.sleep(3000);
			act.moveToElement(driver.findElement(By.xpath("//input[@id='settings_cores_can_not_add_charges_to_request']"))).click().perform();
			driver.findElement(By.id("settings-apply-action")).click();
			Thread.sleep(2000);
			driver.get(url);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("s2id_service_charge_id")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("s2id_autogen1_search")).sendKeys("custom");
			Thread.sleep(2000);
			act.sendKeys(Keys.ENTER).build().perform();
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26289.png");
			 FileUtils.copyFile(SrcFile, DestFile);
			 driver.get(inst);
				Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("Prevent cores from adding free entry charges to request");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='result']")).click();
				Thread.sleep(3000);
				act.moveToElement(driver.findElement(By.xpath("//input[@id='settings_cores_can_not_add_charges_to_request']"))).click().perform();
				driver.findElement(By.id("settings-apply-action")).click();
				Thread.sleep(2000);
				driver.get(url);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(2000);
				driver.findElement(By.id("s2id_service_charge_id")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("s2id_autogen1_search")).sendKeys("custom");
				act.sendKeys(Keys.ENTER).build().perform();	
				TakesScreenshot scrShot1 =((TakesScreenshot)driver);
				File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
				File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB26289-2.png");
				 FileUtils.copyFile(SrcFile1, DestFile1);
			
			// Taking Screenshot of Setting first time enabling
			
		}
			driver.quit();

	}


		
	}


