package macron_testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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

public class ILAB25591 {
	
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	static String url1="https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	
	@Test 
	
	public void Macron25591() throws InterruptedException, IOException {
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
			Thread.sleep(1000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,700)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(2000);
			for(int i =1; i<=2; i++) {
				String A = driver.findElement(By.xpath("//ul[@class='list']/li["+i+"]")).getText();
				System.out.println("the error messages after clicking on generate qoutes " +A);
			}
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,-700)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("quotation_title")).sendKeys("a");
			driver.findElement(By.id("quotation_customer_name")).sendKeys("b");
			Thread.sleep(2000);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("window.scrollBy(0,700)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(2000);
			Alert Alt = driver.switchTo().alert();
			String A = Alt.getText();
			System.out.println("the text of the alert" +A);
			Thread.sleep(2000);
			Alt.accept();
			Thread.sleep(2000);		
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js5.executeScript("window.scrollBy(0,-700)", "");
			driver.findElement(By.id("quotation_title")).clear();
			driver.findElement(By.id("quotation_customer_name")).clear();
			driver.findElement(By.id("quotation_title")).sendKeys("Macron");
			driver.findElement(By.id("quotation_customer_name")).sendKeys("Lola");
			Thread.sleep(2000);
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("window.scrollBy(0,700)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("save_quotation")).click();
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("window.scrollBy(0,700)", "");
			Thread.sleep(2000);
			JavascriptExecutor js7 = (JavascriptExecutor) driver;
			js7.executeScript("window.scrollBy(0,1000)","");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//table[@id='quotation-search-table']/tbody/tr[1]/td[6]/a[1]")).click();
			Alt.accept();
			
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
			driver.findElement(By.xpath("//*[@id='top_nav']/div[2]/span[2]")).click();
			Thread.sleep(1000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,700)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(2000);
			TakesScreenshot scrShot1 =((TakesScreenshot)driver);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB25591.png");
			 FileUtils.copyFile(SrcFile1, DestFile1);
			for(int i =1; i<=2; i++) {
				String A = driver.findElement(By.xpath("//ul[@class='list']/li["+i+"]")).getText();
				System.out.println("the error messages after clicking on generate qoutes " +A);
				Thread.sleep(2000);
				
			}
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,-700)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("quotation_title")).sendKeys("a");
			driver.findElement(By.id("quotation_customer_name")).sendKeys("b");
			Thread.sleep(2000);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("window.scrollBy(0,700)", "");
			driver.findElement(By.id("save_quotation")).click();
			Thread.sleep(2000);
			Alert Alt = driver.switchTo().alert();
			String A = Alt.getText();
			System.out.println("the text of the alert" +A);
			Thread.sleep(2000);
			TakesScreenshot scrShot2 =((TakesScreenshot)driver);
			File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
			File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB25591-Alert.png");
			 FileUtils.copyFile(SrcFile2, DestFile2);
			Alt.accept();
			Thread.sleep(2000);		
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js5.executeScript("window.scrollBy(0,-700)", "");
			driver.findElement(By.id("quotation_title")).clear();
			driver.findElement(By.id("quotation_customer_name")).clear();
			driver.findElement(By.id("quotation_title")).sendKeys("Macron");
			driver.findElement(By.id("quotation_customer_name")).sendKeys("Lola");
			Thread.sleep(2000);
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("window.scrollBy(0,700)", "");
			driver.findElement(By.id("save_quotation")).click();
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("window.scrollBy(0,700)", "");
			driver.findElement(By.xpath("//table[@id='quotation-search-table']/tbody/tr[1]/td[6]/a[1]")).click();
			Alt.accept();
			
		}
driver.close();
}

		
	}


