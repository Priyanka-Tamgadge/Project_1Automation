package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MenMenu;
import pageObject.SignIn;


public class MenMenu_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	MenMenu mm;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		mm = new MenMenu(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_MenMenu level_1_level_2_SubMenu
	@Test(priority =1)
	public void Verify_MenMenu() throws InterruptedException
	{
		mm.url();
		mm.Homepage_title_should_be("Home Page");
		mm.verify_level_1_level_2_SubMenu();
	}
	
   
	//  Verify_SideBar_MenMenuPage
	@Test(priority =2)
	public void Verify_MenMenu_Page() throws InterruptedException
	{
		mm.url();
		mm.Homepage_title_should_be("Home Page");
		mm.clickOnMenMenu();
		mm.Verify_MenMenu_PageTitle("Men");
		mm.Verify_SideBar_MenMenuPage();
	}
	
	
//  Verify_MenMenu_After_Login
	@Test(priority =3)
	public void Verify_MenMenu_After_Login() throws InterruptedException
	{
		s = new SignIn(driver);
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		
		mm.clickOnMenMenu();
		mm.Verify_MenMenu_PageTitle("Men");
		mm.Verify_SideBar_MenMenuPage();
	}
	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


}
