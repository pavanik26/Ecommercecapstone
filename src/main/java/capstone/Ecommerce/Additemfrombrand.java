package capstone.Ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Additemfrombrand {
	
	@FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	private WebElement imgUS;    
	
	@FindBy(xpath = "//button[normalize-space()='Menu']")
	private WebElement menuBtn;
	
    @FindBy(xpath = "//button[normalize-space()='Brands']//*[name()='svg']")
    private WebElement menuBrands;   
    
	@FindBy(xpath = "//a[normalize-space()='Samsung']")
	private WebElement itemBrand; 
    
	@FindBy(xpath = "//a[@class='flex-link'][normalize-space()='TV and home theater']")
	private WebElement itemname; 
		
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Add to Cart'])[1]")
	private WebElement addtocartBtn; 
	
	@FindBy(xpath = "//a[contains(@class, 'cart-link')]")
	private WebElement cartIcon; 
	
	@FindBy(xpath = "//ul[@class='item-list']")
	private WebElement cartItems; 
	
	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	private WebElement checkoutBtn; 
	
	@FindBy(xpath = "//span[contains(text(),'Continue to Payment Information')]")
	private WebElement paymentinfoBtn; 
	
	@FindBy(xpath = "//input[@id='cc-number']")
	private WebElement ccnumberField; 
	
	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement fnameText; 
	
	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement lnameText; 
	
	@FindBy(xpath = "//input[@id='address-input']")
	private WebElement addText; 
	
	@FindBy(xpath = "//input[@id='city']")
	private WebElement cityText; 
	
	@FindBy(xpath = "//select[@id='state']")
	private WebElement stateSelect; 
	
	@FindBy(xpath = "//input[@id='postalCode']")
	private WebElement zipcodeText;
	
	@FindBy(xpath = "//span[contains(text(),'Place Your Order')]")
	private WebElement placeorderBtn;
	
	@FindBy(xpath = "//img[@title='Best Buy Help']")
	private WebElement imgBanner;
	
    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebElements
    public Additemfrombrand(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
    }
    
	// Method to search and add product from brand
    public void searchProductFromBrand() {
		// TODO Auto-generated method stub   	
    	//imgUS.click();  //must be clicked on running the test individually
    	menuBtn.click();
    	menuBrands.click();
    	itemBrand.click();
    	itemname.click();
      	wait.until(ExpectedConditions.elementToBeClickable(addtocartBtn)); 
    	addtocartBtn.click();
     
	}

    // Method to validate the product added in cart
    public void verifyCart() {
		// TODO Auto-generated method stub
    	cartIcon.click();  // Click the cart icon to view the cart

        // Wait for cart page to load
        wait.until(ExpectedConditions.visibilityOf(cartItems));        
                
    	String text = driver.findElement(By.xpath("//h2[@class='cart-item__title-heading']")).getText();
    	if(text.equalsIgnoreCase("TV"))
    	{ 
    		System.out.println("product added");
    	}
    	else
    	{
    		System.out.println("error occured while adding product");
    	}
    }
        
      // Method to click on checkout page after adding products
    	public void checkoutPage() {
    		// TODO Auto-generated method stub
    		
    		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
    		checkoutBtn.click();  
            // Wait for payment page to load
            wait.until(ExpectedConditions.elementToBeClickable(paymentinfoBtn));
            paymentinfoBtn.click();
            ccnumberField.sendKeys("1234 5678 9012 3456"); 
            fnameText.sendKeys("Testfname");
            lnameText.sendKeys("Testlname");
            addText.sendKeys("Flat no-101, Sri Nilayam");
            cityText.sendKeys("Akron");
            stateSelect.sendKeys("NY");
            zipcodeText.sendKeys("44203");
            placeorderBtn.click();
            
	}
    	
       // Method to verify Order status once placing an Order
		public void verifyOrderStatus() {
			// TODO Auto-generated method stub

        	String text = driver.findElement(By.xpath("//div[@id='order-success']/h1")).getText();
        	if(text.equalsIgnoreCase("Your order has been placed successfully!"))
        	{ 
        		System.out.println("Order placed successfully");
        	}
        	else
        	{
        		System.out.println("Error occured while placing Order");
        	}            
       
			
		}

}
