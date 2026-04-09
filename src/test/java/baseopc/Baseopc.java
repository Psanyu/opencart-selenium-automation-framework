package baseopc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilitiesopc.Config;

public class Baseopc {
	
    protected WebDriver dr;
	protected Config config;
   

    @BeforeMethod
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        dr = new ChromeDriver();

        Config config = new Config("config.properties");
        this.config=config;

        dr.manage().window().maximize();
        dr.get(config.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (dr != null) {
            dr.quit();
        }
    }

}
