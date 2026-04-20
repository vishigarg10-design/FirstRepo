package macron_testng;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class ILAB28001 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/332?tab=sc_billing";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
	
	public void ClearNoissues() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='header_panel']/div/div[2]/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class ='ui billing_event_filter_draft draft button right floated']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='actions cell']/a[2]")).click();
		Thread.sleep(2000);
		 String mainWindowHandle = driver.getWindowHandle();
		 Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                Thread.sleep(2000);
	                driver.findElement(By.xpath("//div[@class='ui dropdown billing_event_filter_charges selection initialized']")).click();
	                
	                
	Thread.sleep(2000);
		
		Actions act= new Actions(driver);
		
		act.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		
		
		Thread.sleep(2000);
		if(driver.findElement(By.id("billing_event_clear_search")).isDisplayed()) {
		System.out.println("clear button is displayed");
		}else {
			System.out.println("clear button is not displayed");
		}
		
		
		driver.findElement(By.id("billing_event_clear_search")).click();
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(mainWindowHandle);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='/images/delete.png']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.quit();
		Thread.sleep(2000);

		
		
	}

}
	}	
	}
