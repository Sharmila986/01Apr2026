package seleniumframeworkdesign.tests;



import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumframeworkdesign.TestComponents.BaseTest;
import seleniumframeworkdesign.pageobjects.CartPage;
import seleniumframeworkdesign.pageobjects.CheckoutPage;
import seleniumframeworkdesign.pageobjects.ConfirmationPage;
import seleniumframeworkdesign.pageobjects.LandingPage;
import seleniumframeworkdesign.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	 @Test
	 public void submitOrder() throws IOException {
		
		String productName = "ZARA COAT 3";
        ProductCatalogue productcatalogue = landingPage.loginApplication("Sharmila@gmail.com", "Allah786!");
		List<WebElement> products=productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartPage = productcatalogue.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	
		
		
	}

}
