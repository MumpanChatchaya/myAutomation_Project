package utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PageInitializer;
import utilities.PropertiesReader;

public class BaseClass {

public static WebDriver driver; 
    
    //            return WebDriver
    public static WebDriver getDriver() {
        
        if(driver == null) { // null so that we can open the web page
            
            switch(BaseClass.getProperty("browser")) {
            
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(BaseClass.getProperty("automationTestCaseURL"));
                // maximize
                driver.manage().window().maximize();
//                PageInitializer.initialize();
                break;
                
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(BaseClass.getProperty("automationTestCaseURL"));
                // maximize
                driver.manage().window().maximize();
//                PageInitializer.initialize();
                break;    
                
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                driver.get(BaseClass.getProperty("automationTestCaseURL"));
                // maximize
                driver.manage().window().maximize();
//                PageInitializer.initialize();
                break;        
                
            case "headless":
                //code
                break;
                
            
            }
            driver.get(BaseClass.getProperty("automationTestCaseURL"));
            //maximize
            driver.manage().window().maximize();
            
        }
        
        
        return driver;
    }
    
    
    //close/quit browser
    public static void tearDown() {
        if(driver != null) {
            driver.close();
            //driver.quit();
            driver = null;
        }
    }
    
    

    
//    configuration
    
    
    
    
    
    
    
    
    
    
    
}
