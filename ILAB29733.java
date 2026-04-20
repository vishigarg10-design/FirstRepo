package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ILAB29733 {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/institution/show/35/?tab=cores";
	static String url1= "https://rf2.ilabx.com/institutions/35/semantic/settings";
	WebDriver driver;
	static String Uname = "admin@ilabx.com";
	static String Pword = "Adm1n234!";
	
	@Test 
public void Announcement() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(Login);	
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.get(url1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='annoucement_close'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='settings-input']")).sendKeys("announcement");
		Thread.sleep(2000);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		WebElement A= driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//input[@id='settings_show_institutionwide_announcement']"));
		if(A.isSelected())
		{
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id='settings_institutionwide_announcement_text_ifr']"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			WebElement body = driver.findElement(By.xpath("//body[@id='tinymce'][1]"));
			body.clear();
			body.sendKeys("this is working fine");
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			driver.findElement(By.id("settings-apply-action")).click();
		}else {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", A);
			Thread.sleep(3000);
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id='settings_institutionwide_announcement_text_ifr']"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			WebElement body = driver.findElement(By.xpath("//body[@id='tinymce'][1]"));
			body.clear();
			body.sendKeys("this is working fine");
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			driver.findElement(By.id("settings-apply-action")).click();
		}
		
		driver.findElement(By.id("sign_out_btn")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/a")).click();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		WebElement textElement = driver.findElement(By.xpath("//*[@id='top_nav']/div[3]"));

        // Get the text from the element
        String actualText = textElement.getText();
        System.out.println("the actual text is: " +actualText);
        String expectedText = "Alert!\r\n"
        		+ "this is working fine";
        if (actualText.equals(expectedText)) {
            System.out.println("Text is displayed correctly: " + actualText);
        } else {
            System.out.println("Text mismatch! Expected: " + expectedText + ", but got: " + actualText);
        }
        driver.get(url1);
		driver.findElement(By.xpath("//span[@class='annoucement_close'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='settings-input']")).sendKeys("announcement");
		Thread.sleep(2000);
		Actions act1= new Actions(driver);
		act1.sendKeys(Keys.DOWN).build().perform();
		act1.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		WebElement B= driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//input[@id='settings_show_institutionwide_announcement']"));
        Thread.sleep(2000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Perform the JavaScript click
        jsExecutor.executeScript("arguments[0].click();", B);
        Thread.sleep(3000);
        driver.findElement(By.id("settings-apply-action")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("sign_out_btn")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/a")).click();
		driver.findElement(By.id("login")).sendKeys(Uname);
		driver.findElement(By.id("password_input")).sendKeys(Pword);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(2000);
		WebElement R= driver.findElement(By.xpath("//*[@id='top_nav']/div[3]/span[2]"));
		if(R.isDisplayed()) {
			System.out.println("test case is passed");
			
		}else {
			System.out.println("test cases is failed");
		}
        
		
}
}
