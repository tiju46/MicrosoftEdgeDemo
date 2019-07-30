
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class edgebrowser {
	
	String driverPath = "D:\\";
	public WebDriver driver;
	
	@Test(priority=1)
	public void launchBrowser() {
		System.out.println("launching Microsoft Edge browser");
		System.setProperty("webdriver.edge.driver", driverPath+"MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
	}

	@Test(priority=2)
	public void openEdgeBrowser() {
		driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
		driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
	    driver.findElement(By.name("password")).sendKeys("adda12345");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    //click on login button
	    driver.findElement(By.id("submit_login")).click();
	}
	
	@Test(priority=3)
	public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}	
}