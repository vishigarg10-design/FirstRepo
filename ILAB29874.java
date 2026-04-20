package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ILAB29874 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/administration/procurement_groups";
	static String url1= "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
	public void Procurement() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("//a[@class='ui large right floated green button add_new_procurement_btn']")).click();
		driver.findElement(By.id("procurement_group_name")).sendKeys("Automation1");
		Thread.sleep(3000);
		driver.findElement(By.id("select2-chosen-1")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("peter");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("select2-chosen-3")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("s2id_autogen3_search")).sendKeys("Flan");
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.id("s2id_core_id")).click();
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='admin_procurement_groups']/div/form/div[3]/div[5]/div[1]/input")).click();
		Thread.sleep(2000);
		WebElement A = driver.findElement(By.xpath("//div[@class='ui message success']"));
		System.out.println("procurement group created" +A);
		
		
		
		
		
		
		
	}

}
