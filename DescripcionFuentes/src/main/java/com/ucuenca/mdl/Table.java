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
public class Table {
    private String TABLE_NAME;
    private String TABLE_TYPE;
    private String ENGINE;
    private String VERSION;
    private String ROW_FORMAT;
    private String TABLE_ROWS;
    private String AVG_ROW_LENGTH;
    private String DATA_LENGTH;
    private String MAX_DATA_LENGTH;
    private String AUTO_INCREMENT;
    private String CREATE_TIME;
    private String UPDATE_TIME;
    private String CHECK_TIME;
    private String TABLE_COLLATION;
    private String CHECKSUM;
    private String TABLE_COMMENT;
    private ArrayList<Column> columnas;

    public Table() {
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public String getTABLE_TYPE() {
        return TABLE_TYPE;
    }

    public void setTABLE_TYPE(String TABLE_TYPE) {
        this.TABLE_TYPE = TABLE_TYPE;
    }

    public String getENGINE() {
        return ENGINE;
    }

    public void setENGINE(String ENGINE) {
        this.ENGINE = ENGINE;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public String getROW_FORMAT() {
        return ROW_FORMAT;
    }

    public void setROW_FORMAT(String ROW_FORMAT) {
        this.ROW_FORMAT = ROW_FORMAT;
    }

    public String getTABLE_ROWS() {
        return TABLE_ROWS;
    }

    public void setTABLE_ROWS(String TABLE_ROWS) {
        this.TABLE_ROWS = TABLE_ROWS;
    }

    public String getAVG_ROW_LENGTH() {
        return AVG_ROW_LENGTH;
    }

    public void setAVG_ROW_LENGTH(String AVG_ROW_LENGTH) {
        this.AVG_ROW_LENGTH = AVG_ROW_LENGTH;
    }

    public String getDATA_LENGTH() {
        return DATA_LENGTH;
    }

    public void setDATA_LENGTH(String DATA_LENGTH) {
        this.DATA_LENGTH = DATA_LENGTH;
    }

    public String getMAX_DATA_LENGTH() {
        return MAX_DATA_LENGTH;
    }

    public void setMAX_DATA_LENGTH(String MAX_DATA_LENGTH) {
        this.MAX_DATA_LENGTH = MAX_DATA_LENGTH;
    }

    public String getAUTO_INCREMENT() {
        return AUTO_INCREMENT;
    }

    public void setAUTO_INCREMENT(String AUTO_INCREMENT) {
        this.AUTO_INCREMENT = AUTO_INCREMENT;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(String UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getCHECK_TIME() {
        return CHECK_TIME;
    }

    public void setCHECK_TIME(String CHECK_TIME) {
        this.CHECK_TIME = CHECK_TIME;
    }

    public String getTABLE_COLLATION() {
        return TABLE_COLLATION;
    }

    public void setTABLE_COLLATION(String TABLE_COLLATION) {
        this.TABLE_COLLATION = TABLE_COLLATION;
    }

    public String getCHECKSUM() {
        return CHECKSUM;
    }

    public void setCHECKSUM(String CHECKSUM) {
        this.CHECKSUM = CHECKSUM;
    }

    public String getTABLE_COMMENT() {
        return TABLE_COMMENT;
    }

    public void setTABLE_COMMENT(String TABLE_COMMENT) {
        this.TABLE_COMMENT = TABLE_COMMENT;
    }

    public ArrayList<Column> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<Column> columnas) {
        this.columnas = columnas;
    }
    
    
    
    
    
    
    
    
    
    
    
}
