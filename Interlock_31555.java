package april_a_2026;

import static org.testng.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interlock_31555 {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Test 
    
    public void WebBySwitch() throws InterruptedException {
    	
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=equipment");
        WebElement Username = driver.findElement(By.id("login"));
        Username.sendKeys("admin@ilabx.com");
        WebElement Password = driver.findElement(By.id("password_input"));
        Password.sendKeys("Adm1n234!");
        driver.findElement(By.id("login_btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("equipment-more-actions"))).click();
        driver.findElement(By.xpath("//div[@id='equipment-actions-menu']//a[3]")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui compact blue new_interlock button']"))).click();
        
        driver.findElement(By.xpath("//*[@id='new_interlock_settings']/div[1]/div/div[2]/div[3]")).click();
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui fluid selection dropdown interlock_bridge']"))).click();
        
        Thread.sleep(2000);
        
        Actions act = new Actions(driver);
        act.sendKeys(Keys.DOWN).build().perform();
        act.sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.id("ip_address")).sendKeys("111.23.25.36");
        driver.findElement(By.id("settings_password")).sendKeys("Test1234");
        driver.findElement(By.id("create_interlock")).click();
        
        String  B = driver.findElement(By.xpath("//table[@class='ui basic table']/tbody/tr[4]/th")).getText();
        System.out.println(B);
        Thread.sleep(2000);
        String  C = driver.findElement(By.xpath("//table[@class='ui basic table']/tbody/tr[4]/td")).getText();
        System.out.println(C);
        String expectedText = "true";
        assertEquals(C,expectedText);
        
        WebElement M = driver.findElement(By.xpath("//div[@class='ui segment interlock']//div[@class='ui top left attached label']"));
        System.out.println(M);
        
 
       driver.findElement(By.xpath("//div[@class='ui small negative delete_interlock button']")).click();
        
        driver.findElement(By.xpath("//div[@class='ui positive right labeled button icon delete_confirm']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        
        driver.quit();
        
        
        
        
        
        
        
        
    }
    
    

}
