
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
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

	 @Test(priority=1)
     public void openADDAGK() {
		driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
		driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
	    driver.findElement(By.name("password")).sendKeys("adda12345");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.findElement(By.id("submit_login")).click();
	    
	    }
     @Test(priority=2)
     public void CheckIn() throws InterruptedException {
	    driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='unit_number']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Block 1-002')]")).click();
	    driver.findElement(By.xpath("//tr"));	
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
	    Thread.sleep(5000);
     driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='reason']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).click();
	    driver.findElement(By.xpath("//button[@name='save_visiter']")).click();
	    Thread.sleep(5000);
	    
     }
	   
	    @Test(priority=3)
	    public void CheckOut() throws InterruptedException {
	    driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
	    driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
	    Thread.sleep(5000);
	    }
	    @Test(priority=4)
	    public void staffcheckin() throws InterruptedException {
	    driver.findElement(By.xpath("//p[contains(text(),'Staff')]")).click();
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
	    Thread.sleep(5000);
	    }
	    
	    @Test(priority=5)
	    public void staffcheckout() throws InterruptedException {
	    driver.findElement(By.xpath("//a[@href='#/staff/staff-out']")).click();
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK OUT')]")).click();
	    Thread.sleep(5000);
	    }
	    
     @AfterTest
     public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}
}