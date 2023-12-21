package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paymenttype {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("https://ehrapp.eclipseehrcloud.net/");

driver.findElement(By.xpath("//input[@id='UserId']")).sendKeys("MPNAdmin_User");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
driver.findElement(By.xpath("//button[@id='next']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//span[@title='MPNLiveData']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//i[@class='fa fa-gear']")).click();
driver.findElement(By.xpath("//a[contains(text(),'User Defined Data ')]")).click();
driver.findElement(By.xpath("//a[@id='paymenttypes']")).click();
Thread.sleep(3000);
//driver.findElement(By.xpath("//button[@id='AddNewAppointment']")).click();

WebElement button = driver.findElement(By.xpath("//button[@id='AddNewPayment']"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", button);
driver.findElement(By.xpath("//input[@id='pdescription']")).sendKeys("Test");
driver.findElement(By.xpath(("//span[@class='fa fa-save e-btn-icon e-icon-left']"))).click();
Thread.sleep(3000);
if(driver.getPageSource().contains("Test"))
{ System.out.println("Text is present");

}else {
	System.out.println("text is not present");
}


	}

}
