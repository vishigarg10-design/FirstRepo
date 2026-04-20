package macron_testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class ILAB29910 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/administration/organizations";
	static String url1= "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
	public void orgsettings() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='wrapper_main']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("organization_name")).sendKeys("Automation Org");
		Thread.sleep(2000);
		WebElement A = driver.findElement(By.id("organization_description_ifr"));
		Thread.sleep(2000);
		driver.switchTo().frame(A);
		WebElement B = driver.findElement(By.xpath("//body[@data-id='organization_description']"));
		Thread.sleep(2000);
		B.sendKeys("this is for org");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement sel = driver.findElement(By.id("organization_category"));
		Thread.sleep(2000);
		Select C = new Select(sel);
		C.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.id("institution_name")).sendKeys("Vishal");
		Thread.sleep(3000);
		Actions D = new Actions(driver);
		D.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		D.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		WebElement E = driver.findElement(By.xpath("//div[@class='ui message positive']"));
		String F= E.getText();
		System.out.println("The text is " +F);
		Thread.sleep(2000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,2000)", "");
		driver.findElement(By.id("settings_invoice_and_quote_logo")).sendKeys("this is for org");
		Thread.sleep(2000);
		D.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		D.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		D.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='wrapper_main']/div/a")).click();
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,2000)", "");
	Thread.sleep(3000);
	TakesScreenshot scrShot2 =((TakesScreenshot)driver);
	File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
	File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB29910.png");
	 FileUtils.copyFile(SrcFile2, DestFile2);
	 driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
