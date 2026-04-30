package testsopc;

import org.testng.annotations.Test;
import utilitiesopc.ConfigDB;

public class SQLconnect {

    @Test
    public void validateOpenCartDBConnection() throws Exception {

        ConfigDB.connectToOpenCartDB();

        String orderStatus = ConfigDB.getOrderStatusId("1");
        System.out.println("Order Status ID: " + orderStatus);

        ConfigDB.closeConnection();
    }
}