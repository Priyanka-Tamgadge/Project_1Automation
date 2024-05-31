package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	
    WebDriver driver;
	
    public CreateAccount(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    /* -----------------  Repository of Elements ------------------ */
    
    @FindBy(linkText="Create an Account") WebElement Create_Account_Link;
    @FindBy(id="firstname") public WebElement Firstname;
    @FindBy(id="lastname") public WebElement Lastname;
    @FindBy(id="email_address") public WebElement Email_address;
    @FindBy(id="password") public WebElement Password;
    @FindBy(id="password-confirmation")public WebElement Password_Confirmation;
    @FindBy(xpath="//button[@class='action submit primary']") WebElement Create_Account_Btn;
    
    //required field error
    @FindBy(id="firstname-error") public WebElement firstname_error;
    @FindBy(id="lastname-error") public WebElement lastname_error;
    @FindBy(id="email_address-error") public WebElement email_address_error;
    @FindBy(id="password-error") public WebElement password_error;
    @FindBy(id="password-confirmation-error")public WebElement password_confirmation_error;
   
    
   /* -----------------  Methods  ------------------ */
    
    // url
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
			System.out.println("We are on  the Home Page");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
    }
    
    
    //  clickOnCreate_Account_Link
    public void clickOnCreate_Account_Link() throws InterruptedException {
    	Create_Account_Link.click();
        Thread.sleep(2000);
    }
      
    
    //  Create_Account_Page_Title
    public void Create_Account_Page_Title(String expectedTitle) throws InterruptedException 
      {
  		String actualTitle=driver.getTitle();
  		if(expectedTitle.equals(actualTitle)) {
  			System.out.println("We are on the Create Account Page");
  			}
  		else
  		{
  			System.out.println("We are not on the desired Page");
  		}
     }
    
    
    public void enterFirstname(String f)
    {
    	Firstname.sendKeys(f);
    }
    
    
    public void enterLastname(String l)
    {
    	Lastname.sendKeys(l);
    }
    
    
    public void enterEmail_address(String em)
    {
    	Email_address.sendKeys(em);
    }
    
    
    public void enterPassword(String ps)
    {
    	Password.sendKeys(ps);
    }
    
    
    public void enterPassword_Confirmation(String pc)
    {
    	Password_Confirmation.sendKeys(pc);
    }
    
    
    public void clickOnCreate_Account_Btn() throws InterruptedException
    {
    	Create_Account_Btn.click();
   	    Thread.sleep(2000);
    }
    
    
    //  After_Creating_Account_PageTitle
    public void After_Creating_Account_PageTitle(String expectedTitle) throws InterruptedException 
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
    
    
    //  createAccount_With_BlanckDetails
    public void createAccount_With_BlanckDetails() throws InterruptedException
    {
    	Firstname.sendKeys("");
   	    Thread.sleep(1000);
   	    Lastname.sendKeys("");
   	    Thread.sleep(1000);
   	    Email_address.sendKeys("");
   	    Thread.sleep(1000);
   	    Password.sendKeys("");
   	    Thread.sleep(1000);
   	    Password_Confirmation.sendKeys("");
   	    Thread.sleep(1000);
   	    Create_Account_Btn.click();
   	    Thread.sleep(2000);
   	 
   	 if(Firstname.getText()=="" || Lastname.getText()=="" || Email_address.getText()=="" || 
   			 Password.getText()==""|| Password_Confirmation.getText()=="")
   	 {
   		 System.out.println("Firstname: "+firstname_error.getText() +"\nLastname: "+lastname_error.getText()
   		+"\nEmail Address: "+email_address_error.getText() +"\nPassword: "+password_error.getText()+"\nPassword_Confirmation: "+password_confirmation_error.getText()+"\n");
   	 }
    }
    
    
    //   Create Account Method
    public void Create_Account_Method(String fn,String ln,String Em_Add,String Ps,String Con_pss) throws InterruptedException
    {
    	url();
    	clickOnCreate_Account_Link();
    	enterFirstname(fn);
    	enterLastname(ln);
    	enterEmail_address(Em_Add);
    	enterPassword(Ps);
    	enterPassword_Confirmation(Con_pss);
    	clickOnCreate_Account_Btn();	
    }
   
    
    
    /* ----------  method to verify presence of all menus and links  -------------- */  
    
    public boolean isCreate_Account_LinkDisplayed() {
        return Create_Account_Link.isDisplayed();
    }
    
    public boolean isFirstnameFieldDisplayed() {
        return Firstname.isDisplayed();
    }
    
    public boolean isLastnameFieldDisplayed() {
        return Lastname.isDisplayed();
    }
    
    public boolean isEmail_addressFieldDisplayed() {
        return Email_address.isDisplayed();
    }
    
    public boolean isPasswordFieldDisplayed() {
        return Password.isDisplayed();
    }
    
    public boolean isPassword_ConfirmationFieldDisplayed() {
        return Password_Confirmation.isDisplayed();
    }
   
    public boolean isCreate_Account_BtnDisplayed() {
        return Create_Account_Btn.isDisplayed();
    }
    
 // Added a method to verify presence of all Fields and Buttons
    public boolean areAllFieldsAndButtonsDisplayed() {
        return isCreate_Account_LinkDisplayed() & isFirstnameFieldDisplayed() & isLastnameFieldDisplayed() & 
        		isEmail_addressFieldDisplayed() & isPasswordFieldDisplayed() & 
        		isPassword_ConfirmationFieldDisplayed() & isCreate_Account_BtnDisplayed(); // Added checks for all Fields and Buttons
    }
    

}
