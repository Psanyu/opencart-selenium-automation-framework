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

public class SShippingAltwNew {

    WebDriver dr;
    Config elements;
	WebDriverWait wait;
	String eci;

    public SShippingAltwNew(WebDriver dr) throws Exception {
        this.dr = dr;
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
    	this.wait = wait ;
        elements = new Config("elements.properties");
    }
    
    public void excustomer (String cnme, String clnme, String ccompe, String cadd1e, String ccitye, String cposte, String countrye, String regione) {
               
    	String eci = cnme + " " + clnme + ", " + ccompe + ", " + cadd1e + ", " + ccitye + ", " + cposte + ", " + regione + ", " + countrye;
    	this.eci = eci;
    	
    }
    
    public void newcustomer (String cnmn, String clnmn, String ccompn, String cadd1n, String ccityn, String cpostn, String countryn, String regionn) throws Exception {
    	    	
    	WebElement nwcustnm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("custfirst"))));
        nwcustnm.sendKeys(cnmn);

        WebElement nwcustlnm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("custlast"))));
        nwcustlnm.sendKeys(clnmn);

        WebElement nwcustcomp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("custcomp"))));
        nwcustcomp.sendKeys(ccompn);

        WebElement nwcustadd1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("custadd1"))));
        nwcustadd1.sendKeys(cadd1n);

        WebElement nwcustcity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("custcity"))));
        nwcustcity.sendKeys(ccityn);

        WebElement nwcustpost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("custpost"))));
        nwcustpost.sendKeys(cpostn);

        // Wait and Select country
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("nccountid"))));
        Select nwccount = new Select(dr.findElement(By.xpath(elements.get("nccountid"))));
        List<WebElement> optnwcount = nwccount.getOptions();
        for (WebElement optionc : optnwcount) {
            if (optionc.getText().equals(countryn)) {
                optionc.click();
            }
        }

        // Wait and Select region
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("ncregionid"))));
        Select nwcregion = new Select(dr.findElement(By.xpath(elements.get("ncregionid"))));
        List<WebElement> optnwregion = nwcregion.getOptions();
        for (WebElement optionr : optnwregion) {
            if (optionr.getText().equals(regionn)) {
                optionr.click();
            }
        }
        
        WebElement nwcustsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("custsave"))));
        nwcustsave.click();   
       

    }
    
    
    
    public void selectcust(String cust) {
    	
    	if ("Existing".equals(cust)) {
            WebElement existcust = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("existingcust"))));
            existcust.click();

            // Wait and Select customer existing
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("adid"))));
            Select ec = new Select(dr.findElement(By.xpath(elements.get("adid"))));
            List<WebElement> optc = ec.getOptions();
            for (WebElement option : optc) {
                
                if (option.getText().equals(eci)) {
                    option.click();
                }
            }

        } else {
            WebElement nwcust = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("newcust"))));
            nwcust.click();
            
            }
            

        }
    	
    

    public void shippingmethodselect() throws Exception {
    	
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal-shipping")));

        // Wait and Select Choose
        WebElement shm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("shipm"))));
        shm.click();

        // Wait and Select Shipping method rate
        WebElement shmo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("shipmo"))));
        shmo.click();

        Thread.sleep(5000);

        // Wait and Select Continue
        WebElement shipmcontinue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("shipmcon"))));
        shipmcontinue.click();
        
    }
    
    public void paymentmethodselect() throws Exception {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal-shipping")));

        // Wait and Select Choose
        WebElement pm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("paym"))));
        pm.click();

        // Wait and Select Shipping method rate
        WebElement pmo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("paymo"))));
        pmo.click();

        Thread.sleep(5000);

        // Wait and Select Continue
        WebElement pmcontinue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("paymcon"))));
        pmcontinue.click();
        
    }

    public void confirmorder() throws Exception {
        
        WebElement confirmorder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("confirmor"))));
        confirmorder.click();

        Thread.sleep(5000);
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("contentid"))));
        Assert.assertTrue(successMsg.getText().contains("Your order has been placed!"), "Order success message not found");

    } // method ends



} // class ends