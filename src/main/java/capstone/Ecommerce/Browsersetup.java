package capstone.Ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Browsersetup {	
	
	public static WebDriver driver;

	
	//setting up browser and opening the website
	@BeforeSuite
    public void setUp() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
            
    }
	
	
	//closing the browser after all tests are executed
	 @AfterSuite
	    public void tearDown() {
	        // Close the browser and end the session
	        if (driver != null) {
	            driver.quit(); // This will close all browser windows and terminate the session
	            System.out.println("Browser closed after all tests are completed.");
	        }
	    }

}
