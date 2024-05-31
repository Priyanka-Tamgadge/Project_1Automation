package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearMenu {
	
	
    WebDriver driver;
	
    public GearMenu(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------------------      Repository of Elements       ------------------------------------ */
    
    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
    @FindBy(id="ui-id-6") WebElement GearMenu;
    
    
    //  Level_1_SubMenu (after performing MouseHover Operation on GearMenu --- Bags , Fitness Equipment , Watches )
    
    @FindBy(xpath="//li[starts-with(@class,'level1 nav-4')]/child::a/child::span") List<WebElement> Gear_SubMenu;
    

    /* ------------ SideBar_GearMenuPage Items  (after Clicking on GearMenu) --------  */  
    
    //  ShopBy_Category_Options - Bags , Fitness Equipment , Watches
    @FindBy(xpath="//dd/child::ol/child::li/child::a") List<WebElement> ShopBy_Category_Options;
    
    @FindBy(xpath="//div[@class='categories-menu']/child::ul/child::li/child::a") List<WebElement> Items_List;
       
 
 
    
    /* --------------------------------  Methods  -------------------------------------- */
    
    //  url()       
	    public void url() throws InterruptedException
		{
			driver.get("https://magento.softwaretestingboard.com/");
			Thread.sleep(2000);
		}
	    
	   
	    //  HomePage_title_should_be
	    public void HomePage_title_should_be(String expectedTitle) throws InterruptedException 
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
	    
	    
	    //  clickOnWomenMenu
	    public void clickOnGearMenu() {
	    	GearMenu.click();
	    }
	   
	    
	    //  Perform_MouseHover_Operation
	    public void Perform_MouseHover_Operation() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
			
			act.moveToElement(GearMenu).build().perform();
			Thread.sleep(2000);
	    }
	    
	    
	
/*  -----------  Method for verify_GearMenu_Items (after performing MouseHover Operation on MenMenu ---- */
   
	    
	    //  verify_GearMenu_Items
	    public void verify_GearMenu_Items () throws InterruptedException
	    {
	    	Actions act2=new Actions(driver);
				
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(GearMenu).build().perform();
	    	
	    	String T=GearMenu.getText();
            System.out.println("1) "+T);
	    	
	    	for(int j=0;j<Gear_SubMenu.size();j++)
				{
					act2.moveToElement(Gear_SubMenu.get(j)).build().perform();
					
					String result2=Gear_SubMenu.get(j).getText();
					
					System.out.println("-------------> "+result2);	
					
				}
	    	System.out.println();
	    }
	    
	    
	    
	    
	//  Verify_GearMenu_PageTitle
	    public void Verify_GearMenu_PageTitle(String expectedTitle) throws InterruptedException
	   {
		   String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)) {
				System.out.println("We are on GearMenu Page");       //  Gear
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}   
		   
	   }
	    
  
	   //   Verify_SideBar_GearMenuPage
	    public void Verify_SideBar_GearMenuPage() throws InterruptedException
	    {
	    	System.out.println("\n*SideBar Options:  ");
		    Actions act5=new Actions(driver);
	  
		    // -----------   ShopBy_Category_Options ---------------
		   
		    System.out.println("\n1) ShopBy_Category_Options: "+ShopBy_Category_Options.size());
		    for(int i=0;i<ShopBy_Category_Options.size();i++)  
			{
			   act5.moveToElement(ShopBy_Category_Options.get(i)).build().perform();
			   Thread.sleep(1000);
			   String result=ShopBy_Category_Options.get(i).getText();
				System.out.println(result);
			}
		          System.out.println();
		       
		          JavascriptExecutor js = (JavascriptExecutor) driver;
		          js.executeScript("window.scrollBy(0, 500)");
		          
	          // -------   Items_Inside_GearMenu -------------
		            
		        	
		            for(int j=0;j<Items_List.size();j++)
					{	
		 			    act5.moveToElement(Items_List.get(j)).build().perform();
		 			    Thread.sleep(1000);
		            	String result3=Items_List.get(j).getText(); 
						System.out.println("-------------> "+result3);
					}
					
					System.out.println();
					
	    }
	    
			      
}
