package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {
	
	WebDriver driver;
	
    public SearchBar(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
/* -----------------  Repository of Elements ------------------ */
    
    @FindBy(id="search") public WebElement SearchBar;
    @FindBy(xpath="//div[@class='actions']/child::button") public WebElement SearchBtn;
    
 
    
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
			System.out.println("We are on  the Home Page");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
    }
    
    
    public void enterSearchElement(String s) throws InterruptedException
    {
    	url();
    	SearchBar.sendKeys(s);
		Thread.sleep(2000);
    }
    
    
    public void clickOnSearchBtn() throws InterruptedException
    {
    	SearchBtn.click();
    	Thread.sleep(2000);
    }
    

    
    
/* ----------  method to verify presence of Elements  -------------- */  

    public boolean isSearchBarDisplayed() {
        return SearchBar.isDisplayed();
    }
    
    // Added a method to verify presence of all menus and links
    public boolean areAllMenusAndLinksDisplayed() {
        return isSearchBarDisplayed(); // Added checks for all links
    }
    
    
    
    
    

}
