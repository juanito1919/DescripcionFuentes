/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

import java.util.ArrayList;

/**
 *
 * @author pablo juan.japal@hotmail.com
 */
public class DataBase {

    private String CATALOG_NAME;
    private String SCHEMA_NAME;
    private ArrayList<Table> tables;

    /**
     * @return the CATALOG_NAME
     */
    public String getCATALOG_NAME() {
        return CATALOG_NAME;
    }

    /**
     * @param CATALOG_NAME the CATALOG_NAME to set
     */
    public void setCATALOG_NAME(String CATALOG_NAME) {
        this.CATALOG_NAME = CATALOG_NAME;
    }

    /**
     * @return the SCHEMA_NAME
     */
    public String getSCHEMA_NAME() {
        return SCHEMA_NAME;
    }

    /**
     * @param SCHEMA_NAME the SCHEMA_NAME to set
     */
    public void setSCHEMA_NAME(String SCHEMA_NAME) {
        this.SCHEMA_NAME = SCHEMA_NAME;
    }

    /**
     * @return the tables
     */
    public ArrayList<Table> getTables() {
        return tables;
    }

    /**
     * @param tables the tables to set
     */
    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }
    
}
