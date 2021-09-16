package leaftapsproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		//driver.findElement(By.xpath("//span[text(),'Phone']"));
		driver.findElement(By.xpath("//span[contains(text(), 'Phone')]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8939904321");
		driver.findElement(By.xpath("//button[contains(text(), 'Find Leads')]")).click();
		//driver.findElement(By.xpath("//button[@class='x-btn-text'][contains(text(),'Find Leads')]")).click();10506
		String LeadID = driver.findElement(By.linkText("10532")).getText();
		System.out.println("The Lead ID is :" + LeadID);
		driver.findElement(By.linkText("10532")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID);
		driver.findElement(By.xpath("//button[contains(text(), 'Find Leads')]")).click();		
		driver.findElement(By.xpath("//div[contains(text(), 'No records to display')]"));
		String text = driver.findElement(By.xpath("//div[contains(text(), 'No records to display')]")).getText();
		if (text .contains("No records to display")) {
			System.out.println("The Lead ID is deleted Successfully");
		}
	}

}
