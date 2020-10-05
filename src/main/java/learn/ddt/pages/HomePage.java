package learn.ddt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private By searchtext=By.xpath("//input[@name='q']");
	private By searchbutton=By.xpath("//span[@class='z1asCe MZy1Rb']");
	/*private By email=By.xpath("");
	private By password=By.xpath("");
	private By createaccount=By.xpath("");*/
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	public int searchText(String searchText)
	{
		driver.findElement(searchtext).click();
		driver.findElement(searchtext).sendKeys(searchText);
		driver.findElement(searchtext).sendKeys(Keys.ENTER);
		
		return getWordCount(searchText);
		
	}
	
	private int getWordCount(String searchText){
		// get the text of the body element
		WebElement body = driver.findElement(By.tagName("body"));
		String bodyText = body.getText();

		// count occurrences of the string
		int count = 0;

		// search for the String within the text
		while (bodyText.contains(searchText)){

		    // when match is found, increment the count
		    count++;

		    // continue searching from where you left off
		    bodyText = bodyText.substring(bodyText.indexOf(searchText) + searchText.length());
		}
		return count;
		
	}
	
	public void clickSearchButton()
	{
		driver.findElement(searchbutton).click();
	}
	
	public int add(int a,int b)
	
	{
		
		int c=a+b;
		System.out.println(c);
		return c;
	}
/*public String add(int a,int b)
	
	{
		
	String d=a+b+c;
		System.out.println(d);
		return d;
	}*/

}
