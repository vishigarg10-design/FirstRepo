package march_b_2026;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	
	WebDriver driver;
    WebDriverWait wait;

	@Test 
	
	public void Links() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://web-d.tst-34.aws.agilent.com/sc/2/flow-cytometry-facility/?tab=requests");
        WebElement Username = driver.findElement(By.id("login"));
        Username.sendKeys("admin@ilabx.com");
        WebElement Password = driver.findElement(By.id("password_input"));
        Password.sendKeys("Adm1n234!");
        driver.findElement(By.id("login_btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Getting all links with anchor tag
        
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links found: " + links.size());
        
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            // Skip null or empty links
            if (url == null || url.isEmpty()) {
                System.out.println("Empty or null href found.");
                continue;
            }

            // Skip JavaScript links
            if (url.startsWith("javascript")) {
                continue;
            }

            checkLink(url);
        }

		driver.quit();
		
		
	}
	
	public void checkLink(String linkUrl) {
		 try {
	            URL url = new URL(linkUrl);
	            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	            httpURLConnection.setConnectTimeout(5000);
	            httpURLConnection.connect();

	            int responseCode = httpURLConnection.getResponseCode();

	            if (responseCode >= 400) {
	                System.out.println(linkUrl + " --> Broken link (Response: " + responseCode + ")");
	            } else {
	                System.out.println(linkUrl + " --> Valid link (Response: " + responseCode + ")");
	            }

	        } catch (Exception e) {
	            System.out.println(linkUrl + " --> Exception occurred: " + e.getMessage());
	        }
	    }
	}


