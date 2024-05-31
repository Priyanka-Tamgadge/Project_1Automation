package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCart {
	
	WebDriver driver;
	
	public MyCart(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
 /* -----------------  Repository of Elements ------------------ */
    
    @FindBy(xpath="//a[@class='action showcart']") WebElement MyCart_Link;
    @FindBy(xpath="//strong[@class='subtitle empty']") WebElement Error_Msg;

    
    //  Elements Inside MyCart link
    @FindBy(id="top-cart-btn-checkout") WebElement Proceed_to_Checkout_Btn;
    @FindBy(xpath="//a[@class='action viewcart']") WebElement View_and_Edit_Cart_Link;
    
    
    //  Items Inside Shopping Cart
    @FindBy(xpath="//td[@class='col item']/child::div/child::strong/child::a") List<WebElement> Cart_Items_List;
    @FindBy(xpath="//td[@class='col price']/child::span/child::span/child::span") List<WebElement> Price_List;
    @FindBy(xpath="//input[@class='input-text qty']") List<WebElement> Quantity_List;
    
    @FindBy(xpath="//td[@class='col subtotal']/child::span/child::span/child::span") List<WebElement> SubTotal_List;
 
    
    
 /* -----------------  Methods  ------------------ */
    
    
    //  clickOnMyCart_Link
    public void clickOnMyCart_Link() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(MyCart_Link).build().perform();
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
    
    
    //  isView_and_Edit_Cart_LinkDisplayed
    public boolean isView_and_Edit_Cart_LinkDisplayed() {
        return View_and_Edit_Cart_Link.isDisplayed();
    }
    
    
    //  clickOnProceed_to_Checkout_Btn
    public void clickOnProceed_to_Checkout_Btn() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(Proceed_to_Checkout_Btn).build().perform();
		Thread.sleep(1000);
    	
    	
		Proceed_to_Checkout_Btn.click();
    	Thread.sleep(2000);
    }
    
    
    //  clickOnView_and_Edit_Cart_Link
    public void clickOnView_and_Edit_Cart_Link() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(View_and_Edit_Cart_Link).build().perform();
		Thread.sleep(1000);
    	
    	
		View_and_Edit_Cart_Link.click();
    	Thread.sleep(2000);
    }
    
    
    //  Shopping_Cart_title_should_be
    public void Shopping_Cart_title_should_be(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("We are on Home Page");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
    }
    
  
    //  Access_Shopping_Cart_Items
    public void Access_Shopping_Cart_Items() throws InterruptedException
    {
    	Actions act=new Actions(driver);
    	
		System.out.println("\n* Items Inside Cart: \n");
		
		
		// Item Name
		for(int i=0;i<Cart_Items_List.size();i++)
    	{
			
			act.moveToElement(Cart_Items_List.get(i)).build().perform();
			Thread.sleep(2000);
			
			String Cart_Item=Cart_Items_List.get(i).getText();
    		System.out.println(Cart_Item);
    		
    		// Item Price
    		for(int j=0;j<Price_List.size();j++)
    		{
    			if(i==j)
    			{
    				act.moveToElement(Price_List.get(j)).build().perform();
    				Thread.sleep(2000);
    				
    				String Price=Price_List.get(j).getText();
    	    		System.out.println("Price: "+Price);
    			}
    		}
    		
    		// Item Quantity
    		for(int n=0;n<Quantity_List.size();n++)
    		{
    			if(i==n)
    			{
    				act.moveToElement(Quantity_List.get(n)).build().perform();
    				Thread.sleep(2000);
    				
    				String Quantity=Quantity_List.get(n).getText();
    	    		System.out.println("Quantity: "+Quantity);
    			}
    		}
    		
    		
    		// Item SubTotal
    		for(int m=0;m<SubTotal_List.size();m++)
    		{
    			if(i==m)
    			{
    				act.moveToElement(SubTotal_List.get(m)).build().perform();
    				Thread.sleep(2000);
    				
    				String SubTotal=SubTotal_List.get(m).getText();
    	    		System.out.println("SubTotal: "+SubTotal);
    			}
    			
    		}
    		
    		act.sendKeys(Keys.PAGE_DOWN);
    		Thread.sleep(2000);
    		System.out.println();
    	}
		
		
    }
        

}
