package pagesopc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilitiesopc.Config;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SShipping {

    WebDriver dr;
    Config elements;

    public SShipping(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
    }


    public void shipping(String cust, String eci) throws Exception {

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
              
       if ("Existing".equals(cust)) {
        WebElement existcust = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("existingcust"))));      
        existcust.click();
        
      //Wait and Select customer existing
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("adid"))));
        Select ec = new Select(dr.findElement(By.xpath(elements.get("adid"))));
        List<WebElement> optc = ec.getOptions();
        for (WebElement option:optc){ 
        	if (option.getText().equals(eci)) { 
        		option.click();
        		} 
        	}
        
       }
       
       else {
           WebElement nwcust = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("newcust"))));      
           nwcust.click();   
       }
       
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal-shipping")));
       
       //Wait and Select Choose
        WebElement shm =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("shipm"))));
        shm.click();
        
      //Wait and Select Shipping method rate
        WebElement shmo =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("shipmo"))));
        shmo.click();
        
        Thread.sleep(5000);
        
        //Wait and Select Continue
        WebElement shipmcontinue =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("shipmcon"))));
        shipmcontinue.click();
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal-shipping")));
        
      //Wait and Select Choose
       WebElement pm =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("paym"))));
       pm.click();
       
     //Wait and Select Shipping method rate
       WebElement pmo =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("paymo"))));
       pmo.click();
       
       Thread.sleep(5000);
       
       //Wait and Select Continue
       WebElement pmcontinue =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("paymcon"))));
       pmcontinue.click();
         
       Thread.sleep(5000);
       WebElement confirmorder =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("confirmor"))));
       confirmorder.click(); 
       
       Thread.sleep(5000);
	   WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("contentid"))));
	   Assert.assertTrue(successMsg.getText().contains("Your order has been placed!"),"Order success message not found");
        
        }

			
	}
    
    
	



