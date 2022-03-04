package week2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
// 		get url
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();  //maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement enterusername = driver.findElement(By.id("username"));
		enterusername.sendKeys("Demosalesmanager");

// Giving credential and login
		WebElement enterpassword = driver.findElement(By.id("password"));
		enterpassword.sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();  //clicking Lead
		driver.findElement(By.linkText("Find Leads")).click(); //clicking Find Leads
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("abc");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		String actualName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).getText();
		
		
		System.out.println("First resultant name is " + actualName);
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		Thread.sleep(3000);
		
		String expectedTitle = "Duplicate Lead";
		
		String titleofthepage = driver.getTitle();
		
		if (titleofthepage.contains(expectedTitle)) {
			System.out.println("Title contains Duplicate Lead");
		}
		else {
			System.out.println("Title not match");
		}
		
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		WebElement duplicatedname = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
		
		String finalname = duplicatedname.getText();
		
		System.out.println("After duplicated name is " + finalname);
		
		
		if (actualName.equals(finalname)) {
			System.out.println("Names are same");
		}
		else {
			System.out.println("Names not matched");
		}
		
		
		
		
		

	
	}

}
