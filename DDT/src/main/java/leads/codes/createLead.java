package leads.codes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class createLead {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://leaftaps.com/opentaps/control/login");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");		
			driver.findElement(By.className("decorativeSubmit")).click();
			
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.linkText("Create Contact")).click();
			
			//Filling the details
			driver.findElement(By.id("firstNameField")).sendKeys("Fahad");
			driver.findElement(By.id("lastNameField")).sendKeys("Rahman");
			driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("FNAME");
			driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("LNAME");
			driver.findElement(By.id("createContactForm_departmentName")).sendKeys("CSE");
			driver.findElement(By.id("createContactForm_description")).sendKeys("Engineering");
			driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");
			
			WebElement clickingstate = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
			
			Select state = new Select(clickingstate);
			state.selectByVisibleText("New York");
			
			driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
			
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			
			
			

		}

	}

