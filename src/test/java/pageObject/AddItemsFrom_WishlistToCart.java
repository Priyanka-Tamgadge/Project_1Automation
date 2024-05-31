package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemsFrom_WishlistToCart {
	
WebDriver driver;

	
	public AddItemsFrom_WishlistToCart(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}

	
/* -----------------  Repository of Elements ------------------ */
	    
	// My WishList Page --  item list  
    
    @FindBy(xpath="//div[@class='panel header']/child::ul/child::li[2]/child::span/child::button") WebElement ProfileBtn;
    @FindBy(xpath="//li[@class='link wishlist']/child::a[1]") WebElement My_Wish_List;
    @FindBy(xpath="//div[@class='product-item-info']/child::strong[@class='product-item-name']/child::a") List<WebElement> Wishlisted_Items;

    //
    @FindBy(xpath="//button[@title='Add All to Cart']") WebElement AddAllTo_Cart_Button;
    @FindBy(xpath="//div[@class='messages']/child::div/child::div[1]") List<WebElement> Error_Messages;


    //
    
    
    //  Add to Cart Button 
    
    @FindBy(id="product-addtocart-button") WebElement Add_to_Cart_Btn;
    
    //  MyCart_Link
    @FindBy(xpath="//a[@class='action showcart']") WebElement MyCart_Link;
    
    // Error message for not selecting size and colour 
    @FindBy(xpath="//div[@id='super_attribute[143]-error']") WebElement Error_Msg_Size;
    @FindBy(xpath="//div[@id='super_attribute[93]-error']") WebElement Error_Msg_Colour;
    
    // Size List - 
    @FindBy(xpath="//div[@class='swatch-option text']") List<WebElement> Sizes;
    
    //  colour List - 
    @FindBy(xpath="//div[@class='swatch-option color']") List<WebElement> Colours;
    
    
    
    /* --------------------------------  Methods  -------------------------------------- */
    
    
    public void clickOnProfileBtn() throws InterruptedException
    {
    	ProfileBtn.click();
    	Thread.sleep(2000);
    }
    
    
    public void clickOn_My_Wish_List() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(My_Wish_List).build().perform();
		Thread.sleep(1000);
  
		My_Wish_List.click();
    	Thread.sleep(2000);
    }
    
    
    public void WishListed_Items() throws InterruptedException
    {
    	//clickOnProfileBtn();
    	//clickOn_My_Wish_List();
    	for(int n=0;n<Wishlisted_Items.size();n++)
    	{
    		String My_Wish=Wishlisted_Items.get(n).getText();
    		System.out.println("Item Inside WishList: "+My_Wish);
    	}
    	
    	System.out.println();
    }
    
   
    public void Verify_AddAllTo_Cart_Button() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(AddAllTo_Cart_Button).build().perform();
		Thread.sleep(1000);
  
		AddAllTo_Cart_Button.click();
    	Thread.sleep(3000);
    	
    	for(int i=0;i<Error_Messages.size();i++)
    	{
    		String Error_Msg=Error_Messages.get(i).getText();
    		System.out.println("Error Message: "+Error_Msg);
    	}
    	
    	System.out.println();
    }
    

    
        
    //   Select_Size
	   public void Select_Size() throws InterruptedException
	   {
		   for(int m=0;m<=Sizes.size();m++)
		   {
			   if(m==1)
			   {
			   String Selected_Size=Sizes.get(1).getText();
			   Sizes.get(1).click();
			   Thread.sleep(4000);
			   System.out.println("Size selected by you is: "+Selected_Size);
			   }   
		   }
	   }
	    
	   
	   
	   //   Select_Colour
		   public void Select_Colour() throws InterruptedException
		   {
			   for(int n=0;n<=Colours.size();n++)
			   {
				   if(n==1)
				   {
				   Colours.get(1).click();
				   Thread.sleep(3000);
				   System.out.println("Colour is selected by you");
				   System.out.println();
				   }
				   
			   }
		   }
    
		   
   //  clickOn_AddToCart_Button
	public void clickOn_AddToCart_Button() throws InterruptedException
	{
		  Actions act=new Actions(driver);
		  act.moveToElement(Add_to_Cart_Btn).build().perform();
		  Thread.sleep(1000);
		    
		  Add_to_Cart_Btn.click();
		  Thread.sleep(2000);
	}
    
    	    
    
  //   Add_Item_To_Cart
    public void Add_Item_To_Cart() throws InterruptedException
    {
       Actions act2=new Actions(driver);
			
       for(int n=0;n<Wishlisted_Items.size();n++)
   	{
   		String My_Wish=Wishlisted_Items.get(n).getText();
   		Wishlisted_Items.get(n).click();
   		
   		System.out.println("Item Added to the Cart:   "+My_Wish);
   		
   		Select_Size();
   		Select_Colour();
   		
   		clickOn_AddToCart_Button();
		
		driver.navigate().back();
		Thread.sleep(2000);
   		
   	}
		
    	System.out.println();
    }
    
    

}
