package april_a_2026;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Forbidden_31586 {
	
	WebDriver driver;
	WebDriverWait wait;
	int i =0;
	@Test 
	
	public void Refresh() {
		
		 driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        driver.get("https://rf2.ilabx.com");
	        
	        driver.get("https://rf2.ilabx.com//service_center/show_external/2%20WHERE%207008=7008AND%2F%2A%2A%2F6005=%28SELECT%2F%2A%2A%2FUPPER%28CHR%28126%29%7C%7C%27~%27%7C%7C%28SELECT%2F%2A%2A%2F%28CASE%2F%2A%2A%2FWHEN%2F%2A%2A%2F%286005=6005%29%2F%2A%2A%2FTHEN%2F%2A%2A%2F1%2F%2A%2A%2FELSE%2F%2A%2A%2F0%2F%2A%2A%2FEND%29%2F%2A%2A%2FFROM%2F%2A%2A%2FDUAL%29%7C%7C%27~%27%7C%7CCHR%28126%29%29%2F%2A%2A%2FFROM%2F%2A%2A%2FDUAL%2F%2A%2A%2FWHERE%2F%2A%2A%2FDBMS_RANDOM.VALUE%283439%2C3733%29=1356%29--%20-?name=quality-assurance-core");
		
	        for(i =1; i<=20; i++) {
	        	System.out.println("Refreshing page. Count: " + i);
	        	driver.navigate().refresh();
	        	
	        	
	        }
	        
		
	}

}
