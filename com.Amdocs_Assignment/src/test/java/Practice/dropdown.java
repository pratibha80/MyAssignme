package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdown {
	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		WebElement ele = driver.findElement(By.id("gh-cat"));

		Select s=new Select(ele);
		ArrayList list=new ArrayList();
	List<WebElement> opt = s.getOptions();
	
	for(WebElement wb:opt)
	{
		String data = wb.getText();
		list.add(data);
	}
	ArrayList temp=new ArrayList();
    temp.addAll(list);
    Collections.sort(temp);
    Assert.assertTrue(list.equals(temp));
	
}
}