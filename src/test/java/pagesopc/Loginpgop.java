package pagesopc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilitiesopc.Config;

public class Loginpgop {
	
    WebDriver dr;
    Config elements;
    WebDriverWait wait;
	
	public Loginpgop (WebDriver dr) throws Exception {
				this.dr = dr;
				elements = new Config("elements.properties");
				wait = new WebDriverWait(dr, Duration.ofSeconds(10));
	
			}
	
	public void usern(String en) {
		
		dr.findElement(By.xpath(elements.get("eid"))).sendKeys(en);
		
	}
	
	public void pwdn(String pwd) {
		
		dr.findElement(By.xpath(elements.get("pid"))).sendKeys(pwd);
		
	}
	
	public void lgn() {
		
		dr.findElement(By.xpath(elements.get("lid"))).click();
		
	}
	
	public void lgnconfirm() {
	    wait.until(ExpectedConditions.titleContains("My Account"));
	    Assert.assertTrue(dr.getTitle().contains("My Account"), "Login Unsuccessfull");
	}
}
			



