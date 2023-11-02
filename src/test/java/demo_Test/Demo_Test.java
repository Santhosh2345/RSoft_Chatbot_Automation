package demo_Test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Random;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectSpecific.base.ProjectSpecificMethods;

public class Demo_Test extends ProjectSpecificMethods{
    @BeforeTest
    public void setValues() {
        testCaseName = "Facebook Page Testing";
        authors = "Santhosh";
        category = "Smoke Test";
    }

    @Test
    public void F_05_04_Check_the_Elements_visibility_and_Functionalities_for_Edit_Field_Setting() throws InterruptedException, AWTException, IOException {
        node = test.createNode("Demo");
        
       // d.one();
    }
}
