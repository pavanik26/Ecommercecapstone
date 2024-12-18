package capstone.Ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Additemtocart {
	
	@FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	private WebElement imgUS;    
	
    @FindBy(xpath = "//input[@id='gh-search-input']")
    private WebElement searchInput;   
    
	@FindBy(xpath = "//span[@class='header-search-icon']//*[name()='svg']")
	private WebElement searchBtn; 
    
	@FindBy(xpath = "(//div[contains(@class, 'sku-item')]//a)[1]")
	private WebElement firstProduct; 
	
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add to Cart'])[1]")
	private WebElement addToCart; 
	
	@FindBy(xpath = "//a[contains(@class, 'cart-link')]")
	private WebElement cartIcon; 
	
	@FindBy(xpath = "//ul[@class='item-list']")
	private WebElement cartItems; 
	
    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebElements
    public Additemtocart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
    }
   
    
	// Method to search product by entering text in searchbox
    public void searchProduct() {
		// TODO Auto-generated method stub   	
    	//imgUS.click(); //must be clicked on running the test individually
    	searchInput.sendKeys("laptop");    
    	searchBtn.click();
              
	}

    // Method to add searched product
    public void addProduct() {
		// TODO Auto-generated method stub
    	          
       // Wait for the product page to load"
          wait.until(ExpectedConditions.visibilityOf(addToCart)); // Wait for the 'Add to Cart' button

          addToCart.click();  // Click the 'Add to Cart' button
	}
    
    // Method to verifycart after adding poduct
    public void verifyCart() {
		// TODO Auto-generated method stub
    	cartIcon.click();  // Click the cart icon to view the cart

        // Wait for cart page to load
        wait.until(ExpectedConditions.visibilityOf(cartItems));        
                
    	String text = driver.findElement(By.xpath("//h2[@class='cart-item__title-heading']")).getText();
    	if(text.contains("Laptop"))
    	{ 
    		System.out.println("product added");
    	}
    	else
    	{
    		System.out.println("error occured while adding product");
    	}
        

       
	}
    
    

}
