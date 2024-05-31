package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	
    WebDriver driver;
	
    public SignIn(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    /* -----------------  Repository of Elements ------------------ */
    
    @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement signInLink;
    @FindBy(id="email") public WebElement Email;
    @FindBy(id="pass") public WebElement Password;
    @FindBy(xpath="//div[@class='primary']/child::button") WebElement SignInBtn;
    @FindBy(xpath="//div[@class='secondary']/child::a[@class='action remind']") public WebElement ForgotPasswordLink;
    @FindBy(xpath="//div[@class='primary']/child::a") public WebElement CreateAccountBtn;
    
    @FindBy(id="email-error") public WebElement Email_Error;
    @FindBy(id="pass-error") public WebElement Password_Error;
    
    
    
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
     
     
     public void enterEmail(String e)
     {
    	 Email.sendKeys(e);
     }
     
     public void enterPassword(String p)
     {
    	 Password.sendKeys(p);
     }
     
     
     public void clickOnSignInBtn() throws InterruptedException
     {
    	 SignInBtn.click();
    	 Thread.sleep(2000);
     }
     
     
     public void clickOnForgotPasswordLink() throws InterruptedException
     {
    	 ForgotPasswordLink.click();
    	 Thread.sleep(2000);
     }
     
     
     public void clickOnCreateAccountBtn() throws InterruptedException
     {
    	 CreateAccountBtn.click();
    	 Thread.sleep(2000);
     }
     
     
     public void signIn_With_BlanckDetails() throws InterruptedException
     {
    	 Email.sendKeys("");
    	 Thread.sleep(2000);
    	 Password.sendKeys("");
    	 Thread.sleep(2000);
    	 SignInBtn.click();
    	 Thread.sleep(2000);
    	 
    	 if(Email.getText()=="" || Password.getText()=="")
    	 {
    		 System.out.println("Email: "+Email_Error.getText() +"\nPassword: "+Password_Error.getText());
    	 }
     }
     
     
     public void signIn_With_BlanckEmail() throws InterruptedException
     {
    	 Email.sendKeys("");
    	 Thread.sleep(2000);
    	 Password.sendKeys("");
    	 Thread.sleep(2000);
    	 SignInBtn.click();
    	 Thread.sleep(2000);
    	 
    	 if(Email.getText()=="" || Password.getText()=="")
    	 {
    		 System.out.println(Email_Error.getText() +"\n"+Password_Error.getText());
    	 }
     }
     
     public void signIn_With_BlanckPassword() throws InterruptedException
     {
    	 Email.sendKeys("");
    	 Thread.sleep(2000);
    	 Password.sendKeys("");
    	 Thread.sleep(2000);
    	 SignInBtn.click();
    	 Thread.sleep(2000);
    	 
    	 if(Email.getText()=="" || Password.getText()=="")
    	 {
    		 System.out.println(Email_Error.getText() +"\n"+Password_Error.getText());
    	 }
     }
     
      
     public void SignInMethod(String e,String p) throws InterruptedException
      {
    	  url();
    	  clickOnSignInLink();
    	  enterEmail(e);
    	  enterPassword(p);
    	  clickOnSignInBtn();
      }
     
     
     /* ----------  method to verify presence of all menus and links  -------------- */  
     
     public boolean isEmailFieldDisplayed() {
         return Email.isDisplayed();
     }
     
     public boolean isPasswordFieldDisplayed() {
         return Password.isDisplayed();
     }
     
     public boolean isSignInBtnDisplayed() {
         return SignInBtn.isDisplayed();
     }
     
     public boolean isForgotPasswordLinkDisplayed() {
         return ForgotPasswordLink.isDisplayed();
     }
     
     public boolean isCreateAccountBtnDisplayed() {
         return CreateAccountBtn.isDisplayed();
     }
     
  // Added a method to verify presence of all Fields and Buttons
     public boolean areAllFieldsAndButtonsDisplayed() {
         return isEmailFieldDisplayed() & isPasswordFieldDisplayed() & isSignInBtnDisplayed() & 
        		 isForgotPasswordLinkDisplayed() & isCreateAccountBtnDisplayed(); // Added checks for all Fields and Buttons
     }
      

}
