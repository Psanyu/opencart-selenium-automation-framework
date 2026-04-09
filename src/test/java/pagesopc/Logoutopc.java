package pagesopc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilitiesopc.Config;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logoutopc {

    WebDriver dr;
    Config elements;

    public Logoutopc(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
    }

    public void lgout1() {

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("loid1"))));

        logout.click();
    }
    
    public void lgout2() {

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        
        WebElement userbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("userb"))));
        
        userbutton.click();

        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("loid2"))));

        logout.click();
    }
}