package march_b_2026;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DivLinkChecker {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Test 
	public void DivWorking() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://web-d.tst-34.aws.agilent.com/sc/2/flow-cytometry-facility/?tab=equipment");
        WebElement Username = driver.findElement(By.id("login"));
        Username.sendKeys("admin@ilabx.com");
        WebElement Password = driver.findElement(By.id("password_input"));
        Password.sendKeys("Adm1n234!");
        driver.findElement(By.id("login_btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        

        // Find all divs
        
        List<WebElement> divs = driver.findElements(By.tagName("div"));

        for (int i = 0; i < divs.size(); i++) {

            // Re-fetch elements to avoid stale element exception
            divs = driver.findElements(By.tagName("div"));
            WebElement div = divs.get(i);

            try {
                String beforeUrl = driver.getCurrentUrl();

                // Scroll into view (important)
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView(true);", div);

                div.click();
                Thread.sleep(2000); // wait for navigation

                String afterUrl = driver.getCurrentUrl();

                if (beforeUrl.equals(afterUrl)) {
                    System.out.println("Div index " + i + " --> No navigation / possibly broken");
                } else {
                    System.out.println("Div index " + i + " --> Navigated to: " + afterUrl);

                    // Optional: check page load success
                    if (driver.getTitle().isEmpty()) {
                        System.out.println("   --> Page might be broken (empty title)");
                    }

                    driver.navigate().back();
                    Thread.sleep(2000);
                }

            } catch (Exception e) {
                System.out.println("Div index " + i + " --> Error: " + e.getMessage());
            }
        }

        driver.quit();
    }
}
