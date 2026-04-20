package testsopc;

import org.testng.annotations.Test;

import baseopc.Baseopc;
import pagesopc.Loginpgop;
import pagesopc.Logoutopc;
import pagesopc.SShippingAltwNew;
import pagesopc.SelectItem2;
import pagesopc.ShoppingCart;

public class PrimaryWorkflow2Sprint1Buy extends Baseopc {

@Test
    public void verifyorderconfirmation() throws Exception {
	 Loginpgop loginPg = new Loginpgop(dr);
	    loginPg.usern(config.get("email"));
	    loginPg.pwdn(config.get("password"));
	    loginPg.lgn();
	    loginPg.lgnconfirm();
	    
        SelectItem2 selectits2 = new SelectItem2(dr);
	    //selectits2.itemselect("Laptops & Notebooks", "Show All", "HP LP3065");
	    //selectits2.itemselect("Desktops", "Mac");
	   selectits2.Maincatselect("Laptops & Notebooks");
	   selectits2.Subcatselect("Show All");
	   selectits2.Addproduct("HP LP3065");   
	   selectits2.add2cartfrmlist();
	   selectits2.add2cartfrmProductpage();
	   
	   Thread.sleep(3000);
	   ShoppingCart acart = new ShoppingCart(dr);
	   acart.adcart();

	   Thread.sleep(3000);
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
