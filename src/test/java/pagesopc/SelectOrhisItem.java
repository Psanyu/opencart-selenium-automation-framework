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



public class SelectOrhisItem {

WebDriver dr;
Config elements;
WebDriverWait wait;
JavascriptExecutor jsk; 

 public SelectOrhisItem(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
        wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        this.jsk = (JavascriptExecutor)dr;
}


public void orhispgselect(){
    	              	   
   List <WebElement> retsel = dr.findElements(By.xpath(elements.get("orhisid")));
      for(WebElement rets:retsel) {
          if(rets.getText().trim().equalsIgnoreCase("Order History"))	{
        	  try {
        		    wait.until(ExpectedConditions.elementToBeClickable(rets)).click();
        		} catch (Exception e) {
        		    jsk.executeScript("arguments[0].click();", rets);
        		}
        	  
           break;
          }
      }
    }


}
     
      



