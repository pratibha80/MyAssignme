package TestYantraAssgingment;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BigBasket {
	
	public static void main(String[] args) 
		
	
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bigbasket.com/");
		String ActTitel = driver.getTitle();
		String ExpTitile="Online Grocery Shopping and Online Supermarket in India - bigbasket";
		
		assertEquals(ActTitel, ExpTitile);
		
		WebElement ele = driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']"));
		
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		WebElement ele1 = driver.findElement(By.xpath("(//a[text()='Beverages'])[2]"));
		a.moveToElement(ele1).perform();
		 List<WebElement> list = driver.findElements(By.xpath("//li[@ng-repeat=\"l2 in vm.selectedtop.subcategories.chunks.chunk1 | limitTo:15\"]"));
		 int count=0;
		 for(WebElement wb:list)
		 {
			 System.out.println(wb.getText());
			 count++;
		 }
          
		   System.out.println("total links=>"+count);
			
			driver.findElement(By.xpath("(//a[@ng-href=\"/pc/beverages/coffee/?nc=nb\"])[2]")).click();
			
			driver.findElement(By.xpath("//span[text()='Ground Coffee']")).click();
			driver.findElement(By.xpath("//img[@class=\"img-responsive blur-up lazyautosizes lazyloaded\"]")).click();
			new WebDriverWait(driver,10);
			
			driver.findElement(By.xpath("//div[text()='Multipack']")).click();
			
			driver.findElement(By.xpath("//span[text()='ADD TO BASKET']")).click();
			
			String MRP = driver.findElement(By.xpath("//h1[text()='Cothas Coffee Coffee - Powder, Speciality Blend Of Coffee & Chicory Powder, 2x500 g Multipack ']/ancestor::div[@class='_1PkIz']/descendant::td[@class='IyLvo']")).getText();
			
			
			
			String actualPrice = driver.findElement(By.xpath("//h1[text()='Cothas Coffee Coffee - Powder, Speciality Blend Of Coffee & Chicory Powder, 2x500 g Multipack ']/ancestor::div[@class='_1PkIz']/descendant::td[@class='_2ifWF']")).getText();
			
			String actaul=MRP.substring(3);
			System.out.println(actaul);
			String ExcPrice=actualPrice.substring(3);
			System.out.println(ExcPrice);
			int price = Integer.parseInt(actaul);
			  int price1 = Integer.parseInt(ExcPrice);
			
			  int diffPrice = price1-price;
			  System.out.println("2*500 pouch price details are=>"+price+"  ==> "+price1);
		  
			

			  	  SoftAssert soft = new SoftAssert();
			  soft.assertEquals(diffPrice>0, true);
			  System.out.println("different price is==>"+diffPrice);
			 soft.assertAll();
			
			  
			driver.close();
		}
		
		
		
		
	}


