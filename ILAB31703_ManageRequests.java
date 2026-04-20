package april_b_2026;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ILAB31703_ManageRequests {
	
	WebDriver driver;
	WebDriverWait wait;
	String URL ="https://rf1.ilabx.com/account/login";
	String URL1 ="https://rf1.ilabx.com/requisition/manage_requested";
	

		
		@BeforeTest
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

		@Test
	    public void testManageRequestsSaveFlow() {

	        // Step 1: Login
	        driver.get(URL);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).sendKeys("admin@ilabx.com");
	        driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
	        driver.findElement(By.id("login_btn")).click();
	        
	        
	        driver.get(URL1);
	        String Actual = driver.getCurrentUrl();
	        String Expected = "https://rf1.ilabx.com/requisition/manage_requested";
	        Assert.assertEquals(Actual, Expected, "URL does not match! and TC is failed");
		
	}
	@AfterTest
	   public void teardown() {
	       if (driver != null) {
	      driver.quit();
	   }

}
}