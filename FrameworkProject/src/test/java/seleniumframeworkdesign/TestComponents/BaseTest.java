package seleniumframeworkdesign.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumframeworkdesign.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException 
	{
		//Properties class
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\seleniumframeworkdesign\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			//Firefox
		}
		else if(browserName.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", "edge.exe");
			 driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		}
	
	@BeforeMethod
	public LandingPage lauchApplication() throws IOException
	{
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
