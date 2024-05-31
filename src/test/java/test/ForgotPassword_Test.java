package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;


public class ForgotPassword_Test {
	
	WebDriver driver;
	ForgotPassword f;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		f = new ForgotPassword(driver);
		Thread.sleep(3000);
	}
	
	
//  Verify_ForgotPasswordLink
	@Test(priority =1)
	public void Verify_ForgotPasswordLink_Present() throws InterruptedException
	{
		f.url();
		f.clickOnSignInLink();
		if(f.isForgotPasswordLinkDisplayed())
		{
			System.out.println("ForgotPasswordLink is Present\n");
		}
		else
		{
			System.out.println("ForgotPasswordLink is Absent");
		}
	}
		
	
	//  Verify_ForgotPassword_Page_Title
	@Test(priority=2)
	public void Verify_ForgotPassword_Page_Title() throws InterruptedException
	{
		f.url();
		f.clickOnSignInLink();
		f.clickOnForgotPasswordLink();
		f.ForgotPassword_Page_Title("Forgot Your Password?");
	}
	
	
	
	//  Verify_ForgotPasswordLink_Functonality
	@Test(priority=3)
	public void Verify_ForgotPasswordLink_Functonality() throws InterruptedException
	{
		f.ForgotPasswordMethod();
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Customer Login";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		String Success_Msg=driver.findElement(By.xpath("//div[@class='messages']/child::div/child::div")).getText();
		System.out.println("\n****************** Success_Msg for Forgot Password ********************");
		System.out.println(Success_Msg+"\n");
		
	}
	
	
//  Verify_ForgotPasswordLink_Functonality without entering Email
	@Test(priority=4)
	public void Verify_ForgotPasswordLink_Functonality_WithEmpltyEmail() throws InterruptedException
	{
		f.url();
    	f.clickOnSignInLink();
    	f.clickOnForgotPasswordLink();
    	f.enterEmailAddress("");
    	f.clickOnResetPassword_Btn();
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Forgot Your Password?";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		//String getErrorMessage;
		String msg=driver.findElement(By.id("email_address-error")).getText();
		System.out.println("\n****************** ErrorMessage for Verify_ForgotPasswordLink_Functonality without entering Email ********************");
	    System.out.println(msg+"\n");
		
	}
	
	
//  Verify_ForgotPasswordLink_Functonality with Invalid Email
	@Test(priority=5)
	public void Verify_ForgotPasswordLink_Functonality_WithInvalidEmail() throws InterruptedException
	{
		f.url();
    	f.clickOnSignInLink();
    	f.clickOnForgotPasswordLink();
    	f.enterEmailAddress("Draco@gm");
    	f.clickOnResetPassword_Btn();
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Forgot Your Password?";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		//String getErrorMessage;
		String msg=driver.findElement(By.id("email_address-error")).getText();
		System.out.println("\n****************** Verify_ForgotPasswordLink_Functonality with Invalid Email ********************");
	    System.out.println(msg+"\n");
		
	}
	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}	
	

}
