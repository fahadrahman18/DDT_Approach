package week2.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Dropdown.html"); //Launching the URL
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select choosebyindex = new Select(dropdown1);
		
		choosebyindex.selectByIndex(1);
		
		Thread.sleep(2000);
		
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select choosebytext = new Select(dropdown2);
		
		choosebytext.selectByVisibleText("Appium");
		
		Thread.sleep(2000);
		
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@name='dropdown3']"));
		Select choosebyvalue = new Select(dropdown3);
		
		choosebyvalue.selectByValue("4");
		Thread.sleep(2000);
		
		List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@class='dropdown']/option"));
		int numofdropdowns = dropdowns.size();
		
		for (int i = 0; i < numofdropdowns; i++) {
			System.out.println(numofdropdowns);
			break;
		}
		
		WebElement selectbysendkeys = driver.findElement(By.xpath("(//div[@class='example']/select)[5]"));
		selectbysendkeys.sendKeys("Loadrunner");
		
		driver.findElement(By.xpath("(//div[@class='example']//option[text()='Selenium'])[6]")).click();
		
		
		
		
		
		
		
	}

}
