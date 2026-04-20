package april_a_2026;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelpLink_VAR_31582 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	String URL = "https://web-m.tst-34.aws.agilent.com/sc/332/cell-imaging-center/?tab=requests";
	String URL1= "https://web-m.tst-34.aws.agilent.com/sc/332/cell-imaging-center?tab=animal_requests";
	String URL2 ="https://rf2.ilabx.com/sc/22/animal-modeling-and-therapeutics-core-animal/?tab=animal_requests";
	String URL3 ="https://rf2.ilabx.com/sc/22/animal-modeling-and-therapeutics-core-animal/?tab=requests";
	
	
	@Test
	
	public void VAAR() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(URL3);
        WebElement Username = driver.findElement(By.id("login"));
        Username.sendKeys("admin@ilabx.com");
        WebElement Password = driver.findElement(By.id("password_input"));
        Password.sendKeys("Adm1n234!");
        driver.findElement(By.id("login_btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Clicking on the More Link
        
        driver.findElement(By.xpath("//div[@id='view_requests_tab_definition']//a[2]")).click();
        Thread.sleep(2000);
        
        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
              String B=driver.getCurrentUrl();
              System.out.println(B);
              Thread.sleep(3000);
              String C = driver.getTitle();
              Thread.sleep(3000);
              System.out.println(C);
              Thread.sleep(3000);
              driver.close();
             driver.switchTo().window(originalTab);
             Thread.sleep(2000);
             driver.get(URL2);
             driver.findElement(By.xpath("//div[@id='view_requests_tab_definition']//a[2]")).click();
             Thread.sleep(2000);
             
             String originalTab1 = driver.getWindowHandle();
             for (String handle1 : driver.getWindowHandles()) {
                 if (!handle1.equals(originalTab1)) {
                     driver.switchTo().window(handle1);
                   String D=driver.getCurrentUrl();
                   System.out.println(D);
                   Thread.sleep(3000);
                   String E = driver.getTitle();
                   Thread.sleep(3000);
                   System.out.println(E);
                   Thread.sleep(3000);
                   driver.close();
                  driver.switchTo().window(originalTab1);
             
             driver.quit();
             
                
        }
            
           
            
             }
            }
}
}
}