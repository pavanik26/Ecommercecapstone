package capstone.Ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addfromshopfromdepartment {

	@FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	private WebElement imgUS;    
	
    @FindBy(xpath = "//button[normalize-space()='Menu']")
    private WebElement menuBtn;   
    
	@FindBy(xpath = "//button[normalize-space()='Appliances']//*[name()='svg']")
	private WebElement mainMenu; 
    
	@FindBy(xpath = "//button[normalize-space()='Major Kitchen Appliances']//*[name()='svg']")
	private WebElement submenuItem; 
	
	@FindBy(xpath = "//a[normalize-space()='Refrigerators']")
	private WebElement menuSelection; 
	
	@FindBy(xpath = "//a[@class='flex-link'][normalize-space()='French door refrigerators']")
	private WebElement itemtypeSelection; 
	
	@FindBy(xpath = "(//button[normalize-space()='Add to Cart'])[1]")
	private WebElement addtocartBtn; 
	
	@FindBy(xpath = "//a[contains(@class, 'cart-link')]")
	private WebElement cartIcon; 
	
	@FindBy(xpath = "//ul[@class='item-list']")
	private WebElement cartItems; 
	
    WebDriver driver;
    WebDriverWait wait; 

    // Constructor to initialize WebElements
      public Addfromshopfromdepartment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
    }
   
    
	// Method to search and add product from menu
    public void searchProductFromMenu() {
		// TODO Auto-generated method stub   	
    	//imgUS.click();  //must be clicked on running the test individually
    	menuBtn.click();
    	mainMenu.click();
    	submenuItem.click();
    	menuSelection.click();
    	itemtypeSelection.click();
    	addtocartBtn.click();
           
	}

    // Method to validate the added product
    public void verifyCart() {
		// TODO Auto-generated method stub
    	cartIcon.click();  // Click the cart icon to view the cart
        // Wait for cart page to load
        wait.until(ExpectedConditions.visibilityOf(cartItems));     
                
    	String text = driver.findElement(By.xpath("//h2[@class='cart-item__title-heading']")).getText();
    	if(text.equalsIgnoreCase("Refrigerator"))
    	{ 
    		System.out.println("product added");
    	}
    	else
    	{
    		System.out.println("error occured while adding product");
    	}
        

       
	}
}
