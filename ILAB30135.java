package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ILAB30135 {
	
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/2/?tab=people";
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	WebDriver driver;
	
	@Test
	
	public void People() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='top_nav']/div[2]/span[2]")).click();
		String A = driver.findElement(By.xpath("//div[@id='header_message']")).getText();
		System.out.println(A);
		driver.findElement(By.xpath(("//div[@id='filters_facets']//div[@data-facet='institution_ids']"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='institution']//div[@class='facet_option clearfix']//input[@type='checkbox']")).click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.id("apply_filters")).click();
		Thread.sleep(3000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-1000)", "");
		String B = driver.findElement(By.xpath("//div[@id='header_message']")).getText();
		System.out.println(B);
		driver.findElement(By.id("reset_filters")).click();
		Thread.sleep(2000);
		String C = driver.findElement(By.xpath("//div[@id='header_message']")).getText();
		System.out.println(C);
		if(A.equals(C)) {
			System.out.println("TC is pass");
		}else System.out.println("TC is fail");
		
		driver.quit();
	}

}
