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


public class ShoppingCart{

    WebDriver dr;
    Config elements;

    public ShoppingCart(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
    }

    public void adcart() {

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

        WebElement addtocart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("adtc"))));

        addtocart.click();
        
        }

    
    public void chkout(String i, String sci, String szi, String zci, String cc) throws Exception {

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
              
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("itq"))));
        
        quantity.clear();
        quantity.sendKeys(i);
        
        WebElement estimatetax = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("estax"))));
        estimatetax.click();
        
        //Wait and Select country
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("selectcountry"))));
        Select sc = new Select(dr.findElement(By.xpath(elements.get("selectcountry"))));
        List<WebElement> options = sc.getOptions();
        for (WebElement option:options){ 
        	if (option.getText().equals(sci)) { 
        		option.click();
        		} 
        	}
        
        //Wait and Select zone
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("selectzone"))));
        Select sz = new Select(dr.findElement(By.xpath(elements.get("selectzone"))));
        List<WebElement> optionz = sz.getOptions();
        for (WebElement option:optionz){ 
        	if (option.getText().equals(szi)) { 
        		option.click();
        		} 
        	}
        
        //Fill zipcode
        WebElement zipcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("fillpostcode"))));
        zipcode.clear();
        zipcode.sendKeys(zci);
                
        WebElement gquote = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("getquote"))));
        gquote.click();
        
        WebElement fsr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("flatshiprate"))));
        fsr.click();
        
        WebElement asp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("applyshipping"))));
        asp.click();
        
        Thread.sleep(3000);
        
        WebElement ccode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("coupon"))));
        ccode.click();
        
        WebElement couponcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("couponenter"))));
        couponcode.clear();
        couponcode.sendKeys(cc);
        
        WebElement apcoupon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("couponcd"))));
        apcoupon.click();
        
        //chkout
        WebElement chkout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout")));
        chkout.click();
        
        }

			
	}
    
    
	



