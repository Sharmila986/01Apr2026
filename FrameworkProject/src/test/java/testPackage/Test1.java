package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	@Test
	public void a() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		System.out.println("Hello world");
		System.out.println("Hi");
		System.out.println("Hello New Branch");
		System.out.println("Hello Child Brach");
		System.out.println("Hello Peter");
	}

}
