package Practice;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
	    driver.get("http://yahoo.com");  
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    String allid=driver.getWindowHandle();
	    Set<String> main = driver.getWindowHandles();
	    driver.switchTo().window(allid);
	    driver.get("http://google.com");

	}

}
