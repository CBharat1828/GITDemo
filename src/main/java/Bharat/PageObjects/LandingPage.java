package Bharat.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bharat.AbstractComponents.AbstractComponent;

public class LandingPage  extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
		
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(css="#userEmail")
	WebElement Email;
	@FindBy(css="#userPassword")
	WebElement Password;
	@FindBy(css="#login")
	WebElement Submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		Email.sendKeys(email);
		Password.sendKeys(password);
		Submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public String  getErrorMessage()
	{
		waitForTheWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
