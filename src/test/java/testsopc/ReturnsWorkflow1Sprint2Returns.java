package testsopc;


import org.testng.annotations.Test;

import baseopc.Baseopc;
import pagesopc.Loginpgop;
import pagesopc.SelectOrhisItem;
import pagesopc.SelectReturnsForm;
import pagesopc.Logoutopc;
import pagesopc.SelectOrProductpg;
import pagesopc.SelectOrReturns;
import org.testng.Assert;
import utilitiesopc.DBUtil;



public class ReturnsWorkflow1Sprint2Returns extends Baseopc {

@Test
    public void verifyorderconfirmation() throws Exception {
	 Loginpgop loginPg = new Loginpgop(dr);
	    loginPg.usern(config.get("email"));
	    loginPg.pwdn(config.get("password"));
	    loginPg.lgn();
	    loginPg.lgnconfirm();
	    
	    String OrderIDn="2";
	    
        SelectOrhisItem selorhisit = new SelectOrhisItem(dr);
        selorhisit.orhispgselect();
        
        SelectOrProductpg selectppg = new SelectOrProductpg(dr);
        selectppg.oritemvw(OrderIDn);
        
        SelectOrReturns selectrpg = new SelectOrReturns(dr);
        selectrpg.returnvw();
        
        SelectReturnsForm selectrf = new  SelectReturnsForm(dr);
        selectrf.returnformIfEmpty("ordi", OrderIDn);
        selectrf.returnformIfEmpty("ordate", "2026-04-20");
        selectrf.returnformIfEmpty("fn", "First1");
        selectrf.returnformIfEmpty("ln", "Last1");
        selectrf.returnformIfEmpty("Em", "admin@mail.com");
        selectrf.returnformIfEmpty("Pnm", "HP LP3065");
        selectrf.returnformIfEmpty("Pcd", "Product 21");
        selectrf.returnformProdQty("1");

        
        selectrf.returnformRR("Dead On Arrival");
        selectrf.returnformprop("Yes");  
        
        selectrf.printFieldValue("ordi");
        selectrf.printFieldValue("fn");
        selectrf.printFieldValue("ln");
        selectrf.printFieldValue("Em");
        selectrf.printFieldValue("Pnm");
        selectrf.printFieldValue("Pcd");
        selectrf.printFieldValue("Qt");
        
        selectrf.returnFormSubmit();
        
        System.out.println("Current URL after submit: " + dr.getCurrentUrl());
        System.out.println("Page source contains success? " + dr.getPageSource().contains("Your return request has been submitted"));
        
        Thread.sleep(5000);
        
        String OrderIDn2 = DBUtil.getLatestOrderIdByEmail(config.get("email"));

        boolean returnExists = DBUtil.isReturnPresent(OrderIDn2);

        Assert.assertTrue(returnExists, "Return not found in DB for order: " + OrderIDn);

        System.out.println("Return found in DB for order: " + OrderIDn2);
        
	    Thread.sleep(5000);

	    Logoutopc logoutPg = new Logoutopc(dr);
	    logoutPg.lgout2();
}

}
