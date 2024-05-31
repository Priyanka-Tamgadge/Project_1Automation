package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignIn;
import pageObject.WhatsNewMenu;

public class WhatsNewMenu_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	WhatsNewMenu w;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		w = new WhatsNewMenu(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_SignIn_Page_Title_AllMenus
	@Test(priority =1)
	public void Verify_SignIn_Page_Title() throws InterruptedException
	{
		s = new SignIn(driver);
		s.url();
		s.Homepage_title_should_be("Home Page");
		hp=new HomePage(driver);
		hp.areAllMenusAndLinksDisplayed();
		s.clickOnSignInLink();
		s.SignIn_Page_Title("Customer Login");
		w.isWhatsNewMenuDisplayed();
	}
	
	
	//  Verify_whatsNewMenu_PageTitle
	@Test(priority =2)
	public void Verify_whatsNewMenu_PageTitle() throws InterruptedException
	{
		s = new SignIn(driver);
		s.url();
	    s.clickOnSignInLink();
	    s.SignInMethod("Draco@gmail.com", "Draco@123");
		w.isWhatsNewMenuDisplayed();
		w.clickOnWhatsNewMenu();
		w.whatsNewMenu_PageTitle("What's New");
	}
	
	
//  Verify_Products_Category inside Womwn's and Men's Section
	@Test(priority =3)
	public void Verify_WhatsNew_Products_Category() throws InterruptedException
	{
		s = new SignIn(driver);
		s.url();
	    s.clickOnSignInLink();
	    s.SignInMethod("Draco@gmail.com", "Draco@123");
		w.isWhatsNewMenuDisplayed();
		w.clickOnWhatsNewMenu();
		w.whatsNewMenu_PageTitle("What's New");
		
		System.out.println("\nProducts in New_in_Womens Category: ");
		w.New_in_Womens();
		
		System.out.println("\nProducts in New_in_Mens Category: ");
		w.New_in_mens();
	}
	
	

	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
