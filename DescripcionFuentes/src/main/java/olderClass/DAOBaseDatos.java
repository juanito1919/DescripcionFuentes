/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olderClass;

import Conexion.Conexion;
import olderClass.BaseDatos;
import olderClass.Column;
import olderClass.Table;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Anguisaca
 */
public class DAOBaseDatos {

    static DAOBaseDatos instance = null;
    Connection conexion = null;
    String schema = "";

    public static DAOBaseDatos getInstance() {
        if (instance == null) {
            instance = new DAOBaseDatos();
        }
        return instance;
    }

    public DAOBaseDatos() {
    }

    public DAOBaseDatos(String host, String puerto, String schema, String username, String pass) {
        //  conexion = Conexion.getConection(host,puerto,schema,username,pass);
        conexion = Conexion.getConection();
        this.schema = schema;

    }

    public ArrayList<Table> getTablas(String schema) {
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + schema + "'";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Table> tables = new ArrayList();
            while (rs.next()) {
                /*System.out.println("result0: "+rs.getString(3));;
                 System.out.println("result4: "+rs.getString(4));;
                 System.out.println("result14: "+rs.getString(17));;
                 */
                Table table = new Table();
                table.setTABLE_NAME(rs.getString(3));
                table.setTABLE_TYPE(rs.getString(4));
                table.setENGINE(rs.getString(5));
                table.setVERSION(rs.getString(6));
                table.setROW_FORMAT(rs.getString(7));
                table.setTABLE_ROWS(rs.getString(8));
                table.setAVG_ROW_LENGTH(rs.getString(9));
                table.setDATA_LENGTH(rs.getString(10));
                table.setMAX_DATA_LENGTH(rs.getString(11));
                table.setAUTO_INCREMENT(rs.getString(12));
                table.setCREATE_TIME(rs.getString(13));
                table.setUPDATE_TIME(rs.getString(14));
                table.setCHECK_TIME(rs.getString(15));
                table.setTABLE_COLLATION(rs.getString(16));
                table.setCHECKSUM(rs.getString(17));
                table.setTABLE_COMMENT(rs.getString(17));
                ArrayList<Column> columns = getColumns(schema, table.getTABLE_NAME());
                table.setColumnas(columns);
                tables.add(table);
            }

            return tables;

        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Column> getColumns(String schema, String table) {
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '" + schema + "' AND TABLE_NAME = '" + table + "'";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Column> columns = new ArrayList();
            while (rs.next()) {
                /*System.out.println("result0: "+rs.getString(3));;
                 System.out.println("result4: "+rs.getString(4));;
                 */
                System.out.println("result14: " + rs.getString(17));;
                Column column = new Column();
                column.setCOLUMN_NAME(rs.getString(4));
                column.setORDINAL_POSITION(rs.getString(5));
                column.setCOLUMN_DEFAULT(rs.getString(6));
                column.setIS_NULLABLE(rs.getString(7));
                column.setDATA_TYPE(rs.getString(8));
                column.setCHARACTER_MAXIMUM_LENGTH(rs.getString(9));
                column.setCHARACTER_OCTET_LENGTH(rs.getString(10));
                column.setNUMERIC_PRECISION(rs.getString(11));
                column.setNUMERIC_SCALE(rs.getString(12));
                column.setCHARACTER_SET_NAME(rs.getString(13));
                column.setCOLLATION_NAME(rs.getString(15));
                column.setCOLUMN_KEY(rs.getString(17));
                column.setEXTRA(rs.getString(18));
                column.setCOLUMN_COMMENT(rs.getString(18));

                columns.add(column);
            }

            return columns;

        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public BaseDatos getDataSet() {
        BaseDatos dataset = null;
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + schema + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dataset = new BaseDatos();
                dataset.setCATALOG_NAME(rs.getString(1));
                dataset.setSCHEMA_NAME(rs.getString(2));
                dataset.setDEFAULT_CHARACTER_SET_NAME(rs.getString(3));
                dataset.setDEFAULT_COLLATION_NAME(rs.getString(4));

            }
            ArrayList<Table> tables = getTablas(schema);
            dataset.setTables(tables);
            return dataset;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
