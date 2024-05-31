package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.GearMenu;
import pageObject.HomePage;
import pageObject.MenMenu;
import pageObject.SignIn;

public class GearMenu_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	GearMenu gm;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_GearMenu
	@Test(priority =1)
	public void Verify_GearMenu_Without_Login() throws InterruptedException
	{
		hp=new HomePage(driver);
		hp.url();
		hp.Homepage_title_should_be("Home Page");
		
		gm=new GearMenu(driver);
		gm.verify_GearMenu_Items();
		
	}
	
	
	
//  Verify_GearMenu
	@Test(priority =2)
	public void Verify_GearMenu_After_Login() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");

		gm=new GearMenu(driver);
		gm.verify_GearMenu_Items();
		
	}
	
//  Verify_GearMenu          &   Sidebar
	@Test(priority =3)
	public void Verify_ClickOn_GearMenu() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		gm=new GearMenu(driver);
		gm.verify_GearMenu_Items();
	
		gm.clickOnGearMenu();
		
		gm.Verify_GearMenu_PageTitle("Gear");
		
		gm.Verify_SideBar_GearMenuPage();
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

	

}
