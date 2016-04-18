/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl.prueba;

import com.ucuenca.mdl.Column;
import java.util.ArrayList;

/**
 *
 * @author pablo Japa juan.japal@hotmail.com
 */
public class Table {

    private String TABLE_NAME;
    private String TABLE_TYPE;
    private String ENGINE;
    private String VERSION;
    private int TABLE_ROWS;
    private String DATA_LENGTH;
    private String MAX_DATA_LENGTH;
    private boolean AUTO_INCREMENT;
    private String TABLE_COMMENT;
    private ArrayList<Column> columnas;

    public Table(String TABLE_NAME, String TABLE_TYPE, String ENGINE, String VERSION, int TABLE_ROWS, String DATA_LENGTH, String MAX_DATA_LENGTH, boolean AUTO_INCREMENT, String TABLE_COMMENT, ArrayList<Column> columnas) {
        this.TABLE_NAME = TABLE_NAME;
        this.TABLE_TYPE = TABLE_TYPE;
        this.ENGINE = ENGINE;
        this.VERSION = VERSION;
        this.TABLE_ROWS = TABLE_ROWS;
        this.DATA_LENGTH = DATA_LENGTH;
        this.MAX_DATA_LENGTH = MAX_DATA_LENGTH;
        this.AUTO_INCREMENT = AUTO_INCREMENT;
        this.TABLE_COMMENT = TABLE_COMMENT;
        this.columnas = columnas;
    }

    /**
     * @return the TABLE_NAME
     */
    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    /**
     * @param TABLE_NAME the TABLE_NAME to set
     */
    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    /**
     * @return the TABLE_TYPE
     */
    public String getTABLE_TYPE() {
        return TABLE_TYPE;
    }

    /**
     * @param TABLE_TYPE the TABLE_TYPE to set
     */
    public void setTABLE_TYPE(String TABLE_TYPE) {
        this.TABLE_TYPE = TABLE_TYPE;
    }

    /**
     * @return the ENGINE
     */
    public String getENGINE() {
        return ENGINE;
    }

    /**
     * @param ENGINE the ENGINE to set
     */
    public void setENGINE(String ENGINE) {
        this.ENGINE = ENGINE;
    }

    /**
     * @return the VERSION
     */
    public String getVERSION() {
        return VERSION;
    }

    /**
     * @param VERSION the VERSION to set
     */
    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    /**
     * @return the TABLE_ROWS
     */
    public int getTABLE_ROWS() {
        return TABLE_ROWS;
    }

    /**
     * @param TABLE_ROWS the TABLE_ROWS to set
     */
    public void setTABLE_ROWS(int TABLE_ROWS) {
        this.TABLE_ROWS = TABLE_ROWS;
    }

    /**
     * @return the DATA_LENGTH
     */
    public String getDATA_LENGTH() {
        return DATA_LENGTH;
    }

    /**
     * @param DATA_LENGTH the DATA_LENGTH to set
     */
    public void setDATA_LENGTH(String DATA_LENGTH) {
        this.DATA_LENGTH = DATA_LENGTH;
    }

    /**
     * @return the MAX_DATA_LENGTH
     */
    public String getMAX_DATA_LENGTH() {
        return MAX_DATA_LENGTH;
    }

    /**
     * @param MAX_DATA_LENGTH the MAX_DATA_LENGTH to set
     */
    public void setMAX_DATA_LENGTH(String MAX_DATA_LENGTH) {
        this.MAX_DATA_LENGTH = MAX_DATA_LENGTH;
    }

    /**
     * @return the AUTO_INCREMENT
     */
    public boolean isAUTO_INCREMENT() {
        return AUTO_INCREMENT;
    }

    /**
     * @param AUTO_INCREMENT the AUTO_INCREMENT to set
     */
    public void setAUTO_INCREMENT(boolean AUTO_INCREMENT) {
        this.AUTO_INCREMENT = AUTO_INCREMENT;
    }

    /**
     * @return the TABLE_COMMENT
     */
    public String getTABLE_COMMENT() {
        return TABLE_COMMENT;
    }

    /**
     * @param TABLE_COMMENT the TABLE_COMMENT to set
     */
    public void setTABLE_COMMENT(String TABLE_COMMENT) {
        this.TABLE_COMMENT = TABLE_COMMENT;
    }

    /**
     * @return the columnas
     */
    public ArrayList<Column> getColumnas() {
        return columnas;
    }

    /**
     * @param columnas the columnas to set
     */
    public void setColumnas(ArrayList<Column> columnas) {
        this.columnas = columnas;
    }

}
