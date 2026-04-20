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

public class ILAB25588 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String url1="https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	
	@Test 
	public void Macron25588() throws InterruptedException, IOException {
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
			//driver.findElement(By.xpath("//*[@id='top_nav']/div[2]/span[2]")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
	 		Thread.sleep(2000);
	 		String title = driver.findElement(By.xpath("//*[@id='main_page_content']/div[2]/div/div[2]/div/div[1]/div/div[2]")).getText();
	 		System.out.println("the tile of the page is " + title);
	 		String customertitle = driver.findElement(By.xpath("//div[@class='ui two column grid padded']/div[1]")).getText();
	 		System.out.println("the tile of the page is " + customertitle);
	 		String customername= driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[2]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + customername);
	 		String Email = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[3]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + Email);
	 		String Organ = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[4]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + Organ);
	 		String Bill = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[5]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + Bill);
	 		String Date = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[6]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + Date);
	 		String Note = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[7]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + Note);
	 		String Service = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[8]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + Service);
	 		Thread.sleep(2000);
	 		TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB25588.png");
			 FileUtils.copyFile(SrcFile, DestFile);
	 		JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
	 		String Terms = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[10]/div[1]/label")).getText();
	 		System.out.println("the tile of the page is " + Terms);
	

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
		driver.findElement(By.xpath("//*[@id='settings_generate_external_quotes_tr']/td[2]/div/label[1]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-3']/div[2]/button[2]")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='generate_quote']")).click();
		
		//driver.findElement(By.xpath("//*[@id='top_nav']/div[2]/span[2]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
 		Thread.sleep(2000);
 		String title = driver.findElement(By.xpath("//*[@id='main_page_content']/div[2]/div/div[2]/div/div[1]/div/div[2]")).getText();
 		System.out.println("the tile of the page is " + title);
 		String customertitle = driver.findElement(By.xpath("//div[@class='ui two column grid padded']/div[1]")).getText();
 		System.out.println("the tile of the page is " + customertitle);
 		String customername= driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[2]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + customername);
 		String Email = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[3]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + Email);
 		String Organ = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[4]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + Organ);
 		String Bill = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[5]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + Bill);
 		String Date = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[6]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + Date);
 		String Note = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[7]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + Note);
 		String Service = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[8]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + Service);
 		Thread.sleep(2000);
 		TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB25588-2.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);
 		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(2000);
 		String Terms = driver.findElement(By.xpath("//*[@id='quotation_form']/div[3]/div[10]/div[1]/label")).getText();
 		System.out.println("the tile of the page is " + Terms);
	}
		driver.close();
	}


		
	}


