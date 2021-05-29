package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("^user launch chrome browser$")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		driver=new ChromeDriver();
	    lp=new LoginPage(driver);
	}

	@When("^user opens url {string}$")
	public void user_opens_url(String url) {
		driver.get(url);
	  
	}

	@When("^user enters emails as {string} and password as {string}$")
	public void user_enters_emails_as_and_password_as(String email, String pasword) {
	 lp.setUserName(email); 
	 lp.setpassword(pasword);
	}

	@When("^click on login$")
	public void click_on_login() {
		lp.clickLogin();
	   
	}

	@Then("^Page title should be {string}$")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was Unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title,driver.getTitle());
		}
	  
	}

	@When("^user click on log out link$")
	public void user_click_on_log_out_link() throws InterruptedException {
	 lp.clickLogout();  
	 Thread.sleep(3000);
	}

	@Then("^close browser$")
	public void close_browser() {
		driver.quit();
	    
	}


}
