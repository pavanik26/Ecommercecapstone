package capstone.Ecommerce;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Signuppage {
	
	
	   // WebElements for SignUp page
	   
	    @FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	    private WebElement imgUS;  
	    
	    @FindBy(xpath = "//span[@class='v-p-right-xxs line-clamp']")
	    private WebElement account;      
	
		@FindBy(xpath = "//a[text()='Sign In']")
		private WebElement signUp;
		
	    @FindBy(xpath = "//input[@id='fld-e']")
	    private WebElement emailAddress;
	    
	    @FindBy(xpath = "//button[normalize-space()='Continue']")
	    private WebElement continueBtn;
	    
	    @FindBy(xpath = "//input[@id='password-radio']")
	    private WebElement pwdRadio;	    

	    @FindBy(xpath = "(//input[@id='fld-p1'])")
	    private WebElement passwordField;
	    
	    @FindBy(xpath = "//button[normalize-space()='Skip for now']")
	    private WebElement skipText;	    

	    @FindBy(xpath = "//button[text()='Sign In']")
	    private WebElement signInButton;
	   
	    
	    WebDriver driver;
	    WebDriverWait wait;
	    // Constructor to initialize WebElements
	    public Signuppage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
	    }
	    
		// Method to click signup first
	    public void clickSignUp() {
			// TODO Auto-generated method stub
	    	imgUS.click(); //must be clicked on running the test individually
	    	account.click();
	       	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.elementToBeClickable(signUp));
	    	//createAccountLink.click();
	    	
	    	signUp.click();
		}

	    // Method to enter email address
	    public void enterEmailAddress(String email) {
			// TODO Auto-generated method stub
	    	emailAddress.sendKeys(email);
	    	continueBtn.click();
	    	wait.until(ExpectedConditions.elementToBeClickable(pwdRadio));
	    	pwdRadio.click();
		}

	    // Method to enter password
	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    // Method to click on sign up button
	    public void clickSignUpButton() {
	    	//signInButton.click();
	    	continueBtn.click();
	    	wait.until(ExpectedConditions.elementToBeClickable(skipText));
	    	 // Check if the button is displayed
	         if (skipText.isDisplayed()) {
	                skipText.click();
	            } else {
	                System.out.println("'Skip for now' button is not displayed.");
	            }
	        
	         }

}
