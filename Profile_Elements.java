package org.User_and_Access_Control;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import projectSpecific.base.ProjectSpecificMethods;

public class Profile_Elements extends ProjectSpecificMethods{

	public Profile_Elements(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageUrl, String Stage1Url) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageUrl;
		this.Stage1URL = Stage1Url;
	}
	
	public void profilePage() throws InterruptedException {
		WebElement home = driver.findElement(By.linkText("Home"));
		verify_report_Click(home, "Home Link Button",url());
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().refresh();
		
		WebElement setting = driver.findElement(By.linkText("Setting"));
		verify_report_Click(setting, "Setting Link Button",url());
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
