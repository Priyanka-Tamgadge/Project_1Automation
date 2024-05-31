package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaleMenu {
	
WebDriver driver;
	
    public SaleMenu(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------------------      Repository of Elements       ------------------------------------ */
    
    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
    @FindBy(id="ui-id-8") WebElement SaleMenu;
    

    /* ------------ SideBar_SaleMenuPage Items  (after Clicking on SaleMenu) --------  */  
    
   
    //  Womens_Deals 
    @FindBy(xpath="//div[@class='categories-menu']/child::strong[1]/child::span") WebElement Womens_Deals;
          
          // Items_Inside_Womens_Deals
          @FindBy(xpath="//div[@class='categories-menu']/child::ul[1]/child::li/child::a") List<WebElement> Items_Inside_Womens_Deals; 
 

          
    //  Mens_Deals 
  	 @FindBy(xpath="//div[@class='categories-menu']/child::strong[2]/child::span") WebElement Mens_Deals;
  	           
  	      // Items_Inside_Mens_Deals
                 @FindBy(xpath="//div[@class='categories-menu']/child::ul[2]/child::li/child::a") List<WebElement> Items_Inside_Mens_Deals; 


                 
     //  Gear_Deals 
     @FindBy(xpath="//div[@class='categories-menu']/child::strong[3]/child::span") WebElement Gear_Deals;
              	           
           // Items_Inside_Gear_Deals
                  @FindBy(xpath="//div[@class='categories-menu']/child::ul[3]/child::li/child::a") List<WebElement> Items_Inside_Gear_Deals; 


   
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
	    public void clickOnSaleMenu() {
	    	SaleMenu.click();
	    }
	   
	    
	    //  Perform_MouseHover_Operation
	    public void Perform_MouseHover_Operation() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
			
			act.moveToElement(SaleMenu).build().perform();
			Thread.sleep(2000);
	    }
	    
	    
	//  Verify_SaleMenu_PageTitle
	    public void Verify_SaleMenu_PageTitle(String expectedTitle) throws InterruptedException
	   {
		   String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)) {
				System.out.println("We are on SaleMenu Page");      //  Sale
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}   
		   
	   }
	    
	    
	    
//-----------  Method for "SideBar" Options available inside SaleMenu Menu  ---------------
		   
	    //  Verify_SideBar_SaleMenuMenMenuPage
	    public void Verify_SideBar_SaleMenuPage() throws InterruptedException
	   {
		    Actions act5=new Actions(driver);
	  
	 // -------   Womens_Deals and Items_Inside_Womens_Deals  -------------
		            
		            String result2=Womens_Deals.getText();
		            System.out.println("1) "+result2);
		        	
		            System.out.println("Items_Inside_Womens_Deals: "+Items_Inside_Womens_Deals.size());
		        	
		            for(int j=0;j<Items_Inside_Womens_Deals.size();j++)
					{	
		 			    act5.moveToElement(Items_Inside_Womens_Deals.get(j)).build().perform();
		 			    Thread.sleep(1000);
		            	String result3=Items_Inside_Womens_Deals.get(j).getText(); 
						System.out.println("-------------> "+result3);
					}
					
					System.out.println();
					
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollBy(0, 500)");
					
	 
					// --------  Mens_Deals and Items_Inside_Mens_Deals  ------------
					
					String result3=Mens_Deals.getText();
				    System.out.println("2) "+result3);
				    
				    System.out.println("Items_Inside_Mens_Deals: "+Items_Inside_Mens_Deals.size());	
					
				    for(int n=0;n<Items_Inside_Mens_Deals.size();n++)
					{	
		 			    act5.moveToElement(Items_Inside_Mens_Deals.get(n)).build().perform();
		 				Thread.sleep(1000);
				    	String result4=Items_Inside_Mens_Deals.get(n).getText();  
						System.out.println("-------------> "+result4);
					}
					System.out.println();
				
					
					
               // --------  Gear_Deals and Items_Inside_Gear_Deals  ------------
					
					String result4=Gear_Deals.getText();
				    System.out.println("2) "+result4);
				    
				    System.out.println("Items_Inside_Gear_Deals: "+Items_Inside_Gear_Deals.size());	
					
				    for(int i=0;i<Items_Inside_Gear_Deals.size();i++)
					{	
		 			    act5.moveToElement(Items_Inside_Gear_Deals.get(i)).build().perform();
		 				Thread.sleep(1000);
				    	String result5=Items_Inside_Gear_Deals.get(i).getText();  
						System.out.println("-------------> "+result5);
					}
		
				    System.out.println();
	   }
	  
	    
	    
	   
	    
    
    
    
}
