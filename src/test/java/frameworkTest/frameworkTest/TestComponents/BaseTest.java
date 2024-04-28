package frameworkTest.frameworkTest.TestComponents;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.POM.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/ankityadav/EclipseWS/frameworkTest2_optimised/src/main/java/resources/GlobalData.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chromee")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();

		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
	
		driver=initializeDriver();
		LandingPage landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;

	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
}
