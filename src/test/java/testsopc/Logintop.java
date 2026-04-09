package testsopc;

import org.testng.annotations.Test;
import baseopc.Baseopc;
import pagesopc.Loginpgop;


public class Logintop extends Baseopc {

    @Test
    public void verifyLogin() throws Exception {

        Loginpgop loginPg = new Loginpgop(dr);

        loginPg.usern(config.get("email"));
        loginPg.pwdn(config.get("password"));
        loginPg.lgn();
    }
}

