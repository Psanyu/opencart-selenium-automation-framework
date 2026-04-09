package pagesopc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilitiesopc.Config;

public class Loginpgop {
	
    WebDriver dr;
    Config elements;
	
	public Loginpgop (WebDriver dr) throws Exception {
				this.dr = dr;
				elements = new Config("elements.properties");
	
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
}
			



