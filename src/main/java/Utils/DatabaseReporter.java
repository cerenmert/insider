package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseReporter {
    Connection conn = null;

    public DatabaseReporter() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/insider_test?user=root");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void sendReport(String method, String status) {
        if (conn != null) {
            try {
                String sql = "INSERT INTO test_results (`case`, `status`) VALUES (?, ?)";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, method);
                preparedStatement.setString(2, status);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
    }
}
