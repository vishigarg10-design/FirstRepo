package macron_testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ILAB22327 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	
	@Test 
	
	public void Groupid() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get("https://rf2.ilabx.com/service_centers/299/equipment_settings/89579/edit");
		Thread.sleep(2000);
		
			
		}	
	}


