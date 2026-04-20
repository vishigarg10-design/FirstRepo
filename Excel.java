package macron_testng;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Excel {
	static String Login = "https://rf2.ilabx.com/account/login";
	static String url= "https://rf2.ilabx.com/service_center/332/?tab=equipment";
	WebDriver driver;
	int i;
	
	@Test 
	
	public void ExcelData() throws IOException {
	//WebDriver driver = new ChromeDriver();
	//driver.get(Login);	
	//driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("C://Users//vishgarg//OneDrive - Agilent Technologies//Desktop//Selenium Excel.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for(i=0; i<sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Login"))
					{
				XSSFSheet sheet = 	workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();
				Row Firstrow= rows.next();
				Iterator<Cell> ce=Firstrow.cellIterator();
				ce.next();
				
			}
		
			
}
		
		
		
	}

}
