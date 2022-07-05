package ddt.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002 extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData() {
		 excelFilePath = "C://Users//User//git//repository//DDT//src//test//resources//testdata1.xlsx";
	}
	
	
	@Test(dataProvider = "testdata")
	public void TC002_EditLead(String username, String password, String cname, String fname, String lname, String phnnum, String country) throws InterruptedException {

		WebElement enterusername = driver.findElement(By.id("username"));
		enterusername.sendKeys("Demosalesmanager");

// Giving credential and login
		WebElement enterpassword = driver.findElement(By.id("password"));
		enterpassword.sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();  //clicking Lead
		driver.findElement(By.linkText("Find Leads")).click(); //clicking Find Leads
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Test");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		Thread.sleep(2000);
		
		String titlename = driver.getTitle();
		
		System.out.println("Title of the page is " + titlename);

		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TATA");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		
		String verifycomname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		System.out.println("Changed company name is " + verifycomname);
		

	}

}
