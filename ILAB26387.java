package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ILAB26387 {
	static String Login = "https://rf2.ilabx.com/account/login";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	
	
	@Test 
	
	public void subsidy() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wrapper_main']/div/table/tbody/tr/td[3]/a[1]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1800)", "");
		driver.findElement(By.xpath("//*[@id='wrapper_main']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("center_name")).sendKeys("VishalSubsidy");
		Thread.sleep(2000);
		WebElement A = driver.findElement(By.id("center_description_ifr"));
		driver.switchTo().frame(A);
	    driver.findElement(By.xpath("//body[@data-id='center_description']")).sendKeys("this is for center");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.id("institution_name")).sendKeys("Vishal");
		Thread.sleep(2000);
		Actions act1= new Actions(driver);
    	act1.sendKeys(Keys.DOWN).build().perform();
    	act1.sendKeys(Keys.ENTER).build().perform();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id='new_center']/p/input")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//li[@class='ui-state-default ui-corner-top'][1]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@class='ui form']/div[@class='live_search_div']/input[@data-target_id='add_subsidy_form']")).sendKeys("APP");
	}

}
