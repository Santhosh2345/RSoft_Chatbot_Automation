package form_UIType;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import logic_Jump.Logic_Jump;
import projectSpecific.base.ProjectSpecificMethods;
import ui_type_present.UI_Type_Default_Content_Checking;

public class All_UI_Types_In_Form_Test extends ProjectSpecificMethods{

    @BeforeTest
    public void setValues() {
        testCaseName = "Survey Form Filling";
        authors = "Santhosh";
        category = "Smoke Test";
    }

    @Test
    private void run() throws InterruptedException, IOException, UnsupportedFlavorException {
        node = test.createNode("Form Filling");
        extent.attachReporter(spark);
        All_UI_Types_In_Form a = new All_UI_Types_In_Form(driver, node, prop, Environment, StageURL, Stage1URL);
        a.file();
    }
}
