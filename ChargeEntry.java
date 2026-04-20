package march_b_2026;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ChargeEntry {
	

	WebDriver driver;
    WebDriverWait wait;
    int i =0;
    @Test 
	    public void setUp() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        driver.get("https://rf1.ilabx.com/service_centers/332/charge_entry");
	        WebElement Username = driver.findElement(By.id("login"));
	        Username.sendKeys("admin@ilabx.com");
	        WebElement Password = driver.findElement(By.id("password_input"));
	        Password.sendKeys("Adm1n234!");
	        driver.findElement(By.id("login_btn")).click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        // Adding the charges in the Charge Entry
	        
	        driver.findElement(By.xpath("//div[@id='s2id_select_service_item']")).click();
	        Actions act = new Actions(driver);
	        act.sendKeys(Keys.ENTER).build().perform();
	        driver.findElement(By.id("select2-chosen-3")).click();
	        Actions act1 = new Actions(driver);
	        act1.sendKeys(Keys.ENTER).build().perform();
	        
	        Thread.sleep(3000);
	        
	        
	        
	       
	        	driver.findElement(By.id("add_to_list_button")).click();
	        	
	        
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,500);");
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm_charges_button"))).click();
	        
	        
	        JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("window.scrollBy(0,1000);");
	        
	        
	        WebElement table = driver.findElement(By.xpath("//table[@id='confirmed_charges_list']"));

	        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
	        System.out.println(rows.size());
	        

	            
	        	
	            WebElement dropdown = driver.findElement(By.xpath("//select[@class='line_item_billing_status tipsy_tip']"));

	            // Use Select class
	            Select select = new Select(dropdown);
	            String selectedValue = select.getFirstSelectedOption().getText();

	          System.out.println("Row " + i + " Selected Value: " + selectedValue);
	          
	          
	        }
	      
	        
	        }

	        
	        
	        
	
	    
	    
	    	
	    	 
	    	 
	    	
	    	


	    
	    
