package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println("Title" + title);
		driver.findElement(By.name("UserFirstName")).sendKeys("Kani");
		driver.findElement(By.name("UserLastName")).sendKeys("Selva");
		driver.findElement(By.name("UserEmail")).sendKeys("kani.selva@gmail.com");
		driver.findElement(By.name("CompanyName")).sendKeys("CTS");
		driver.findElement(By.name("UserPhone")).sendKeys("123456789");

		// Dropdowns - Job Title
		WebElement jobTitle = driver.findElement(By.name("UserTitle"));
		Select Jtitle = new Select(jobTitle);
		Jtitle.selectByVisibleText("Customer Service Manager");
		// Employees
		WebElement Employees = driver.findElement(By.name("CompanyEmployees"));
		Select Emp = new Select(Employees);
		Emp.selectByValue("950"); // Denmark

//Country
		WebElement Country = driver.findElement(By.name("CompanyCountry"));
		Select CTY = new Select(Country);
		CTY.selectByValue("BB");

		// driver.findElement(By.xpath("(//div[@class='checkbox-ui'])[1]")).click();
		driver.findElement(By.xpath("//input[@id = 'SubscriptionAgreement']/following-sibling::div"));
		//driver.close();

	}

}
