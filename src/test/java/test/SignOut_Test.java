package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignIn;

public class SignOut_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	
   //  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		hp = new HomePage(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_HomePage_Title
	@Test(priority =1)
	public void Verify_HomePage_Title() throws InterruptedException
	{
		hp.url();
		hp.Homepage_title_should_be("Home Page");
	}
	
	
	//  areAllMenusAndLinksDisplayedProperly
	@Test(priority =2)
	public void areAllMenusAndLinksDisplayedProperly() throws InterruptedException
	{
		hp = new HomePage(driver);
		hp.url();
		hp.areAllMenusAndLinksDisplayed();
		System.out.println("All Menus And Links are Displayed");
	}
	
	
	 //  verify_SignOut_Functionality
		@Test(priority =3)
		public void verify_SignOut_Functionality() throws InterruptedException
		{
			s = new SignIn(driver);
			s.url();
			s.SignInMethod("Draco@gmail.com", "Draco@123");
			s.Homepage_title_should_be("Home Page");
			
			WebElement ProfileBtn=driver.findElement(By.xpath("//div[@class='panel header']/child::ul/child::li[2]/child::span/child::button"));
			WebElement LogOutBtn=driver.findElement(By.xpath("//ul[@class='header links']/child::li[3]/child::a[1]"));
			
			ProfileBtn.click();
			Thread.sleep(2000);
			
			LogOutBtn.click();
			Thread.sleep(5000);
			
			String Actual_Title1=driver.getTitle();
			String Expected_Title1="Home Page";
			Assert.assertEquals(Actual_Title1, Expected_Title1);
		
		}
		
		
		@AfterMethod
		public void close()
		{
			driver.quit();
		}
		
	
	
	

}
