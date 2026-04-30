package testsopc;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import baseopc.Baseopc;
import pagesopc.Loginpgop;
import pagesopc.Logoutopc;
import pagesopc.SShippingAltwNew;
import pagesopc.SelectItem2;
import pagesopc.ShoppingCart;

import org.testng.Assert;
import utilitiesopc.DBUtil;

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
        List<String> products = Arrays.asList("HP LP3065", "MacBook", "Sony VAIO");
        boolean readyToCheckout = false;
        int i = 0;

        while (!readyToCheckout && i < products.size()) {
	   selectits2.Maincatselect("Laptops & Notebooks");
	   selectits2.Subcatselect("Show All");
	   selectits2.Addproduct(products.get(i));  
	   selectits2.add2cartfrmlist(products.get(i));
	   selectits2.add2cartfrmProductpage();
	   i++;
	   if (i == products.size()) {
	        readyToCheckout = true;
	    }
        }
	   
	   Thread.sleep(3000);
	   ShoppingCart acart = new ShoppingCart(dr);
	   acart.adcart();
	   
	   Thread.sleep(3000);

	   while (i < products.size()) {
	   acart.chkoutqty("1");
	   i++;
	   }
	   
	   acart.chkouttax("Canada", "British Columbia", "V4B1F4");
	   acart.chkoutcoupon("DXCFFFFF");
	   acart.chkout();

	   SShippingAltwNew confirm = new SShippingAltwNew(dr);
	   
	   confirm.selectcust("New");
	   confirm.newcustomer("Sam", "Salt", "Unemployed", "36 ABC", "West Chester", "P9SL0G", "United States", "Pennsylvania");
	   
	   Thread.sleep(3000);
	   confirm.shippingmethodselect();
	   
	   Thread.sleep(3000);
	   confirm.paymentmethodselect();
	   
	   Thread.sleep(3000);
	   confirm.confirmorder();
	   
	   String OrderIDn = DBUtil.getLatestOrderIdByEmail(config.get("email"));

	   Assert.assertNotNull(OrderIDn, "No order found in DB for email: " + config.get("email"));

	   boolean orderExists = DBUtil.isOrderPresent(OrderIDn);

	   Assert.assertTrue(orderExists, "Order not found in DB: " + OrderIDn);

	   System.out.println("Latest order found in DB: " + OrderIDn);
	   
	    Thread.sleep(3000);

	    Logoutopc logoutPg = new Logoutopc(dr);
	    logoutPg.lgout2();
}

}
