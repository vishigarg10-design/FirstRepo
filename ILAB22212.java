package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



import java.time.Duration;

public class ILAB22212 {
	@Test 

	public void AgilentILAB22212() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		// Login to application 
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		driver.findElement(By.id("equipment_button")).click();
		driver.findElement(By.xpath("//*[@id='service_project_template_91324']/td[3]/a[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='search-settings']/div[1]/input")).sendKeys("buffer");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='result'][1]")).click();
		Thread.sleep(2000);
		WebElement a = driver.findElement(By.xpath("//*[@id='buffer-times']/div[1]/div/div/div/label/i"));
		Thread.sleep(2000);
		Actions act= new Actions(driver);
		act.moveToElement(a).perform();
		Thread.sleep(5000);
	   String A =  driver.findElement(By.xpath(("//div[@class='ui popup wide top left transition visible initialized']"))).getText();
	   System.out.println("the text of tooltip is " + A);
	   Thread.sleep(2000);
	   
	   String B = "Buffer times are not billable times. They are intended to block adjacent time before or after a reservation for preparation of instrument, cleaning procedure and other procedures, etc.";
	   if ( A==B ) {
		   System.out.println("Test case is pass");
	   }else
	   System.out.println("The test case is fail");
		Thread.sleep(2000);
		driver.quit();
	}

}
