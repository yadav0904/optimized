package frameworkTest.frameworkTest.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworkTest.frameworkTest.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.POM.CartPage;
import pageObject.POM.CheckOutPage;
import pageObject.POM.ConfirmationPage;
import pageObject.POM.LandingPage;
import pageObject.POM.ProductCatalogue;

public class SubmitTest extends BaseTest{

	
@Test
public void submitOrder() throws IOException {
		String productname="ZARA COAT 3";
		//user email id and password with login 
		String username="ankit0904@gmail.com";  	
		String password="Ankit@123";
		
		
		LandingPage landingpage=launchApplication();
		landingpage.loginApplication(username, password);
		
		ProductCatalogue productCatalogue=landingpage.loginApplication(username, password);
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productname);

		
		//clicking on cart and proceeding ahead
		productCatalogue.goToCartPage();		
		
		
		//CArt Section
		CartPage cartPage=new CartPage(driver);
		
		Boolean match=cartPage.VerifyProductDispaly(productname);
		
		
		Assert.assertTrue(match);
		
		//checkout page
		cartPage.goToCheckOut(driver);
		
		//payment method
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		
		checkOutPage.fillCheckOutForm(driver); 
		
		String countryName="India";
		checkOutPage.selectCountry(countryName);
		
		checkOutPage.placeOrder(driver);

		//Thank you page
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		String confirmMmessage=confirmationPage.confirmationMessage(driver);
	
		AssertJUnit.assertTrue(confirmMmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

	}

}
