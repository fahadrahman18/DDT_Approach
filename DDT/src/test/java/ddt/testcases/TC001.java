package ddt.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TC001 extends ProjectSpecificMethods{
	
	@Test
	public void TC001_CreateLead() throws InterruptedException {
		
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();  //clicking leads
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Filling the details
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TATA");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("fname");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("lname");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("123456789");
		
		WebElement clickingstate = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select state = new Select(clickingstate);
		state.selectByVisibleText("New York");
		
		
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		
		

	}
	}


