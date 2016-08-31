package net.testfire.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
	WebDriver driver;
	public WelcomePage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
			WebDriverWait wait;
	public boolean isValidLogin(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(driver.findElement(By.id("_ctl0__ctl0_LoginLink")).getText().equals("Sign Off")){
			return true;
		}
		return false;
	}
	
	public List<WebElement> returnColumnElements() throws InterruptedException {

		List<WebElement> elements = new ArrayList<>();
		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl().toString());
		driver.findElements(By.className("sidebar")).stream().forEach(e -> e.findElements(By.tagName("a")).stream().forEach(f -> elements.add(f)));

		return elements;
	}
	public void closePage(){

	}
}
