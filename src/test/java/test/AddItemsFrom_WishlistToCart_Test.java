package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.AddItemsFrom_WishlistToCart;
import pageObject.AddToWishList;
import pageObject.HomePage;
import pageObject.SignIn;
import pageObject.WhatsNewMenu;
import pageObject.WomenMenu;

public class AddItemsFrom_WishlistToCart_Test {
	
	WebDriver driver;
	
	HomePage hp;
	SignIn s;
	//WhatsNewMenu w;
	//WomenMenu wm;
	//AddToWishList awl;
	AddItemsFrom_WishlistToCart wc;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
//  Verify_AddAllTo_Cart_Button
	@Test(priority =1)
	public void Verify_AddAllTo_Cart_Button() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		wc = new AddItemsFrom_WishlistToCart(driver);
		
		wc.clickOnProfileBtn();
		wc.clickOn_My_Wish_List();
		wc.WishListed_Items();
		
		wc.Verify_AddAllTo_Cart_Button();
		
	}
	
	
	//  Verify_AddItemsFrom_WishlistToCart
	@Test(priority =2)
	public void Verify_AddItemsFrom_WishlistToCart() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		wc = new AddItemsFrom_WishlistToCart(driver);
		
		wc.clickOnProfileBtn();
		wc.clickOn_My_Wish_List();
		wc.WishListed_Items();
		
		wc.Add_Item_To_Cart();
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	

}
