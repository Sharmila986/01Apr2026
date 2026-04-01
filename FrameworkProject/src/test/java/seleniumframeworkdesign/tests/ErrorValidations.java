package seleniumframeworkdesign.tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumframeworkdesign.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	 @Test
	 public void submitOrder() throws IOException {
		
		String productName = "ZARA COAT 3";
       landingPage.loginApplication("Sharmila@gmail.com", "Allah786");
      Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    	
	}

}
