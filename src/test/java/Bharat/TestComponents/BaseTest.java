package Bharat.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Bharat.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver InitializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		
	
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Bharat\\Resources\\GlobalData.properties\\");
		
		prop.load(fis);
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		
		}
		else
		{
			//WebDriver driver =new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	public  List<HashMap<String, String>> getJsonToMap(String filePath) throws IOException
	{
		//read json to string
		String JsonContent=FileUtils.readFileToString(new File(filePath));

	
	//string to HashMap
	ObjectMapper mapper = new ObjectMapper();
	
	List<HashMap<String, String>>data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	
	return data;
	
	}
	public String getScreenshot(String testCaseName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
		return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	}
	
		
	@BeforeMethod(alwaysRun=true)
		public LandingPage launchApplication() throws IOException
		{
			driver=InitializeDriver();
			landingPage = new LandingPage(driver);
			landingPage.goTo();
			return landingPage;
		}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
		
	
	
	
	
	
	
	
	

}
