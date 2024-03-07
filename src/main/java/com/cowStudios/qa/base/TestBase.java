package com.cowStudios.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	// Global variables 
	public static WebDriver driver;
	public static Properties prop;
//	public WebDriverWait wait;
	
	// Constructor
	 public TestBase() 
		{

			try {
				
				prop = new Properties();
				FileInputStream ip = new FileInputStream("F:\\Eclipse1\\workspace\\AssignmentForSDETTestAutomation\\src\\main"
						+ "\\java\\com\\cowStudios\\qa\\config\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

	 // Initialization Method to call driver
	 public static void initialization ()
	 {
		 String browserName = prop.getProperty("browser");
		 
		 if(browserName.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver", "F:\\Eclipse1\\workspace\\AssignmentForSDETTestAutomation\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		 }
		 else if(browserName.equals("FF"))
		 {
			System.setProperty("webdriver.gecko.driver", "F:\\Eclipse1\\workspace\\AssignmentForSDETTestAutomation\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get(prop.getProperty("url"));
		 
	 } 
	 
	 
	 /*
	// Method to wait for element to be clickable
	    public static WebElement waitForElementToBeClickable(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Use Duration object
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
*/
}
