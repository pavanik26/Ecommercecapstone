package JATTask24.Ecommerce;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import capstone.Ecommerce.Browsersetup;
import capstone.Ecommerce.Menuvalidation;
import capstone.Ecommerce.ScreenshotListner;

@Listeners(ScreenshotListner.class)
public class MenuvalidationTest {
	
	WebDriver driver;
	Menuvalidation MenuvalidationTestPage; 

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  @BeforeMethod
	    public void beforeTest() {
	        // Use the WebDriver from Browsersetup class
		    driver = Browsersetup.driver;
	        MenuvalidationTestPage = new Menuvalidation(driver);  // Initialize Menuvalidation page object
	    }
	
	    @Test
	    public void validateItemsFromMenu() {		    	
	    	MenuvalidationTestPage.validateMenuItemsInDeals();
	    	MenuvalidationTestPage.validateMenuItemsInSupport();
	    	MenuvalidationTestPage.validateMenuItemsInBrands();
	    	
	    }

}
