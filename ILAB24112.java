package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;



public class ILAB24112 {
	@Test

	public void AgilentILAB24112() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("coremember.piper.boyle@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Test1234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		driver.findElement(By.id("services_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='service_project_template_935']/td[2]/span/span[1]/span/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@class='add_event_to_service']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='s2id_autogen1']")).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='start datepart quick_event asset_only']")).click();
		driver.findElement(By.xpath("//a[@class='green_button book_all_equipments_link']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='mfp-close']")).click();
		
	}

}
