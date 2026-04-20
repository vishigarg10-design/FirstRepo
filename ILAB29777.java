package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ILAB29777 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=services";
	static String url1= "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=admin";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	
	@Test 
	
	public void Hide() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
	   
	    if(driver.findElements(By.xpath("//a[@update='live_search_service_results_cat']")).size()!=0) {
	    	System.out.println("Sort manually button is displayed");
	    }
	    else {
	    	driver.get(url1);
	    	Thread.sleep(2000);
	    	driver.findElement(By.id("edit_other_settings_title_tag")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//input[@id='settings-searchbox']")).click();
	    	driver.findElement(By.xpath("//input[@id='settings-searchbox']")).sendKeys("Display services organized by category?");
	    	Actions act= new Actions(driver);
	    	act.sendKeys(Keys.DOWN).build().perform();
	    	act.sendKeys(Keys.ENTER).build().perform();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//label[@for='settings_show_category_on_list_view_yes']")).click();
	    	Thread.sleep(2000);
	    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-3']/div[2]/button[2]")).click();
			Thread.sleep(2000);
			driver.get(url);
			Thread.sleep(2000);
			WebElement A= driver.findElement(By.xpath("//a[@update='live_search_service_results_cat']"));
			
	    	if(A.isDisplayed()){
	    		System.out.println("sort manually button is displayed");
	    	}else
	    	{
	    		System.out.println("Test case is failed");
	    	}
	    	
	    	Thread.sleep(2000);
	    	driver.get(url1);
	    	Thread.sleep(2000);
	    	driver.findElement(By.id("edit_other_settings_title_tag")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//input[@id='settings-searchbox']")).click();
	    	driver.findElement(By.xpath("//input[@id='settings-searchbox']")).sendKeys("Display services organized by category?");
	    	Actions act1= new Actions(driver);
	    	act1.sendKeys(Keys.DOWN).build().perform();
	    	act1.sendKeys(Keys.ENTER).build().perform();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//label[@for='settings_show_category_on_list_view_no']")).click();
	    	Thread.sleep(2000);
	    	JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ui-jaccordion-1-panel-3']/div[2]/button[2]")).click();
			Thread.sleep(2000);
			driver.get(url);
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//a[@update='live_search_service_results_cat']")).size()!=0) {
		    	System.out.println("Sort manually button is not displayed. Hence TC is pass");
			}
		driver.quit();
	}
		
	}

}
