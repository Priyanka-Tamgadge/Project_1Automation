package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishList {
	
WebDriver driver;
	
    public MyWishList(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
 /* -----------------  Repository of Elements ------------------ */
    
    @FindBy(xpath="//div[@class='panel header']/child::ul/child::li[2]/child::span/child::button") WebElement ProfileBtn;
    @FindBy(xpath="//li[@class='link wishlist']/child::a[1]") WebElement My_Wish_List;
    @FindBy(xpath="//div[@class='product-item-info']/child::strong[@class='product-item-name']/child::a") List<WebElement> Wishlisted_Items;
    
    
    
    
 /* -----------------  Methods  ------------------ */
    
    
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
    
    
    public void My_Wish_List_PageTitle(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("We are on the My_Wish_List Page \n");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
   }
    
    
    
    public void WishListed_Items() throws InterruptedException
    {
    	//clickOnProfileBtn();
    	//clickOn_My_Wish_List();
    	System.out.println("Wishlisted Items are: ");
    	for(int n=0;n<Wishlisted_Items.size();n++)
    	{
    		Actions act=new Actions(driver);
    		act.moveToElement(Wishlisted_Items.get(n)).build().perform();
    		Thread.sleep(1000);
    		
    		String My_Wish=Wishlisted_Items.get(n).getText();
    		System.out.println("Item Added to the WishList: "+My_Wish);
    	}
    	System.out.println();
    }
    
    
    
    public boolean isProfileBtnDisplayed() {
        return ProfileBtn.isDisplayed();
    }
    
    
    public boolean isMy_Wish_ListFieldDisplayed() {
        return My_Wish_List.isDisplayed();
    }
       

}
