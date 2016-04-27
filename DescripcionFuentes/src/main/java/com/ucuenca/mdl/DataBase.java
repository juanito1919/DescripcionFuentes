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

    private String catalog_name;
    private String schema_name;
    private String Character_set;
    private String collation_name;
    private String issued;
    private ArrayList<Table> tables;

    public DataBase() {
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    
    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public String getSchema_name() {
        return schema_name;
    }

    public void setSchema_name(String schema_name) {
        this.schema_name = schema_name;
    }

    public String getCharacter_set() {
        return Character_set;
    }

    public void setCharacter_set(String Character_set) {
        this.Character_set = Character_set;
    }

    public String getCollation_name() {
        return collation_name;
    }

    public void setCollation_name(String collation_name) {
        this.collation_name = collation_name;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    
    
}
