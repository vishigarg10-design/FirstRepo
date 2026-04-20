package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ILAB24678 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url = "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=equipment";
    WebDriver driver;
    static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
    
    @Test 
    
    public void deleteEquipment() throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.id("equipment-more-actions")).click();
		driver.findElement(By.xpath("//*[@id='equipment-actions-menu']/div/a[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("equipment_settings_name")).clear();
		driver.findElement(By.id("equipment_settings_name")).sendKeys("Automation Equipment");
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,3000)", "");
		driver.findElement(By.xpath("//a[@data-section='usage_types']")).click();
		
    	
    }
}
