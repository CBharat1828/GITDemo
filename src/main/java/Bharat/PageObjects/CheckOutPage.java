package Bharat.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Bharat.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
		
	}


	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".ta-item:last-of-type")
	WebElement selectCountry;
	@FindBy(css=".action__submit")
	WebElement submitOrder;
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{

Actions a1= new Actions(driver);
a1.sendKeys(country,countryName).build().perform();
waitForTheElementsToAppear(results);
selectCountry.click();
	}
	public ConfirmationPage submitOrder()
	{
		submitOrder.click();
		ConfirmationPage confirmationPage= new ConfirmationPage(driver);
		return confirmationPage;
	}
	
	
	
	
}
