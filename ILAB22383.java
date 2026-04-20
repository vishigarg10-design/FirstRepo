package macron_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ILAB22383 {
	@Test 

	public void AgilentILAB22383() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// Login to application 
		driver.get("https://rf2.ilabx.com/account/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("admin@ilabx.com");
		driver.findElement(By.id("password_input")).sendKeys("Adm1n234!");
		driver.findElement(By.id("login_btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		driver.get("https://rf2.ilabx.com/centers/1/edit");
		driver.findElement(By.id("ui-id-7")).click();
		
		driver.findElement(By.xpath("//table[@id='subsidies_table']/tbody/tr[1]/td[13]/a[2]")).click();
		Thread.sleep(3000);
		int row = driver.findElements(By.xpath("//*[@id='subsidy_log_157']/div[2]/table//tr")).size();
		int col = driver.findElements(By.xpath("//*[@id='subsidy_log_157']/div[2]/table//th")).size();
		System.out.println(row);
		System.out.println(col);
		
		
		for(int i=1; i<row; i++) {
			for( int j=1 ; j<col; j++) {
				WebElement table = driver.findElement(By.xpath("//*[@id='subsidy_log_157']/div[2]/table"));
				List <WebElement>header= table.findElements(By.xpath("//th"));
				for(WebElement heading:header) {
				String a = heading.getText();
					System.out.println(a);
				String val = driver.findElement(By.xpath("//*[@id='subsidy_log_157']/div[2]/table//tr["+i+1+"]//td["+j+"]")).getText();
				System.out.println("the value of text of table is " +val);
				
			}
			
		}
		
			
		}	
		
	}

	}


