package comInternship;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidatingFacegene{
	public static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	  driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://facegenie-ams-school.web.app");
	}
	
	@Test(priority = 1)
	public void validateLoginFunction() {
	driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
	driver.findElement(By.id("password")).sendKeys("testing@123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actual = driver.getCurrentUrl();
	String expected = "https://facegenie-ams-school.web.app/";
	Assert.assertEquals(actual, expected);
	driver.quit();
	}
	@Test(priority = 2)
	public void validateLoginFunctionWithinvalidData() {
		driver.findElement(By.id("email")).sendKeys("tes@gmail.com");
		driver.findElement(By.id("password")).sendKeys("tesg@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual = driver.getCurrentUrl();
		String expected = "https://facegenie-ams-school.web.app";
		Assert.assertEquals(actual, expected);
		driver.quit();
	}
	@Test(priority = 3)
	public void validateLoginFunctionWithoutemail() {
		driver.findElement(By.id("email")).sendKeys("  ");
		driver.findElement(By.id("password")).sendKeys("tesg@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual = driver.getCurrentUrl();
		String expected = "https://facegenie-ams-school.web.app";
		Assert.assertEquals(actual, expected);
		driver.quit();
	}
	@Test(priority = 4)
	public void ValidateLogoutFunction() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
		driver.findElement(By.id("password")).sendKeys("testing@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		JavascriptExecutor ex1 = (JavascriptExecutor)driver;
	WebElement button =	driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
	ex1.executeScript("arguments[0].click();", button );
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/button[2]")).click();
		String actual = "https://facegenie-ams-school.web.app/dashboard/home";
		Thread.sleep(2000);
		String Expected1 = "https://facegenie-ams-school.web.app";
		Assert.assertNotEquals(actual, Expected1);
		driver.quit();
	}
	@Test(priority = 5)
	public void ValidateLogoutCancel() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
		driver.findElement(By.id("password")).sendKeys("testing@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		JavascriptExecutor ex1 = (JavascriptExecutor)driver;
	WebElement button =	driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
	ex1.executeScript("arguments[0].click();", button );
		driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/button[1]")).click();
		String actual = "https://facegenie-ams-school.web.app/dashboard/home";
		Thread.sleep(2000);
		String Expected1 = "https://facegenie-ams-school.web.app";
		Assert.assertNotEquals(actual, Expected1);
		driver.quit();
	}
	@Test(priority = 6)
	public void ValidateLicenseWithvalidData() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
		driver.findElement(By.id("password")).sendKeys("testing@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
	WebElement manage1 =	driver.findElement(By.xpath("//span[contains(text(),'Manage Licenses')]"));
		ex.executeScript("arguments[0].click();", manage1 );
		JavascriptExecutor ex3 = (JavascriptExecutor)driver;
		WebElement Add = driver.findElement(By.xpath("//p[contains(text(),'Add License')]"));
		ex3.executeScript("arguments[0].click();", Add );	
		driver.findElement(By.name("empId")).sendKeys("SIS231");
		driver.findElement(By.name("firstName")).sendKeys("Kumar");
		driver.findElement(By.name("lastName")).sendKeys("KM");
		driver.findElement(By.name("phoneNumber")).sendKeys("987456321");
		driver.findElement(By.name("busNo")).sendKeys("43");
		driver.findElement(By.name("email")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Kumar@123");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[5]/button")).click();
		String actual = driver.getCurrentUrl();
		String expected2 = "https://facegenie-ams-school.web.app";
		Assert.assertNotEquals(actual, expected2);
		driver.quit();
	}
	@Test(priority = 7)
	public void ValidateLicenseWithInvalidData() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
		driver.findElement(By.id("password")).sendKeys("testing@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
	WebElement manage1 =	driver.findElement(By.xpath("//span[contains(text(),'Manage Licenses')]"));
		ex.executeScript("arguments[0].click();", manage1 );
		JavascriptExecutor ex1 = (JavascriptExecutor)driver;
		WebElement Add1 = driver.findElement(By.xpath("//p[contains(text(),'Add License')]"));
		ex1.executeScript("arguments[0].click();", Add1 );		
		driver.findElement(By.name("empId")).sendKeys("##$");
		driver.findElement(By.name("firstName")).sendKeys("Ku");
		driver.findElement(By.name("lastName")).sendKeys("KM");
		driver.findElement(By.name("phoneNumber")).sendKeys("987456");
		driver.findElement(By.name("busNo")).sendKeys("43");
		driver.findElement(By.name("email")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Kumar@123");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[5]/button")).click();
		String actual = driver.getCurrentUrl();
		String expected2 = "https://facegenie-ams-school.web.app/dashboard/managelicenses";
		Assert.assertEquals(actual, expected2);
		driver.quit();
	}
@AfterMethod
	public void aftermethod() {
		driver.quit();
	}
	
	}	
	
