package march_b_2026;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DatePicker {
	 WebDriver driver;
	
@Test 
	 

	public void Date() throws InterruptedException {
		
		
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
		        
		        // Navigating to Calendar Page
		       
		        
		        driver.get("https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=equipment");
		        driver.findElement(By.id("schedule_button_90869")).click();
		        
		        // Code for opening a new tab
		        
		        String originalTab = driver.getWindowHandle();
		        for (String handle : driver.getWindowHandles()) {
		            if (!handle.equals(originalTab)) {
		                driver.switchTo().window(handle);
		                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			            
			            WebElement dateInput= driver.findElement(By.xpath("//div[@class='ui small icon button']"));
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			            dateInput.click();
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			            WebElement calendarPopup = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']")); 
			            Assert.assertTrue(calendarPopup.isDisplayed());
			            System.out.println("calendar date picker is displayed");
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			            
			            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			           WebElement Dateselect= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[1]"));
			           Dateselect.click();
			           
			           LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
				        for (org.openqa.selenium.logging.LogEntry entry : logs) {
				        	
				        	if (entry.getLevel().toString().equals("SEVERE")) {
				        		 System.out.println("ERROR: " + entry.getMessage());
				            }
				        	}
			           
			           driver.close();
			           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			           driver.switchTo().window(originalTab);
			           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			           
				        driver.quit();
			             
			        	   
			           }
			            
		            }
		            
		            
		   
		        
		        
		        
		        
		        
		 }
		 
}
	


