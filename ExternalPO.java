package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ExternalPO {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String Uname= "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	static String url = "https://rf2.ilabx.com/external_generic_funds?core_id=332&tab=sc_po";
	
	
	@Test 
	
	public void EPO() throws InterruptedException {
		
			WebDriver driver = new ChromeDriver();
			driver.get(Login);	
			driver.manage().window().maximize();
			driver.findElement(By.id("login")).sendKeys(Uname);
			driver.findElement(By.id("password_input")).sendKeys(Pword);
			driver.findElement(By.id("login_btn")).click();
			Thread.sleep(3000);
			driver.get(url);
			driver.findElement(By.id("add_standing_po")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("term")).sendKeys("ste");
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			act.sendKeys(Keys.ENTER).build().perform();
			driver.findElement(By.id("proceed_button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("external_generic_fund_n1")).sendKeys("1000000");
			driver.findElement(By.id("description_text_area")).sendKeys("smoke PO");
			driver.findElement(By.id("external_generic_fund_available_funds")).sendKeys("121021210");
			driver.findElement(By.id("jqueryui_datepicker")).sendKeys("Apr 30, 2026");
			driver.findElement(By.xpath("//div[@class='ui button gray hide_if_no_group_selected new_po_submit']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
			
			
		
			
			
			
			
			
			
			
			
		
		
	}

}
