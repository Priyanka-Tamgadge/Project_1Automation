package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pageObject.HomePage;
import pageObject.SearchBar;
import pageObject.SignIn;

public class SearchBar_Test {
	
	WebDriver driver;
	HomePage hp;
	SearchBar sb;
	SignIn s;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		sb = new SearchBar(driver);
		Thread.sleep(3000);
	}
	
	//  Verify_HomePage_Title
	@Test(priority =1)
	public void Verify_HomePage_Title() throws InterruptedException
	{
		sb.url();
		sb.Homepage_title_should_be("Home Page");
	}
	
	
	//  areAllMenusAndLinksDisplayedProperly
	@Test(priority =2)
	public void areAllMenusAndLinksDisplayedProperly() throws InterruptedException
	{
		hp = new HomePage(driver);
		hp.url();
		hp.areAllMenusAndLinksDisplayed();
		System.out.println("All Menus And Links are Displayed");
	}
	
	
	//  verify_SearchBar_Displayed
	@Test(priority =3)
	public void verify_SearchBar_Displayed() throws InterruptedException
	{
		sb.url();
		sb.isSearchBarDisplayed();
		System.out.println("Search Bar is Displayed");
	}
	
	
    //  verify_EnterSearchElements
	@Test(priority =4)
	public void verify_EnterSearchElements() throws InterruptedException
	{
		sb.enterSearchElement("Jackets");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER);
		act.build().perform();
		Thread.sleep(5000);
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Search results for: 'Jackets'";
		Assert.assertEquals(Actual_Title, Expected_Title);	
		
		List<WebElement> Search_Results=driver.findElements(By.xpath("//dd[@class='item']"));
		System.out.println("Total Search Results: "+Search_Results.size());
		
		System.out.println("\nRelated Search Terms: ");
		
		for(int i=0;i<Search_Results.size();i++)
		{
			String result=Search_Results.get(i).getText();  
			System.out.println(result);
		}
		
		System.out.println();
	}
	
	
	//  verify_MinimumSearch_query_length
	@Test(priority =5)
	public void verify_MinimumSearch_query_length() throws InterruptedException
	{
		sb.enterSearchElement("pa");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER);
		act.build().perform();
		Thread.sleep(5000);
		
		String Actual_Title=driver.getTitle();
		String Expected_Title="Search results for: 'pa'";
		Assert.assertEquals(Actual_Title, Expected_Title);
		
		String msg_notice=driver.findElement(By.xpath("//div[@class='message notice']")).getText();
		System.out.println(msg_notice+"\n");
	}
	
	
	
    //  verify_SearchElement_AfterLogIn
	@Test(priority =6)
	public void verify_SearchElement_AfterLogIn() throws InterruptedException
	{
		s = new SignIn(driver);
		s.url();
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		sb.Homepage_title_should_be("Home Page");
		
		sb.enterSearchElement("Tees");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER);
		act.build().perform();
		Thread.sleep(5000);
		
		String Actual_Title1=driver.getTitle();
		String Expected_Title1="Search results for: 'Tees'";
		Assert.assertEquals(Actual_Title1, Expected_Title1);
		
		List<WebElement> Search_Results=driver.findElements(By.xpath("//dd[@class='item']"));
		System.out.println("Total Search Results: "+Search_Results.size());
		
		System.out.println("\nRelated Search Terms: ");
		
		for(int i=0;i<Search_Results.size();i++)
		{
			String result=Search_Results.get(i).getText();  
			System.out.println(result);
		}
		
		System.out.println();
		
	}
	
	
   //  verify_SearchButton_Functionality
	@Test(priority =7)
	public void verify_SearchButton_Functionality() throws InterruptedException
	{
		s = new SignIn(driver);
		s.url();
		s.SignInMethod("Draco@gmail.com", "Draco@123");
		
		sb.Homepage_title_should_be("Home Page");
		
		sb.enterSearchElement("Tees");
		
		if(sb.SearchBtn.isEnabled())
		{
		sb.clickOnSearchBtn();
		}
		
		else
		{
			System.out.println("Search button is not Enabled");
		}
		
		String Actual_Title1=driver.getTitle();
		String Expected_Title1="Search results for: 'Tees'";
		Assert.assertEquals(Actual_Title1, Expected_Title1);
	
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
}
