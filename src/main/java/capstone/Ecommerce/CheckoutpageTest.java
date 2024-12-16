package capstone.Ecommerce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListner.class)
public class CheckoutpageTest {

	WebDriver driver;
	Additemfrombrand addItemFromBrandTestPage; 

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  @BeforeMethod
	    public void beforeTest() {
	        // Use the WebDriver from Browsersetup class
	        driver = Browsersetup.driver;
	        addItemFromBrandTestPage = new Additemfrombrand(driver);  // Initialize Createaccount page object
	    }
	
	    @Test
	    public void testCheckOutAndPay() {	
	    	
	    	addItemFromBrandTestPage.checkoutPage();
	    	addItemFromBrandTestPage.verifyOrderStatus();
	    	
	    	
	    }
}
