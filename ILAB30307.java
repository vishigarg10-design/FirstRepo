package macron_testng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ILAB30307 extends BaseClass {
	
	@Test 
	
	public void Members() throws InterruptedException, IOException {
		setup();
		login();
		driver.get("https://rf2.ilabx.com/administration/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"wrapper_main\"]/div/table/tbody/tr/td[3]/a[3]")).click();
		driver.findElement(By.id("select2-chosen-1")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Peter");
		Thread.sleep(2000);
		Enter();
		driver.findElement(By.xpath("//a[@class='edit_institution'][1]")).click();
		Thread.sleep(4000);
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,5000)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='azlist_table']/tbody/tr[1]/td[5]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("association_order_flag")).click();
		Thread.sleep(2000);
		
		
		try {
			driver.findElement(By.xpath("//table[@class='azlist_table']/tbody/tr[1]/td[@class='buttons']/a[1]")).click();
		} catch (Exception e) {
		    Assert.fail("Button click threw an exception: " + e.getMessage());
		}
		Screenshot();
		Thread.sleep(2000);
		teardown();
	}

}
