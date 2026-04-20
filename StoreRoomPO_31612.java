package april_b_2026;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StoreRoomPO_31612 {
	WebDriver driver;
	WebDriverWait wait;
	String URL ="https://web-m.tst-34.aws.agilent.com/sc/65/campus-scientific-store-product-cores/?tab=requests";
	
	
	
	@BeforeTest 
	public void setup() {
		
		
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
		// Step 1: Launch URL
	
	@Test()
		
		public void POLINK() throws InterruptedException {
        driver.get(URL);

        // Step 2: Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).sendKeys("admin@ilabx.com");
        driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();

        // Step 3: Click Manage Catalog
        WebElement manageCatalog = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("core_products_button")
        ));
        manageCatalog.click();
        

        // Step 4: Click Self Service Kiosk
        
        WebElement kioskBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='view_requests_top_buttons']//a[4]")
        ));
        kioskBtn.click();
        
        Thread.sleep(2000);

        // Step 5: Search user "ilab admin"
        
       driver.findElement(By.id("scope_all")).click();
       
       WebElement FindingUser = 
    		   wait.until(ExpectedConditions.elementToBeClickable(
    	                By.id("select2-chosen-1")));
       FindingUser.click();
       
        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("ilab admin");
        
        Thread.sleep(2000);
        
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).build().perform();
        
        WebElement green = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table[@class='ui very basic table kiosk-requests-table']/tbody/tr[1]/td[8]")
        ));
        green.click();
        
       
        
     // Step 6: Click Next
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ui float_right huge buttons']")
        ));
        next.click();

       

        // Step 7: Click Add New PO
        WebElement addNewPO = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add_standing_po")
        ));
        addNewPO.click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='close_po_modal custom-po-modal-cancel']")).click();

        
        // Step 8 : selecting a PO
        driver.findElement(By.id("external_po_select")).click();
        
        Actions act1 = new Actions(driver);
        act1.sendKeys(Keys.DOWN).build().perform();
        act1.sendKeys(Keys.ENTER).build().perform();
       
		
	}
	
	
	@AfterTest
	
	public void teardown() {
	       if (driver != null) {
	      driver.quit();
	   }

}
}