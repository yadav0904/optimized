package pageObject.POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	WebDriverWait wait;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".form__cc input.text-validated")
	WebElement ccnumber;	
	
	@FindBy(xpath = "//div[text()='CVV Code ']/following-sibling::input")
	WebElement CVVnumber;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement NameonCard;
	
	
	public void fillCheckOutForm(WebDriver driver)
	{
		ccnumber.sendKeys("4542 9931 9292 2293");
		CVVnumber.sendKeys("123");
		NameonCard.sendKeys("Ankit Yadav");
	}
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(css="//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
		
	
	public void selectCountry(String countryName)
	{
		Actions a =new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		
			
	}
	
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	public ConfirmationPage placeOrder(WebDriver driver)
	{
		
		placeorder.click();
		
		return new ConfirmationPage(driver);
	}
	
	





}
