package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.Login.LoginPage;

public class BaseClass {

	public static WebDriver driver;
    public static Properties prop;

 // Constructor: Loads config.properties
    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src\\main\\java\\com\\config\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException f) {
        	f.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
//// Login To Application
//    public static LoginPage loginPage;
//
//    public void loginToApplication() {
//
//        loginPage = new LoginPage();
//
//        loginPage.clickSignUpLogin();
//        loginPage.scrollByPixel(200);
//        loginPage.login(prop.getProperty("emailAddress"),
//                        prop.getProperty("password"));
//    }

 // Launch browser and open URL
    public void initialization() {
        String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }
    
 // Close browser safely
 	public void closeBrowser() {
 		if (driver != null) {
 		driver.quit();
 		driver = null;
 	}
   } 
 	
 // Take screenshot (called from test classes)
    public void takeScreenshot(String testName) {
        if (driver == null) {
            System.out.println("Driver is null, cannot take screenshot.");
            return;
        }

        try {
            // Folder to store screenshots
            File destDir = new File("screenshots");
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            // Add timestamp so file names are unique
            String timestamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(new Date());

            // Capture screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(destDir, testName + "_" + timestamp + ".png");

            // Copy screenshot file to destination
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
// Scroll Down/Up by pixels    
    public void scrollByPixel(int pixels) 
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ");");
        System.out.println("Scrolled down by " + pixels + " pixels");
    }
	
}
