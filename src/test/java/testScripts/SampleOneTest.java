package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class SampleOneTest {
	
	WebDriver driver;
	Properties prop;
	
	//@BeforeTest
	
/*	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	}*/
	
	
	
@Test(priority=1)
	
public void seleniumSearchTest() {
	//System.setProperty("webdriver.chrome.driver","E:\\Zuci\\webdriver\\chromedriver_win32\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();
   
	/*
	WebDriverManager.edgedriver().setup();
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	*/
	
    driver.get("https://www.google.com/");
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("Selenium Tutorial");
    searchBox.submit();
    AssertJUnit.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search Page");
  
    
  }

/*@Test

public void seleniumSearchTest() {
	driver.get("https://www.google.com/");
    WebElement searchBox = driver.findElement(By.name("q"));
    SoftAssert softAssert = new SoftAssert();
    
    softAssert.assertEquals(driver.getTitle(), "Google Page");
    searchBox.sendKeys("Selenium Tutorial");
    searchBox.submit();
    softAssert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search Page");
    softAssert.assertAll();
    
	}*/

@Test(alwaysRun=true, dependsOnMethods= "seleniumSearchTest") //This part execute first without using priority
	public void javaSearchTest() {
		 //System.setProperty("webdriver.chrome.driver","E:\\Zuci\\webdriver\\chromedriver_win32\\chromedriver.exe");
	    // WebDriver driver = new ChromeDriver();
		
		/*
		 WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		*/
		 driver.get(prop.getProperty("url"));
	    // driver.get("https://www.google.com/");
	     WebElement searchBox = driver.findElement(By.name("q"));
	     searchBox.sendKeys("Java Tutorial");
	     searchBox.submit();
	     AssertJUnit.assertEquals(driver.getTitle(), "Java Tutorial = Google Search");
	   
	
	
	}
@Test(enabled=false) //this part not executed because of using enabled=false
public void cucumberSearchTest() {
	  driver.get(prop.getProperty("url"));
	     WebElement searchBox = driver.findElement(By.name("q"));
	     searchBox.sendKeys("Cucumber Tutorial");
	     searchBox.submit();
	     AssertJUnit.assertEquals(driver.getTitle(), "Cucumber Tutorial = Google Search");
	   
	
	
	}
@BeforeTest
public void readFromProp() throws IOException {
	String path = System.getProperty("user.dir")+" //scr//test//resources//configFiles//config.properties";
	prop = new Properties();
	FileInputStream fin= new FileInputStream(path);
	prop.load(fin);
}
//@Parameter("browser")
@BeforeMethod
public void setup(String strBrowser) {
    if(strBrowser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
    else if(strBrowser.equalsIgnoreCase("edge")) {
    	WebDriverManager.edgedriver().setup();
    	driver = new EdgeDriver();
    	}
	driver.manage().window().maximize();
}

	
@AfterMethod
	
	public void teardown() {
		driver.close();
	}
	
}
