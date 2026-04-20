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
           wait.until(ExpectedConditions.elementToBeClickable(mcats)).click(); 
           break;
          }
      }
}
      
      public void Subcatselect(String itemsubcat) {
   WebElement scats = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(itemsubcat)));
   scats.click(); 
         }
      
      public void Addproduct(String itemn) {
   
   List <WebElement> itselnw = dr.findElements(By.xpath(elements.get("prodid")));
   for (WebElement itsnw: itselnw) {
	if (itsnw.getText().equals(itemn)) { 	   
   JavascriptExecutor js =(JavascriptExecutor) dr;
   js.executeScript("arguments[0].scrollIntoView({block:'center'});", itsnw); 
   break;
               }
           }
         }            
        

  public void add2cartfrmlist() throws Exception {
  Thread.sleep(3000);
   WebElement adCartButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("adoc"))));
   adCartButton.click();
  }
  
  public void add2cartfrmProductpage() throws Exception {
	  try { 
   WebElement atc = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart"))); 
   atc.click(); 
   } catch (Exception e) { 
    System.out.println("button-cart not present, stayed on listing page"); 
	} 
   
}
}


      



