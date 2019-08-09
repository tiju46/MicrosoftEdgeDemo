
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class edgebrowser {
	
	public WebDriver driver;
	
	@Test(priority=1)
	public void launchBrowser() {
		System.out.println("launching chrome browser");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\tiju thomas\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","/home/testing/Desktop/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
	}

	//@Test(priority=2)
	public void openChromeBrowser() {
		driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
		driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
	    driver.findElement(By.name("password")).sendKeys("adda12345");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    //click on login button
	    driver.findElement(By.id("submit_login")).click();
	}
	
	//@Test(priority=3)
	public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}	
}