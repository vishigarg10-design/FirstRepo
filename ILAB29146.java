package macron_testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ILAB29146 {
	static String Login = "https://rf2.ilabx.com/account/login";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";

	@Test 
		public void Procurement() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get("https://rf2.ilabx.com/procurement_groups/1/?tab=requests");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='purchases_button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='search_result_entry'][1]//div[@class=' cell actions']//a[3]")).click();
		Thread.sleep(2000);
		TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB29146.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);	
		
	}

}
