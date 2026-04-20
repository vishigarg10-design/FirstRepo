package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ILAB28000 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/332?tab=sc_billing";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
	
	public void Clearsearch() throws InterruptedException {
		
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
		driver.findElement(By.xpath("//a[@class='ui review_charges button right floated']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ui dropdown billing_event_filter_charges selection initialized']")).click();
		Thread.sleep(2000);
		
		String b= driver.findElement(By.id("included-charges-count")).getText();
		System.out.println("total count of charges are " +b);
		Thread.sleep(2000);
		
		Actions act= new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
		if(driver.findElement(By.id("billing_event_clear_search")).isDisplayed()) {
			System.out.println("clear button is displayed");
		}else {
			System.out.println("clear button is not displayed");
		}
		String a = driver.findElement(By.id("included-charges-count")).getText();
		System.out.println("the count of Included Charges are " +a);
		
		driver.findElement(By.id("billing_event_clear_search")).click();
		String c = driver.findElement(By.id("included-charges-count")).getText();
		System.out.println("the count of charges again " +c);
		Thread.sleep(3000);
		Thread.sleep(3000);
		if(b.equals(c)) {
			System.out.println("Test cases is pass");
		}
		driver.quit();
	}

}
