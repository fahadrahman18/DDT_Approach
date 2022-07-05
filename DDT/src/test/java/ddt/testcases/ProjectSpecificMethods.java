package ddt.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.files.ReadExcel;

public class ProjectSpecificMethods {
	
	public static WebDriver driver;
	public String excelFilePath;

	
	@BeforeMethod
	public void Precondition() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");
		
	}
	
// commenting due to we are going to extract data from excel
//so using new DataProvider to read data from excel file
//	@DataProvider()
//	public Object[][] TestDatas() {
//		Object[][] data = new Object[2][7];
//		
//		//1st row
//		data[0][0] = "Demosalesmanager"; //username
//		data[0][1] = "crmsfa"; //password
//		data[0][2] = "tata"; //cname
//		data[0][3] = "fname"; //fname
//		data[0][4] = "lname"; //lname
//		data[0][5] = "phnnum"; //phnnum
//		data[0][6] = "Mexico"; //country
//		
//		//2nd row
//		data[1][0] = "Demosalesmanager"; //username
//		data[1][1] = "crmsfa"; //password
//		data[1][2] = "Testleaf"; //cname
//		data[1][3] = "first"; //fname
//		data[1][4] = "last"; //lname
//		data[1][5] = "9791234567"; //phnnum
//		data[1][6] = "India"; //country
//		
//		return data;
//	}
	
	//DataProvider for getting datas from ReadExcel java file
	@DataProvider(name="testdata")
	public String[][] getData() throws IOException{
		String[][] exdata = ReadExcel.getData(excelFilePath);
		return exdata;
	}
	
	
	@AfterMethod
	public void PostCondition() {
		driver.close();
	}
	

}
