// separate the connection string call and easy to call in servlet. reusable
package qg21;

import java.sql.Connection;
import java.sql.SQLException;
import qg21.TestJdbc02;

public class TestMssqlJdbc03 extends TestJdbc02 {

    public TestMssqlJdbc03() throws ClassNotFoundException {
        super("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    public Connection connect(
            String ip, String port, String db, String usr, String pwd)
            throws SQLException {
        String connection_string
                = "jdbc:sqlserver://" + ip + ":" + port + ";"
                + "databaseName=" + db + ";"
                + "user=" + usr + ";password=" + pwd;

        return super.connect(connection_string);
    }
}
