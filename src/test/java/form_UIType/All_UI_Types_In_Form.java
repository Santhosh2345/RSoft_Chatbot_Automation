package form_UIType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import ui_type_present.UI_Type_Default_Content_Checking;

public class All_UI_Types_In_Form extends UI_Type_Default_Content_Checking{

    public All_UI_Types_In_Form(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment,
            String StageURL, String Stage1URL) {
        super(driver, node, prop, Environment, StageURL, Stage1URL);
        // TODO Auto-generated constructor stub
    }

    Random ran = new Random();
    JavascriptExecutor js = (JavascriptExecutor)driver;
    
    /*
     * Message - Not and Input Field
     */
    
    /*
     * Multi Choice
     */
    
    public String multiChoice() {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='msshow-container float multichoice']/li"));
        int size = options.size();
        
        int nextInt = 1;
        if(ran.nextInt(size) > 0) {
            nextInt = ran.nextInt(size);
        }
        WebElement selected_Option = driver.findElement(By.xpath("(//ul[@class='msshow-container float multichoice']/li)["+nextInt+"]"));
        String selected_Value = selected_Option.getText();
        return selected_Value;
    }
    
    
    /*
     * Text Question
     */
    public String textQuestion() {
        WebElement input = driver.findElement(By.id("textquestion_textarea"));
        
        String a = null;
        
        for (int i = 0; i < 10; i++) {
            a+= (char) ran.nextInt(33, 126);
        }
        
        input.sendKeys(a);
        return a;
    }
    
    /*
     *Email 
     */
    public String email() {
        String a = "sk@gmail.com";
        WebElement input = driver.findElement(By.id("ems_email"));
        input.sendKeys(a);
        return a;
    }
    
    /*
     * Phone Prefix
     */
    public String phonePrefix() {
        WebElement prefix_DropDown = driver.findElement(By.className("ng-arrow-wrapper"));
        prefix_DropDown.click();
        List<WebElement> prefixes = driver.findElements(By.xpath("//div[@role='option']"));
        int size = prefixes.size();
        int nextInt = ran.nextInt(size);
        WebElement prefix = driver.findElement(By.xpath("(//div[@role='option'])["+nextInt+"]"));
        prefix.click();
        return driver.findElement(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).getText();
    }
    
    /*
     * Phone Number
     */
    public String phoneNumber() {
        String phone_Number = null;
        WebElement ph = driver.findElement(By.id("phs_phonenumber"));
        ph.sendKeys(phone_Number);
        return phone_Number;
    }
    
    /*
     * Appointment
     */
    
    /*
     * Multi Select
     */
    public String multiSelect() throws InterruptedException {
        WebElement dropown = driver.findElement(By.className("dropdown-multiselect__caret"));
        dropown.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='dropdown-list']/ul[2]/li"));
        int size = options.size();
        int nof = ran.nextInt(size);
        String repeat = "0";
        for (int i = 0; i < nof; i++) {
            int nextInt = ran.nextInt(size);
            if(nextInt<=0) {
                --i;
                continue;
            }
            if(i!=0&&repeat.contains(Integer.toString(nextInt))) {
                --i;
                continue;
            }
            repeat+=nextInt;
            WebElement option = driver.findElement(By.xpath("//div[@class='dropdown-list']/ul[2]/li["+nextInt+"]"));
            
            js.executeScript("arguments[0].scrollIntoView(true);", option);
            option.click();
        }
        
        dropown.click();
        Thread.sleep(1000);
        dropown.click();
        
        List<WebElement> values = driver.findElements(By.xpath("//span[@class='selected-item ng-star-inserted']/span"));
        
        String text = values.get(0).getText(); 
        
        for(int i=1; i<values.size(); i++) {
            text += ", "+values.get(i).getText();
        }
        
        return text;
    }
    
    /*
     * List
     */
    public String list() {
        WebElement input = driver.findElement(By.tagName("input"));
        input.click();
        List<WebElement> options = driver.findElements(By.xpath("//ul//a"));
        int nextInt = ran.nextInt(options.size());
        
        WebElement option = driver.findElement(By.xpath("(//ul//a)["+nextInt+"]"));
        
        js.executeScript("arguments[0].scrollIntoView(true);", option);
        String text = option.getText();
        option.click();
        
        return text;
    }
    
    /*
     * Number
     */
    public String number() {
        String number = "5432167890";
        WebElement input = driver.findElement(By.id("numbershow"));
        input.sendKeys(number);
        return number;
    }
    
    /*
     * Range
     */
    public String range() throws InterruptedException {
        driver.get("https://rthree.live/showform?formid=19487&nurams=bot1");
        //formNext();
        WebElement range = driver.findElement(By.id("rangeinput"));
        
        for (int i = 0; i < 20; i++) {
            range.sendKeys(Keys.ARROW_RIGHT);
        }
        
        return "f";
    }
    
    /*
     *Number 
     */
    public String rating() {
        driver.get("https://rthree.live/showform?formid=19487&nurams=bot1");
        //formNext();
        WebElement rating = driver.findElement(By.xpath("//label[text()='Awesome']"));
        String attribute = rating.getAttribute("innerHTML");
        System.out.println(attribute);
        rating.click();
        return attribute;
    }
    
    /*
     * Opinion Scale
     */
    public String opinionScale() {
        driver.get("https://rthree.live/showform?formid=19487&nurams=bot1");
        //formNext();
        int nextInt = ran.nextInt(1, 11);
        WebElement rating = driver.findElement(By.xpath("(//li[@class='item float-item myanimation ng-star-inserted'])["+nextInt+"]"));
        String attribute = rating.getAttribute("innerHTML");
        attribute = attribute.trim();
        
        if(attribute.equals("1")){
            attribute = "Bad";
        }
        if(attribute.equals("10")){
            attribute = "Awesome";
        }
        
        rating.click();
        return attribute;
    }
    
    /*
     * Date
     */
    public String date() throws InterruptedException {
        driver.get("https://rthree.live/showform?formid=19487&nurams=bot1");
        WebElement dateIcon = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-icon-button mat-button-base']"));
        dateIcon.click();
        Thread.sleep(1000);
        
        WebElement date = driver.findElement(By.xpath("//div[contains(@class,'today')]"));
        date.click();
        
        Date dat = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date_format = format.format(dat);
        
        System.out.println(date_format);
        return date_format;
    }
    
    /*
     * File Upload
     */
    public void file() throws FileNotFoundException {
        driver.get("https://rthree.live/showform?formid=19487&nurams=bot1");
        WebElement upload = driver.findElement(By.id("fileid"));
        String property = System.getProperty("user.dir", "Automation.docx");
        System.out.println(property);
        upload.sendKeys(property);
    }
}











