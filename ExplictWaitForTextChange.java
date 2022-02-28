package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplictWaitForTextChange {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/TextChange.html");
		
		File file1 = driver.getScreenshotAs(OutputType.FILE);
		File dstn1 = new File("./src/main/resources/snaps/before.png");
		FileUtils.copyFile(file1, dstn1);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
		File file2 = driver.getScreenshotAs(OutputType.FILE);
		File dstn2 = new File("./src/main/resources/snaps/after.png");
		FileUtils.copyFile(file2, dstn2);
		
		String text = driver.findElement(By.xpath("//button[text()='Click ME!']")).getText();
		
		if(text.equals("Click ME!")) {
			System.out.println("Text changes to Click ME! Button");
		}
		
		driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String mssg = alert.getText();
		
		System.out.println(mssg);
		
		if (mssg.equals("Click ME!"))
		{
			System.out.println("Valid Alert Text with the Text of Click ME! ");
			alert.accept();
		}
		else {
			System.out.println("Invalid Alert Text ");
		}
		
		
		
}
}