package TestYantraAssgingment;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class urbanledder {
	public static void main(String[] args) throws Throwable
		{
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.urbanladder.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			WebElement ele = driver.findElement(By.xpath("//li[@class='topnav_item decorunit']"));
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
			driver.findElement(By.xpath("//span[text()='Wall Mirrors']")).click();
			driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
			Thread.sleep(2000);
			WebElement ele1 = driver.findElement(By.xpath("//span[text()='Vaidya Mirror ']/ancestor::div[@class='productbox']/descendant::span[2]"));
			System.out.println(ele1.getText());
			
//			//String actPrice =ele1.getText();
//			
//			//int act =Integer.parseInt(actPrice);
//			int ExpPrice=5000;
//			if(act >= ExpPrice)
//			{
//				System.out.println(act +" is greater");
//			}
//			else
//			{
//				System.out.println(act +" is less");
//			}
//			

			driver.findElement(By.xpath("//span[text()='Vaidya Mirror ']")).click();
			String mainid = driver.getWindowHandle();
			Set<String> allid = driver.getWindowHandles();
			for(String id:allid)
				if(!mainid.equals(id))
			{
				driver.switchTo().window(id);
				
				driver.findElement(By.xpath("//span[text()='Change']")).click();
				driver.findElement(By.xpath("//input[@class='user-pincode']")).sendKeys("201301");
				driver.findElement(By.xpath("//button[text()='CHECK']")).click();
			//	driver.findElement(By.xpath("//button[@data-variantname='(Floral)']")).click();
			}
			
			
			
	    }



		}
	
