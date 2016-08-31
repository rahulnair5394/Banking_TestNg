package net.testfire.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class BankingTests {
	private LoginPageObject lpo;
	private WelcomePage welcomePage;
	@BeforeMethod
	public void initializeDriver(){
		lpo = new LoginPageObject();
	}
	
	@Test(priority = 1)
	public void invalidUserLoginTest() throws InterruptedException {
		lpo = lpo.invalidLogin("rahul", "password");
		String message = lpo.checkMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Login Failed: We're sorry, but this username was not found in our system. Please try again.");
				
		
	}
	@Test(priority = 2)
	public void invalidPasswordLoginTest() throws InterruptedException {
		lpo = lpo.invalidLogin("admin", "tarun");
		String message = lpo.checkMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Login Failed: Your password appears to be invalid. Please re-enter your password carefully.");
		
	}
	
	@Test(priority = 3)
	public void validLogin(){
		welcomePage = lpo.validLogin("admin", "admin");
		Assert.assertTrue(welcomePage.isValidLogin());
	}

	@Test(priority = 4)
	public void printElements() throws InterruptedException {
		int defaultValue = 65;
		welcomePage = lpo.validLogin("admin", "admin");
		//welcomePage.returnColumnElements().stream().forEach(e -> System.out.println(e.getText()));
		List<WebElement> elementList = welcomePage.returnColumnElements();
		for(int i = 0 ; i < elementList.size() ; i++){
			Character val = (char)(defaultValue+i);
			Assert.assertEquals(elementList.get(i).getText() , MyEnum.valueOf(val.toString()).getCurrentValue());
			//System.out.print(elementList.get(i).getText());
			//System.out.println("----------->>>>>     "+MyEnum.valueOf(val.toString()).getCurrentValue());
		}


	}
	
	@AfterMethod
	public void tearDown(){

	}

	public enum MyEnum{
		A("View Account Summary"),
		B("View Recent Transactions"),
		C("Transfer Funds"),
		D("Search News Articles"),
		E("Customize Site Language"),
		F("View Application Values"),
		G("Edit Users");

		private String currentValue;
		private MyEnum(String value){
			this.currentValue = value;
		}
		public String getCurrentValue(){
			return currentValue;
		}
	}

}
