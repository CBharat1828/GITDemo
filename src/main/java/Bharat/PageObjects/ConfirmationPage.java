package Bharat.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Bharat.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(css=".hero-primary")
	WebElement ConfirmMessage;
	
	
	public String getConfirmationMessage()
	{
		
	
	return ConfirmMessage.getText();
	
	}
}
