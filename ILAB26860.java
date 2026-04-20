package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ILAB26860 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_centers/332/charge_entry";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	@Test  
	
	public void NoteChargeEntry() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		driver.findElement(By.id("select2-chosen-2")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("select2-chosen-3")).click();
		driver.findElement(By.id("s2id_autogen3_search")).sendKeys("1");
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("add_to_list_button")).click();
		Thread.sleep(2000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("confirm_charges_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='tipsy_tip']")).click();
		
		driver.findElement(By.xpath("//input[@name='line_item[note_attributes][content]']")).sendKeys("this is for editing");
		driver.findElement(By.xpath("//input[@name='line_item[note_attributes][content]']")).clear();
		driver.findElement(By.xpath("//input[@name='line_item[note_attributes][content]']")).sendKeys("this is working fine");
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//img[@class=' tipped_target tipsy_tip']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='j_link_to_remote tipsy_tip']")).click();
		Thread.sleep(2000);
		driver.close();
		
		
		
		
		
		
		
	
		
		
		
		
	}
	

}
