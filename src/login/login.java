package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class login {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver(co);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://ehrapp.eclipseehrcloud.net/");
		
		String expectedtitle = "Choose your account";
		Thread.sleep(5000);
		String actualtitle = driver.getTitle();
		
		Assert.assertEquals(actualtitle, expectedtitle);
		
		
		driver.findElement(By.xpath("//input[@id='UserId']")).sendKeys("MPNAdmin_User");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[@id='next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='MPNLiveData']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-gear']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'User Defined Data ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Adjustment Types')]")).click();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Design Test"))
		{ System.out.println("Text is present");
		
		}else {
			System.out.println("text is not present");
		}
		
		
		driver.findElement(By.xpath("//button[@id='AddNewAdjustment']")).click();
		Thread.sleep(2000);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='textbox-fd2fde94-535e-4730-b728-12bfc43d1b46']")));
		driver.findElement(By.xpath("//input[@id='adjdescription']")).sendKeys("Test");
		driver.findElement(By.xpath("(//button[@class='e-control e-btn e-lib sf-blue-oval-button'])[1]")).click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		}

}
