package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	
WebDriver driver;

	
	public AddToCart(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}

	
/* -----------------  Repository of Elements ------------------ */
	    
	  @FindBy(id="ui-id-5") WebElement MenMenu;

	//  Level_1_SubMenu (after performing MouseHover Operation on WomenMenu --- Tops , Bottom )
	    
	  @FindBy(xpath="//li[starts-with(@class,'level1 nav-3-1')]/child::a[1]/child::span[2]") WebElement Tops;
	  @FindBy(xpath="//li[starts-with(@class,'level1 nav-3-2')]/child::a[1]/child::span[2]") WebElement Bottoms;
	    
	    
	    /*  Level_2_SubMenu (after performing MouseHover Operation on WomenMenu ---- 
      Tops - Jackets , Hoodies & Sweat shirts , Tees ,Bras & Tanks.
      Bottoms - Pants , Shorts.
      */
	  @FindBy(xpath="//li[starts-with(@class,'level2 nav-3-1-')]/child::a") List<WebElement> Tops_SubMenu1;
  	  @FindBy(xpath="//li[starts-with(@class,'level2 nav-3-2-')]/child::a/child::span") List<WebElement> Bottoms_SubMenu2;

	    
	    //  Add item to Cart 
	    
	    @FindBy(xpath="//div[@class='product details product-item-details']/child::strong/child::a") List<WebElement> Jackets_List;
	   
	    
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
	    
	    
	    
	    
	   //   clickOnMyCart_Link
	    public void clickOnMyCart_Link() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
			act.moveToElement(MyCart_Link).build().perform();
			Thread.sleep(1000);
	    	
	    	
	    	MyCart_Link.click();
	    	Thread.sleep(2000);
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
	    
	    
	    
	    //  clickOnMenMenu
	    public void clickOnMenMenu() {
	    	MenMenu.click();
	    }
	    
	   
	    //  Perform_MouseHover_Operation
	    public void Perform_MouseHover_Operation() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
			act.moveToElement(MenMenu).build().perform();
			Thread.sleep(2000);
	    }
	    
	    
	    
	    //  Error_Msg_ForSize
	    public void Error_Msg_ForSize()
	    {
	    	String Error_Msg=Error_Msg_Size.getText();
	    	System.out.println("Error Message For Not Selecting Size:     "+Error_Msg);
	    }
	    
	    
	    //  Error_Msg_ForColour
	    public void Error_Msg_ForColour()
	    {
	    	String Error_Msg=Error_Msg_Colour.getText();
	    	System.out.println("Error Message For Not Selecting Colour:     "+Error_Msg);
	    	System.out.println();
	    }
	    
	    
	    
	    //   Select_Size
		   public void Select_Size() throws InterruptedException
		   {
			   for(int m=0;m<=Sizes.size();m++)
			   {
				   if(m==2)
				   {
				   String Selected_Size=Sizes.get(2).getText();
				   Sizes.get(2).click();
				   Thread.sleep(3000);
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
	    
	    
	    	    
	    
	  //   Add_Item_To_Cart
	    public void Add_Item_To_Cart() throws InterruptedException
	    {
           Actions act2=new Actions(driver);
				
	   		
			// -------   Items_Inside_Tops  -------------
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Tops).build().perform();
	    	
	    	String T=Tops.getText();
            //System.out.println("1) With Login ");
	    	
	    	for(int j=0;j<=0;j++)
				{
					act2.moveToElement(Tops_SubMenu1.get(j)).build().perform();
					Tops_SubMenu1.get(j).click();
					
					for(int i=1;i<=2;i++)
					{
						String result2=Jackets_List.get(i).getText();
						Jackets_List.get(i).click();
						
						System.out.println("Item Added to the Cart:   "+result2);
						
						Thread.sleep(2000);
						Select_Size();
						
						Thread.sleep(2000);
						Select_Colour();
						
						
						//System.out.println("Item Added to the Cart:   "+result2);
						//System.out.println(result2);
						clickOn_AddToCart_Button();
					
						driver.navigate().back();
						Thread.sleep(2000);
					}	
					
				}
	    	System.out.println();
	    }
	    
	    
	    
	    
	   //   AddItemToCart_Without_Size_and_Colour
	    public void AddItemToCart_Without_Size_and_Colour() throws InterruptedException
	    {
           Actions act2=new Actions(driver);
				
	   		
			// -------   Items_Inside_Tops  -------------
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Tops).build().perform();
	    	
	    	String T=Tops.getText();
           // System.out.println("1) With Login \n");
	    	
	    	for(int j=0;j<=0;j++)
				{
					act2.moveToElement(Tops_SubMenu1.get(j)).build().perform();
					Tops_SubMenu1.get(j).click();
					
					for(int i=1;i<=2;i++)
					{
						Jackets_List.get(i).click();
						clickOn_AddToCart_Button();
						
						System.out.println("Item is not Added to the Cart: ");
						
						Error_Msg_ForSize();
						Error_Msg_ForColour();
						
						driver.navigate().back();
						
						Thread.sleep(2000);
					}	
					System.out.println();
					
				}
	    	System.out.println();
	    }
	    

	    //  Add_Item_To_Cart_without_Login
	    public void Add_Item_To_Cart_without_Login() throws InterruptedException
	    {
           Actions act2=new Actions(driver);
				
	   		
			// -------   Items_Inside_Tops  -------------
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Tops).build().perform();
	    	
	    	String T=Tops.getText();
            System.out.println("2) Without Login: ");
	    	
	    	for(int j=0;j<=0;j++)
				{
					act2.moveToElement(Tops_SubMenu1.get(j)).build().perform();
					Tops_SubMenu1.get(j).click();
					
					for(int i=0;i<=1;i++)
					{
						String result2=Jackets_List.get(i).getText();
						Jackets_List.get(i).click();
						clickOn_AddToCart_Button();
						if(driver.getTitle()=="My Wish List")
						{
						System.out.println("Item Added to the Cart: "+result2);
						}
						else
						{
							System.out.println("Item not Added to the Cart User must Login");
						}
						driver.navigate().back();
						driver.navigate().back();
						Thread.sleep(2000);
					}	
					
				}
	    	System.out.println();
	    }
	    
	    
	    //  PageTitle_Without_Login
	    public void PageTitle_Without_Login(String expectedTitle)
	    {
	    	String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)) {
				System.out.println("We are on the Customer Login Page \n");  //Proteus Fitness Jackshirt
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}
	    }
	    
	        
	    
	   
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
