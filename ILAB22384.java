package macron_testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ILAB22384 {
	@Test 

	public void AgilentILAB22384() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rf2.ilabx.com/centers/7/edit/#subsidies");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-target_id='add_subsidy_form']")).sendKeys("12");
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ARROW_DOWN).build().perform();
        act.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.id("subsidy_name")).sendKeys("Automation Subsidy");
        driver.findElement(By.id("subsidy_percent")).sendKeys("10");
        driver.findElement(By.xpath("//a[@class='add_subsidy']")).click();
         Thread.sleep(3000);
         TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB22383.png");
			 FileUtils.copyFile(SrcFile, DestFile);
        		
        driver.findElement(By.xpath("//table[@id='subsidies_table']/tbody/tr[1]/td[13]/a[3]")).click();
        Thread.sleep(2000);
        TakesScreenshot scrShot1 =((TakesScreenshot)driver);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB22383-2.png");
		 FileUtils.copyFile(SrcFile1, DestFile1);
		 String A=  driver.findElement(By.xpath("//div[@class='ui large modal transition visible active']")).getText();
	       System.out.println("the pop-up for the model is" +A);
	       act.sendKeys(Keys.ESCAPE).build().perform();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//table[@id='subsidies_table']/tbody/tr[1]/td[13]/a[1]")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.id("subsidy_name")).clear();
	       driver.findElement(By.id("subsidy_name")).sendKeys("Automation Subsidy1");
	       driver.findElement(By.id("subsidy_percent")).clear();
	       Thread.sleep(2000);
	        driver.findElement(By.id("subsidy_percent")).sendKeys("12");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[@class='update_subsidy']")).click();
	        Thread.sleep(2000);
	        driver.switchTo().alert().accept();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//table[@id='subsidies_table']/tbody/tr[1]/td[13]/a[3]")).click();
	        Thread.sleep(2000);
	        String B=driver.findElement(By.xpath("//div[@class='ui large modal transition visible active']")).getText();
	        Thread.sleep(2000);
	        System.out.println("the pop-up for the model is" +B);
	        TakesScreenshot scrShot2 =((TakesScreenshot)driver);
			File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
			File DestFile2=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium\\ILAB22383-2.png");
			 FileUtils.copyFile(SrcFile2, DestFile2);
			 Thread.sleep(2000);
	          act.sendKeys(Keys.ESCAPE).build().perform();
		       Thread.sleep(4000);
		        Thread.sleep(2000);
		        act.sendKeys(Keys.ESCAPE).build().perform();
		        driver.findElement(By.xpath("//table[@id='subsidies_table']/tbody/tr[1]/td[13]/a[2]")).click();
		        Thread.sleep(2000);
		         driver.switchTo().alert().accept();
		        Thread.sleep(2000);
		       driver.navigate().refresh();
		       Thread.sleep(2000);
		       driver.quit();
	        
	        
	       

	}

}
