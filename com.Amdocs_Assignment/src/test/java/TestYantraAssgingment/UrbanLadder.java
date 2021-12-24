package TestYantraAssgingment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UrbanLadder {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
		String ActTitle=driver.getTitle();
		String ExpTitle="Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder";
		assertEquals(ActTitle, ExpTitle);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("(//span[@class='topnav_itemname'])[2]"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.xpath("//span[text()='Lounge Chairs']")).click();
		driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
		Thread.sleep(2000);
		String ele1 = driver.findElement(By.xpath("(//span[text()='Genoa Wing Chair '])[1]/ancestor::div[@class='productbox']/descendant::span[2]")).getText();
		
		String actPrice =ele1.replace(",","");
		System.out.println(actPrice);
		String Actual = actPrice.substring(1);
		int act =Integer.parseInt(Actual);
		int ExpPrice=20000;
		if(act >= ExpPrice)
		{
			assertTrue(true);
			System.out.println(act +" is greater");
		}
		else
		{
			System.out.println(act +" is less");
		}
		driver.findElement(By.xpath("//span[text()='Genoa Wing Chair ']")).click();
		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid)
			if(!mainid.equals(id))
		{
			driver.switchTo().window(id);
			
			driver.findElement(By.xpath("//button[@data-variantname='(Floral)']")).click();
			 driver.close();
		}
		

}
}