package testsopc;


import org.testng.annotations.Test;

import baseopc.Baseopc;
import pagesopc.Loginpgop;
import pagesopc.Logoutopc;

public class Logouttopc extends Baseopc {

    @Test
    public void verifyLogout() throws Exception {
	 Loginpgop loginPg = new Loginpgop(dr);
	    loginPg.usern(config.get("email"));
	    loginPg.pwdn(config.get("password"));
	    loginPg.lgn();
	    
	   Thread.sleep(10000);
	    
	    Logoutopc logoutPg = new Logoutopc(dr);
	    logoutPg.lgout1();
}

}
