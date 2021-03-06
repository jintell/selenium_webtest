import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.io.IOException;

public class WebAppSeleniumTest {
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "/opt/google/chromedriver/bin/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("http://localhost:8080");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("about-us")).click();
		String pageText = driver.findElement(By.tagName("body")).getText(); 
	
		if(pageText.contains("about") || pageText.contains("About")) {        	
			System.out.println("The Website Selenium Test was Successful!!!");
		}else {
			System.out.println("The Website Selenium Test failed");
		}
		Thread.sleep(1000);
		driver.quit();
	}
}
