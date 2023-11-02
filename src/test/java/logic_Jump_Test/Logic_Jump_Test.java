package logic_Jump_Test;

import java.io.FileInputStream;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import logic_Jump.Logic_Jump;
import projectSpecific.base.ProjectSpecificMethods;

public class Logic_Jump_Test extends ProjectSpecificMethods{

    @BeforeTest
    public void setValues() {
        testCaseName = "Chatbot";
        authors = "Santhosh";
        category = "Smoke Test";
    }

    @Test
    private void run() throws InterruptedException, IOException {
        node = test.createNode("Chatbot - 1");
        extent.attachReporter(spark);
        Logic_Jump a = new Logic_Jump(driver, node, prop, Environment, StageURL, Stage1URL);
        a.ma();
        
        }
}