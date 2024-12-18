package JATTask24.Ecommerce;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import capstone.Ecommerce.Browsersetup;
import capstone.Ecommerce.Createaccount;
import capstone.Ecommerce.ScreenshotListner;

@Listeners(ScreenshotListner.class)
public class CreateaccountTest {
	
	WebDriver driver;
	Createaccount createAccountPage; 

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  @BeforeMethod
	    public void beforeTest() {
	        // Use the WebDriver from Browsersetup class
	        driver = Browsersetup.driver;
	        createAccountPage = new Createaccount(driver);  // Initialize Createaccount page object
	    }
	
	    @Test
	    public void testCreateAccount() {	      
	        // Perform actions
	    	createAccountPage.clickAccount();	    	
	        createAccountPage.enterFName("Testabc");
	    	createAccountPage.enterLName("Testabc");
	    	createAccountPage.enterPassword("Testabc@12345");
	    	createAccountPage.enterConfirmPassword("Testabc@12345");
	    	createAccountPage.enterEmailAddress("pavani.k26@gmail.com");
	    	createAccountPage.enterMobileNumber("9177673612");
	    	createAccountPage.clickCreateAccountButton();
            
	    	String message = driver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']")).getText();
	    	if(message.contains("Hi"))
	    	{ 
	    		System.out.println("account creation successful");
	    	}
	    	else
	    	{
	    		System.out.println("error occured while creating account");
	    	}
	        
	    }
	    
	 
}
