package pageObject.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;

	public Boolean VerifyProductDispaly(String productname) {
		Boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		return match;
	}
	

	
	@FindBy(css=".totalRow button")
	WebElement checkOutEle;
	public CheckOutPage goToCheckOut(WebDriver driver) {
		checkOutEle.click();
		
		return new CheckOutPage(driver);
	}
	
	
	
	
	
}
