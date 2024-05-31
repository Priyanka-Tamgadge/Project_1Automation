package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyCart;
import pageObject.MyWishList;
import pageObject.SignIn;

public class MyCart_Test {

		WebDriver driver;
		
		SignIn s;
		MyCart mc;
		HomePage hp;
		
		//  launchBrowser
		@BeforeMethod
		public void launchBrowser() throws InterruptedException
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			mc = new MyCart(driver);
			Thread.sleep(3000);
		}

		
		//  Verify_MyCart_Link_Without_Login
		@Test(priority =1)
		public void Verify_MyCart_Link_Without_Login() throws InterruptedException
		{
			hp = new HomePage(driver);
			hp.url();
			
			mc.isMyCart_LinkDisplayed();
			mc.clickOnMyCart_Link();
			
			mc.isError_MsgDisplayed();
			mc.GetErrorMessage();
		}
		
		
	//  Verify_MyCart_Link_After_Login
			@Test(priority =2)
			public void Verify_MyCart_Link_After_Login() throws InterruptedException
			{
				s = new SignIn(driver);
				s.SignInMethod("Draco@gmail.com", "Draco@123");
				Thread.sleep(2000);	
				
				String Actual_Title=driver.getTitle();
				String Expected_Title="Home Page";
				Assert.assertEquals(Actual_Title, Expected_Title);
				
				mc.isMyCart_LinkDisplayed();
				mc.clickOnMyCart_Link();
				
				mc.isProceed_to_Checkout_BtnDisplayed();
				
				mc.isView_and_Edit_Cart_LinkDisplayed();
				mc.clickOnView_and_Edit_Cart_Link();
				
				mc.Shopping_Cart_title_should_be("Shopping Cart");	
			}
	
		
			
			//  Verify_Items_Inside_Shopping_Cart
					@Test(priority =3)
					public void Verify_Items_Inside_Shopping_Cart() throws InterruptedException
					{
						s = new SignIn(driver);
						s.SignInMethod("Draco@gmail.com", "Draco@123");
						Thread.sleep(2000);						
						
						String Actual_Title=driver.getTitle();
						String Expected_Title="Home Page";
						Assert.assertEquals(Actual_Title, Expected_Title);
						
						mc.isMyCart_LinkDisplayed();
						mc.clickOnMyCart_Link();
						
						mc.isProceed_to_Checkout_BtnDisplayed();
						
						mc.isView_and_Edit_Cart_LinkDisplayed();
						mc.clickOnView_and_Edit_Cart_Link();
						
						mc.Shopping_Cart_title_should_be("Shopping Cart");
						
						mc.Access_Shopping_Cart_Items();
							
					}	
		
		
		
		@AfterMethod
		public void close()
		{
			driver.quit();
		}
		
	

}

