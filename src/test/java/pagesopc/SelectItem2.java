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


public class SelectItem2 {

WebDriver dr;
Config elements;
WebDriverWait wait;

 public SelectItem2(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
        wait = new WebDriverWait(dr, Duration.ofSeconds(10));
}


public void Maincatselect(String itemcat){
    	              	   
   List <WebElement> mcatsel = dr.findElements(By.xpath(elements.get("mcatid")));
      for(WebElement mcats:mcatsel) {
          if(mcats.getText().trim().equalsIgnoreCase(itemcat))	{
        	  try {
        		    wait.until(ExpectedConditions.elementToBeClickable(mcats)).click();
        		} catch (Exception e) {
        		    ((JavascriptExecutor) dr).executeScript("arguments[0].click();", mcats);
        		}
           break;
          }
      }
}
      
      public void Subcatselect(String itemsubcat) {
   WebElement scats = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(itemsubcat)));
   ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", scats);
   try {
       scats.click();
   } catch (Exception e) {
       ((JavascriptExecutor) dr).executeScript("arguments[0].click();", scats);
   }
 }
      
public void Addproduct(String itemn) throws Exception { 
 List <WebElement> itselnw = dr.findElements(By.xpath(elements.get("prodid")));
   for (WebElement itsnw: itselnw) {
	if (itsnw.getText().equals(itemn)) { 	   
   JavascriptExecutor js =(JavascriptExecutor) dr;
   js.executeScript("arguments[0].scrollIntoView({block:'center'});", itsnw); 
   break;
  }
 }
}            
        

public void add2cartfrmlist(String itemn) {
List<WebElement> products = dr.findElements(By.xpath(elements.get("prodid")));

for (WebElement product : products) {
if (product.getText().trim().equalsIgnoreCase(itemn)) {
WebElement addBtn = product.findElement(By.xpath("./ancestor::div[contains(@class,'product-thumb')]//button"));
JavascriptExecutor jsa =(JavascriptExecutor) dr;
jsa.executeScript("arguments[0].click();", addBtn);
return;
  }
 }
}
  
  public void add2cartfrmProductpage() throws Exception {
	  try { 
   WebElement atc = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart"))); 
   atc.click(); 
   } catch (Exception e) { 
    System.out.println("Not redirected to the Product page"); 
	} 
   
}
}


      



