package pagesopc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilitiesopc.Config;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SelectOrReturns {

WebDriver dr;
Config elements;
WebDriverWait wait;
JavascriptExecutor jsk; 

 public SelectOrReturns(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
        wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        this.jsk = (JavascriptExecutor)dr;
}   

public void returnvw() {
    WebElement rbi = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("rbid"))));

    try {
        jsk.executeScript("arguments[0].scrollIntoView(true);", rbi);
        rbi.click();
    } catch (Exception e) {
        jsk.executeScript("arguments[0].click();", rbi);
    }
  }
}
     
      



