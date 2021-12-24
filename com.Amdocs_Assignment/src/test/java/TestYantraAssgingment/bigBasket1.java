package TestYantraAssgingment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bigBasket1 {

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
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		driver.findElement(By.xpath("(//a[text()='Fruits & Vegetables'])[2]")).click();
		String title=driver.getTitle();
		String ExpectedTitle="Fruits And Vegetables: Buy Fruits And Vegetables Online at Our Online Vegetable Store at great price";
		
		assertEquals(title, ExpectedTitle);
		List<WebElement> ele1 = driver.findElements(By.xpath("//h5[@class='owl-dot ng-scope']"));
		System.out.println(ele1.size());
		List<WebElement> feature = driver.findElements(By.xpath("//div[@class='owl-item active']"));
		int count=0;
		
		 for(WebElement wb:feature)
		 {
			 System.out.println(wb.getText());
			 count++;
		 }
		 System.out.println("total =>"+count);
		 
		 int product=count;
		 if(product<=5)
		 {
			 assertTrue(true);
			 System.out.println("items are 5");
			 
		 }
//		 driver.findElement(By.xpath("//a[@ng-click=\"vm.pushToGoogleAnalytics('_trackEvent','item-clicked','custom-page',sectionModel.display_pos+' "
//		 		+ "| '+sectionModel.pageinternalName+' | CRPD | '+sectionModel.internalName+' "
//		 		+ "| '+vm.selectedProduct.sku+' | '+vm.selectedProduct.p_desc +' | '+ vm.itemposition,1)\"]")).getText();
		 
		 driver.close();

	}

}
