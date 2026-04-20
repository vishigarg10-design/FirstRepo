package macron_testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;



public class ILAB16361 {
	@Test 

	public void AgilentILAB16361()throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='equipment_button']")).click();
		driver.findElement(By.xpath("//*[@id='service_project_template_91324']/td[3]/a[1]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(8000);
		WebElement innerFrame = driver.findElement(By.id("schedule_description_equipment_settings_91324_ifr"));
        driver.switchTo().frame(innerFrame);
		
		WebElement body = driver.findElement(By.id("tinymce"));
		
		body.sendKeys("Calendar Notes are showing on the settings");
		Actions act = new Actions( driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();

		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='equipment_button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='schedule_button_91324']")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
        String originalTab = driver.getWindowHandle();
        
        System.out.println("originalTab");
        
        for (String handle : windowHandles) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                
                System.out.println("Current page title: " + driver.getTitle());
                Thread.sleep(2000);
                TakesScreenshot scrShot =((TakesScreenshot)driver);
        		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        		
        		File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\Calendar notes.png");
        		 FileUtils.copyFile(SrcFile, DestFile);
        		 
        		 
        		 Thread.sleep(2000);
        		 
        		 driver.switchTo().window(originalTab);
        		 driver.findElement(By.xpath("//*[@id='service_project_template_91324']/td[3]/a[1]")).click();
        			Thread.sleep(2000);
        			JavascriptExecutor js2 = (JavascriptExecutor) driver;
        			js2.executeScript("window.scrollBy(0,250)", "");
        			Thread.sleep(8000);
        			WebElement innerFrame1 = driver.findElement(By.id("schedule_description_equipment_settings_91324_ifr"));
        	        driver.switchTo().frame(innerFrame1);
        			
        			WebElement body1 = driver.findElement(By.id("tinymce"));
        			
        			body1.clear();
        			Actions act1 = new Actions( driver);
        			act1.sendKeys(Keys.TAB).build().perform();
        			act1.sendKeys(Keys.TAB).build().perform();

        			act1.sendKeys(Keys.ENTER).build().perform();
        		 

driver.quit();		
	}

}
	}
}

