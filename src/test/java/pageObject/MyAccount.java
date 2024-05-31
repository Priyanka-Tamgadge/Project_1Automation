package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
WebDriver driver;
	
    public MyAccount(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
 /* -----------------  Repository of Elements ------------------ */
    
   
    @FindBy(xpath="//ul[@class='header links']/child::li[1]/child::a[1]") WebElement My_Account;
    @FindBy(xpath="//div[@class='panel header']/child::ul/child::li[2]/child::span/child::button") WebElement ProfileBtn;
    @FindBy(xpath="//div[@class='box-content']/child::p") WebElement Contact_Info;
    @FindBy(xpath="//div[@class='box-actions']/child::a[1]") WebElement Edit_Contact_Info;
    @FindBy(xpath="//div[@class='box-actions']/child::a[2]") WebElement Change_Password;
    
    
    
    @FindBy(xpath="//div[@class='block-title']/child::a[@class='action edit']") WebElement Manage_Address_Link;
    @FindBy(xpath="//div[@class='box box-billing-address']/child::div[2]/child::a") WebElement Default_Billing_Address;
    @FindBy(xpath="//div[@class='box box-shipping-address']/child::div[2]/child::a") WebElement Default_Shipping_Address;
    
    @FindBy(xpath="//div[@id='block-collapsible-nav']/child::ul/child::li/child::a") List<WebElement> My_Account_SideBar;
    

    
/* -----------------  Methods  ------------------ */
    
   
    public void clickOnProfileBtn() throws InterruptedException
    {
    	ProfileBtn.click();
    	Thread.sleep(2000);
    }
    
    
    public void clickOnMy_Account() throws InterruptedException
    {
    	Actions act=new Actions(driver);
		act.moveToElement(My_Account).build().perform();
		Thread.sleep(1000);
  
    	My_Account.click();
    	Thread.sleep(2000);
    }
    
    
    public void My_Account_PageTitle(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("We are on the My_Account Page");
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
   }
    
   
    
    //  Contact_Info
    public void Contact_Info()
    {
    	String Ci=Contact_Info.getText();
    	System.out.println("\n*Contact Information is: \n"+Ci+"\n");
    	
    	String Edit=Edit_Contact_Info.getText();
    	String Change_Pass=Change_Password.getText();
    	
    	System.out.println("Edit_Contact_Info link is Displayed:   "+Edit);
    	System.out.println("Edit_Contact_Info link is Displayed:   "+Change_Pass);
    }
    
    
    //  My_Account_SideBar
    public void My_Account_SideBar() throws InterruptedException
    {
    	 System.out.println("\n*My Account SideBar Options:  ");
		    Actions act5=new Actions(driver);
		      
		    // -----------   My_Account_SideBar_Options ---------------
		   
		    System.out.println("\nMy Account SideBar Options size: "+My_Account_SideBar.size());
		    
		    for(int i=0;i<My_Account_SideBar.size();i++)  
			{
			   act5.moveToElement(My_Account_SideBar.get(i)).build().perform();
			   Thread.sleep(1000);
			   String result=My_Account_SideBar.get(i).getText();
			   System.out.println(" "+result);
			}
		          System.out.println();
    }
    
   
   
    //  clickOn_SideBar_Options
    public void clickOn_SideBar_Options() throws InterruptedException
    {
    	System.out.println("\n*My Account SideBar Options Clickable:  ");
	    Actions act5=new Actions(driver);
	    
	    // -----------   clickOn_SideBar_Options ---------------
	   
	    System.out.println("\nMy Account SideBar Options size: "+My_Account_SideBar.size());
	    
	    for(int i=0;i<My_Account_SideBar.size();i++)  
		{
		   act5.moveToElement(My_Account_SideBar.get(i)).build().perform();
		   Thread.sleep(1000);
		     
		   String result=My_Account_SideBar.get(i).getText();
		   My_Account_SideBar.get(i).click();
		   Thread.sleep(2000);
		   System.out.println("Cliked on:   "+result);
		}
	          System.out.println();
    }
    
    

    
    public boolean isProfileBtnDisplayed() {
        return ProfileBtn.isDisplayed();
    }
    
    
    public boolean isMy_AccountFieldDisplayed() {
        return My_Account.isDisplayed();
    }
    
    
    
}
