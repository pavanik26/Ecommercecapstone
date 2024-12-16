package capstone.Ecommerce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

@Listeners(ScreenshotListner.class)
public class AddfromshopfromdepartmentTest {
	
	WebDriver driver;
	Addfromshopfromdepartment addItemFromMenuToCartTestPage; 

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  @BeforeMethod
	    public void beforeTest() {
	        // Use the WebDriver from Browsersetup class
	        driver = Browsersetup.driver;
	        addItemFromMenuToCartTestPage = new Addfromshopfromdepartment(driver);  // Initialize Createaccount page object
	    }
	
	    @Test
	    public void testAddProductFromMenu() {	
	    	
	    	addItemFromMenuToCartTestPage.searchProductFromMenu();
	    	addItemFromMenuToCartTestPage.verifyCart();
	    	
	    }


}
