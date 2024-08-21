package Bharat.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Bharat.PageObjects.CartPage;
import Bharat.PageObjects.OrdersPage;

public class AbstractComponent {
WebDriver driver;
	
	

public AbstractComponent(WebDriver driver) {
	this.driver=driver;
	// TODO Auto-generated constructor stub
	PageFactory.initElements(driver, this);
}
@FindBy(css="button[routerlink='/dashboard/cart']")
WebElement proceedToCart;
@FindBy(css="button[routerlink='/dashboard/myorders']")
WebElement proceedToOrders;


public void waitForTheElementsToAppear(By findBy)
{
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	
}

public void waitForTheWebElementToAppear(WebElement findBy)
{
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOf(findBy));
	
}




public void waitForTheElementsToDisappear(WebElement ele) throws InterruptedException
{
	Thread.sleep(1000);
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.invisibilityOf(ele));
}

public CartPage goToCart()
{
	proceedToCart.click();
	CartPage cartPage = new CartPage(driver);
	return cartPage;
}
public OrdersPage goToOrders()
{
	proceedToOrders.click();
OrdersPage ordersPage = new OrdersPage(driver);
return ordersPage;
}
	
}
