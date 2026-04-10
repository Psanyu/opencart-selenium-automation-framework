package testsopc;

import org.testng.annotations.Test;

import baseopc.Baseopc;
import pagesopc.Loginpgop;
import pagesopc.Logoutopc;
import pagesopc.SShippingAltwNew;
import pagesopc.SelectItem;
import pagesopc.ShoppingCart;

public class SecondaryWorkflowSprint2Buy extends Baseopc {

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

	   acart.chkout("1", "Canada", "British Columbia", "V4B1F4", "DXCFFFFF");

	   SShippingAltwNew confirm = new SShippingAltwNew(dr);
	   
	   confirm.selectcust("New");
	   confirm.newcustomer("Sam", "Salt", "Unemployed", "36 ABC", "West Chester", "P9SL0G", "United States", "Pennsylvania");
	   
	   Thread.sleep(3000);
	   confirm.shippingmethodselect();
	   
	   Thread.sleep(3000);
	   confirm.paymentmethodselect();
	   
	   Thread.sleep(3000);
	   confirm.confirmorder();
	   
	    Thread.sleep(3000);

	    Logoutopc logoutPg = new Logoutopc(dr);
	    logoutPg.lgout2();
}

}
