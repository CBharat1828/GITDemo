package Bharat.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Bharat.AbstractComponents.AbstractComponent;

public class CartPage  extends AbstractComponent{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	@FindBy(css=".cartSection h3")
	List<WebElement>cartProducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement proceedToCheckOut;
	
	
	
	
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match=cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	
public CheckOutPage goToCheckOutPage()
{
	proceedToCheckOut.click();
	CheckOutPage checkOutPage = new CheckOutPage(driver);
	return checkOutPage;
}
}
