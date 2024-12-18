package JATTask24.Ecommerce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import capstone.Ecommerce.Browsersetup;
import capstone.Ecommerce.ScreenshotListner;
import capstone.Ecommerce.Signuppage;


@Listeners(ScreenshotListner.class)
public class SignupTest {
	
	WebDriver driver;
	Signuppage signUpPage;
	WebDriver wait;

	 @BeforeMethod
	    public void beforeTest() {
	        // Use the WebDriver from Browsersetup class
	        driver = Browsersetup.driver;
	        signUpPage = new Signuppage(driver);  // Initialize Signup page object
	    }

	
	    @Test
	    public void testSignUp() {	      
	        // Perform actions
		    signUpPage.clickSignUp();
		    signUpPage.enterEmailAddress("pavani.k26@gmail.com");
	        signUpPage.enterPassword("Testabc@12345");
	        signUpPage.clickSignUpButton();

	        // Assertion to verify successful sign-up
	      
	        String message = driver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']")).getText();
	    	if(message.contains("Hi"))
	    	{ 
	    		System.out.println("Signin successful");
	    	}
	    	else
	    	{
	    		System.out.println("error occured while sign in");
	    	}
	        

	      
	    }
	 



}
