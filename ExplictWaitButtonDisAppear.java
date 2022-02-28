package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplictWaitButtonDisAppear {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/disapper.html");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='disappear']//button//b")));
		String text = driver.findElement(By.xpath("//div[@class='disappear']//button//b")).getText();
		
		System.out.println(text);
		if(text.equals("I'm going to disappear. Keep looking at me!!"))
		{
		System.out.println("Button disappeared");
		}
	}
}
