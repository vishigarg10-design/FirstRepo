package april_a_2026;

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

public class InactivePO_31585 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Test 
	
	    public void BillingPO() throws InterruptedException {
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
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sc_po_button"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui blue top right pointing floating dropdown icon button add_new_external_purchase_order initialized']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("term"))).sendKeys("Shweta test");
		
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.id("proceed_button")).click();
		
		
		driver.findElement(By.id("external_generic_fund_n1")).sendKeys("10003456");
		driver.findElement(By.id("description_text_area")).sendKeys("Automation PO");
		driver.findElement(By.id("external_generic_fund_available_funds")).sendKeys("1000000");
		driver.findElement(By.id("jqueryui_datepicker")).click();
		
		WebElement C = driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']//a[2]"));
		C.click();
		WebElement D = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[1]"));
		D.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui button gray hide_if_no_group_selected new_po_submit']")).click();
		Thread.sleep(3000);
		
		String M = driver.switchTo().alert().getText();
		System.out.println(M);
		
		driver.switchTo().alert().accept();
		
		
		
		
		
		
		
		
	}

}
