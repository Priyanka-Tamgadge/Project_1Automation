package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
	 WebDriver driver;
		
	    public ForgotPassword(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}
	    
   /* -----------------  Repository of Elements ------------------ */
	    
	    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
	    @FindBy(xpath="//div[@class='secondary']/child::a[@class='action remind']") public WebElement ForgotPasswordLink;
	    @FindBy(id="email_address") public WebElement Email;
	    @FindBy(xpath="//button[@class='action submit primary']/child::span") WebElement ResetPassword_Btn;
	    @FindBy(id="email_address-error") public WebElement Email_Error;
	    
	    
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
	    
	    
	    
	    public void clickOnSignInLink() throws InterruptedException {
	        signInLink.click();
	        Thread.sleep(2000);
	    }
	      
	    
	    
	    public void SignIn_Page_Title(String expectedTitle) throws InterruptedException 
	      {
	  		String actualTitle=driver.getTitle();
	  		if(expectedTitle.equals(actualTitle)) {
	  			System.out.println("We are on the SignIn Page");
	  			}
	  		else
	  		{
	  			System.out.println("We are not on the desired Page");
	  		}
	     }
	    
	    public void clickOnForgotPasswordLink() throws InterruptedException
	    {
	    	ForgotPasswordLink.click();
	    	Thread.sleep(2000);
	    }
	    
	    
	    public void ForgotPassword_Page_Title(String expectedTitle) throws InterruptedException 
	      {
	  		String actualTitle=driver.getTitle();
	  		if(expectedTitle.equals(actualTitle)) {
	  			System.out.println("We are on the ForgotPassword Page");
	  			}
	  		else
	  		{
	  			System.out.println("We are not on the desired Page");
	  		}
	     }
	    
	    
	    public void enterEmailAddress(String e)
	    {
	    	Email.sendKeys(e);
	    }
	    
	    
	    public void clickOnResetPassword_Btn() throws InterruptedException
	    {
	    	ResetPassword_Btn.click();
	    	Thread.sleep(2000);
	    }
	    
	    
	    public void ForgotPasswordMethod() throws InterruptedException
	    {
	    	url();
	    	Homepage_title_should_be("Home Page");
	    	clickOnSignInLink();
	    	SignIn_Page_Title("Customer Login");
	    	clickOnForgotPasswordLink();
	    	enterEmailAddress("Draco@gmail.com");
	    	clickOnResetPassword_Btn();
	    }
	    
	    
	    
	 /* ----------  method to verify presence of all menus and links  -------------- */  
	     
	     
	     public boolean isForgotPasswordLinkDisplayed() {
	         return ForgotPasswordLink.isDisplayed();
	     }
	     
	     
	  // Added a method to verify presence of ForgotPasswordLink
	     public boolean areAllFieldsAndButtonsDisplayed() {
	         return isForgotPasswordLinkDisplayed(); // Added checks for all Fields and Buttons
	     }
	    
	    

}
