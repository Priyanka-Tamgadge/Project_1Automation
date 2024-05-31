package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewAndPayments {
	
WebDriver driver;
	
	public ReviewAndPayments(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
 
	/* -----------------  Repository of Elements ------------------ */
    
    @FindBy(xpath="//div[@class='checkout-billing-address']/child::div/child::input") WebElement Checkbox;
    @FindBy(xpath="//div[@class='billing-address-details']") WebElement Entered_Details;

    @FindBy(xpath="//div[@class='actions-toolbar']/child::div/child::button[@class='action primary checkout']") WebElement Place_Order_Btn;
    @FindBy(xpath="//table[@class='data table table-totals']") WebElement Order_Summary;
    
    @FindBy(xpath="//div[@class='ship-to']/child::div[@class='shipping-information-content']") WebElement Shipping_Information;
    @FindBy(xpath="//div[@class='ship-via']/child::div[2]/child::span") WebElement Shipping_Method;
    
    
    
    
    //  After Successfully Placing an Order
    @FindBy(xpath="//div[@class='checkout-success']/child::p/child::a/child::strong") WebElement Order_Number;
    @FindBy(xpath="//div[@class='checkout-success']") WebElement Checkout_Success;
    @FindBy(xpath="//a[@class='action primary continue']") WebElement Continue_Shopping_Link;
    @FindBy(xpath="//a[@class='action print']") WebElement Print_Receipt;
    
    

    
  /* -----------------  Methods  ------------------ */
   
    
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
    
    
    
    public void isCheckBoxSelected() throws InterruptedException
    {
    	if(Checkbox.isSelected()) 
    	{
    		System.out.println("My billing and shipping address are the same");
    	}
    	
    	else
    	{
    		Checkbox.click();
    		Thread.sleep(2000);
    	}
    }
        
    
    
    public void Entered_Details()
    {
    	String Details=Entered_Details.getText();
    	System.out.println("\nYour Details are: ");
    	System.out.println(Details);
    	System.out.println();
    }
    
    
    public void Order_Summary_Info()
    {
    	String Details=Order_Summary.getText();
    	System.out.println("\nYour Order_Summary is: ");
    	System.out.println(Details);
    	System.out.println();
    }
    
    
    public void Shipping_Information()
    {
    	String Details=Shipping_Information.getText();
    	System.out.println("\nYour Shipping_Information is: ");
    	System.out.println(Details);
    	System.out.println();
    }
    
   
    public void Shiiping_Method()
    {
    	String Details=Shipping_Method.getText();
    	System.out.println("\nYour Shipping_Method is: ");
    	System.out.println(Details);
    	System.out.println();
    }
    
    
    public void clickOn_Place_Order_Btn() throws InterruptedException
    {
    	Place_Order_Btn.click();
    	Thread.sleep(5000);
    }
    

    
    public void Success_Page_title_should_be(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {                      //  Success Page
			System.out.println("We are on Success Page");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
    }
    
    
    
    public void Your_Order_Number()
    {
    	String result=Order_Number.getText();
    	System.out.println("\nYour Order Number is: "+result);
    	System.out.println();
    }
    
    
    public void Checkout_Success()
    {
    	String result=Checkout_Success.getText();
    	System.out.println("\nYour Checkout_Success is: "+result);
    	System.out.println();
    }
    
    
    
    //  isContinue_Shopping_LinkDisplayed
    public boolean isContinue_Shopping_LinkDisplayed() {
        return Continue_Shopping_Link.isDisplayed();
    }
    
   
    //  isPrint_ReceiptDisplayed
    public boolean isPrint_ReceiptDisplayed() {
        return Print_Receipt.isDisplayed();
    }

}
