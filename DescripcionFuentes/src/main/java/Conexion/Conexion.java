/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanj
 */
public class Conexion {

    /**
     * Establece y devuelve la conexión con la base de datos.
     *
     * @return null si hay problemas.
     */
    public static Connection getConection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/experimento1","root", "heroes");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Cierra la conexión que se le pasa.
     *
     * @param conexion
     */
    public static void cierraConexion(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
