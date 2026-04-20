package testsopc;

import org.testng.annotations.Test;

import baseopc.Baseopc;
import pagesopc.Loginpgop;
import pagesopc.Logoutopc;
import pagesopc.SShipping;
import pagesopc.SelectItem;
import pagesopc.ShoppingCart;

public class PrimaryWorkflow1Sprint1MacBuy extends Baseopc {

@Test
    public void verifyorderconfirmation() throws Exception {
	 Loginpgop loginPg = new Loginpgop(dr);
	    loginPg.usern(config.get("email"));
	    loginPg.pwdn(config.get("password"));
	    loginPg.lgn();

	   Thread.sleep(3000);
	    SelectItem selectmac = new SelectItem(dr);
	    selectmac.dtop();

	   Thread.sleep(3000);

	   selectmac.macselect();

	   Thread.sleep(3000);

	   ShoppingCart acart = new ShoppingCart(dr);
	   acart.adcart();

	   acart.chkoutqty("1");	   
	   acart.chkouttax("Canada", "British Columbia", "V4B1F4");
	   acart.chkoutcoupon("DXCFFFFF");

	   SShipping confirm = new SShipping(dr);
	   confirm.shipping("Existing", "Sam Sak, Unemployed, 26 ABC, West Chester, Pennsylvania, United States");

	    Thread.sleep(3000);

	    Logoutopc logoutPg = new Logoutopc(dr);
	    logoutPg.lgout2();
}

}
