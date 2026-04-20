package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ILAB26877 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/332/?tab=equipment";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
	
	public void ExternalPage() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='tipsy_tip'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-section='usage_types']")).click();
		if(driver.findElement(By.xpath("//a[@class='ui button blue false_form_submit']")).isDisplayed()){
			driver.findElement(By.xpath("//i[@class='trash outline icon large black'][1]")).click();
			
		}else 
		{
		
		}
		
		
	}

}
