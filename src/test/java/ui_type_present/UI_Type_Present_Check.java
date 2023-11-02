package ui_type_present;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import projectSpecific.base.ProjectSpecificMethods;

public class UI_Type_Present_Check extends UI_Type_Default_Content_Checking{

    public UI_Type_Present_Check(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
        super(driver, node, prop, Environment, StageURL, Stage1URL);
    }
    
    String buildName = "For Automation";
    
    String[] uiname = {"Message", "Multi Choice", "Text Question", "Email", 
            "Phone Number", "Appointment", "Multi Select/List", "List", 
            "Number", "Range", "Rating", "Opinion Scale", 
            "Date", "File Upload", "Links", "Thank you", 
            "Section", "Picture Message", "Yes Or No", "Agreement", 
            "Ranking (Matrix)", "Voice Record", "Google Map", };
    
    List <String> li = new ArrayList<>(Arrays.asList(uiname));
    
    
    int section_Present = 0;
    int i_continuity = 0;
    
    public void initial() throws InterruptedException {
        Random ran = new Random();
        
        if(Environment.equalsIgnoreCase("Live")) {
            navigateto(StageURL);
        }else if(Environment.equalsIgnoreCase("Testing")) {
            navigateto(Stage1URL);
        }
        
        login();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='ng-clear-wrapper ng-star-inserted']"))));
        
        
        addBuild.click();
        Thread.sleep(1000);
        
        buildName_Input.sendKeys(buildName);
        
        buildCreate_Button.click();
        
        try {
            WebElement buildName_AlreadyExistToaster = driver.findElement(By.xpath("//div[text()=' Build Name Already Exits...! ']"));
            wait.until(ExpectedConditions.visibilityOf(buildName_AlreadyExistToaster));
            
            for (int i = 0; i < 5; i++) {
                char ch = (char) ran.nextInt(256);
                
                if(Character.isLetter(ch)) {
                    buildName += ch;
                }
            }
            
            Thread.sleep(1000);
            
            buildName_Input.clear();
            Thread.sleep(1000);
            
            buildName_Input.sendKeys(buildName);
            Thread.sleep(1000);
            
            buildCreate_Button.click();
            
        }catch (Exception e) {
            System.out.println("Build Successfully Created");
        }
        
        refresh();
        
        WebElement drop_button = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[2]"));
        drop_button.click();
        
        WebElement build_Path = driver.findElement(By.xpath("//div[text()='"+buildName+" ']"));
        
        build_Path.click();
        refresh();

    }
    
    public void drag_and_Drop_and_defaultContent_Verification() throws InterruptedException, IOException {
        
        for (int i = 0; i < li.size(); i++) {
        
            if(i==0) {
                WebElement body = driver.findElement(By.xpath("//div[@class='box-list']"));
                drag_Drop(ele(i), body, i);
                check_content(ele(i), li.get(i), i+1, i+1);
            }
            else {
                drag_Drop(ele(i), row2(i), i);
                check_content(ele(i), li.get(i), i+1, i+1);
            }
        }
    }
        
    public WebElement ele(int i) {
        WebElement message_ = driver.findElement(By.xpath("//button[text()='"+li.get(i)+"']"));
        return message_;
    }

        
    
public void drag_Drop(WebElement src, WebElement des, int Script_UI_position_Num) throws InterruptedException {
        
        Actions actions = new Actions(driver);
        
        if(Script_UI_position_Num!=0) {
            actions.moveToElement(driver.findElement(By.xpath("(//div[@class='droppable-drag-row1'])[1]"))).perform();
            JavascriptExecutor js = driver;
            WebElement mElement = driver.findElement(By.xpath("(//div[@class='droppable-drag-row1'])["+Script_UI_position_Num+"]"));
            js.executeScript("arguments[0].scrollIntoView(true);",mElement);
        }
        
        
        actions.moveToElement(src)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(src)
                .pause(Duration.ofSeconds(1))
                .moveToElement(des)
                .pause(Duration.ofSeconds(1))
                .release().perform();
        System.out.println("Drag and Drop completed");
        
        Thread.sleep(1000);
        refresh();
        Thread.sleep(1000);
    }

    public WebElement row2(int element_Add_Row_Number) {
        WebElement row2 = null;
        if(section_Present!=1) {
            row2 = driver.findElement(By.xpath("(//div[@class='row droppable-drag-row2'])["+element_Add_Row_Number+"]"));
            //element_Add_Row_Number++;
            return row2;
        }
        else if(section_Present==1) {
            row2 = driver.findElement(By.xpath("(//div[@class='droppable-drag-row1'])["+element_Add_Row_Number+"]"));
            //element_Add_Row_Number++;
            return row2;
        }
        return row2;
    }
    
    
    public void check_content(WebElement UIType, String UI_Name, int Script_UI_position_Num, int Edit_Icon_Num) throws IOException, InterruptedException {
        System.err.println(UIType.getAttribute("innerHTML")+"____"+UI_Name);
        
        FileInputStream fi = new FileInputStream(".\\UI_Type_Default_Content - Copy.xlsx");
        Workbook wb = new XSSFWorkbook(fi);
        Sheet sheetAt = wb.getSheetAt(0);
        Row row = sheetAt.getRow(1);
        
        Actions actions = new Actions(driver);
        
            actions.moveToElement(driver.findElement(By.xpath("(//div[@class='droppable-drag-row1'])[1]"))).perform();
            Thread.sleep(1000);
            JavascriptExecutor js = driver;
            WebElement mElement = driver.findElement(By.xpath("(//div[@class='ddr-div1'])["+Script_UI_position_Num+"]"));
            js.executeScript("arguments[0].scrollIntoView(true);",mElement);
            Thread.sleep(1000);
            
        FileOutputStream fos = new FileOutputStream(".\\UI_Type_Default_Content - Copy.xlsx");
        
        try {
            if(UIType.getAttribute("innerHTML").equals(UI_Name)) {
                System.err.println("In 1st condition");
                actions.moveToElement(mElement).perform();
                
                if(section_Present==1) {
                    ++Edit_Icon_Num;
                }
                
                if(UIType.getText().equalsIgnoreCase("Section")) {
                    System.err.println(UIType.getText());
                    section_Present = 1;
                }
                
                WebElement edit = driver.findElement(By.xpath("(//button[text()='edit'])["+Edit_Icon_Num+"]"));
                edit.click();
                WebElement message_Content = driver.findElement(By.tagName("h3"));
                String actual = message_Content.getText();
                System.err.println(actual); 
                
                
                Cell cell = row.getCell(Script_UI_position_Num);
                String stringCellValue = cell.getStringCellValue();
                
                
                if(actual.equals(stringCellValue)) {
                    System.err.println("In 2nd Condition");
                    
                    sheetAt.getRow(2).createCell(Script_UI_position_Num).setCellValue(actual);
                    
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//span[text()='Close']")).click();
                    Thread.sleep(1000);
                    
                    wb.write(fos);
                    wb.close();
                    
                    refresh();
                    Thread.sleep(1000);
                }
                else {
                    sheetAt.getRow(2).createCell(Script_UI_position_Num).setCellValue("Message Content was Not Equal");
                    wb.write(fos);
                    wb.close();
                }
        }
        }catch(Exception e) {
            System.err.println("Error");
            wb.close();
        }

    }
}
