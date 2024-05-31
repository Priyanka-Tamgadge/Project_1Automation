package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class SupportThisProject_Test {
	
	WebDriver driver;
	HomePage hp;
	
   //  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		hp = new HomePage(driver);
		Thread.sleep(3000);
	}
	
	
	//   Verify_SupposrThisPage_Page_Title
	@Test(priority=1)
	public void Verify_CreateAccount_Page_Title() throws InterruptedException
	{
		hp.url();
		hp.Homepage_title_should_be("Home Page");
		hp.clickOnSupportLink();
		
		String ExpectedTitle="Software Testing Board is Creating a community for Software Testing Professionals";
		String Actual_Title=driver.getTitle();
		if(ExpectedTitle.equals(Actual_Title)) 
		{
			System.out.println("We are on the Support This Project Page \n");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	

}
