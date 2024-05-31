package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
WebDriver driver;
	
    public HomePage(WebDriver wd)
	{
		driver=wd;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
	
	/* -----------------  Repository of Elements ------------------ */
	
	@FindBy(xpath="//h1[@class='page-title']/child::span[@class='base']") WebElement titleLocator;
	@FindBy(xpath="//a[@class='block-promo home-main']") WebElement newLumaYogaCollectionBannerLocator;
	@FindBy(xpath="//span[@class='action more button']") WebElement shopNewYogaButtonLocator;
	
	 // Menu Elements
    
    @FindBy(id="ui-id-3") WebElement whatsNewMenu;
    @FindBy(id="ui-id-4") WebElement womenMenu;
    @FindBy(id="ui-id-5") WebElement menMenu;
    @FindBy(id="ui-id-6") WebElement gearMenu;
    @FindBy(id="ui-id-7") WebElement trainingMenu;
    @FindBy(id="ui-id-8") WebElement saleMenu;
    
    // Link Elements

    @FindBy(xpath="//li[@class='greet welcome']/child::span/child::a[1]") WebElement supportLink;
    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
    @FindBy(linkText="Create an Account") WebElement createAccountLink;
    @FindBy(name="q") WebElement SearchBar;
    @FindBy(xpath="//a[@class='action showcart']") WebElement showCart;
    
    
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
    
    public void clickOnShopNewYogaButton() {
    	shopNewYogaButtonLocator.click();
    }
       
   
    // Methods for menus
    public void clickOnWhatsNewMenu() {
    	whatsNewMenu.click();
    }
    
    
    public void clickOnWomenMenu() {
        womenMenu.click();
    }

    
    public void clickOnmenMenuLocator() {
        menMenu.click();
    }
       
    
    public void clickOntrainingMenuLocatorr() {
        trainingMenu.click();
    }

    
    public void clickOnsaleMenuLocator() {
        saleMenu.click();
    }

    
 // Methods for  links
    
    public void clickOnSupportLink() {
        supportLink.click();
    }
    
    
    public void clickOnSignInLink() {
        signInLink.click();
    }
    
    
    public void clickOnCreateAccountLink() {
        createAccountLink.click();
    }

    
    public void clickOnSearchBar() {
        SearchBar.click();
    }
    
    
    public void clickOnShowCart() {
    	showCart.click();
    }
    
/* ----------  method to verify presence of all menus and links  -------------- */  
    
    
    public boolean isnewLumaYogaCollectionBannerLocatorDisplayed() {
        return newLumaYogaCollectionBannerLocator.isDisplayed();
    }
    
    
    public boolean isWhatsNewMenuDisplayed() {
        return whatsNewMenu.isDisplayed();
    }
    
    
    public boolean isWomenMenuDisplayed() {
        return womenMenu.isDisplayed();
    }
    
    
    public boolean ismenMenuLocatorDisplayed() {
        return menMenu.isDisplayed();
    }
    
    
    public boolean istrainingMenuLocatorDisplayed() {
        return trainingMenu.isDisplayed();
    }
    
    
    public boolean issaleMenuLocatorDisplayed() {
        return saleMenu.isDisplayed();
    }
    
    
    public boolean isSupportLinkDisplayed() {
        return supportLink.isDisplayed();
    }
    
    
    public boolean isSignInLinkDisplayed() {
        return signInLink.isDisplayed();
    }
    
    
    public boolean isCreateAccountLinkDisplayed() {
        return createAccountLink.isDisplayed();
    }

    
    public boolean isSearchBarDisplayed() {
        return SearchBar.isDisplayed();
    }
    
    
    public boolean isShowCartDisplayed() {
        return showCart.isDisplayed();
    }

    
    // Added a method to verify presence of all menus and links
    public boolean areAllMenusAndLinksDisplayed() {
        return isWhatsNewMenuDisplayed() & isWomenMenuDisplayed() & isnewLumaYogaCollectionBannerLocatorDisplayed() & ismenMenuLocatorDisplayed() & istrainingMenuLocatorDisplayed() & issaleMenuLocatorDisplayed() & isShowCartDisplayed() &
               isSupportLinkDisplayed() & isSignInLinkDisplayed() & isCreateAccountLinkDisplayed(); // Added checks for all links
    }
     
    
    

}
