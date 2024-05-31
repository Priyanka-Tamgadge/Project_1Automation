package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.AddToCart;
import pageObject.HomePage;
import pageObject.ProceedToCheckout;
import pageObject.ReviewAndPayments;
import pageObject.SignIn;

public class ProceedToCheckout_Test {
	
	WebDriver driver;
	HomePage hp;
	SignIn s;
	ProceedToCheckout pc;
	ReviewAndPayments rp;
	AddToCart atc;
	
	
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		s = new SignIn(driver);
		Thread.sleep(3000);
	}
	

//  Verify_ProceedToCheckout_Complete_Process    
	@Test(priority =1)
	public void Verify_ProceedToCheckout_Complete_Process() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		atc = new AddToCart(driver);
		atc.Add_Item_To_Cart();
		
		pc = new ProceedToCheckout(driver);
		pc.ProceedToCheckout_Method();
		
		rp = new ReviewAndPayments(driver);
		
		rp.Checkout_Page_title_should_be("Checkout");
		rp.isCheckBoxSelected();
		rp.Entered_Details();
		
		rp.Order_Summary_Info();
		rp.Shipping_Information();
		rp.Shiiping_Method();
		
		rp.clickOn_Place_Order_Btn();
		
		//  After Placing an Order
	
		rp.Success_Page_title_should_be("Success Page");
		rp.Your_Order_Number();
		rp.Checkout_Success();
		rp.isContinue_Shopping_LinkDisplayed();
		rp.isPrint_ReceiptDisplayed();
		
		Thread.sleep(5000);
		
		
	}
	

	
	
	/*	
	//  Verify_ProceedToCheckoutr_Login   ------  Check are All Fields And Buttons Displayed
	@Test(priority =1)
	public void Verify_ProceedToCheckout_AllElements() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		pc = new ProceedToCheckout(driver);
		
		pc.clickOnMyCart_Link();
		pc.clickOnProceed_to_Checkout_Btn();
		pc.Checkout_Page_title_should_be("Checkout");
		
		pc.areAllFieldsAndButtonsDisplayed();
		System.out.println("All Elements are Displyed \n");
		
	}
	
	
	
	
//  Verify_ProceedToCheckoutr_Login   ------  
	@Test(priority =2)
	public void Verify_ProceedToCheckout() throws InterruptedException
	{
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Home Page";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		pc = new ProceedToCheckout(driver);
		
		pc.clickOnMyCart_Link();
		pc.clickOnProceed_to_Checkout_Btn();
		Thread.sleep(2000);
		pc.Checkout_Page_title_should_be("Checkout");
		
		pc.areAllFieldsAndButtonsDisplayed();
		
		pc.clickon_FirstName();
		pc.clickon_LastName();
		pc.Enter_Company("XYZ");
		pc.Enter_StreetAddress("Street Address Entered");
		pc.Enter_City("ABC");
		pc.SelectFrom_StateList();
		pc.Enter_ZipCode("12345-6789");
		pc.Select_Country();
		pc.Enter_PhoneNumber("2589631475");
		pc.Select_ShippingMethod();
		pc.clickOn_NextButton();
		Thread.sleep(2000);
		
	}
*/
	
	

	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
