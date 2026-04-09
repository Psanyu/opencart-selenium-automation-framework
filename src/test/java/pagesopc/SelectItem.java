package pagesopc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilitiesopc.Config;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectItem {

    WebDriver dr;
    Config elements;

    public SelectItem(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
    }

    public void dtop() {

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

        WebElement dtop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("desktopc"))));

        dtop.click();
        
        }
    
    public void macselect() {

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
     
        WebElement macsel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Mac")));
        
        macsel.click();
        
        WebElement macadoc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("adoc"))));
        
        macadoc.click();
        
        
    }
}	



