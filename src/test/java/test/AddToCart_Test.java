package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.AddToCart;
import pageObject.AddToWishList;
import pageObject.HomePage;
import pageObject.SignIn;
import pageObject.WhatsNewMenu;
import pageObject.WomenMenu;

public class AddToCart_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	AddToCart atc;
	
	
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_AddToCart_After_Login
	@Test(priority =1)
	public void Verify_AddToCart_After_Login() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		atc = new AddToCart(driver);
		
		atc.Add_Item_To_Cart();
		
	}
	
	
   //  AddItemToCart_Without_Size_and_Colour
	@Test(priority =2)
	public void AddItemToCart_Without_Size_and_Colour() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		atc = new AddToCart(driver);
		
		//atc.Add_Item_To_Cart();
		atc.AddItemToCart_Without_Size_and_Colour();
	}
	
	
	
//  Verify_AddToCart_Without_Login
	@Test(priority =3)
	public void Verify_AddToCart_Without_Login() throws InterruptedException
	{
		
		hp = new HomePage(driver);
		hp.url();
		
		atc = new AddToCart(driver);
		atc.Add_Item_To_Cart();
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
