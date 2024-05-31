package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.AddToWishList;
import pageObject.HomePage;

import pageObject.SignIn;
import pageObject.WhatsNewMenu;
import pageObject.WomenMenu;

public class AddToWishList_Test {
	
	WebDriver driver;
	
	HomePage hp;
	SignIn s;
	AddToWishList awl;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_AddToWishList After Login
	@Test(priority =1)
	public void Verify_AddToWishList_After_Login() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		awl = new AddToWishList(driver);
		awl.Add_Item_To_WishList();
	}
	
	

//  Verify_Items_Inside_WishList
	@Test(priority =2)
	public void Verify_Items_Inside_WishList() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		awl = new AddToWishList(driver);
		System.out.println("My WishListed Items are: ");
		awl.WishListed_Items();
	}

	
	
	//  Verify_AddToWishList Without Login
	@Test(priority =3)
	public void Verify_AddToWishList_Without_Login() throws InterruptedException
	{
		hp = new HomePage(driver);
		hp.url();
		
		awl = new AddToWishList(driver);
		awl.Add_Item_To_WishList_without_Login();
		awl.PageTitle_Without_Login("Customer Login");
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
