package capstone.Ecommerce;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UrlCheck {
	
	WebDriver driver;
	WebDriverWait wait;
	
	 // Constructor to initialize WebElements	
	  public UrlCheck(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
	    }

	public boolean isBrokenLink(String url) {
		try {
            // Create a URL object and open the connection
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");  // Send a GET request
            connection.connect();

            // Get the response code
            int responseCode = connection.getResponseCode();
            connection.disconnect();

            // Return true if the response code is not 200 (OK)
            return responseCode != HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            // Consider the URL broken if an exception occurs
            e.printStackTrace();
            return true;
        }
    }
}
