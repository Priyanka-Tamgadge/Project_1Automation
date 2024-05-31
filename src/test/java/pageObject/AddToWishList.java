package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToWishList {
	
	WebDriver driver;

	
	public AddToWishList(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}

	
/* -----------------  Repository of Elements ------------------ */
	    
	   
	    @FindBy(id="ui-id-4") WebElement womenMenu;
	    
	    //  Level_1_SubMenu (after performing MouseHover Operation on WomenMenu --- Tops , Bottom )
	    
	    @FindBy(xpath="//li[starts-with(@class,'level1 nav-2-1')]/child::a[1]/child::span[2]") WebElement Tops;
	    @FindBy(xpath="//li[starts-with(@class,'level1 nav-2-2')]/child::a[1]/child::span[2]") WebElement Bottoms;
	    
	    
	    /*  Level_2_SubMenu (after performing MouseHover Operation on WomenMenu ---- 
        Tops - Jackets , Hoodies & Sweat shirts , Tees ,Bras & Tanks.
        Bottoms - Pants , Shorts.
        */
	    @FindBy(xpath="//li[starts-with(@class,'level2 nav-2-1-')]/child::a") List<WebElement> Tops_SubMenu1;
	    @FindBy(xpath="//li[starts-with(@class,'level2 nav-2-2-')]/child::a/child::span") List<WebElement> Bottoms_SubMenu2;
	    
	    
	    //  Add item to wishlist 
	    
	    @FindBy(xpath="//div[@class='product details product-item-details']/child::strong/child::a") List<WebElement> Jackets_List;
	    
	   
	    
	    //  Add to wishlist Link 
	    
	    @FindBy(xpath="//div[@class='product-addto-links']/child::a") WebElement Add_to_wishlist_Link;
	   
	   
	    // My WishList Page --  item list  
	    
	    @FindBy(xpath="//div[@class='panel header']/child::ul/child::li[2]/child::span/child::button") WebElement ProfileBtn;
	    @FindBy(xpath="//li[@class='link wishlist']/child::a[1]") WebElement My_Wish_List;
	    @FindBy(xpath="//div[@class='product-item-info']/child::strong[@class='product-item-name']/child::a") List<WebElement> Wishlisted_Items;
 
	    //   
	    
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
	    
	    
	    
	    //  clickOnWomenMenu
	    public void clickOnWomenMenu() {
	        womenMenu.click();
	    }
	    
	    //  Perform_MouseHover_Operation
	    public void Perform_MouseHover_Operation() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
			act.moveToElement(womenMenu).build().perform();
			Thread.sleep(2000);
	    }
	    
   
	    //  Add_Item_To_WishList
	    public void Add_Item_To_WishList() throws InterruptedException
	    {
           Actions act2=new Actions(driver);
				
	   		
			// -------   Items_Inside_Tops  -------------
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Tops).build().perform();
	    	
	    	String T=Tops.getText();
            System.out.println("1) With Login ");
	    	
	    	for(int j=0;j<=0;j++)
				{
					act2.moveToElement(Tops_SubMenu1.get(j)).build().perform();
					Tops_SubMenu1.get(j).click();
					
					for(int i=0;i<=1;i++)
					{
						String result2=Jackets_List.get(i).getText();
						Jackets_List.get(i).click();
						clickOn_Add_to_wishlist_Link();
						System.out.println("Item Added to the WishList: "+result2);
						driver.navigate().back();
						driver.navigate().back();
						Thread.sleep(2000);
					}	
					
				}
	    	System.out.println();
	    }
	    
	    
	    
	    public void Add_Item_To_WishList_without_Login() throws InterruptedException
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
						clickOn_Add_to_wishlist_Link();
						if(driver.getTitle()=="My Wish List")
						{
						System.out.println("Item Added to the WishList: "+result2);
						}
						else
						{
							System.out.println("Item not Added to the WishList User must Login");
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
				System.out.println("We are on the Customer Login Page \n");
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}
	    }
	    
	        
	    //  clickOn_Add_to_wishlist_Link
	    public void clickOn_Add_to_wishlist_Link() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
			act.moveToElement(Add_to_wishlist_Link).build().perform();
			Thread.sleep(1000);
	    	Add_to_wishlist_Link.click();
	    	Thread.sleep(2000);
	    }
	    
	    
	    // WishListed_Items 
	    public void WishListed_Items() throws InterruptedException
	    {
	    	clickOnProfileBtn();
	    	clickOn_My_Wish_List();
	    	for(int n=0;n<Wishlisted_Items.size();n++)
	    	{
	    		String My_Wish=Wishlisted_Items.get(n).getText();
	    		System.out.println("Item Inside WishList: "+My_Wish);
	    	}
	    	
	    	System.out.println();
	    }
}
