package leaftapsproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");

		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click(); 
		driver.findElement(By.linkText("Create Contact")).click(); 
		driver.findElement(By.id("firstNameField")).sendKeys("ABC");
		driver.findElement(By.id("lastNameField")).sendKeys("DEF");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("AAA");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("BBB");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Banking");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Selenium Training: Learn Selenium ");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("kaniselva@gmail.com");
		WebElement Countrydrp = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select Country = new Select(Countrydrp);
		Country.selectByVisibleText("New York"); 
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Selenium Training: Learn Selenium ");
		//form/div/div[2]/table/tbody/tr[8]/td[2]/input
		//driver.findElement(By.xpath("//form[@id = 'updateContactForm']//input")).click();
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		String title = driver.getTitle();
		System.out.println("Title" + title);
		
	}

}
