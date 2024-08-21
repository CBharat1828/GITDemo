package BharatPractice.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Bharat.PageObjects.CartPage;
import Bharat.PageObjects.CheckOutPage;
import Bharat.PageObjects.ConfirmationPage;
import Bharat.PageObjects.LandingPage;
import Bharat.PageObjects.OrdersPage;
import Bharat.PageObjects.ProductCatalogue;
import Bharat.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName="ZARA COAT 3";
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException
	{
			
	
ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));

WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

productCatalogue.getProductList();
productCatalogue.addProductToCart(input.get("productName"));

CartPage cartPage =productCatalogue.goToCart();

Boolean match=cartPage.verifyProductDisplay(input.get("productName"));
Assert.assertTrue(match);
CheckOutPage checkOutPage= cartPage.goToCheckOutPage();


checkOutPage.selectCountry("India");
ConfirmationPage confirmationPage=checkOutPage.submitOrder();

String confirmMessage=confirmationPage.getConfirmationMessage();
Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));



	}

	@Test(dependsOnMethods={"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue=landingPage.loginApplication("bharat1234@gmail.com", "Bharat@1234");
		OrdersPage ordersPage=productCatalogue.goToOrders();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>data= getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Bharat\\Data\\PurchaseOrder.jSon") ;
		
	return new Object[][] {{data.get(0)},{data.get(1)}};
	//return new Object[][] {{"bharat1234@gmail.com","Bharat@1234","ZARA COAT 3"},{"sai1234@gmail.com","Sai@1234","ADIDAS ORIGINAL"}};

		//HashMap<String,String>map= new HashMap<String,String>();
		//map.put("email", "bharat1234@gmail.com");
//		map.put("password", "Bharat@1234");
		//map.put("productName", "ZARA COAT 3");
		//
		//HashMap<String,String>map1= new HashMap<String,String>();
		//map1.put("email", "sai1234@gmail.com");
		//map1.put("password", "Sai@1234");
		//map1.put("productName", "ADIDAS ORIGINAL");
	
	}
	




	}


