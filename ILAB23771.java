package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.time.Duration;

public class ILAB23771 {
	@Test 

	public void AgilentILAB23771() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// Login to application 
		driver.get("https://rf2.ilabx.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rf2.ilabx.com/sc/344/electron-microscopy-facility/?tab=requests");
		// Navigating to Billing Pages now.
		
		driver.findElement(By.id("sc_billing_button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='header_panel']/div/div[1]/a[2]")).click();
		
		// Verify the UI of the Page now
		
		// Cancel button
		
		WebElement can = driver.findElement(By.xpath("//a[@class='ui cancel basic blue button right floated']"));
		String c = can.getText();
		System.out.println("the text of cancel button is= "  + c);
		
		// Review Charges button 
	
		WebElement dr = driver.findElement(By.xpath("//a[@class='ui review_charges button right floated']"));
		String s = dr.getText();
		System.out.println("the text of Review Charge button is " + s);
		
		// Label names
		
		
		WebElement date = driver.findElement(By.xpath("//*[@id='billing-event-parameters']/div[1]/label"));
		String D = date.getText();
		System.out.println("the label name is " + D);
		
		
		
		WebElement eventname = driver.findElement(By.xpath("//*[@id='billing-event-parameters']/div[2]/label"));
		String E = eventname.getText();
		System.out.println("the name of the core label is " + E);
		
		WebElement Charge= driver.findElement(By.xpath("//*[@id='billing-event-parameters']/div[3]/label"));
		String C = Charge.getText();
		System.out.println("the Charge selected label name is " + C);
		
		
		WebElement Group = driver.findElement(By.xpath("//*[@id='billing-event-parameters']/div[4]/label"));
		String G = Group.getText();
		System.out.println("the label text for Grouping invoice is " + G);
		
		//Tootltip text
		
		Actions act = new Actions(driver);
		WebElement I= driver.findElement(By.xpath("//*[@id='billing-event-parameters']/div[1]/i"));
		act.moveToElement(I).build().perform();
		Thread.sleep(2000);
		WebElement Tool = driver.findElement(By.xpath("//div[@class='ui popup inverted top center transition visible initialized']"));
		String T = Tool.getText();
		System.out.println("the text of the tooltip is " + T);
		
		
		WebElement Eventname = driver.findElement(By.xpath("//*[@id='billing-event-parameters']/div[2]/i"));
		act.moveToElement(Eventname).build().perform();
		WebElement tool2= driver.findElement(By.xpath("//div[@class='content']"));
		String Eve = tool2.getText();
		System.out.println("the tooltip text of event name is "+ Eve);
		Thread.sleep(2000);
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
		System.out.print("the log text is : : " + logs);
		Thread.sleep(2000);
		for (org.openqa.selenium.logging.LogEntry entry1 : logs) {
            System.out.println("[" + entry1.getLevel() + "] " + entry1.getMessage());
            Thread.sleep(2000);
driver.quit();
	}
}
}	
		
	


