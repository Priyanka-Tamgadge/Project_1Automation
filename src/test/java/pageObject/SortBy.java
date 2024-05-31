package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SortBy {
	
WebDriver driver;

	
	public SortBy(WebDriver idriver)
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
	    
	    
	    //  Sort By options 
	    
	    @FindBy(xpath="//select[@class='sorter-options']") WebElement SortBy;
	    
	    
	    //  click on sort by name and price
	    @FindBy(xpath="//option[@value='name']") WebElement SortBy_Name;
	    @FindBy(xpath="//option[@value='price']") WebElement SortBy_Price;
        
	    
	    // results after sorting item list
	    @FindBy(xpath="//strong[@class='product name product-item-name']/child::a") List<WebElement> By_Name;
	    @FindBy(xpath="//span[@class='price-container price-final_price tax weee']/child::span/child::span") List<WebElement> By_Price;
	    
	    
	    
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
	    
	    
	
	    //  Sort_By_Name
	    public void Sort_By_Name() throws InterruptedException
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
	    		    	
	    		    	SortBy.click();
	    		    	Thread.sleep(2000);
	    		    	
	    		    	SortBy_Name.click();
	    		    	Thread.sleep(2000);
	    		    	
	    		    	System.out.println("\n***Sort By Name: \n");
    	    		    
    		    		for(int m=0;m<By_Name.size();m++)
    		    		{
    		    			
    		    			act2.moveToElement(By_Name.get(m)).build().perform();
    		    			Thread.sleep(1000);
    		    			String Result2=By_Name.get(m).getText();  
    		    			//String Result3=By_Price.get(m).getText();
    		    			System.out.println("Product Name: "+Result2);
    		    		}
    		    		
    		    		System.out.println();
	    		    	
	    		    }
				}
	    }
	    
	    
	    
	    //  Sort_By_Price
	    public void Sort_By_Price() throws InterruptedException
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
	    		    	
	    		    	SortBy.click();
	    		    	Thread.sleep(2000);
	    		    	
	    		    	SortBy_Price.click();
	    		    	Thread.sleep(2000);
	    		    	
	    		    	System.out.println("\n***Sort By Price: \n");
    	    		    
    		    		for(int m=0;m<=By_Name.size();m++)
    		    		{
    		    			
    		    			act2.moveToElement(By_Price.get(m)).build().perform();
    		    			Thread.sleep(1000);  
    		    			String Result3=By_Price.get(m).getText();
    		    			System.out.println("Product Price: "+Result3);
    		    		
    		    		}
    		    		
    		    		System.out.println();
	    		    	
	    		    }
				}
}
}


	    

	    		    




	    		    		
	    		    		
	    		    		
	    		    	
	    		    
	    		    	
	    		    
	    		    
	    		    
	    		    
	    		 
