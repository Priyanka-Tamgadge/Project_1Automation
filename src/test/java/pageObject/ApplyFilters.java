package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyFilters {
	
	
WebDriver driver;

	
	public ApplyFilters(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}

	
/* -----------------  Repository of Elements ------------------ */
	    
	   
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
	    

	    

	    //  Filter Name
	    @FindBy(xpath="//div[@id='narrow-by-list']/child::div/child::div[@aria-selected='false']") List<WebElement> List;
        @FindBy(xpath="//div[@aria-selected='true']") List<WebElement> List2;

        //  Accessing items inside Filter Name
        @FindBy(xpath="//div[@aria-hidden='false']/child::ol/child::li/child::a") List<WebElement> Inside_List;
        @FindBy(xpath="//div[@aria-hidden='false']/child::div/child::div/child::a/child::div") List<WebElement> Inside_List2;


	    
	    	    
	    
/* --------------------------------  Methods  -------------------------------------- */
	    
	    
	    
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
	    
	    
	    
	    //  Page_title_should_be
	    public void Page_title_should_be(String expectedTitle) throws InterruptedException 
	    {
			String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)) {                      
				System.out.println("We are on Tees Page");
				}
			else
			{
				System.out.println("We are not on the desired Page");
			}
	    }
	    
	    
	    //  Apply_Filter
	    public void Apply_Filter() throws InterruptedException
	    {
           Actions act2=new Actions(driver);
			
			// -------   Items_Inside_Tops  -------------
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Tops).build().perform();
	    	
	    	String T=Tops.getText();
	    	
	    	for(int j=0;j<=2;j++)
				{
					
	    		    act2.moveToElement(Tops_SubMenu1.get(j)).build().perform();
	    		    String res=Tops_SubMenu1.get(j).getText();
	    		    String Expected_res="Tees";
	    		    
	    		    if(res.equals(Expected_res))
	    		    {
	    		    	Tops_SubMenu1.get(j).click();
	    		    	Thread.sleep(2000);
	    		    	
	    		    	Page_title_should_be("Tees - Tops - Women");
	    		    	
	    		    	
	    		    	for(int i=0;i<List.size();i++)
	    		    	{
	    		    		if (List.get(i).isEnabled()) 
	    		    		{
	    		    		String Filter=List.get(i).getText();
	    		    		List.get(i).click();
	    		    		Thread.sleep(3000);
	    		    		System.out.println("Filter Applied: "+Filter);
	    		    		
	    		    		for(int n=0;n<=Inside_List.size();n++)
	    		    		{
	    		    		String Sub_Filter=Inside_List.get(n).getText();
	    		    		//if(Inside_List.get(i).isEnabled())
	    		    		if (Inside_List.get(n).isEnabled()) 	  
	    		    		{
	    		    			//act2.moveToElement(Inside_List.get(i)).build().perform();
	    		    			Inside_List.get(n).click();
	    		    			Thread.sleep(3000);
	    		    			System.out.println("Sub_Filter: "+Sub_Filter);
	    		    		}
	    		    		}
	    		    		
	    		    			System.out.println();
	    		    		}
	    		    	}
	    		    	}
	    		    	System.out.println();
	    		    	
	    		    	}
	    		 
	    		    }
	    
	    
	    //  Apply_Filter_Size_and_Color 
	    public void Apply_Filter_Size_and_Color() throws InterruptedException
	    {
           Actions act2=new Actions(driver);
			
			// -------   Items_Inside_Tops  -------------
				
	    	Perform_MouseHover_Operation();
	    	act2.moveToElement(Tops).build().perform();
	    	
	    	String T=Tops.getText();
        
	    	for(int j=0;j<=2;j++)
				{
					
	    		    act2.moveToElement(Tops_SubMenu1.get(j)).build().perform();
	    		    String res=Tops_SubMenu1.get(j).getText();
	    		    String Expected_res="Tees";
	    		    
	    		    if(res.equals(Expected_res))
	    		    {
	    		    	Tops_SubMenu1.get(j).click();
	    		    	Thread.sleep(2000);
	    		    	
	    		    	Page_title_should_be("Tees - Tops - Women");
	    		    	
	    		    	System.out.println();
	    		    	
	    		    	for(int i=0;i<List.size();i++)
	    		    	{
	    
	      // Filter for size 
	    		    		if (List.get(i).isEnabled()) 
	    		    		{
	    		    		String Filter=List.get(i).getText();
	    		    		String s="SIZE";
	    		    		if(Filter.equals(s))
	    		    		{
	    		    		List.get(i).click();
	    		    		Thread.sleep(3000);
	    		    		System.out.println("Filter Applied: "+s);
	    		    		
	    		    		
	    		    		for(int n=0;n<=Inside_List2.size();n++)
	    		    		{
	    		    		String Sub_Filter=Inside_List2.get(n).getText();
	    		    		//if(Inside_List.get(i).isEnabled())
	    		    		if (Inside_List2.get(n).isEnabled()) 	  
	    		    		{
	    		    			Inside_List2.get(n).click();
	    		    			Thread.sleep(3000);
	    		    			System.out.println("Sub_Filter: "+Sub_Filter);
	    		    			System.out.println();
	    		    		}
	    		    		}
	    		    		}
	    		    		}
	    		    		
	    		    		
	    // Filter for color
	    		    		if (List.get(i).isEnabled()) 
	    		    		{
	    		    		String Filter=List.get(i).getText();
	    		    		String c="COLOR";
	    		    		if(Filter.equals(c))
	    		    		{
	    		    		List.get(i).click();
	    		    		Thread.sleep(3000);
	    		    		System.out.println("Filter Applied: "+c);
	    		    		
	    		    		
	    		    		for(int n=0;n<=Inside_List2.size();n++)
	    		    		{
	    		    		String Sub_Filter=Inside_List2.get(n).getText();
	    		    		//if(Inside_List.get(i).isEnabled())
	    		    		if (Inside_List2.get(n).isEnabled()) 	  
	    		    		{
	    		    			Inside_List2.get(n).click();
	    		    			Thread.sleep(3000);
	    		    			System.out.println("Sub_Filter: "+Sub_Filter);
	    		    			System.out.println();
	    		    		}
	    		    		}
	    		    		}
	    		    		}
	    		    	}
	    		    		
	    		    			
	    		    		}
	    		    	}
	    	
	    		    	
	    		    }
				}




	    
	    	    


