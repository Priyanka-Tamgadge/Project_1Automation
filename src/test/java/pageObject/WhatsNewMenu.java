package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNewMenu {
	
	 WebDriver driver;
		
	    public WhatsNewMenu(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}
	    
	    
	    /* -----------------  Repository of Elements ------------------ */
	    
	    @FindBy(id="ui-id-3") WebElement whatsNewMenu;
	    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
	    @FindBy(xpath="//div[@class='categories-menu']/child::ul[1]") WebElement New_in_Womens;
	    @FindBy(xpath="//div[@class='categories-menu']/child::ul[2]") WebElement New_in_mens;
	    
	    @FindBy(xpath="//div[@class='categories-menu']/child::ul[2]/li") List<WebElement> New_in_mens_List;
	    @FindBy(xpath="//div[@class='categories-menu']/child::ul[1]/li") List<WebElement> New_in_Womens_List;
	    
/* -----------------  Methods  ------------------ */
	    
	    public void url() throws InterruptedException
		{
			driver.get("https://magento.softwaretestingboard.com/");
			Thread.sleep(2000);
		}
	    
	    
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
	    
	    
	    public void clickOnWhatsNewMenu() {
	    	whatsNewMenu.click();
	    }
	    
	    
	    public void whatsNewMenu_PageTitle(String expectedTitle)
	    {
	    	String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)) {
				System.out.println("We are on What's New Page");
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}
	    }
	    
	    
	    public void New_in_Womens() throws InterruptedException
	    {
	   
			System.out.println("Total Search Results: "+New_in_Womens_List.size());
			
			System.out.println("\nNew_in_Womens Products: ");
			
			Actions act2=new Actions(driver);
			
			for(int i=0;i<New_in_Womens_List.size();i++)
			{
				act2.moveToElement(New_in_Womens_List.get(i)).build().perform();
				Thread.sleep(1000);
				String result=New_in_Womens_List.get(i).getText();  
				System.out.println(result);
			}
			
			System.out.println();

	    }
	    
	    
	    public void New_in_mens() throws InterruptedException
	    {
	    	
			System.out.println("Total Search Results: "+New_in_mens_List.size());
			
			System.out.println("\nNew_in_mens Products: ");
			
			Actions act2=new Actions(driver);
			
			for(int i=0;i<New_in_mens_List.size();i++)
			{
				act2.moveToElement(New_in_mens_List.get(i)).build().perform();
				Thread.sleep(1000);
				String result=New_in_mens_List.get(i).getText();  
				System.out.println(result);
			}
			
			System.out.println();
	    }
	    

	    /* ----------  method to verify presence of all menus and links  -------------- */  
	    
	    
	    public boolean isWhatsNewMenuDisplayed() {
	        return whatsNewMenu.isDisplayed();
	    }
	      
	    public boolean isSignInLinkDisplayed() {
	        return signInLink.isDisplayed();
	    }
	    
	    // Added a method to verify presence of all what's New menu and SignIn link
	    public boolean areAllMenusAndLinksDisplayed() {
	        return isWhatsNewMenuDisplayed() & isSignInLinkDisplayed(); // Added checks for all links
	    }
	     
	    
}
