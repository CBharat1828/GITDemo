package Bharat.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Bharat.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tr /td[2]")
	List<WebElement>orderNames;
	

	public Boolean verifyOrderDisplay(String productName)
	{
		Boolean match=orderNames.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	

}
