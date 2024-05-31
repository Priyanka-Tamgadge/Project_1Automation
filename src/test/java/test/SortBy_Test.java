package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.AddToCart;
import pageObject.HomePage;
import pageObject.ProceedToCheckout;
import pageObject.ReviewAndPayments;
import pageObject.SignIn;
import pageObject.SortBy;

public class SortBy_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	SortBy sb;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
    //  Verify_SortBy_Product_Name                    &                Printing them in console 
	@Test(priority =1)
	public void Verify_SortBy_Product_Name() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		sb= new SortBy(driver);
		
		sb.Sort_By_Name();
	
	}
	


    //  Verify_SortBy_Product_Price           &                Printing them in console    
	@Test(priority =2)
	public void Verify_SortBy_Product_Price() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		sb= new SortBy(driver);
		
		sb.Sort_By_Price();
		
	}
	

	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	
	

}
