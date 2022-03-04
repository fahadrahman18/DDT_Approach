package week2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html"); //Launching the URL
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/img)[1]")).click(); //Click on this image to go home page

		Thread.sleep(3000);
		driver.navigate().back();
		
		
		//Am I Broken Image?
		WebElement brokenimage = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/img)[2]"));
		brokenimage.click();
		
		if (driver.getCurrentUrl().contains("pages/Image.html")) {
			System.out.println("Broken Image");
		}
		else {
			System.out.println("Image not broken");
		}
		
		
		int widthsize = brokenimage.getSize().getWidth();
		System.out.println("width of broken image is " + widthsize);

		
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/img)[3]")).click();  //Click me using Keyboard or Mouse

		
	}

}
