package week2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditField {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://leafground.com/pages/Edit.html"); //LaunchURL
		
		
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com"); //Enter your email address

		
		WebElement appendbox = driver.findElement(By.xpath("//input[@value='Append ']")); //Append a text and press keyboard tab
		appendbox.sendKeys("Texts"+ Keys.TAB);
		
		Thread.sleep(4000);
		
		WebElement getdefaulttext = driver.findElement(By.name("username"));
		System.out.println(getdefaulttext.getAttribute("value")); //Get default text entered

		
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear(); //Clear the text

		
		WebElement enabledornot = driver.findElement(By.xpath("//input[@disabled='true']"));
		
		System.out.println(enabledornot.isEnabled()); // Confirm that edit field is disabled


	}

}
