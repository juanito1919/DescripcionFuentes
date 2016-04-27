/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import olderClass.DAOBaseDatos;
import Conexion.Conexion;
import com.ucuenca.mdl.Column;
import com.ucuenca.mdl.Column_Base;
import com.ucuenca.mdl.DataBase;
import com.ucuenca.mdl.Table;
import com.ucuenca.mdl.Table_Base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo and Adrian Anguisca
 */
public class BaseDatosDao extends AbstractDao {

    private static BaseDatosDao instance = null;
    private Connection conexion = null;
    private String schema = "";

    public BaseDatosDao() {
    }

    public BaseDatosDao(String host, String puerto, String schema, String username, String pass) {
        conexion = Conexion.getConection(host, puerto, schema, username, pass);
        this.schema = schema;
    }

    public static BaseDatosDao getInstance() {
        if (instance == null) {
            instance = new BaseDatosDao();
        }
        return instance;
    }

    /**
     * This method gets all table
     *
     * @param schema
     * @Author pablo and adrian
     */
    public ArrayList<Table> getTables(String schema) {
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + schema + "'";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Table> tables = new ArrayList();
            while (rs.next()) {
                Table_Base table = new Table_Base();
                table.setTitle(rs.getString(3));//TABLE_NAME
                table.setDescription(rs.getString(21));//TABLE_COMMENT
                System.out.println("isuued table.. "+rs.getString(15)+"/"+rs.getString(3));
                table.setIssued(rs.getString(15));//CREATE_TIME
                if(rs.getString(16) != null){
                    table.setModified(rs.getString(16));//UPDATE_TIME
                
                }else
                {
                    table.setModified("");//UPDATE_TIME
                
                }
                table.setMediaType("application/sql");
                table.setFormat("application/sql");
                table.setByteSize(getByteSizeDBTable(rs.getString(10), rs.getString(12)));
                table.setCharacterSet(getCharacterSetTableDB(schema, rs.getString(3)));
                table.setDefaultDecimalSeparator(".");//default standard mysql
                table.setOverrallRecordCount(rs.getString(8));
                ArrayList<Column> columns = getColumns(schema, table.getTitle());
                table.setColumnas(columns);
                tables.add(table);
            }
            return tables;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public String getByteSizeDBTable(String data_length, String index_length){
        
        double dataAux = Double.parseDouble(data_length);        
        double indexAux = Double.parseDouble(index_length);        
        double bytesize = (dataAux + indexAux)/1024/1024;
        return String.valueOf(bytesize);
    
    }
    
    public String getCharacterSetTableDB(String schema, String table) {
        String character_set = "";
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            sql = "SELECT CCSA.character_set_name FROM INFORMATION_SCHEMA.TABLES T,"
                    + "INFORMATION_SCHEMA.COLLATION_CHARACTER_SET_APPLICABILITY CCSA "
                    + " WHERE T.TABLE_SCHEMA = '" + schema + "' AND T.TABLE_NAME = '"+table+"'"
                    + "AND CCSA.COLLATION_NAME = T.TABLE_COLLATION";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                character_set = rs.getString(1);
            }
            return character_set;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
 
    /**
     * This method gets all column
     *g
     * @param schema
     * @param table
     * @Author pablo and adrian
     */
    public ArrayList<Column> getColumns(String schema, String table) {
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '" + schema + "' AND TABLE_NAME = '" + table + "'";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Column> columns = new ArrayList();
            while (rs.next()) {
                Column_Base column = new Column_Base();
                column.setTitle(rs.getString(4));
                column.setStorageFormat(rs.getString(8));
                column.setDecimalPositions(".");//default standard mysql
                column.setRecordNumber(getRecordNumberColumnBD(schema, table, column.getTitle()));
                columns.add(column);
            }
            return columns;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public String getRecordNumberColumnBD(String schema, String table, String column) {
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            String recordNumber = "";
            sql = "SELECT count("+column+") FROM "+schema+"."+table+" WHERE "+column+" IS NOT NULL ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                recordNumber = rs.getString(1);
            }
            
            return recordNumber;
        } catch (SQLException ex) {
            //Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }

    /**
     * This method gets DataSet
     *
     * @Author pablo and adrian
     */
    public DataBase getDataSet() {
        DataBase dataset = null;
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + schema + "'";
            ResultSet rs = stmt.executeQuery(sql);
            dataset = new DataBase();
            while (rs.next()) {
                
                dataset.setCatalog_name(rs.getString(1));
                dataset.setSchema_name(rs.getString(2));
                dataset.setCharacter_set(rs.getString(3));
                dataset.setCollation_name(rs.getString(4));
                dataset.setIssued(getIssuedBD(schema));

            }
            ArrayList<Table> tables = getTables(schema);
            dataset.setTables(tables);
            return dataset;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public String getIssuedBD(String schema) {
        try {
            Statement stmt = conexion.createStatement();
            String sql;
            String issued = "";
            sql = "SELECT min(create_time) FROM  INFORMATION_SCHEMA.TABLES WHERE table_schema = '"+schema+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                issued = rs.getString(1);
            }
            System.out.println("issued"+issued+"  "+sql);
            return issued;
        } catch (SQLException ex) {
            Logger.getLogger(DAOBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
