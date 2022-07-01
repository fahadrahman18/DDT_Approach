package selenium.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns {
	
	//public void DropdownTest() {
	public static void main(String args[]) throws InterruptedException {
		
		//Driver setup for chrome
		//System.setProperty("webdriver.chrome.driver", "path_of_the_driver");
		WebDriverManager.chromedriver().setup(); // Because of WebDriverManager, no need to download and specify the driver
		ChromeDriver driver = new ChromeDriver();
		
		//Managing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Launching browser
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		
		//First DropDown
		WebElement dd1 = driver.findElement(By.xpath("//div//select[@id='first']"));	
		Select down1 = new Select(dd1);
		down1.selectByIndex(1);
		//down1.selectByValue("Apple");
		
		//Second DropDown
		WebElement dd2 = driver.findElement(By.xpath("//select[@id='animals']"));
		Select down2 = new Select(dd2);
		down2.selectByVisibleText("Avatar");
		
		boolean mul1 = down2.isMultiple();
		System.out.println("Second dropdown is multiple selectable: " + mul1);
		
		//Third Dropdown - Multiple selection
		WebElement dd3 = driver.findElement(By.xpath("//select[@id='second']"));
		Select down3 = new Select(dd3);
		down3.selectByIndex(1);
		down3.selectByIndex(3);

		
		boolean mul2 = down3.isMultiple();
		System.out.println("Third dropdown is multiple selectable: " + mul2);
		
		System.out.println("Page Title is: " + driver.getTitle());
		
		Thread.sleep(2000);
		
		down3.deselectAll(); //Deselecting all the selected options
		
		//driver.close(); // closing the browser(current window)
	

	}

	//Below shorcuts
	
// suggestion - ctrl + space
// run using keyword -  alt + shift + X and J
//assign the value with suggested varaible name -  ctrl+2 and L


}
