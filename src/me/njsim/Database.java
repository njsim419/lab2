package me.njsim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;






public class Database
{
  private static Connection connection;
  static String database;
  String username;
  String password;
  
  public Database(String database, String username, String password)
  {
    database = database;
    this.username = username;
    this.password = password;
  }
  
  
  public static void getAgents() {
      try {
          Class.forName("com.mysql.jdbc.Driver");

          Connection conn = DriverManager.getConnection("jdbc:mysql://149.56.243.238:3306/TravelExperts?autoReconnect=true&useSSL=false", "root", "flat*!Cat52");
          String sql = "select * from Agents";
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while (rs.next())
          {
        	  System.out.println(rs.getInt(1));
          }


      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
  }

  public Database(String ip, String userName, String password, String db)
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + db + "?user=" + userName + "&password=" + password);
      connection.setAutoCommit(false);
    }
    catch (Exception e)
    {
      System.out.println("[MySQL]: [ERROR] " + e.getMessage());

    }
  }
}