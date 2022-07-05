package ddt.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// |username|password|cname|fname|lname|phnnum|country

public class TC001 extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData() {
		 excelFilePath = "C://Users//User//git//repository//DDT//src//test//resources//testdata1.xlsx";
	}
	
	
	@Test(dataProvider = "testdata")
	public void TC001_CreateLead(String username, String password, String cname, String fname, String lname, String phnnum, String country) throws InterruptedException {
		
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();  //clicking leads
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Filling the details
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnnum);
		
		WebElement clickingstate = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		
		Select state = new Select(clickingstate);
		state.selectByVisibleText(country);
		
		
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		
		

	}
	}


