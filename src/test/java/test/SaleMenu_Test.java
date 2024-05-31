package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.GearMenu;
import pageObject.HomePage;
import pageObject.SaleMenu;
import pageObject.SignIn;

public class SaleMenu_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	SaleMenu sm;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_SaleMenu_Without_Login
	@Test(priority =1)
	public void Verify_SaleMenu_Without_Login() throws InterruptedException
	{
		hp=new HomePage(driver);
		hp.url();
		hp.Homepage_title_should_be("Home Page");
		
		sm=new SaleMenu(driver);
		sm.Perform_MouseHover_Operation();
		sm.clickOnSaleMenu();
		sm.Verify_SaleMenu_PageTitle("Sale");
		
	}
	
	
	
//  Verify_SaleMenu_After_Login       &            SideBar   
	@Test(priority =2)
	public void Verify_SaleMenu_After_Login() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");

		sm=new SaleMenu(driver);
		sm.Perform_MouseHover_Operation();
		sm.clickOnSaleMenu();
		sm.Verify_SaleMenu_PageTitle("Sale");
		sm.Verify_SideBar_SaleMenuPage();
	}

	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


}
