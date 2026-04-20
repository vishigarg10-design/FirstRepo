package macron_testng;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class ILAB16354 {
	@Test 
	public void AgilentILAB16354() throws InterruptedException, IOException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		driver.findElement(By.xpath("//div[@id='equipment_button']")).click();
		driver.findElement(By.id("schedule_button_91324")).click();
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
        String originalTab = driver.getWindowHandle();
        
        System.out.println("originalTab");
        
        for (String handle : windowHandles) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                
                System.out.println("Current page title: " + driver.getTitle());
                Thread.sleep(2000);
		Actions act= new Actions(driver);
		WebElement ele= driver.findElement(By.id("schedule-favorite-btn"));
		Thread.sleep(2000);
		act.moveToElement(ele).perform();
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\heart.png");
		FileUtils.copyFile(SrcFile, DestFile);
		Thread.sleep(2000);
		WebElement ele1= driver.findElement(By.id("schedule-asset-settings-btn"));
		act.moveToElement(ele1).perform();
		File SrcFile1=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\gear.png");
		FileUtils.copyFile(SrcFile1, DestFile1);
		Thread.sleep(5000);
		WebElement ele2= driver.findElement(By.id("schedule-description-modal"));
		act.moveToElement(ele2).perform();
		File SrcFile2=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\info.png");
		FileUtils.copyFile(SrcFile2, DestFile2);
		Thread.sleep(2000);
		driver.quit();
	}

	}

	}
}
