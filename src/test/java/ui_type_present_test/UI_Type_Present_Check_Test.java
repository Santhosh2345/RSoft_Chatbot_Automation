package ui_type_present_test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectSpecific.base.ProjectSpecificMethods;
import ui_type_present.UI_Type_Present_Check;

public class UI_Type_Present_Check_Test extends ProjectSpecificMethods{

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
        UI_Type_Present_Check a = new UI_Type_Present_Check(driver, node, prop, Environment, StageURL, Stage1URL);
        a.initial();
        a.drag_and_Drop_and_defaultContent_Verification();

    }
}
