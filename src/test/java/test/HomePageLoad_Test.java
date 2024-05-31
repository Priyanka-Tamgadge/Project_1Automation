package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class HomePageLoad_Test {
	
	WebDriver driver;
	HomePage hp;
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		hp = new HomePage(driver);
		Thread.sleep(3000);
	}
	
	
	@Test(priority =1)
	public void enterURL() throws InterruptedException
	{
		hp.url();
        System.out.println("Url is entered");
	}
	
	
	@Test(priority =2)
	public void verifyPageTitle() throws InterruptedException
	{
	    hp.url();
		hp.Homepage_title_should_be("Home Page");
	}
	
	
	@Test(priority =3)
	public void areAllMenusAndLinksDisplayedProperly() throws InterruptedException
	{
	    hp.url();
		hp.areAllMenusAndLinksDisplayed();
		System.out.println("All Menus And Links are Displayed");
	}
	

	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	
	

}
