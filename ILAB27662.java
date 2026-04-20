package macron_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ILAB27662 {
	
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/sc/332/cell-imaging-center/?tab=requests";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
	
	public void billingFilter() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		driver.findElement(By.id("sc_billing_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='header_panel']/div/div[2]/a[2]")).click();
		driver.findElement(By.xpath("//a[@class='ui review_charges button right floated']")).click();
		Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id='included-charges']/div/div/input")).sendKeys("lola");
	    Thread.sleep(2000);
	    List<WebElement> head=  driver.findElements(By.xpath("//div[@id='included-charges']//table[@class='ui celled table']//th"));
	    System.out.println("the columns of the table " + head.size());
	    for(WebElement ele:head) 
	    {
	    	String A= ele.getText();
	    	System.out.println("the header of the tables are "+ A);
	    }
	    Thread.sleep(4000);
	   
	 List <WebElement> rows=   driver.findElements(By.xpath("//div[@id='included-charges']//table[@class='ui celled table']//tr"));
	 
	 for(WebElement ele:rows) 
	    {
	    	String B= ele.getText();
	    	System.out.println("the no. of rows in the tables are "+ B);
	    
				
		
	}
	 driver.quit();
	
	}
}
