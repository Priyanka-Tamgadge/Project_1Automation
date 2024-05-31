package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.ApplyFilters;
import pageObject.HomePage;
import pageObject.SignIn;
import pageObject.SortBy;

public class ApplyFilter_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	ApplyFilters af;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	

	
//  Verify_Apply_Filter_Size_Color                    
	@Test(priority =1)
	public void Verify_Apply_Filter_Size_Color() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		af= new ApplyFilters(driver);

		af.Apply_Filter_Size_and_Color();

	}
	

	//  Verify_Apply_Filter                    
	@Test(priority =2)
	public void Verify_Apply_Filter() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		af= new ApplyFilters(driver);
	
		af.Apply_Filter();
	
	}
	
	
	
//  Verify_Apply_Filter                    
	@Test(priority =3)
	public void Verify_Apply_Filter_Without_Login() throws InterruptedException
	{
		hp=new HomePage(driver);
		hp.url();
		
		af= new ApplyFilters(driver);
		af.Apply_Filter();
	
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
