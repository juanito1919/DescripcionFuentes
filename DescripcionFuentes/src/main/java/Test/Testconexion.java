/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pablo
 */
public class Testconexion {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
      String url = "jdbc:mysql://localhost:3306/";
      String dbName = "base";
      String driver = "com.mysql.jdbc.Driver";
      String userName = "root"; 
      String password = "1234";
      try {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url+dbName,userName,password);
        System.out.println("Successfully connected");
      } catch (Exception e) {
          e.printStackTrace();
      }
     }
    
}
