package stepsdefn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginLogout {
	
	WebDriver driver;
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	   driver = new ChromeDriver();
	   driver.get("http://localhost/opencart/index.php?route=account/login&language=en-gb");
	   driver.manage().window().maximize();
	   
	}

	@When("User enters username")
	public void user_enters_username() {
	   driver.findElement(By.id("input-email")).sendKeys("admin@mail.com");
	}

	@When("User enters password")
	public void user_enters_password() {
	driver.findElement(By.id("input-password")).sendKeys("admin@123");
	}

	@When("User clicks on Login Button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	
	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    
		    // Wait until "My Account" text is present in the content div
		    wait.until(ExpectedConditions.textToBePresentInElementLocated(
		        By.xpath("//div[@id='content']"), "My Account"
		    ));

		    WebElement Lsuccess = driver.findElement(By.xpath("//div[@id='content']"));
		    Assert.assertTrue(
		        Lsuccess.getText().contains("My Account"),
		        "Expected 'My Account' but got: " + Lsuccess.getText()
		    );
	}

	@When("User clicks on logout button")
	public void user_clicks_on_logout_button() {
	    WebElement logoutLink = driver.findElement(By.xpath("//a[contains(@href, 'logout')]"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", logoutLink);
	}

	@Then("User should be logged out")
	public void user_should_be_logged_out() {

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    
		    // Wait until "My Account" text is present in the content div
		    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='content']"), "Account Logout"));

		    WebElement Loutsuccess = driver.findElement(By.xpath("//div[@id='content']"));
		    Assert.assertTrue(Loutsuccess.getText().contains("Account Logout"),"Expected 'Account Logout' but got: " + Loutsuccess.getText());
		    driver.close();
	}


}
