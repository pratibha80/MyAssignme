package TestYantraAssgingment;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SrcollHome {

	public static void main(String[] args) throws Throwable {
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bigbasket.com/");
		String ActTitel = driver.getTitle();
		String ExpTitle="Online Grocery Shopping and Online Supermarket in India - bigbasket";
		assertEquals(ActTitel, ExpTitle);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,500)");
		List<WebElement> ele = driver.findElements(By.xpath("//h2[text()='Bank Offers']/ancestor::section[@class='row custom-component carousel-section ng-scope']/descendant::div[@class='col-lg-3 col-md-3 col-sm-4 col-xs-6 col ng-scope']"));
		
		int count=0;
		for(WebElement wb:ele)
		{
			System.out.println(wb.getText());
			count++;
		}
		System.out.println(count);
		driver.findElement(By.xpath("(//h2[text()='Bank Offers']/ancestor::section[@class='row custom-component carousel-section ng-scope']/descendant::div[@class='col-lg-3 col-md-3 col-sm-4 col-xs-6 col ng-scope'])[2]")).click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/bankoffer.png");
		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.xpath("//span[text()='Shop Now']")).click();
		
		WebElement term = driver.findElement(By.xpath("//a[text()='Terms and Conditions']"));
		if(term.isDisplayed())
		{
			System.out.println("term and condition is displayed");
		}
		else
		{
			System.out.println("term and condition is not displayed");
		}
		driver.close();
	}

}
