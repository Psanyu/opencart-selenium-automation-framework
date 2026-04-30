package utilitiesopc;

import java.sql.*;

public class DBUtil {

    public static boolean isOrderPresent(String orderId) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/opencart_cd";
        String username = "root";
        String password = "";

        String query = "SELECT order_id FROM oc_order WHERE order_id = ?";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, orderId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    public static String getLatestOrderIdByEmail(String email) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/opencart_cd";
        String username = "root";
        String password = "";

        String query = "SELECT order_id FROM oc_order WHERE email = ? ORDER BY order_id DESC LIMIT 1";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("order_id");
                }
            }
        }

        return null;
    }

    public static boolean isReturnPresent(String orderId) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/opencart_cd";
        String username = "root";
        String password = "";

        String query = "SELECT return_id FROM oc_return WHERE order_id = ?";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, orderId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}