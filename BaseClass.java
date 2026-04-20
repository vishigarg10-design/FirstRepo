package macron_testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import groovyjarjarasm.asm.commons.Method;

public class BaseClass {
	private static final String ExtentReports = null;
	protected WebDriver driver;
	
	public void setup() {
		 driver = new ChromeDriver();
	}
	
public void teardown() {
	if (driver != null) {
        driver.quit();
}
		
}
public void Scroll() {
	JavascriptExecutor js4 = (JavascriptExecutor) driver;
	js4.executeScript("window.scrollBy(0,500)", "");
}
public void Screenshot() throws IOException {
	
	TakesScreenshot scrShot1 =((TakesScreenshot)driver);
	File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
	File DestFile1=new File("C:\\Users\\vishgarg\\OneDrive - Agilent Technologies\\Desktop\\Selenium//1.png");
	 FileUtils.copyFile(SrcFile1, DestFile1);
}
public void down() {
	Actions act = new Actions(driver);
	act.sendKeys(Keys.DOWN).build().perform();	
}
public void Enter() {
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER).build().perform();
	
}
public void Tab() {
	Actions act = new Actions(driver);
	act.sendKeys(Keys.TAB).build().perform();
	
}
public void Up() {
	Actions act = new Actions(driver);
	act.sendKeys(Keys.UP).build().perform();
	
}

    
public void login() {
	
	driver.get("https://rf2.ilabx.com");
	driver.manage().window().maximize();
	driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
	driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
	driver.findElement(By.id("login_btn")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rf2.ilabx.com/sc/332/electron-microscopy-facility/?tab=requests");
}
}