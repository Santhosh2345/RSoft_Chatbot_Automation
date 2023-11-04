package ui_type_present;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import projectSpecific.base.ProjectSpecificMethods;

public class UI_Type_Default_Content_Checking extends ProjectSpecificMethods{
    
    public UI_Type_Default_Content_Checking(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL ) {
        
        this.driver = driver;
        this.node = node;
        this.prop = prop;
        this.Environment = Environment;
        this.StageURL = StageURL;
        this.Stage1URL = Stage1URL;
        
        PageFactory.initElements(driver, this);
//        PageFactory.initElements(node, this);
//        PageFactory.initElements(prop, this);
//        PageFactory.initElements(Environment, this);
//        PageFactory.initElements(StageURL, this);
//        PageFactory.initElements(Stage1URL, this);
    }
    
        @FindBy(xpath = "//span[@class='ng-clear-wrapper ng-star-inserted']")
        public WebElement buildClearButton;
        
        @FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[2]")
        public WebElement buildDropDownButton;
        
    
        @FindBy(xpath = "//button[@title='Add build']")
        public WebElement addBuild;
        
        @FindBy(className = "swal2-input")
        public WebElement buildName_Input;
        
        @FindBy(xpath = "//button[text()='Create']")
        public WebElement buildCreate_Button;
        
        @FindBy(id = "publish")
        public WebElement publish;
        
        @FindBy(xpath = "//input[@name='swal2-radio' and @value='2']")
        public WebElement publish_New_Bot;
        
        @FindBy(xpath = "//input[@name='swal2-radio' and @value='1']")
        public WebElement copy_URL;
        
        @FindBy(xpath = "//button[text()='OK']")
        public WebElement urlCopied;
        
        @FindBy(xpath = "//button[text()='Yes, Publish it..!']")
        public WebElement publish_Confirm;
        
        public WebElement buildPath(String buildName) {
            return  driver.findElement(By.xpath("//div[text()='"+buildName+" ']"));
        }
        
        public WebElement UIType_Path(String buildName) {
            return  driver.findElement(By.xpath("//button[text()='"+buildName+"']"));
        }
        
        @FindBy(xpath = "//div[@class='box-list']")
        public WebElement emptyBody;
        
        
        public WebElement drop_Next_To(int element_Add_Row_Number) {
            return  driver.findElement(By.xpath("(//div[@class='droppable-drag-row1'])["+element_Add_Row_Number+"]"));
        }
        
        
        public WebElement script_UI_position(int Script_UI_position_Num) {
            return driver.findElement(By.xpath("(//div[@class='ddr-div1'])["+Script_UI_position_Num+"]"));
        }
        
        public WebElement script_UI_Text() {
            return driver.findElement(By.xpath("(//div[@class='ddr-div1'])[\"+Script_UI_position_Num+\"]/div/span/span"));
        }
        
        public WebElement editIcon(int Edit_Icon_Num) {
            return  driver.findElement(By.xpath("(//button[text()='edit'])["+Edit_Icon_Num+"]"));
        }
        
        public WebElement deleteIcon(int Edit_Icon_Num) {
            return  driver.findElement(By.xpath("(//button[text()='delete_forever'])["+Edit_Icon_Num+"]"));
        }
        
        @FindBy(xpath = "//button[text()='Yes, Delete it..!']")
        public WebElement UIType_DeleteConfirm;
        
        @FindBy(tagName = "h3")
        public WebElement messageContent;
        
        @FindBy(xpath = "//span[text()='Done']")
        public WebElement Done;
        
        @FindBy(xpath = "//span[text()='Close']")
        public WebElement Close;
        
        public List<WebElement> UI_InSection(){
            List<WebElement> li = driver.findElements(By.xpath("//div[@class='cdk-drag drag-box drag-box-sub ng-star-inserted']"));
            return li;
        }
        
        public WebElement row2(int sectionPresent, int element_Add_Row_Number) {
            WebElement row2 = null;
            if(sectionPresent!=1) {
                row2 = driver.findElement(By.xpath("(//div[@class='row droppable-drag-row2'])["+element_Add_Row_Number+"]"));
                //element_Add_Row_Number++;
                return row2;
            }
            else if(sectionPresent==1) {
                row2 = driver.findElement(By.xpath("(//div[@class='droppable-drag-row1'])["+element_Add_Row_Number+"]"));
                //element_Add_Row_Number++;
                return row2;
            }
            return row2;
        }
        
        @FindBy(id = "back_btn_on")
        public WebElement backOptionYes;
        
        @FindBy(id = "back_btn_off")
        public WebElement backOptionNo;
        
        @FindBy(id = "skip_btn_on")
        public WebElement skipOptionsYes;
        
        @FindBy(id = "skip_btn_off")
        public WebElement skipOptionsNo;
        
        public WebElement jumpIcon(int questionPositionNumber) {
            int positinoNumber = questionPositionNumber-1;
            return driver.findElement(By.xpath("//div[@id='options"+positinoNumber+"']/button[text()='device_hub']"));

        }
        
        @FindBy(xpath = "(//div[contains(@class,'skiplg')]//span[@class='ng-arrow-wrapper'])[1]")
        public WebElement ifDropDownButton_Skip;
        
        @FindBy(xpath = "(//div[contains(@class,'skiplg')]//span[@class='ng-arrow-wrapper'])[2]")
        public WebElement thenDropDownButton_Skip;
        
        @FindBy(id = "skipList0")
        public WebElement skipLogic_Select;
        
        @FindBy(xpath = "//div[@role='option']/span[text()='Skip On']")
        public WebElement skipONoption;
        
        @FindBy(xpath = "//div[@role='option']/span[text()='Skip Off']")
        public WebElement skipOFFoption;
        
        public WebElement skip_ToQuestion(String Question_Text) {
             return driver.findElement(By.xpath("//div[@role='option']/span[text()='"+Question_Text+"']"));
        }
        
        @FindBy(xpath = "//button[text()='Done']")
        public WebElement skipDoneButton;
        
        @FindBy(xpath = "//button[text()='next']")
        public WebElement formNext;
        
        @FindBy(xpath = "//button/span")
        public WebElement formMessNext;
        
        public void formNext() {
            try {
                formNext.click();
            }catch(Exception e) {
                try {
                    formMessNext.click();
                }catch(Exception a) {
                    System.err.println("Unable to Click Next");
                    System.exit(1);
                }
            }
        }
        
        
}
