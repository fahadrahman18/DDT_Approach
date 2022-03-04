package week2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html"); //Launching the URL
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click(); //Go to Home Page
		
		driver.navigate().back();
		
		WebElement withoutclick = driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"));
		
		String verifywithoutclick = withoutclick.getAttribute("href");
		
		System.out.println(verifywithoutclick);
		
		WebElement checkbrokenlink = driver.findElement(By.xpath("//a[text()='Verify am I broken?']")); //Verify am I broken?
		checkbrokenlink.click();
		String verifybroken = driver.getTitle();
		
		if (verifybroken.contains("404")) {
			System.out.println("It is broken");
		}
		else {
			System.out.println("Not broken");
		}
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		
		
		

	}

}
