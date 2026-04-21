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

public class SelectReturnsForm {

    WebDriver dr;
    Config elements;
    WebDriverWait wait;
    JavascriptExecutor jsk;

    public SelectReturnsForm(WebDriver dr) throws Exception {
        this.dr = dr;
        elements = new Config("elements.properties");
        wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        this.jsk = (JavascriptExecutor) dr;
    }

    public void returnformIfEmpty(String xpathKey, String value) {
        String xpathValue = elements.get(xpathKey);

        if (xpathValue == null || xpathValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing xpath in elements.properties for key: " + xpathKey);
        }

        By locator = By.xpath(xpathValue);
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        String currentValue = field.getAttribute("value");
        if (currentValue == null) {
            currentValue = "";
        }

        if (currentValue.trim().isEmpty()) {
            field.sendKeys(value);
        }
    }

    public void returnformProdQty(String productQty) {
        WebElement prodqty = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.get("Qt")))
        );

        String currentQty = prodqty.getAttribute("value");
        if (currentQty == null) {
            currentQty = "";
        }

        if (currentQty.trim().isEmpty()) {
            prodqty.sendKeys(productQty);
        }
    }

    public void returnformRR(String productRR) {
        List<WebElement> prodrr = dr.findElements(By.xpath(elements.get("prrr")));

        for (WebElement prdr : prodrr) {
            try {
                String value = prdr.getAttribute("value");
                String id = prdr.getAttribute("id");

                if (value != null && value.equalsIgnoreCase(productRR)) {
                    jsk.executeScript("arguments[0].scrollIntoView(true);", prdr);
                    wait.until(ExpectedConditions.elementToBeClickable(prdr)).click();
                    break;
                }

                if (id != null && !id.isEmpty()) {
                    WebElement label = dr.findElement(By.xpath("//label[@for='" + id + "']"));
                    if (label.getText().trim().equalsIgnoreCase(productRR)) {
                        jsk.executeScript("arguments[0].scrollIntoView(true);", label);
                        wait.until(ExpectedConditions.elementToBeClickable(label)).click();
                        break;
                    }
                }
            } catch (Exception e) {
                // continue checking next option
            }
        }
    }

    public void returnformprop(String productRRop) {
        List<WebElement> prodrrop = dr.findElements(By.xpath(elements.get("prodop")));

        for (WebElement prdrop : prodrrop) {
            try {
                String value = prdrop.getAttribute("value");
                String id = prdrop.getAttribute("id");

                if (value != null && value.equalsIgnoreCase(productRRop)) {
                    jsk.executeScript("arguments[0].scrollIntoView(true);", prdrop);
                    wait.until(ExpectedConditions.elementToBeClickable(prdrop)).click();
                    break;
                }

                if (id != null && !id.isEmpty()) {
                    WebElement label = dr.findElement(By.xpath("//label[@for='" + id + "']"));
                    if (label.getText().trim().equalsIgnoreCase(productRRop)) {
                        jsk.executeScript("arguments[0].scrollIntoView(true);", label);
                        wait.until(ExpectedConditions.elementToBeClickable(label)).click();
                        break;
                    }
                }
            } catch (Exception e) {
                // continue checking next option
            }
        }
    }
    
    public void printFieldValue(String xpathKey) {
        String xpathValue = elements.get(xpathKey);
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
        System.out.println(xpathKey + " = " + field.getAttribute("value"));
    }

    public void returnFormSubmit() {
        By submitBtn = By.xpath(elements.get("subbtn"));

        try {
            WebElement subbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));

            jsk.executeScript("arguments[0].scrollIntoView({block:'center'});", subbtn);

            // small wait for UI to settle
            Thread.sleep(500);

            wait.until(ExpectedConditions.elementToBeClickable(subbtn)).click();
            System.out.println("Submit button clicked using normal click");

        } catch (Exception e) {

            WebElement subbtn = wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));

            // fallback
            jsk.executeScript("arguments[0].click();", subbtn);
            System.out.println("Submit button clicked using JS click (fallback)");
        }
    }
    
    public String getReturnSuccessMessage() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@id='content']")
        ));
        return msg.getText();
    }
}