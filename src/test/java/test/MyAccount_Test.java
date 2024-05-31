package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.MyAccount;
import pageObject.SignIn;

public class MyAccount_Test {
	
	WebDriver driver;
	SignIn s;
	MyAccount ma;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_MyAccount_Option
	@Test(priority =1)
	public void Verify_MyAccount_Option() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		ma = new MyAccount(driver);
		
		ma.isProfileBtnDisplayed();
		ma.clickOnProfileBtn();
		
		ma.isMy_AccountFieldDisplayed();
		ma.clickOnMy_Account();
		System.out.println("My_Account Field Displayed");
	}
	
	
//  Verify_MyAccount_ContactInfo_Displayed
	@Test(priority =2)
	public void Verify_MyAccount_ContactInfo_Displayed() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		ma = new MyAccount(driver);
		ma.clickOnProfileBtn();
		ma.clickOnMy_Account();
		ma.My_Account_PageTitle("My Account");
		ma.Contact_Info();
	}
	
	
		
//  Verify_MyAccount_SideBar_Displayed
	@Test(priority =3)
	public void Verify_MyAccount_SideBar_Displayed() throws InterruptedException
	{
		
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		ma = new MyAccount(driver);
		ma.clickOnProfileBtn();
		ma.clickOnMy_Account();
		ma.My_Account_PageTitle("My Account");
		ma.My_Account_SideBar();
		System.out.println("My Account SideBar all Options are displayed");
	}


	
//  Verify_MyAccount_SideBar_Clickable
     
	@Test(priority =4)
	public void Verify_MyAccount_SideBar_Clickable() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		ma = new MyAccount(driver);
		ma.clickOnProfileBtn();
		ma.clickOnMy_Account();
		ma.My_Account_PageTitle("My Account");
		ma.clickOn_SideBar_Options();
	}	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	

}
