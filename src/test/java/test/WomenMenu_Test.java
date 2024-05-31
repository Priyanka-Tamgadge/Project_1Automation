package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignIn;
import pageObject.WhatsNewMenu;
import pageObject.WomenMenu;

public class WomenMenu_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	WhatsNewMenu w;
	WomenMenu wm;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wm = new WomenMenu(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_WomenMenu level_1_level_2_SubMenu
	@Test(priority =1)
	public void Verify_WomenMenu() throws InterruptedException
	{
		wm.url();
		wm.Homepage_title_should_be("Home Page");
		wm.verify_level_1_level_2_SubMenu();
	}
	
   //  Verify_SideBar_WomenMenuPage
	@Test(priority =2)
	public void Verify_WomenMenu_Page() throws InterruptedException
	{
		wm.url();
		wm.Homepage_title_should_be("Home Page");
		wm.clickOnWomenMenu();
		wm.Verify_WomenMenu_PageTitle("Women");
		wm.Verify_SideBar_WomenMenuPage();
	}
	
	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
