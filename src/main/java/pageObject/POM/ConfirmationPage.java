package pageObject.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "hero-primary")
	WebElement context;
	
	public String confirmationMessage(WebDriver driver) {
		String confirmationtext=context.getText();
		System.out.println(confirmationtext);
		return confirmationtext;
	}
	
	
}
