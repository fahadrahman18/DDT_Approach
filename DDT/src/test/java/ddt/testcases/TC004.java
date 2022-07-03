package ddt.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC004 extends ProjectSpecificMethods {
	
	@Test
	public void TC004_DeleteLead() throws InterruptedException {
		
		WebElement enterusername = driver.findElement(By.id("username"));
		enterusername.sendKeys("Demosalesmanager");

		// Giving credential and login
		WebElement enterpassword = driver.findElement(By.id("password"));
		enterpassword.sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();  //clicking Lead
		driver.findElement(By.linkText("Find Leads")).click(); //clicking Find Leads
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		WebElement getfirstelement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String aa = getfirstelement.getText();
		
		System.out.println(aa);
		
		getfirstelement.click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[13]")).sendKeys(aa);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		String FinalResult = "No records to display";
		
		String verifyresult = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		
		
		System.out.println(verifyresult);
		
		
		if (verifyresult.equals(FinalResult)) {
			System.out.println("Deletion successfull");
		}
		else {
			System.out.println("wrong");
		}

	}

}
