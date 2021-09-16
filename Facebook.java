package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println("Title" + title);
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Kanimozhi");
		driver.findElement(By.name("lastname")).sendKeys("Kanimozhi");
		driver.findElement(By.name("reg_email__")).sendKeys("kanimozhi.c2@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("kani123");
		//dropdowns - Select Day
		WebElement day = driver.findElement(By.name("birthday_day"));
		Select bday = new Select(day);
		bday.selectByVisibleText("20");
		//dropdowns - Select Month
		WebElement Month = driver.findElement(By.name("birthday_month"));
		Select birthmonth = new Select(Month);
		birthmonth.selectByVisibleText("Apr");
		//dropdowns - Select Month
		
		WebElement Year = driver.findElement(By.name("birthday_year"));
		Select birthyr = new Select(Year);
		birthyr.selectByVisibleText("1990");
		
		// Radiobutton
		//driver.findElement(By.xpath("//label[@text(),'Female']/input")).click();
		driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).click();
	}

}
