package projectSpecific.base;

import java.io.IOException;




import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import selenium.base.SeleniumBase;
import utilities.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	public String dataSheetName;
	public String Environment;
	public String StageURL;
	public String Stage1URL;

	public String User_Name = "rbot.live@gmail.com";
	public String Password = "12345678";
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}
     
	@BeforeMethod
	public void beforeMethod() throws IOException {
		// Stage.d9 or Stage.d11
		Environment = "Testing";
		
		StageURL = "https://rbot.live/?return=%2Fbuildscript";
		Stage1URL = "https://rthree.live/?return=%2Fbuildscript";
		
		String browser = "chrome";
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = startApp1("chrome");

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = startApp1("edge");

		}
		// node = test.createNode(testCaseName);
	}
    public void login() throws InterruptedException {
    	
    	try {
    	Alert alt = driver.switchTo().alert();
    	alt.accept();
    	}catch(Exception d) {
    		System.out.println("No Alert");
    	}
    	

		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
		username.clear();
		username.sendKeys(User_Name);

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.clear();
		password.sendKeys(Password);

		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton.click();
//		 try{
//			 WebElement toast = driver.findElement(By.id("toast-container"));
//			 System.out.println("\nPlease Enter Valid Credentials\n\n");
//		     reportStep("The Element"+loginbutton+"clicked", "FAIL"); 
//		     driver.quit();
//		    }
//		 catch (Exception e) {
//			 System.out.println("Login Successfull");
//			 //e.printStackTrace();
//			 //reportStep("The Element"+loginbutton+"clicked", "FAIL"); 
//		}
}   
	
	@AfterMethod
	public void afterMethod() {
		//quit();
	}
	
}