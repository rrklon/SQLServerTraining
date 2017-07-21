package qg21;

import java.sql.SQLException;

public class TestQG21 {

  private static TestMssqlJdbc03 mssql;
  
  public static TestMssqlJdbc03 mssql() 
      throws ClassNotFoundException, SQLException {
    if( mssql == null ) {
      mssql = new TestMssqlJdbc03();
      mssql.connect(
          "192.168.1.126", "1433", 
          "AdventureWorksDW2014", "Rushamir", "abc123");
    }
    return mssql;
  }
}