package march_b_2026;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class FrontIssue {
	
	
	WebDriver driver;
	
	@Test 
	
	
	
	
	public void SecurityRegression() throws InterruptedException {
		 driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://rf2.ilabx.com/account/login");
	        
	        // Login to Application
	        
	        WebElement Username = driver.findElement(By.id("login"));
	        Username.sendKeys("admin@ilabx.com");
	        WebElement Password = driver.findElement(By.id("password_input"));
	        Password.sendKeys("Adm1n234!");
	        driver.findElement(By.id("login_btn")).click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Opening Survey module
	        
	        driver.get("https://rf2.ilabx.com/institutions/35/semantic/dashboard");
	        driver.findElement(By.xpath("//a[@class='item surveys_tab']")).click();
	        
	        Thread.sleep(5000);
	        
	        // Console Log
	        
	        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
	        for (org.openqa.selenium.logging.LogEntry entry : logs) {
	        	
	        	if (entry.getLevel().toString().equals("SEVERE")) {
	        		 System.out.println("ERROR: " + entry.getMessage());
	            }
	        	}
	        
	        // Navigating to the Interlock status page
	        
	        driver.findElement(By.id("user_dropdown")).click();
	        driver.findElement(By.xpath("//div[@class='menu transition visible']/a[2]")).click();
	        driver.findElement(By.xpath("//table[@class='ui table basic']/tbody/tr/td[6]/a[16]")).click();
	        Thread.sleep(5000);
	        
	        LogEntries logs_Interlock = driver.manage().logs().get(LogType.BROWSER);
	        for (org.openqa.selenium.logging.LogEntry entry : logs_Interlock) {
	        	
	        	if (entry.getLevel().toString().equals("SEVERE")) {
	        		 System.out.println("ERROR: " + entry.getMessage());
	            }
	        	}
	        driver.quit();

	        }
	        
		
	}
	
	


