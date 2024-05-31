package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenMenu {
	
	 WebDriver driver;
		
	    public WomenMenu(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}
	    
	    
/* -----------------------------      Repository of Elements       ------------------------------------ */
	    
	    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
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
	    
	   
	    
/* ------------ SideBar_WomenMenuPage Items  (after Clicking on WomenMenu) --------  */  
            
	    //  ShopBy_Category_Options - Tops , Bottoms
	    @FindBy(xpath="//dd/child::ol/child::li/child::a") List<WebElement> ShopBy_Category_Options;
	    
		
	    //  Tops Category Menu 
	    @FindBy(xpath="//div[@class='categories-menu']/child::strong[1]/child::span") WebElement Tops_Menu1;
	          
	          // items inside Tops Category Menu
	          @FindBy(xpath="//div[@class='categories-menu']/child::ul[1]/child::li/child::a") List<WebElement> Items_Inside_Tops; 
	        
	    
	    //  Bottoms Category Menu 
	    @FindBy(xpath="//div[@class='categories-menu']/child::strong[2]/child::span") WebElement Bottoms_Menu2;
	           
	           // items inside Bottoms Category Menu
               @FindBy(xpath="//div[@class='categories-menu']/child::ul[2]/child::li/child::a") List<WebElement> Items_Inside_Bottoms; 
  
	    
	     
	    
	    
	    
/* --------------------------------  Methods  -------------------------------------- */
	    
       //  url()       
	    public void url() throws InterruptedException
		{
			driver.get("https://magento.softwaretestingboard.com/");
			Thread.sleep(2000);
		}
	    
	   
	    //  Homepage_title_should_be
	    public void Homepage_title_should_be(String expectedTitle) throws InterruptedException 
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
	    
	    
	
/*  -----------  Method for level_1_level_2_SubMenu (after performing MouseHover Operation on WomenMenu ---- 
        Tops - Jackets , Hoodies & Sweat shirts , Tees ,Bras & Tanks.
        Bottoms - Pants , Shorts.  ---------------	   */
	    
	    //  verify_level_1_level_2_SubMenu
	    public void verify_level_1_level_2_SubMenu() throws InterruptedException
	    {
	    	Actions act2=new Actions(driver);
				
	   		
			// -------   Items_Inside_Tops  -------------
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Tops).build().perform();
	    	
	    	String T=Tops.getText();
            System.out.println("1) "+T);
	    	
	    	for(int j=0;j<Tops_SubMenu1.size();j++)
				{
					act2.moveToElement(Tops_SubMenu1.get(j)).build().perform();
					Thread.sleep(1000);
					String result2=Tops_SubMenu1.get(j).getText();
					
					System.out.println("-------------> "+result2);	
					
				}
				
			
			// -------   Items_Inside_Bottoms  -------------
				
	    	
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Bottoms).build().perform();
	    	
	    	String B=Bottoms.getText();
            System.out.println("1) "+B);
	    	
	    	for(int n=0;n<Bottoms_SubMenu2.size();n++)
				{
					act2.moveToElement(Bottoms_SubMenu2.get(n)).build().perform();
					Thread.sleep(1000);
					String result3=Bottoms_SubMenu2.get(n).getText(); 
	
					System.out.println("-------------> "+result3);
					
				}
	    	System.out.println();
			}
			  
	    
	   //  Verify_WomenMenu_PageTitle
	    public void Verify_WomenMenu_PageTitle(String expectedTitle) throws InterruptedException
	   {
		   String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)) {
				System.out.println("We are on WomenMenu Page");
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}   
		   
	   }
	   
	  
	   
//  -----------  Method for "SideBar" Options available inside Women's Menu  ---------------
	   
	    //  Verify_SideBar_WomenMenuPage
	    public void Verify_SideBar_WomenMenuPage() throws InterruptedException
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
		          
	 // -------   Tops_Menu1 and Items_Inside_Tops  -------------
		            
		            String result2=Tops_Menu1.getText();
		            System.out.println("2) "+result2);
		        	
		            System.out.println("Items_Inside_Tops: "+Items_Inside_Tops.size());
		        	
		            for(int j=0;j<Items_Inside_Tops.size();j++)
					{	
		 			    act5.moveToElement(Items_Inside_Tops.get(j)).build().perform();
		 			    Thread.sleep(1000);
		            	String result3=Items_Inside_Tops.get(j).getText(); 
						System.out.println("-------------> "+result3);
					}
					
					System.out.println();
					
	 
					// --------  Bottoms_Menu2 and Items_Inside_Bottoms  ------------
					
					String result3=Bottoms_Menu2.getText();
				    System.out.println("3) "+result3);
				    
				    System.out.println("Items_Inside_Bottoms: "+Items_Inside_Bottoms.size());	
					
				    for(int n=0;n<Items_Inside_Bottoms.size();n++)
					{	
		 			    act5.moveToElement(Items_Inside_Bottoms.get(n)).build().perform();
		 				Thread.sleep(1000);
				    	String result4=Items_Inside_Bottoms.get(n).getText();  
						System.out.println("-------------> "+result4);
					}
					System.out.println();
				
	   }
				
				
	   }
		   
	   


