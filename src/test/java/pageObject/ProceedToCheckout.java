package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProceedToCheckout {
	
WebDriver driver;
	
	public ProceedToCheckout(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
 
	/* -----------------  Repository of Elements ------------------ */
    
    @FindBy(xpath="//div[@class='minicart-wrapper']/child::a[@class='action showcart']") WebElement MyCart_Link;
    @FindBy(xpath="//div[@class='block-content']/child::strong[@class='subtitle empty']") WebElement Error_Msg;

    
    //  Elements Inside MyCart link
    @FindBy(id="top-cart-btn-checkout") WebElement Proceed_to_Checkout_Btn;
    @FindBy(xpath="//a[@class='action viewcart']") WebElement View_and_Edit_Cart_Link;
    
    
    // Elements Inside Shipping Address
    @FindBy(name="firstname") WebElement FirstName;
    @FindBy(name="lastname") WebElement LastName;
    @FindBy(name="company") WebElement Company;
    @FindBy(name="street[0]") WebElement Street_Address;
    @FindBy(name="city") WebElement City;
    @FindBy(name="region_id") WebElement State_List;
    @FindBy(name="postcode") WebElement Zip_Code;
    @FindBy(name="country_id") WebElement Country_List;
    @FindBy(name="telephone") WebElement Phone_Number;
    
    
 // Elements Inside Shipping Methods
    @FindBy(name="ko_unique_11") List<WebElement> Radio_Btn;
    @FindBy(xpath="//td[@class='col col-method']") List<WebElement> Select_Shipping_Method;
    
    
 //  Elements In Order Summary  
    @FindBy(xpath="//div[@class='block items-in-cart']") WebElement Items_In_Cart;
    
//  Next button
    @FindBy(xpath="//div[@id='shipping-method-buttons-container']/child::div/child::button") WebElement Next_Button;
    
    
//  shipping-address-items(Already Address is saved)
    @FindBy(xpath="//div[@class='shipping-address-items']/child::div") WebElement shipping_address_items;  
    @FindBy(name="ko_unique_1") List<WebElement> Radio_Btn2;
    @FindBy(xpath="//td[@id='label_method_flatrate_flatrate']") List<WebElement> Select_Shipping_Method2;
    
 //
    @FindBy(xpath="//strong[@class='subtitle empty']") WebElement Cart_Empty;
    
 
    
    
 /* -----------------  Methods  ------------------ */

    
    //  clickOnMyCart_Link
    public void clickOnMyCart_Link() throws InterruptedException
    {
    	Actions act1=new Actions(driver);
		act1.moveToElement(MyCart_Link).build().perform();
		Thread.sleep(1000);
 
    	MyCart_Link.click();
    	Thread.sleep(2000);
 
    }
    
    
    //  GetErrorMessage 
    public void GetErrorMessage() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(Error_Msg).build().perform();
		Thread.sleep(1000);
    	
    	String msg=Error_Msg.getText();
    	System.out.println("\nError Message: "+msg+"\n");
    	Thread.sleep(2000);
    }
    
    
    //  isMyCart_LinkDisplayed
    public boolean isMyCart_LinkDisplayed() {
        return MyCart_Link.isDisplayed();
    }
    
    
    //  isError_MsgDisplayed
    public boolean isError_MsgDisplayed() {
        return Error_Msg.isDisplayed();
    }
     
    
    //  isProceed_to_Checkout_BtnDisplayed
    public boolean isProceed_to_Checkout_BtnDisplayed() {
        return Proceed_to_Checkout_Btn.isDisplayed();
    }
    
    
//  clickOnProceed_to_Checkout_Btn
    public void clickOnProceed_to_Checkout_Btn() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(Proceed_to_Checkout_Btn).build().perform();
		Thread.sleep(1000);
    	
    	
		Proceed_to_Checkout_Btn.click();
    	Thread.sleep(5000);
    }
    
    
    //  Checkout_Page_title_should_be
    public void Checkout_Page_title_should_be(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {                      //  Checkout
			System.out.println("We are on Checkout Page");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
    }
    
   public void clickon_FirstName() throws InterruptedException
   {
	   FirstName.click();
	   Thread.sleep(2000);
   }
   
   public void clickon_LastName() throws InterruptedException
   {
	   LastName.click();
	   Thread.sleep(2000);
   }
   
   public void Enter_Company(String comp) throws InterruptedException
   {
	   Company.sendKeys(comp);
	   Thread.sleep(2000);
   }
   
   
   public void Enter_StreetAddress(String SA) throws InterruptedException
   {
	   Street_Address.sendKeys(SA);
	   Thread.sleep(2000);
   }
   
   public void Enter_City(String c) throws InterruptedException
   {
	   City.sendKeys(c);
	   Thread.sleep(2000);
   }
   
   
   public void SelectFrom_StateList()
   {
	   Select My_State=new Select(State_List);
	   My_State.selectByIndex(4);
   }
   
   public void Enter_ZipCode(String zp) throws InterruptedException
   {
	   Zip_Code.sendKeys(zp);
	   Thread.sleep(2000);
   }
    
    public void Select_Country()
    {
    	Select Country=new Select(Country_List);
    	Country.selectByIndex(4);
    }
    
    public void Enter_PhoneNumber(String num) throws InterruptedException
    {
    	Phone_Number.sendKeys(num);
 	    Thread.sleep(2000);
    }
    
    
    //  Select_ShippingMethod
    public void Select_ShippingMethod() throws InterruptedException
    {
    	for(int i=0;i<Radio_Btn.size();i++)
		{
			String Name=Select_Shipping_Method.get(i).getText();                 
			System.out.println(Name);
			
			if(Name.equals("Fixed"))
			{
				Radio_Btn.get(i).click();
				Thread.sleep(2000);
				
				if(Radio_Btn.get(i).isSelected())
				{
					System.out.println("Radio Button is Clicked");
				}
				else
				{
					System.out.println("Radio Button is not Clicked");
				}
			}
		}
    	Thread.sleep(5000);
    	
    }
    
    
    
    public void clickOn_NextButton() throws InterruptedException
    {
    	Next_Button.click();
    	Thread.sleep(5000);
    }
    

    
    
 // Added a method to verify presence of all Fields and Buttons
    public boolean areAllFieldsAndButtonsDisplayed() {
        return isFirstNameDisplayed() & isLastNameDisplayed() & isCompanyDisplayed() & 
        		isStreet_AddressDisplayed() & isCityDisplayed() & 
        		isState_ListDisplayed() & isZip_CodeDisplayed() & isCountry_ListDisplayed() & isPhone_NumberDisplayed() &
        		isRadio_BtnDisplayed() & isNext_ButtonEnabled() & isItems_In_CartDisplayed(); // Added checks for all Fields and Buttons
    }
    
 
  
 
//  isStreet_AddressDisplayed
    public boolean isshipping_address_itemsDisplayed() {
        return shipping_address_items.isDisplayed();
    }
    
   
//  isCart_EmptyDisplayed
    public boolean isCart_EmptyDisplayed() {
        return Cart_Empty.isDisplayed();
    }
  
    
    //  ProceedToCheckout_Method
    public void ProceedToCheckout_Method() throws InterruptedException
    {
    	clickOnMyCart_Link();
    	Thread.sleep(2000);

    		clickOnProceed_to_Checkout_Btn();
    		Thread.sleep(2000);
    		Checkout_Page_title_should_be("Checkout");
    		
    		Thread.sleep(5000);
    		
    		if(isshipping_address_itemsDisplayed())
    		{
    			Select_ShippingMethod2();
    			clickOn_NextButton();
    			Thread.sleep(5000);
    		}
    		
    		else
    		{
    		areAllFieldsAndButtonsDisplayed();
    		
    		clickon_FirstName();
    		clickon_LastName();
    		Enter_Company("XYZ");
    		Enter_StreetAddress("Street Address Entered");
    		Enter_City("ABC");
    		SelectFrom_StateList();
    		Enter_ZipCode("12345-6789");
    		Select_Country();
    		Enter_PhoneNumber("2589631475");
    		Select_ShippingMethod();
    		clickOn_NextButton();
    		Thread.sleep(2000);
    		}
		
    }
    
    
    //  Select_ShippingMethod2
    public void Select_ShippingMethod2() throws InterruptedException
    {
    	for(int i=0;i<Radio_Btn2.size();i++)
		{
			String Name=Select_Shipping_Method2.get(i).getText();                 
			System.out.println(Name);
			
			if(Name.equals("Fixed"))
			{
				Radio_Btn2.get(i).click();
				Thread.sleep(2000);
				
				if(Radio_Btn2.get(i).isSelected())
				{
					System.out.println("Radio Button is Clicked");
				}
				else
				{
					System.out.println("Radio Button is not Clicked");
				}
			}
		}
    	Thread.sleep(5000);
    	
    }   
   
    
 /* ----------  method to verify presence of all menus and links  -------------- */      
     
    
    //  isFirstNameDisplayed
    public boolean isFirstNameDisplayed() {
        return FirstName.getText() != null;
    }
     
    
    //  isLastNameDisplayed
    public boolean isLastNameDisplayed() {
        return LastName.getText() != null;
    }
    
    //  isCompanyDisplayed
    public boolean isCompanyDisplayed() {
        return Company.isDisplayed();
    }
     
    
    //  isStreet_AddressDisplayed
    public boolean isStreet_AddressDisplayed() {
        return Street_Address.isDisplayed();
    }
    
   //  isCityDisplayed
    public boolean isCityDisplayed() {
        return City.isDisplayed();
    }
     
    
    //  isState_ListDisplayed
    public boolean isState_ListDisplayed() {
        return State_List.isDisplayed();
    }
    
    
   //  isZip_CodeDisplayed
    public boolean isZip_CodeDisplayed() {
        return Zip_Code.isDisplayed();
    }
     
    
    //  isCountry_ListDisplayed
    public boolean isCountry_ListDisplayed() {
        return Country_List.isDisplayed();
    }
    
    
    //  isPhone_NumberDisplayed
    public boolean isPhone_NumberDisplayed() {
        return Phone_Number.isDisplayed();
    }
     
    
    //  isRadio_BtnDisplayed
    public boolean isRadio_BtnDisplayed() {
        //return ((WebElement) Radio_Btn).isEnabled();
    	
    	 if(Radio_Btn.size()>=0)
    	{
    		return true;
    	}
    	 
    	 else
    	 {
		return false;
    	 }
    }
    
    //  isNext_ButtonEnabled
    public boolean isNext_ButtonEnabled() {
        return Next_Button.isEnabled();
    }  
    
//  isItems_In_CartDisplayed
    public boolean isItems_In_CartDisplayed() {
        return Items_In_Cart.isDisplayed();
    }
    
    
    
    
    

}
