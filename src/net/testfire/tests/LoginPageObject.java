package net.testfire.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginPageObject {
	private WebDriver driver;
	//WebDriverWait wait;
	public LoginPageObject()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.testfire.net/bank/login.aspx");

	}
	
	public WelcomePage validLogin(String username, String password){
		driver.findElement(By.id("uid")).clear();
		driver.findElement(By.id("passw")).clear();
		driver.findElement(By.id("uid")).sendKeys(username);
		driver.findElement(By.id("passw")).sendKeys(password);
		driver.findElement(By.name("btnSubmit")).click();
		return new WelcomePage(driver);
	}
	public LoginPageObject invalidLogin(String username, String password){
		driver.findElement(By.id("uid")).clear();
		driver.findElement(By.id("passw")).clear();
		driver.findElement(By.id("uid")).sendKeys(username);
		driver.findElement(By.id("passw")).sendKeys(password);
		driver.findElement(By.name("btnSubmit")).click();
		return this;
	}
	public String checkMessage() throws InterruptedException {
		//wait = new WebDriverWait(driver, 10);
		Thread.sleep(5000);
		return driver.findElement(By.id("_ctl0__ctl0_Content_Main_message")).getText();
	}
	public void closePage(){
		driver.close();
	}
}
