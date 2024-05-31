package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.SignIn;

public class SignIn_Test {
	
	WebDriver driver;
	SignIn s;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_SignIn_Page_Title
	@Test(priority =1)
	public void Verify_SignIn_Page_Title() throws InterruptedException
	{
		s.url();
		s.Homepage_title_should_be("Home Page");
		s.clickOnSignInLink();
		s.SignIn_Page_Title("Customer Login");
	}
	
	
	//  areAllMenusAndLinksDisplayedProperly
	@Test(priority =2)
	public void areAllMenusAndLinksDisplayedProperly() throws InterruptedException
	{
	    s.url();
	    s.clickOnSignInLink();
		s.areAllFieldsAndButtonsDisplayed();
		System.out.println("All Fields And Buttons are Displayed");
	}
	
	
	//  Verify_SignIn_With_BlankDetails
	@Test(priority =3)
	public void Verify_SignIn_With_BlankDetails() throws InterruptedException
	{
		s.SignInMethod("", "");
		
		if(s.Email.getText()=="" || s.Password.getText()=="")
		{
			String Actual_Title=driver.getTitle();
			String Expected_Title="Customer Login";
			Assert.assertEquals(Actual_Title, Expected_Title);
			
			System.out.println("\n****************** ErrorMessage for Verify_SignIn_With_BlankDetails ********************");
			System.out.println("Email: "+s.Email_Error.getText() +"\nPassword: "+s.Password_Error.getText()+"\n");
		}
	}
	
	
	//  Verify_SignIn_With_BlankEmail
	@Test(priority =4)
	public void Verify_SignIn_With_BlankEmail() throws InterruptedException
	{
		s.SignInMethod("", "Draco@123");
		
		if(s.Email.getText()=="" || s.Password.getText()=="")
		{
			String Actual_Title=driver.getTitle();
			String Expected_Title="Customer Login";
			Assert.assertEquals(Actual_Title, Expected_Title);
			
			System.out.println("\n****************** ErrorMessage for Verify_SignIn_With_BlankEmail ********************");
			System.out.println("Email: "+s.Email_Error.getText()+"\n");
		}	
	}
	
	
	//  Verify_SignIn_With_BlankPassword
	@Test(priority =5)
	public void Verify_SignIn_With_BlankPassword() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "");
		
		if(s.Email.getText()=="" || s.Password.getText()=="")
		{
			String Actual_Title=driver.getTitle();
			String Expected_Title="Customer Login";
			Assert.assertEquals(Actual_Title, Expected_Title);
			
			System.out.println("\n****************** ErrorMessage for Verify_SignIn_With_BlankPassword ********************");
			System.out.println("Password: "+s.Password_Error.getText()+"\n");
		}
	}
	
	
	//  Verify_SignIn_With_Valid_EmailPassword
	@Test(priority =6)
	public void Verify_SignIn_With_Valid_EmailPassword() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
			
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);	
	}
	
	
	//  Verify_SignIn_With_InValid_EmailPassword
	@Test(priority =7)
	public void Verify_SignIn_With_InValid_EmailPassword() throws InterruptedException
	{
		s.SignInMethod("Drac@gmail.com", "Drac@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Customer Login";
		Assert.assertEquals(Actual_Title, Expected_Title);	
		
		//String getErrorMessage;
		String msg=driver.findElement(By.xpath("//div[@role='alert']/child::div/child::div")).getText();
		System.out.println("\n****************** ErrorMessage for CreateAccount_with_InvalidEmailAddress ********************");
		System.out.println(msg+"\n");
	}

	

	//  Verify_SignIn_With_InValidEmail_ValidPassword
	@Test(priority =8)
	public void Verify_SignIn_With_InValidEmail_ValidPassword() throws InterruptedException
	{
		s.SignInMethod("Drac@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Customer Login";
		Assert.assertEquals(Actual_Title, Expected_Title);	
		
		//String getErrorMessage;
		String msg=driver.findElement(By.xpath("//div[@role='alert']/child::div/child::div")).getText();
		System.out.println("\n****************** ErrorMessage for Verify_SignIn_With_InValidEmail_ValidPassword ********************");
		System.out.println(msg+"\n");
	}
	
	
    //  Verify_SignIn_With_ValidEmail_InValidPassword
	@Test(priority =9)
	public void Verify_SignIn_With_ValidEmail_InValidPassword() throws InterruptedException
	{
		s.SignInMethod("Drac@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Customer Login";
		Assert.assertEquals(Actual_Title, Expected_Title);	
		
		//String getErrorMessage;
		String msg=driver.findElement(By.xpath("//div[@role='alert']/child::div/child::div")).getText();
		System.out.println("\n****************** ErrorMessage for Verify_SignIn_With_ValidEmail_InValidPassword ********************");
		System.out.println(msg+"\n");
	}
	
	
	//  Verify_ForgotPasswordLink
	@Test(priority =10)
	public void Verify_ForgotPasswordLink() throws InterruptedException
	{
		s.url();
		s.clickOnSignInLink();
		if(s.isForgotPasswordLinkDisplayed())
		{
			System.out.println("ForgotPasswordLink is Present\n");
		}
		else
		{
			System.out.println("ForgotPasswordLink is Absent");
		}
		
	}

	
	//  Verify_CreateAccountBtn
	@Test(priority =11)
	public void Verify_CreateAccountBtn() throws InterruptedException
	{
		s.url();
		s.clickOnSignInLink();
		if(s.isCreateAccountBtnDisplayed())
		{
			System.out.println("CreateAccountBtn is Present\n");
		}
		else
		{
			System.out.println("CreateAccountBtn is Absent");
		}
		
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	

}
