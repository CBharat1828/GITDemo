package BharatPractice.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Bharat.PageObjects.ProductCatalogue;
import Bharat.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest{

	
	@Test
	public void loginErrorValidaton()
	{
		
	landingPage.loginApplication("bharat1234@gmail.com", "Bharat1234");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());;
		
	
	}
	
	
	
	
	
	
	
	
	
}
