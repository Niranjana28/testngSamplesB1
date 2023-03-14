package testScripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTwoTest {
	WebDriver driver;
	@Test
	 public void cypressSearchTest() {
		
		
	    // System.setProperty("webdriver.chrome.driver","E:\\Zuci\\webdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
    	 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 // System.setProperty("webdriver.chrome.driver","E:\\Zuci\\webdriver\\chromedriver_win32\\chromedriver.exe");
	     //WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
 driver.get("https://www.google.com");
	     WebElement searchBox = driver.findElement(By.name("q"));
	     searchBox.sendKeys("Cypress Tutorial");
	     searchBox.submit();
	     Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
	     driver.close();
		// System.out.println("testExecution");
	
	}

}
