package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.CreateAccount;

public class CreateAccount_Test {
	
	WebDriver driver;
	CreateAccount ca;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ca = new CreateAccount(driver);
		Thread.sleep(3000);
	}
	
	
	//   Verify_CreateAccount_Page_Title
	@Test(priority=1)
	public void Verify_CreateAccount_Page_Title() throws InterruptedException
	{
		ca.url();
		ca.Homepage_title_should_be("Home Page");
		ca.clickOnCreate_Account_Link();
		ca.Create_Account_Page_Title("Create New Customer Account");
	}
	
	
	//   areAllMenusAndLinksDisplayedProperly
	@Test(priority=2)
	public void areAllMenusAndLinksDisplayedProperly() throws InterruptedException
	{
	    ca.url();
	    ca.clickOnCreate_Account_Link();;
		ca.areAllFieldsAndButtonsDisplayed();
		System.out.println("All Fields And Buttons are Displayed");
	}
	
	
	//   Verify_createAccount_With_BlanckDetails
	@Test(priority=3)
	public void Verify_createAccount_With_BlankDetails() throws InterruptedException
	{
		ca.Create_Account_Method("","","","","");
		
		 if(ca.Firstname.getText()=="" || ca.Lastname.getText()=="" || ca.Email_address.getText()=="" || 
				 ca.Password.getText()==""|| ca.Password_Confirmation.getText()=="")
	   	 {
			 	String Actual_Title=driver.getTitle();
				String Expected_Title="Create New Customer Account";
				Assert.assertEquals(Actual_Title, Expected_Title);
				
	   		 System.out.println("Firstname: "+ca.firstname_error.getText() +"\nLastname: "+ca.lastname_error.getText()
	   		+"\nEmail Address: "+ca.email_address_error.getText() +"\nPassword: "+ca.password_error.getText()
	   		+"\nPassword_Confirmation: "+ca.password_confirmation_error.getText()+"\n");
	   	 }
	}
	
	
	//   CreateAccount_with_Valid_Details
	@Test(priority=4)
	public void CreateAccount_with_Valid_Details() throws InterruptedException
	{
		ca.Create_Account_Method("James", "Potter", "James@gmail.com", "James@123", "James@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="My Account";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		String Success_Msg=driver.findElement(By.xpath("//div[@class='message-success success message']/child::div")).getText();
		System.out.println("\n****************** ErrorMessage for CreateAccount_with_Valid_Details ********************");
		System.out.println(Success_Msg+"\n");
	}
	
	
	//  CreateAccount_with_Numbers
	@Test(priority=5)
	public void CreateAccount_with_Numbers() throws InterruptedException
	{
		ca.Create_Account_Method("1456457", "1789787", "tryNum@gmail.com", "TryMe@123457", "TryMe@123457");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="My Account";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		String Success_Msg=driver.findElement(By.xpath("//div[@class='message-success success message']/child::div")).getText();
		System.out.println("\n****************** Success_Msg for CreateAccount_with_Numbers ********************");
		System.out.println(Success_Msg+"\n");
	}
	
	
	
	//   CreateAccount_with_InvalidEmailAddress
	@Test(priority=6)
	public void CreateAccount_with_InvalidEmailAddress() throws InterruptedException
	{
		ca.Create_Account_Method("BLily", "BPotter", "BLily", "Harry@123", "Harry@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Create New Customer Account";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		//String getErrorMessage;
		String msg=driver.findElement(By.id("email_address-error")).getText();
		System.out.println("\n****************** ErrorMessage for CreateAccount_with_InvalidEmailAddress ********************");
		System.out.println(msg+"\n");
	}
	
	
	//   CreateAccount_with_WeakPassword
	@Test(priority=7)
	public void CreateAccount_with_WeakPassword() throws InterruptedException
	{
		ca.Create_Account_Method("ALily", "APotter", "BLily@gmail.com", "Harry", "Harry");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Create New Customer Account";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		//String getErrorMessage;
		String msg=driver.findElement(By.id("password-error")).getText();
		System.out.println("\n****************** ErrorMessage for CreateAccount_with_WeakPassword ********************");
		System.out.println(msg+"\n");
	}
	
	
	
	//   CreateAccount_with_MismatchPassword
	@Test(priority=8)
	public void CreateAccount_with_MismatchPassword() throws InterruptedException
	{
		ca.Create_Account_Method("ALily", "APotter", "mLily@gmail.com", "Harry@123", "Harry@456");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Create New Customer Account";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		//String getErrorMessage;
		String msg=driver.findElement(By.id("password-confirmation-error")).getText();
		System.out.println("\n****************** ErrorMessage for CreateAccount_with_MismatchPassword ********************");
		System.out.println(msg+"\n");
	}
	
	
	
	//   CreateAccount_with_Existing_Details
	@Test(priority=9)
	public void CreateAccount_with_Existing_Details() throws InterruptedException
	{
		ca.Create_Account_Method("BHarry", "BPotter", "BHarry@gmail.com", "BHarry@123", "BHarry@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Create New Customer Account";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		String Success_Msg=driver.findElement(By.xpath("//div[@class='message-error error message']/child::div")).getText();
		System.out.println("\n****************** ErrorMessage for CreateAccount_with_Existing_Details ********************");
		System.out.println(Success_Msg+"\n");
	}
	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


}
