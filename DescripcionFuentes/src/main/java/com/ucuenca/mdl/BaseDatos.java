/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

import java.util.ArrayList;

/**
 *
 * @author Adrian Anguisaca
 */
public class BaseDatos {
    
    private String CATALOG_NAME;
    private String SCHEMA_NAME;
    private String DEFAULT_CHARACTER_SET_NAME;
    private String DEFAULT_COLLATION_NAME;
    private ArrayList<Table> tables;

    public BaseDatos(String CATALOG_NAME, String SCHEMA_NAME, String DEFAULT_CHARACTER_SET_NAME, String DEFAULT_COLLATION_NAME, ArrayList<Table> tables) {
        this.CATALOG_NAME = CATALOG_NAME;
        this.SCHEMA_NAME = SCHEMA_NAME;
        this.DEFAULT_CHARACTER_SET_NAME = DEFAULT_CHARACTER_SET_NAME;
        this.DEFAULT_COLLATION_NAME = DEFAULT_COLLATION_NAME;
        this.tables = tables;
    }

    public BaseDatos() {
    }

    public String getCATALOG_NAME() {
        return CATALOG_NAME;
    }

    public void setCATALOG_NAME(String CATALOG_NAME) {
        this.CATALOG_NAME = CATALOG_NAME;
    }

    public String getSCHEMA_NAME() {
        return SCHEMA_NAME;
    }

    public void setSCHEMA_NAME(String SCHEMA_NAME) {
        this.SCHEMA_NAME = SCHEMA_NAME;
    }

    public String getDEFAULT_CHARACTER_SET_NAME() {
        return DEFAULT_CHARACTER_SET_NAME;
    }

    public void setDEFAULT_CHARACTER_SET_NAME(String DEFAULT_CHARACTER_SET_NAME) {
        this.DEFAULT_CHARACTER_SET_NAME = DEFAULT_CHARACTER_SET_NAME;
    }

    public String getDEFAULT_COLLATION_NAME() {
        return DEFAULT_COLLATION_NAME;
    }

    public void setDEFAULT_COLLATION_NAME(String DEFAULT_COLLATION_NAME) {
        this.DEFAULT_COLLATION_NAME = DEFAULT_COLLATION_NAME;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }
    
    
    
    
}
