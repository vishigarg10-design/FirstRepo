package macron_testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class ILAB29068 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/institution/show/35/?tab=cores";
	static String url1= "https://rf2.ilabx.com/institutions/35/semantic/settings";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
	public void Center() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='wrapper_main']/div/table/tbody/tr/td[3]/a[6]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='select2-arrow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).sendKeys("flow");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		List<WebElement> suggestions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='select2-result-sub']")));
		boolean resultFound = false;
		for (WebElement suggestion : suggestions) {
            System.out.println("Dropdown Option: " + suggestion.getText()); // Debugging
            if (suggestion.getText().equalsIgnoreCase("flow")) { // Expected result
                resultFound = true;
                break;
            }
        }
		if (resultFound) {
            System.out.println("Test Passed: Expected result found in dropdown.");
        } else {
            System.out.println("Test Failed: Expected result not found in dropdown.");
        }
		
		
	driver.quit();
		
	}

}
