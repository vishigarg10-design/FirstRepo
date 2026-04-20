package april_a_2026;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ILAB_31585_POinactive {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Test 
	
	 
		
		public void InactivePOS() throws InterruptedException {
		 	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        driver.get("https://rf2.ilabx.com/sc/330/flow-cytometry-facility?tab=services");
	        WebElement Username = driver.findElement(By.id("login"));
	        Username.sendKeys("admin@ilabx.com");
	        WebElement Password = driver.findElement(By.id("password_input"));
	        Password.sendKeys("Adm1n234!");
	        driver.findElement(By.id("login_btn")).click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        
	        // Creating the Request for Lola Paucek
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='service_project_template_907']/td[2]/span/span[1]/span/a"))).click();
	        
	        driver.findElement(By.id("scope_all")).click();
	        driver.findElement(By.id("select2-chosen-1")).click();
	        driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Lola Paucek");
	        
	        Thread.sleep(2000);
	        Actions act = new Actions(driver);
	        act.sendKeys(Keys.ENTER).build().perform();
	        driver.findElement(By.id("select2-chosen-3")).click();
	        Thread.sleep(2000);
	        Actions act1 = new Actions(driver);
	        act1.sendKeys(Keys.ENTER).build().perform();
	        driver.findElement(By.xpath("//a[@class='spinnable button']")).click();
	        Thread.sleep(5000);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1000);");
	        
	        driver.findElement(By.id("external_po_select")).click();
	        
	        Actions act3 = new Actions(driver);
	        act3.sendKeys(Keys.DOWN).build().perform();
	        act3.sendKeys(Keys.ENTER).build().perform();
	        
	        
	        driver.findElement(By.id("skip_approval")).click();
	        driver.findElement(By.id("begin_work_check_box")).click();
	        
	        
	        driver.findElement(By.id("create_service_item_save")).click();
	        
	        
	        // Navigating to VAR page and complete the requests
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=' positive tipsy_tip spinnable submit_service_item_save'][1]"))).click();
	        
	        // navigating to Billing page
	        
	        driver.findElement(By.id("sc_billing_button")).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header_panel']//a[2]"))).click();
	        
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui review_charges button right floated']"))).click();
	        
	        Thread.sleep(5000);
	        
	        
	        // Navigating to PO tab to make PO Invalid
	        
	        driver.get("https://rf2.ilabx.com/external_generic_funds?core_id=330&tab=sc_po");
	        
	        driver.findElement(By.xpath("//i[@class='icon exchange grey tipsy_tip']")).click();
	        
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-action='revert_to_pending']"))).click();
	        Thread.sleep(2000);
	        
	        driver.switchTo().alert().accept();
	        
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//i[@class='icon remove grey tipsy_tip']")).click();
	        
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-action='reject']"))).click();
	        driver.navigate().refresh();
	        
	        
	        
	        // Verify the red flag for PO when inactive
	        driver.findElement(By.id("sc_billing_button")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header_panel']//a[2]"))).click();
	      
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui review_charges button right floated']"))).click();
	        
	        Thread.sleep(5000);
	        
	       String A =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='included-charges']//table[@class='ui celled table']//tr[2]//td[7]//span[@class='tipsy_tip billing_status']"))).getText();        
	        
	        System.out.println(A);
	        
	        String Expected ="Ready To Bill";
	        
	        assertEquals(A, Expected);
	        
	       Thread.sleep(3000);
	       // Verify the Red Flag is displayed 
	        WebElement flagElement = driver.findElement(By.xpath("//div[@id='included-charges']//table[@class='ui celled table']//tr[2]//td[7]//img[@class='tipsy_tip invalid']"));

	        // 1. Check if element is displayed
	        if (flagElement.isDisplayed()) {
	            System.out.println("Flag is displayed");

	            // 2. Get color (CSS property)
	            String color = flagElement.getCssValue("color");
	            System.out.println("Color: " + color);
	            
	            if (color.equals("rgba(0, 0, 0, 0.87)")) {
	                System.out.println("Flag is RED");
	            } else {
	                System.out.println("Flag is NOT red");
	            }

	        } else {
	            System.out.println("Flag is NOT displayed");
	        }
	        
	        
	        driver.findElement(By.id("billing_event_save")).click();
	        Thread.sleep(20000);
	        driver.findElement(By.xpath("//div[@class='search_result_entry core_entry']//div[@class='cell actions']//a[3]")).click();
	        driver.switchTo().alert().accept();
	        
	        
	        // Deactivating the PO
	        
	        driver.findElement(By.id("sc_po_button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id='external_generic_fund_tabs']/div[1]/a[2]")).click();
	        
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon exchange grey tipsy_tip']"))).click();
	        driver.findElement(By.xpath("//a[@data-action='revert_to_pending']")).click();
	        
	        driver.switchTo().alert().accept();
	        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//i[@class='icon checkmark green tipsy_tip']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//a[@data-action='approve']")).click();
	        Thread.sleep(2000);
	        driver.navigate().refresh();
	        
	        driver.quit();
	        
	        
	        
	        

	}
}
	        	
	        
	        
	        
	       
	        
	        
	        
	        
	        
		
		

	

