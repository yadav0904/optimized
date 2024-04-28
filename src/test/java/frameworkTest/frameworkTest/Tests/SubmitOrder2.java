package frameworkTest.frameworkTest.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder2 {

	@Test
	public void standAloneTest2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String productname="ZARA COAT 3";
		//user email id and password with login 
		String username="ankit0904@gmail.com";
		String password="Ankit@123";
	driver.findElement(By.id("userEmail")).sendKeys(username);
	driver.findElement(By.id("userPassword")).sendKeys(password);
		
		driver.findElement(By.id("login")).click();
			
		////login is succesful till now
		//selecting product
//		List<WebElement> products=driver.findElements(By.xpath("//div/h5/b"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));		
		
		
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));		
		
		//clicking on cart and proceeding ahead
		WebElement cartbutton=driver.findElement(By.cssSelector("button[routerlink*='cart']"));
		wait.until(ExpectedConditions.elementToBeClickable(cartbutton));
		cartbutton.click();
		Thread.sleep(3000);		
		
		
		//CArt Section
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		
		
		
		Assert.assertTrue(match);
		
		//checkout page
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//payment method
		WebElement ccnumber=driver.findElement(By.cssSelector(".form__cc input.text-validated"));
		ccnumber.sendKeys("4542 9931 9292 2293");
		
		WebElement CVVnumber=driver.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input"));
		CVVnumber.sendKeys("123");
		
		WebElement NameonCard=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		NameonCard.sendKeys("Ankit Yadav");
		
		
		
		Actions a =new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		WebElement placeorder=driver.findElement(By.cssSelector(".action__submit"));
		placeorder.click();

		//Thank you page
		String confirmMmessage=driver.findElement(By.className("hero-primary")).getText();
	
		AssertJUnit.assertTrue(confirmMmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	
	}
}
