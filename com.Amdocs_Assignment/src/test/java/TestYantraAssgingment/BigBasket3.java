package TestYantraAssgingment;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasket3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bigbasket.com/");
		String ActTitel = driver.getTitle();
		String ExpTitile="Online Grocery Shopping and Online Supermarket in India - bigbasket";
		
		assertEquals(ActTitel, ExpTitile);
		driver.findElement(By.xpath("//input[@qa='searchBar']")).sendKeys("bread");
		driver.findElement(By.xpath("//i[@class='icon svg-header svg-search svg-search-dim hidden-sm hidden-xs']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//a[text()='Sandwich Bread - Safe, Preservative Free']/ancestor::div[@class='items']/descendant::div[@class='clearfix']"));
	    System.out.println(ele.size());
	    driver.findElement(By.xpath("//a[text()='sandwich bread']")).click();
	    

	   driver.findElement(By.xpath("//span[text()='Combo 2 Items' and @class ='ng-binding']")).click();
	   
	     WebElement ele1 = driver.findElement(By.xpath("//div[@ng-if=\"vm.selectedProduct.dis_t == 'P' && vm.selectedProduct.dis_val != '0.00'\"]"));
	     System.out.println(ele1.getText());
	    if(ele1.isDisplayed())
	    {
	    	System.out.println("discount banner is displayed");
	    }
	    else
	    {
	    	System.out.println("discount banner is not displayed");
	    }
	   String express = driver.findElement(By.xpath("//a[text()='Brown Bread + Sandwich Bread (Safe, Preservative Free 200 g)']/ancestor::div[@class='clearfix']/descendant::div[@class='delivery-opt']")).getText();
	    String delivery = driver.findElement(By.xpath("//a[text()='Sandwich Bread - White, Chemical Free 400G + Eggs - Regular 6pcs']/ancestor::div[@class='clearfix']/descendant::div[@class='delivery-opt']")).getText();
	    
	    assertEquals(express, delivery);
	    
	}

}
