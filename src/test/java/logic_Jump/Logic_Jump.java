package logic_Jump;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import ui_type_present.UI_Type_Default_Content_Checking;
import ui_type_present.UI_Type_Present_Check;

public class Logic_Jump extends UI_Type_Default_Content_Checking{

    public Logic_Jump(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL,
            String Stage1URL) {
        super(driver, node, prop, Environment, StageURL, Stage1URL);
        // TODO Auto-generated constructor stub
    }
    
    String buildName = "For Automation";
    
    int section = 0;
    int sectionUITotal = 0;

    private String text = null;
    
    Actions act = new Actions(driver);
    
    public void ma() throws InterruptedException, IOException {
        
        if(Environment.equalsIgnoreCase("Live")) {
            navigateto(StageURL);
        }else if(Environment.equalsIgnoreCase("Testing")) {
            navigateto(Stage1URL);
        }
        
        login();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(buildClearButton));
        
        buildDropDownButton.click();
        
        buildPath(buildName).click();
        
        refresh();
        
        FileInputStream fis = new FileInputStream(".\\Logic_Jump.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        int numberOfSheets = wb.getNumberOfSheets();
        
        List<String> lis = new ArrayList<>();
        
        for (int i = 0; i < numberOfSheets; i++) {
            lis.add(wb.getSheetName(i));
        }
        
//        for (int i = 0; i < lis.size(); i++) {
//            scriptCreation(lis.get(0));
//            skipLogic_Setup(lis.get(0));
            
            first_Element_Remove(lis.get(1));
//        }
        
        
    }
    
    /*
     * This method contains
     * 1. Drag and Drop
     * 2. Edit the Drag and Dropped UI types 
     * Using File Input Stream
     */
    public void scriptCreation(String sheetName) throws IOException, InterruptedException {
        
        UI_Type_Present_Check ui = new UI_Type_Present_Check(driver, node, prop, Environment, StageURL, Stage1URL);
        
        FileInputStream fis = new FileInputStream(".\\Logic_Jump.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        int nr = sheet.getPhysicalNumberOfRows();
        
       // List<String> lis = new ArrayList<>();
        
        Row row_UIType = sheet.getRow(0);
        int r1nc = row_UIType.getPhysicalNumberOfCells();
        
        Row row_Question = sheet.getRow(1);
        
        Row row_Back = sheet.getRow(2);
        
        Row row_Skip = sheet.getRow(3);
        
        for (int j = 0; j < r1nc; j++) {
            Cell cell = row_UIType.getCell(j+1);
            String cellValue = cell.getStringCellValue();
            
            //lis.add(j, cellValue);  
             
             if(j==0) {
              ui.drag_Drop(UIType_Path(cellValue), emptyBody, j);
              
             }else {
                     ui.drag_Drop(UIType_Path(cellValue),row2(section, j), j);
             }
             
             if(section!=1) {
                 System.err.println(j);
                 act.moveToElement(script_UI_position(j+1)).perform();
                 Thread.sleep(2000);
                 
                 editIcon(j+1).click();
                 Thread.sleep(1000);
                 
                 messageContent.clear();
                 messageContent.sendKeys(row_Question.getCell(j+1).getStringCellValue());
                 Thread.sleep(1000);
                 
                 String backOpt = row_Back.getCell(1).getStringCellValue();
                 backOption(backOpt);
                 
                 String skipOpt = row_Skip.getCell(1).getStringCellValue();
                 skipOption(skipOpt);
                 
                 Done.click();
                 Thread.sleep(2000);
                 
                 refresh();
             }
             
             else if(section==1) {
                 System.err.println("Section  "+j);
                 act.moveToElement(script_UI_position(j+1)).perform();
                 Thread.sleep(2000);
                 
                 editIcon(j+1+UI_InSection().size()).click();
                 Thread.sleep(1000);
                 
                 messageContent.clear();
                 messageContent.sendKeys(row_Question.getCell(j+1).getStringCellValue());
                 Thread.sleep(1000);
                 
                 String backOpt = row_Back.getCell(1).getStringCellValue();
                 backOption(backOpt);
                 
                 String skipOpt = row_Skip.getCell(1).getStringCellValue();
                 skipOption(skipOpt);
                 
                 Done.click();
                 Thread.sleep(2000);
                 
                 refresh();
             }
             
             if(cellValue.equals("Section")) {
                 section = 1;
             }
             
             
        }

    }
    
    /*
     * This method for set Skip Logic for Particular UI Type
     */
    public void skipLogic_Setup(String sheetName) throws InterruptedException, IOException {
        
        FileInputStream fis = new FileInputStream(".\\Logic_Jump.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        
        Row row_SkipLogic = sheet.getRow(4);
        
        Row row_To_Question = sheet.getRow(5);
        
                act.moveToElement(script_UI_position(1)).perform();
                jumpIcon(1).click();
                
                String  skip_Logic = row_SkipLogic.getCell(1).getStringCellValue();
                String  to_Question = row_To_Question.getCell(1).getStringCellValue();
                Thread.sleep(1000);
                
                ifDropDownButton_Skip.click();
                Thread.sleep(1000);
                
                if(skip_Logic.equalsIgnoreCase("On")) {
                    Thread.sleep(1000);
                    skipONoption.click();
                }
                else {
                    Thread.sleep(1000);
                    skipOFFoption.click();
                }
                
                thenDropDownButton_Skip.click();
                Thread.sleep(1000);
                
                skip_ToQuestion(to_Question).click();
                
                skipDoneButton.click();
                }
    
    /*
     * This method for Back option selection for Drag and Dropped UI Types
     */
    
    private void backOption(String backOpt) {
            
            if(backOpt.equalsIgnoreCase("ON")) {
            backOptionYes.click();
        }
        else {
            backOptionNo.click();
        }
    
    }
    
    /*
     * This method for Skip option selection for Drag and Dropped UI Types
     */
    private void skipOption(String skipOpt) {
        
        if(skipOpt.equalsIgnoreCase("ON")) {
            skipOptionsYes.click();
        }
        else {
            skipOptionsNo.click();
        }
    
    }
    
    private void first_Element_Remove(String sheetName) throws InterruptedException, IOException {
        UI_Type_Present_Check ui = new UI_Type_Present_Check(driver, node, prop, Environment, StageURL, Stage1URL);
        
        FileInputStream fis = new FileInputStream(".\\Logic_Jump.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        int nr = sheet.getPhysicalNumberOfRows();
        
        Row row_UIType = sheet.getRow(0);

        Row row_Question = sheet.getRow(1);
        
        Row row_Back = sheet.getRow(2);
        
        Row row_Skip = sheet.getRow(3);
        
        Cell cell = row_UIType.getCell(1);
        String cellValue = cell.getStringCellValue();
        
        ui.drag_Drop(UIType_Path(cellValue),drop_Next_To(1), 1);
        
        Actions act = new Actions(driver);
        act.moveToElement(script_UI_position(1)).perform();
        Thread.sleep(1000);
        
        deleteIcon(1).click();
        Thread.sleep(1000);
        
        UIType_DeleteConfirm.click();
        Thread.sleep(3000);
        
        act.moveToElement(script_UI_position(1)).perform();
        Thread.sleep(2000);
        
        editIcon(1).click();
        Thread.sleep(1000);
        
        messageContent.clear();
        messageContent.sendKeys(row_Question.getCell(1).getStringCellValue());
        Thread.sleep(1000);
        
        String backOpt = row_Back.getCell(1).getStringCellValue();
        backOption(backOpt);
        
        String skipOpt = row_Skip.getCell(1).getStringCellValue();
        skipOption(skipOpt);
        
        Done.click();
        Thread.sleep(2000);
        
        refresh();
        
        skipLogic_Setup(sheetName);
        
    }
}
