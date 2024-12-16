package capstone.Ecommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menuvalidation {
	
	@FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	private WebElement imgUS;  
	
	@FindBy(xpath = "//button[normalize-space()='Menu']")
    private WebElement menuBtn;   
    
	@FindBy(xpath = "//button[normalize-space()='Deals']")
	private WebElement dealsMenu; 
    
	@FindBy(xpath = "//button[normalize-space()='Support & Services']")
	private WebElement supportMenu; 
	
	@FindBy(xpath = "//button[normalize-space()='Brands']")
	private WebElement brandsMenu; 
	
	@FindBy(xpath = "//button[contains(@class,'c-button-unstyled close-button-sidecar')]")
	private WebElement closeBtn; 
		
    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebElements
    public Menuvalidation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
    }
   
    //method to validate items under Deals menu
    public void validateMenuItemsInDeals() {
    	//imgUS.click(); //must be clicked on running the test individually
    	menuBtn.click();
    	dealsMenu.click();
        List<WebElement> menuItems = driver.findElements(By.xpath("//div[contains(@class, 'hamburger-menu-flyout-list-item-wrapper')]/ul/li"));

        // Iterate over each <li> element
        for (WebElement item : menuItems) {
            // Log the content of the <li> element
            System.out.println("Li Content: " + item.getAttribute("outerHTML"));

            // Find all <a> tags inside the <li> element
            List<WebElement> anchors = item.findElements(By.xpath(".//a"));

            // Log the number of <a> tags found
            System.out.println("Number of <a> tags found in this <li>: " + anchors.size());

            // If there are any <a> tags, print the text of the first one
            if (!anchors.isEmpty()) {
                for (WebElement anchor : anchors) {
                    System.out.println("Anchor Text: " + anchor.getText());
                }
            } else {
                System.out.println("No <a> tag found in this <li> element.");
             }
         }

}
    
    
  //method to validate items under support and services menu
    public void validateMenuItemsInSupport() {
    	supportMenu.click();
        List<WebElement> menuItems = driver.findElements(By.xpath("//div[contains(@class, 'hamburger-menu-flyout-list-item-wrapper')]/ul/li"));

        // Iterate over each <li> element
        for (WebElement item : menuItems) {
            // Log the content of the <li> element
            System.out.println("Li Content: " + item.getAttribute("outerHTML"));

            // Find all <a> tags inside the <li> element
            List<WebElement> anchors = item.findElements(By.xpath(".//a"));

            // Log the number of <a> tags found
            System.out.println("Number of <a> tags found in this <li>: " + anchors.size());

            // If there are any <a> tags, print the text of the first one
            if (!anchors.isEmpty()) {
                for (WebElement anchor : anchors) {
                    System.out.println("Anchor Text: " + anchor.getText());
                }
                
            } else {
                System.out.println("No <a> tag found in this <li> element.");
             }
            
        }

}
  
    //method to validate items under Brands menu
    public void validateMenuItemsInBrands() {
    	brandsMenu.click();
        List<WebElement> menuItems = driver.findElements(By.xpath("//div[contains(@class, 'hamburger-menu-flyout-list-item-wrapper')]/ul/li"));

        // Iterate over each <li> element
        for (WebElement item : menuItems) {
            // Log the content of the <li> element
            System.out.println("Li Content: " + item.getAttribute("outerHTML"));

            // Find all <a> tags inside the <li> element
            List<WebElement> anchors = item.findElements(By.xpath(".//a"));

            // Log the number of <a> tags found
            System.out.println("Number of <a> tags found in this <li>: " + anchors.size());

            // If there are any <a> tags, print the text of the first one
            if (!anchors.isEmpty()) {
                for (WebElement anchor : anchors) {
                    System.out.println("Anchor Text: " + anchor.getText());
                }
            } else {
                System.out.println("No <a> tag found in this <li> element.");
             }
                       
        }
       }
    
}
