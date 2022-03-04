package week2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB_CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");  //Launch URL
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//a[contains(text(),'Create')])[1]")).click();
		
		
		driver.findElement(By.name("firstname")).sendKeys("fname");
		driver.findElement(By.name("lastname")).sendKeys("lname");
		driver.findElement(By.name("reg_email__")).sendKeys("2689281912");
		driver.findElement(By.name("reg_passwd__")).sendKeys("passwords");
		
		WebElement choosedate = driver.findElement(By.id("day"));
		WebElement choosemonth = driver.findElement(By.id("month"));
		WebElement chooseyear = driver.findElement(By.id("year"));
		
		Select clickdate = new Select(choosedate);
		Select clickmonth = new Select(choosemonth);
		Select clickyear = new Select(chooseyear);
		
		clickdate.selectByVisibleText("30");
		clickmonth.selectByVisibleText("Mar");
		clickyear.selectByVisibleText("1997");
		
		driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
		
		
		

		
	}

}
