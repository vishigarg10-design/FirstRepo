package macron_testng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ILAB29916 extends BaseClass{
	
	@Test 
	
	
	public void ExternalCalendar() throws InterruptedException, IOException {
		setup();
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/332/electron-microscopy-facility/?tab=equipment");
		
		// Navigating to Equipment settings
		
		driver.get("https://rf2.ilabx.com/service_centers/332/equipment_settings/90869/edit");
		driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("public");
		Thread.sleep(2000);
		down();
		Enter();
		Tab();
		Tab();
		Tab();
		Enter();
		
		Thread.sleep(2000);
		driver.findElement(By.id("sign_out_btn")).click();
		Thread.sleep(2000);
		// Navigating to External URL of the Service center
		driver.get("https://rf2.ilabx.com/service_center/show_external/332");
		Scroll();
		Screenshot();
		String A = driver.findElement(By.xpath("//table[@id='equipment_list']/tbody/tr[2]/td[1]")).getText();
		System.out.println(A);
		
		
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/332/electron-microscopy-facility/?tab=equipment");
		
		// Navigating to Equipment settings
		
		driver.get("https://rf2.ilabx.com/service_centers/332/equipment_settings/90869/edit");
		driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("public");
		Thread.sleep(2000);
		down();
		Enter();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='public_visibility']//div[@class='ui search dropdown selection initialized']")).click();
		Thread.sleep(2000);
		down();
		Thread.sleep(2000);
		down();
		Thread.sleep(2000);
		Enter();
		Thread.sleep(2000);
		Tab();
		Thread.sleep(2000);
		Tab();
		Thread.sleep(2000);
		Enter();
		driver.findElement(By.id("sign_out_btn")).click();
		Thread.sleep(2000);
		// Navigating to External URL of the Service center
		driver.get("https://rf2.ilabx.com/service_center/show_external/332");
		Scroll();
		Screenshot();
		
		// Returning to default settings
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/332/electron-microscopy-facility/?tab=equipment");
		
		// Navigating to Equipment settings
		
		driver.get("https://rf2.ilabx.com/service_centers/332/equipment_settings/90869/edit");
		driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("public");
		Thread.sleep(2000);
		down();
		Enter();
		driver.findElement(By.xpath("//div[@id='public_visibility']//div[@class='ui search dropdown selection initialized']")).click();
		Thread.sleep(2000);
		Up();
		Up();
		Enter();
		
		Tab();
		Thread.sleep(2000);
		Tab();
		Thread.sleep(2000);
		Enter();
		driver.findElement(By.id("sign_out_btn")).click();
		Thread.sleep(2000);
		teardown();
		
		
	}

	
	
		
		
	}

