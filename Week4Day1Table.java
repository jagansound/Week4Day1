package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1Table {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
		driver.manage().window().maximize(); // Maximize the opened chrome browser window 
		driver.get("http://www.leafground.com/pages/table.html"); // Loads the URL in the opened browser 
		// Finding elementTable through a locator from a webpage
		WebElement elementTable = driver.findElement(By.xpath("//table[@id='table_id']"));

		// Finding the row from the elementTable found
		List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
		
		//To get the number of row count
		int RowCount = listRows.size(); 
		System.out.println("The number of Rows in the Table:" + RowCount);

		// Finding the Column from the elementTable found
		List<WebElement> listColumns = elementTable.findElements(By.tagName("th"));
		
		//To get the number of column count
		int ColumnCount = listColumns.size(); 
		System.out.println("The number of Columns in the Table:" + ColumnCount);
	
		//To get the Progress value of Learn to Interact with Elements
		WebElement webelement1 = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
		String ProgressPercentage = webelement1.getText();
		System.out.println("Progress value of Learn to Interact with Elements is :" + ProgressPercentage);
	
		//To check The vital task for the least completed progress
		WebElement onClick = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
		onClick.click();
		Boolean b = onClick.isSelected();
		
		File output = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(output, new File("./src/main/resources/snaps/Table.png"));
		if (b== true) {
			System.out.println("Vital task for least completed progress check box is checked");
		}
			else
				System.out.println("Vital task for least completed progress checkbox is not checked");
		  }
}
