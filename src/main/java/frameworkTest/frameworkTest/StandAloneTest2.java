package frameworkTest.frameworkTest;

import java.time.Duration;
import java.util.List;
import org.testng.Assert;

import com.fasterxml.jackson.core.sym.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.POM.CartPage;
import pageObject.POM.CheckOutPage;
import pageObject.POM.ConfirmationPage;
import pageObject.POM.LandingPage;
import pageObject.POM.ProductCatalogue;
import pageObject.POM.CartPage;

public class StandAloneTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String productname="ZARA COAT 3";
		//user email id and password with login 
		String username="ankit0904@gmail.com";
		String password="Ankit@123";
		
		LandingPage landingpage=new LandingPage(driver);
		landingpage.goTo();
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
	
		Assert.assertTrue(confirmMmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	
	}

}
