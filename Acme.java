package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Acme {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.name("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Login')]")).click();
		// driver.findElement(By.xpath("//button[contains(text(),
		// 'Login')][@type='submit']")).click();
		String title = driver.getTitle();
		System.out.println("Title" + title);
		driver.findElement(By.linkText("Log Out")).click();

		driver.close();

	}

}
