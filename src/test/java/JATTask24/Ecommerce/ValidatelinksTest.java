package JATTask24.Ecommerce;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import capstone.Ecommerce.Browsersetup;
import capstone.Ecommerce.ScreenshotListner;
import capstone.Ecommerce.Validatelinks;

@Listeners(ScreenshotListner.class)
public class ValidatelinksTest {
	
	WebDriver driver;
	Validatelinks validateLinksPage; 

	WebDriverWait wait;
	
	  @BeforeMethod
	    public void beforeTest() {
	        // Use the WebDriver from Browsersetup class
	        driver = Browsersetup.driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	        validateLinksPage = new Validatelinks(driver);  // Initialize Validatelinks page object
	    }
	
	 @Test
	    public void testFooterLinks() {
	        // Instantiate the FooterLinksPage	       
	        // Validate all the links in the footer
		   validateLinksPage.validateFooterLinks();
	    }

}
