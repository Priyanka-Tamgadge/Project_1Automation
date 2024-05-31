package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyWishList;
import pageObject.SignIn;

public class MyWishList_Test {
	
	WebDriver driver;
	SignIn s;
	MyWishList mw;
	HomePage hp;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
		
	
	//  Verify_My_Wish_List_Option
	@Test(priority =1)
	public void Verify_My_Wish_List_Option() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		mw = new MyWishList(driver);
		
		mw.isProfileBtnDisplayed();
		mw.clickOnProfileBtn();
		
		mw.isMy_Wish_ListFieldDisplayed();
		System.out.println("My_Wish_List Field Displayed");
		
		mw.clickOn_My_Wish_List();
		mw.My_Wish_List_PageTitle("My Wish List");
	}
	

	
//  Accessing My WishList Page
	@Test(priority =2)
	public void Accessing_My_WishList_Page() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		mw = new MyWishList(driver);
		
		mw.isProfileBtnDisplayed();
		mw.clickOnProfileBtn();
		
		mw.isMy_Wish_ListFieldDisplayed();
		
		mw.clickOn_My_Wish_List();
		mw.My_Wish_List_PageTitle("My Wish List");
		
		mw.WishListed_Items();
	}

	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
