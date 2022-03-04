package week2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/checkbox.html"); //Launching the URL
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Select the languages that you know?
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click(); 
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		
		//Confirm Selenium is checked
		WebElement element = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));
		boolean checkedornot = element.isSelected();
		
		System.out.println(checkedornot);
		

		driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click(); //DeSelect only checked
		
		//Select all below checkboxes
		driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[13]")).click();
		
		
		

	}

}
