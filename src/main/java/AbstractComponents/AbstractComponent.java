package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractComponent {


	WebDriver driver;
    WebDriverWait wait;
	
	@FindBy(css="button[routerlink*=cart]")
	WebElement cartHeader;
	
	public AbstractComponent(WebDriver driver)
	{
		
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy) 
	{
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void invisibilityOf(WebElement ele) 
	{
	
		

	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void elementToBeClickable(WebElement ele) 
	{
	
		

		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void goToCartPage()
	{

		elementToBeClickable(cartHeader);
		cartHeader.click();
		//Thread.sleep(3000);
	}
}
