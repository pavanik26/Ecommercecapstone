package JATTask24.Ecommerce;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import capstone.Ecommerce.ScreenshotListner;

import capstone.Ecommerce.Additemtocart;
import capstone.Ecommerce.Browsersetup;

@Listeners(ScreenshotListner.class)
public class AdditemtocartTest {
	
	WebDriver driver;
	Additemtocart addItemToCartTestPage; 

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  @BeforeMethod
	    public void beforeTest() {
	        // Use the WebDriver from Browsersetup class
	        driver = Browsersetup.driver;
	        addItemToCartTestPage = new Additemtocart(driver);  // Initialize Additemtocart page object
	    }
	
	    @Test
	    public void testAddProduct() {	    	
	    	addItemToCartTestPage.searchProduct();
	    	addItemToCartTestPage.addProduct();
	    	addItemToCartTestPage.verifyCart();
	    	
	    }

}
