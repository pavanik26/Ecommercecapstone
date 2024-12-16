package capstone.Ecommerce;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Validatelinks {
	
	// WebElements for Validatelinks page
	
	@FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	private WebElement imgUS;  
	   
    @FindBy(xpath = "//div[@class='flex justify-content-start']")
    private WebElement footerLinks;  
    
    
    WebDriver driver;
    WebDriverWait wait;
    
    // Constructor to initialize WebElements
     public Validatelinks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
    }
   
     // Method to retrieve the links
    public void validateFooterLinks() {
    	//imgUS.click(); //must be clicked on running the test individually
    	 WebElement footerSection = driver.findElement(By.xpath("//div[@class='flex justify-content-start']"));
       List<WebElement> links = footerSection.findElements(By.tagName("a"));

        for (WebElement link : links) {
           // String linkText = link.getText();
            String linkUrl = link.getAttribute("href");
            verifyLink(linkUrl);          
          
        }
        }   
    
    // Method to validate all footer links
       public void verifyLink(String url) {
    	try {
    	URL link = new URL(url);
    	HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
    	httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
    	httpURLConnection.connect();


    	if (httpURLConnection.getResponseCode() == 200) {
    	System.out.println(url + " - " + httpURLConnection.getResponseMessage());
    	} else {
    	System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
    	}
    	} catch (Exception e) {
    	System.out.println(url + " - " + "is a broken link");
    	}
 
}
}

