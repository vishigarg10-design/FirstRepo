package macron_testng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ILAB29643 extends BaseClass {
	@Test 
	public void OutsideContact() throws IOException, InterruptedException {
		// Calling Set up Function from BaseClass
		
		setup();
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/332/electron-microscopy-facility/?tab=requests");
		
		// opening Study page.
		driver.findElement(By.id("studies_button")).click();
		driver.findElement(By.xpath("//span[@class='text']")).click();
		driver.findElement(By.xpath("//a[@class='ui item spinnable']")).click();
		
		//Creating a Study
		
		driver.findElement(By.id("study_name")).sendKeys("7th July");
		driver.findElement(By.id("study_brief_name")).sendKeys("7th July title");
		
		// Scrolling down the page to navigate to the Outside contact.
		
		Scroll();
				
		
		// Clicking on the Outside contact link
		
		driver.findElement(By.xpath("//a[@class='magnific_popup_link ui button blue tiny']")).click();
		
		// Filling New Contact form
		driver.findElement(By.id("contact_name")).sendKeys("Vishal Garg");
		driver.findElement(By.id("contact_role")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@class='ui button spinnable green']")).click();
		Thread.sleep(4000);
		Screenshot();
		Scroll();
		driver.findElement(By.xpath("//a[@class='ui button green tiny submit_study_btn']")).click();
		Thread.sleep(2000);
		teardown();
		
	}

}
