package week2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("http://leafground.com/pages/Button.html"); //Launching the URL
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.findElement(By.id("home")).click(); //Click button to travel home page
			
			Thread.sleep(3000);
			driver.navigate().back(); //back to the current url
			
			WebElement findposition = driver.findElement(By.xpath("//button[@id='position']"));
			System.out.println("position of x,y is " + findposition.getLocation()); //Find position of button (x,y)
			
			WebElement getcolor = driver.findElement(By.xpath("//button[@id='color']"));
			String color = getcolor.getCssValue("background-color");  
			System.out.println("rgba value is "+ color);  //Find button color
			
			WebElement getsize = driver.findElement(By.xpath("//button[@id='size']"));
			System.out.println("size is " + getsize.getSize());  //Find the height and width
			
			//Test ends
			
			
			

	}

}
