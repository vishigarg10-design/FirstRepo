package macron_testng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ILAB27983 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=services";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	static String Button= "//*[@id=\"service_templates_list\"]/table[1]/tbody/tr/td/span[1]/a";
	
	
	@Test 
	public void SaveDisabled() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Button)).click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,2800)", "");
		Thread.sleep(2000);
		
		boolean a= driver.findElement(By.xpath("//input[@class='ui button blue disabled']")).isEnabled();
		Thread.sleep(2000);
		System.out.println("the button is disabled or enabled "  + a);

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-2800)", "");
		
		driver.findElement(By.id("asset_name")).sendKeys("this is working fine");
		Thread.sleep(2000);
		
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("window.scrollBy(0,2800)", "");
		Thread.sleep(3000);
		
		System.out.println("a is enabled or disabled " +  a);
	    Thread.sleep(2000);
	    driver.quit();
				

}
}