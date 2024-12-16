package capstone.Ecommerce;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListner.class)
public class UrlTest {

	  UrlCheck urlCheckPage = new UrlCheck(Browsersetup.driver);

	
	 @Test
	    public void testUrlCheck() {
	     
		 String currentUrl = Browsersetup.driver.getCurrentUrl();
	     // Check if the URL is broken
	     boolean isBroken = urlCheckPage.isBrokenLink(currentUrl);
	     // Assert that the URL is not broken
	     Assert.assertFalse(isBroken, "The URL " + currentUrl + " is broken.");

	    }
	
}
	 

