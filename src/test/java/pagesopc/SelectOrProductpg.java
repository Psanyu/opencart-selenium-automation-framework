package pagesopc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilitiesopc.Config;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SelectOrProductpg {

WebDriver dr;
Config elements;
WebDriverWait wait;
JavascriptExecutor jsk; 

 public SelectOrProductpg(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
        wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        this.jsk = (JavascriptExecutor)dr;
}

public void oritemvw(String orvwid){	   
    List <WebElement> oritvw = dr.findElements(By.xpath(elements.get("oritvwid")));

    boolean orderFound = false;
    for(WebElement orvws:oritvw) {

        if(orvws.getText().contains(orvwid)) {
        	
        	orderFound = true;

            WebElement viewbtn = orvws.findElement(By.xpath(".//a[contains(@href,'order.info') or contains(@href,'order_id')]"));

            try {
                
                jsk.executeScript("arguments[0].scrollIntoView(true);", viewbtn);
                wait.until(ExpectedConditions.elementToBeClickable(viewbtn)).click();
            } catch (Exception e) {
              
                jsk.executeScript("arguments[0].click();", viewbtn);
            }
            break;
        }
    }
    
    if (!orderFound) {
        throw new RuntimeException("Order ID not found in Order History: " + orvwid);
    }
}
	
}
     
      



