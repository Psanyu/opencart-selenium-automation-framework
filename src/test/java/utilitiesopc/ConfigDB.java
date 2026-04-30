package utilitiesopc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigDB {

    private static Connection connection;

    public static void connectToOpenCartDB() throws SQLException {
    	String url = "jdbc:mysql://localhost:3306/opencart_cd";
    	String username = "root";
    	String password = "";

        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to OpenCart DB");
    }

    public static String getOrderStatusId(String orderId) throws SQLException {
        String query = "SELECT order_status_id FROM oc_order WHERE order_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, orderId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("order_status_id");
        }

        return null;
    }

    public static String getOrderTotal(String orderId) throws SQLException {
        String query = "SELECT total FROM oc_order WHERE order_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, orderId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("total");
        }

        return null;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("DB connection closed");
        }
    }
}