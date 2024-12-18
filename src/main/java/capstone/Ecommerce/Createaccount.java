package capstone.Ecommerce;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Createaccount {
	
	// WebElements for Create account page	   
	
	@FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	private WebElement imgUS;    
	
    @FindBy(xpath = "//span[@class='v-p-right-xxs line-clamp']")
    private WebElement account;   
    
	@FindBy(xpath = "//a[text()='Create Account']")
	private WebElement createAccountLink;
    
    @FindBy(id = "firstName")
    private WebElement fName;    
    
    @FindBy(id = "lastName")
    private WebElement lName;    
    
    @FindBy(id = "email")
    private WebElement emailAddress;  
    
    @FindBy(id = "fld-p1")
    private WebElement passwordField;  
    
    @FindBy(id = "reenterPassword")
    private WebElement confirmPassword;  
    
    @FindBy(id = "phone")
    private WebElement phoneNumber; 
    
	@FindBy(xpath = "//button[text()='Create an Account']")
	private WebElement createAccountBtn;
	
	        
    WebDriver driver;
    WebDriverWait wait;
    // Constructor to initialize WebElements
    public Createaccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
    }
   
    
	// Method to click signup first
    public void clickAccount() {
		// TODO Auto-generated method stub   	
    	imgUS.click();  //must be clicked only for the first time on running entire test suite 
    	account.click();
       	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(createAccountLink));
    	createAccountLink.click();
	}

    // Method to enter first name
    public void enterFName(String fname) {
		// TODO Auto-generated method stub
    	fName.sendKeys(fname);
	}
    
    // Method to enter last name
    public void enterLName(String lname) {
		// TODO Auto-generated method stub
    	lName.sendKeys(lname);
	}
    
    // Method to enter email address
    public void enterEmailAddress(String email) {
		// TODO Auto-generated method stub
    	emailAddress.sendKeys(email);
	}

    // Method to enter password
    public void enterPassword(String password) {
    	passwordField.sendKeys(password);
    }
    
    // Method to enter confirm password
    public void enterConfirmPassword(String password) {
    	confirmPassword.sendKeys(password);
    }

    // Method to enter mobile number
    public void enterMobileNumber(String number) {
    	phoneNumber.sendKeys(number);
    }

    // Method to click on create account button
    public void clickCreateAccountButton() {
    	createAccountBtn.click();
    }
   

}
