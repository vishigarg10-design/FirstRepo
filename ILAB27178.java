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

public class ILAB27178 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_centers/332/charge_entry";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	static String ChargeEntry ="https://rf2.ilabx.com/service_centers/332/charge_entry";
	
	@Test 
	public void reserform() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(ChargeEntry);
		driver.findElement(By.id("select2-chosen-2")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("select2-chosen-3")).click();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(4000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='reset_form']")).click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		TakesScreenshot scrShot2 =((TakesScreenshot)driver);
		File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
		File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB27178-ReserForm.png");
		 FileUtils.copyFile(SrcFile2, DestFile2);
		 Thread.sleep(2000);
		 driver.quit();
		
	}

}
