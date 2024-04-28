package pageObject.POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userEmail=driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userpassword;

	@FindBy(id = "login")
	WebElement submit;

	//Initializing object of Prodoct catalogue in this method
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userpassword.sendKeys(password);

		submit.click();
		return new ProductCatalogue(driver);
		
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
