// Use to test connection to database for servlet02
//this one is the best practice to code connection.
package qg21;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc02 {

    String driver;
    Connection conn;

    public TestJdbc02(String driver) throws ClassNotFoundException {

        this.driver = driver;
        Class.forName(driver); //load for JDBC Driver

    }
    String url;
    String user;
    String password;

    public Connection connect(String url) throws SQLException {
        //to connect to database
        this.url = url;
        conn = DriverManager.getConnection(url);
        return conn;
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();

        }
        conn = null;
        url = null;
    }

    public String getSimpleMetaData() throws SQLException {

        if (conn != null) {
            DatabaseMetaData dbmd = conn.getMetaData();
            StringBuilder sb = new StringBuilder();
            sb.append("Database info:\n")
                    .append("   name[")
                    .append(dbmd.getDatabaseProductName()).append("]\n")
                    .append("version[")
                    .append(dbmd.getDatabaseProductVersion()).append("]");
            return sb.toString();
        } else {
            return ("No database Connection!");
        }
    }
}
