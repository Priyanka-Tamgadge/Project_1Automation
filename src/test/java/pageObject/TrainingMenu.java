package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingMenu {
	
WebDriver driver;
	
    public TrainingMenu(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------------------      Repository of Elements       ------------------------------------ */
    
    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
    @FindBy(id="ui-id-7") WebElement TrainingMenu;
    
    
    //  Level_1_SubMenu (after performing MouseHover Operation on TrainingMenu ---  Video Download)
    
    @FindBy(xpath="//li[starts-with(@class,'level1 nav-5')]/child::a/child::span") List<WebElement> Training_SubMenu;
    

    /* ------------ SideBar_TrainingMenu Items  (after Clicking on TrainingMenu) --------  */  
    
    //  ShopBy_Category_Options - Video Download
    @FindBy(xpath="//dd/child::ol/child::li/child::a") List<WebElement> ShopBy_Category_Options;
    
	

    
    
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
	    
	    
	    //  clickOnTrainingMenu
	    public void clickOnTrainingMenu() {
	    	TrainingMenu.click();
	    }
	   
	    
	    //  Perform_MouseHover_Operation
	    public void Perform_MouseHover_Operation() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
			
			act.moveToElement(TrainingMenu).build().perform();
			Thread.sleep(2000);
	    }
	    
	    
	
/*  -----------  Method for verify_TrainingMenu_Items (after performing MouseHover Operation on TrainingMenu ---- */
   
	    
	    //  verify_TrainingMenu_Items
	    public void verify_TrainingMenu_Items () throws InterruptedException
	    {
	    	Actions act2=new Actions(driver);
				
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(TrainingMenu).build().perform();
	    	
	    	String T=TrainingMenu.getText();
            System.out.println("1) "+T);
	    	
	    	for(int j=0;j<Training_SubMenu.size();j++)
				{
					act2.moveToElement(Training_SubMenu.get(j)).build().perform();
					
					String result2=Training_SubMenu.get(j).getText();
					
					System.out.println("-------------> "+result2);	
					
				}
	    	System.out.println();
	    }
	    
	    
	    
	    
	//  Verify_TrainingMenu_PageTitle
	    public void Verify_TrainingMenu_PageTitle(String expectedTitle) throws InterruptedException
	   {
		   String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)) {
				System.out.println("We are on TrainingMenu Page");       //  Training
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}   
		   
	   }
	    
 
	    
	    public void Verify_SideBar_TrainingMenuPage() throws InterruptedException
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
		         
					
	    }
    
}
