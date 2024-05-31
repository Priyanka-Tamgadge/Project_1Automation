package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.GearMenu;
import pageObject.HomePage;
import pageObject.SignIn;
import pageObject.TrainingMenu;

public class TrainingMenu_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	TrainingMenu tm;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_TrainingMenu_Without_Login
	@Test(priority =1)
	public void Verify_TrainingMenu_Without_Login() throws InterruptedException
	{
		hp=new HomePage(driver);
		hp.url();
		hp.Homepage_title_should_be("Home Page");
		
		tm=new TrainingMenu(driver);
		tm.verify_TrainingMenu_Items();
		
	}
	
	
	
    //  Verify_TrainingMenu_After_Login
	@Test(priority =2)
	public void Verify_TrainingMenu_After_Login() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");

		tm=new TrainingMenu(driver);
		tm.verify_TrainingMenu_Items();
		
	}
	
   
	//  Verify_ClickOn_TrainingMenu          &   Sidebar
	@Test(priority =3)
	public void Verify_ClickOn_TrainingMenu() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		tm=new TrainingMenu(driver);
		tm.verify_TrainingMenu_Items();
	
		tm.clickOnTrainingMenu();
		
		tm.Verify_TrainingMenu_PageTitle("Training");
		
		tm.Verify_SideBar_TrainingMenuPage();
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


}
