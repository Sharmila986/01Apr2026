package seleniumframeworkdesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframeworkdesign.AbstractComponenets.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		//initializaion
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
    //PageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	//div[@class='ng-tns-c4-6 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	
	
	public ProductCatalogue loginApplication(String email,String pass) 
	{
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}

