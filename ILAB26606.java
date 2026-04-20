package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ILAB26606 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/332/?tab=equipment";
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	WebDriver driver;
	
	@Test 
	
	
	public void Customfield() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		driver.findElement(By.id("admin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("edit_custom_forms_title_tag")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='edit_custom_forms']/div/span/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("custom_form_name")).clear();
		driver.findElement(By.id("custom_form_name")).sendKeys("FLAN");
		Select s1 = new Select(driver.findElement(By.xpath("//select[@class='template_fields_new_field_type']")));
		s1.selectByIndex(14);
		driver.findElement(By.id("new_custom_form_link")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='template_fields[1][required]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='custom_form_form']/div[3]/span/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("services_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='service_project_template_911']/td[2]/span/span[1]/a[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='add-form-911']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='add_custom_form_36122_to_spt_911']/td[3]/a")).click();
		Thread.sleep(2000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		driver.findElement(By.id("create_service_project_template_save")).click();
		
		
		
		
		
		
		
	}

}
