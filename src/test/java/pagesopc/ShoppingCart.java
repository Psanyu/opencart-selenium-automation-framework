package pagesopc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    WebDriverWait wait;

    public ShoppingCart(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
        wait = new WebDriverWait(dr, Duration.ofSeconds(10));
    }

    public void adcart() {

        WebElement addtocart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("adtc"))));

        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", addtocart);

        try {
            addtocart.click();
        } catch (Exception e) {
            ((JavascriptExecutor) dr).executeScript("arguments[0].click();", addtocart);
        }
        
        }

    
    public void chkoutqty(String i) throws Exception {     
              
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("itq"))));
        
        quantity.clear();
        quantity.sendKeys(i);
    }
        
    public void chkouttax(String sci, String szi, String zci) throws Exception {

        WebElement estimatetax = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath(elements.get("estax"))
        ));

        ((JavascriptExecutor) dr).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", estimatetax
        );

        wait.until(ExpectedConditions.elementToBeClickable(estimatetax));

        try {
            estimatetax.click();
            System.out.println("Estimate tax clicked using normal click");
        } catch (Exception e) {
            ((JavascriptExecutor) dr).executeScript("arguments[0].click();", estimatetax);
            System.out.println("Estimate tax clicked using JS fallback");
        }

        // Wait and Select country
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("selectcountry"))));
        Select sc = new Select(dr.findElement(By.xpath(elements.get("selectcountry"))));

        List<WebElement> options = sc.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(sci)) {
                option.click();
                break;
            }
        }

        // Wait and Select zone
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("selectzone"))));
        Select sz = new Select(dr.findElement(By.xpath(elements.get("selectzone"))));

        List<WebElement> optionz = sz.getOptions();
        for (WebElement option : optionz) {
            if (option.getText().equals(szi)) {
                option.click();
                break;
            }
        }

        // Fill zipcode
        WebElement zipcode = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(elements.get("fillpostcode"))
        ));
        zipcode.clear();
        zipcode.sendKeys(zci);

        WebElement gquote = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("getquote"))));
        gquote.click();

        WebElement fsr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("flatshiprate"))));
        fsr.click();

        WebElement asp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("applyshipping"))));
        asp.click();
    }
    
    public void chkoutcoupon(String cc) throws Exception {
        
        Thread.sleep(3000);
        
        WebElement ccode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("coupon"))));
        ccode.click();
        
        WebElement couponcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("couponenter"))));
        couponcode.clear();
        couponcode.sendKeys(cc);
        
        WebElement apcoupon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.get("couponcd"))));
        apcoupon.click();
        
    }
    
    public void chkout() {
        
        //chkout
        WebElement chkout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout")));
        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", chkout);

        try {
            chkout.click();
        } catch (Exception e) {
            ((JavascriptExecutor) dr).executeScript("arguments[0].click();", chkout);
        }
        
        }

			
	}
    
    
	



