package TestYantraAssgingment;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket2 {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("(//a[text()='View All'])[2]")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,500)");
		
		
		

	}

}
