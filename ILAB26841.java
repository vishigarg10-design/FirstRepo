package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ILAB26841 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/332/?tab=equipment";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	@Test  
	
	public void Offline() throws InterruptedException {
		    WebDriver driver = new ChromeDriver();
			driver.get(Login);	
			driver.manage().window().maximize();
			driver.findElement(By.id("login")).sendKeys(Uname);
			driver.findElement(By.id("password_input")).sendKeys(Pword);
			driver.findElement(By.id("login_btn")).click();
			Thread.sleep(2000);
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='offline_online_button_90869']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='offline_time_interface_90869']/table/tbody/tr[3]/td/span/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table[@class='section_header_light_blue']/tbody/tr/td[2]/span/a[1]")).click();
			Thread.sleep(5000);
			List <WebElement> Links = driver.findElements(By.tagName("a"));
			for(WebElement blinks : Links) {
				if(blinks.getText().equals("Aria2_Sample - Trained and Untrained")) {
					System.out.println("Test case is failed");
				}
				else {
					System.out.println("TC is passed");
				}
			}
			driver.findElement(By.xpath("//*[@id='main_page_content']/div/div/div[2]/div[1]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='offline_online_button_90869']/a")).click();
			driver.close();
			
			
			
					
			
	}

}
