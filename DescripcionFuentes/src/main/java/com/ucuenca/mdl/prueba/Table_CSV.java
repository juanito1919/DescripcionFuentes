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
 * @author pablo
 */
public class Table_CSV extends Table {

    private String DELIMITER;
    private String TEXTQUALIFER;
    private String CONSECUTIVE_DE_DELIMITER_AS_ONE;
    private String NAME_ON_FIRST_ONE;
    private String FIRST_DATE_LINE;

    public Table_CSV(String TABLE_NAME, String TABLE_TYPE, String ENGINE, String VERSION, int TABLE_ROWS, String DATA_LENGTH, String MAX_DATA_LENGTH, boolean AUTO_INCREMENT, String TABLE_COMMENT, ArrayList<Column> columnas) {
        super(TABLE_NAME, TABLE_TYPE, ENGINE, VERSION, TABLE_ROWS, DATA_LENGTH, MAX_DATA_LENGTH, AUTO_INCREMENT, TABLE_COMMENT, columnas);
    }

    /**
     * @return the DELIMITER
     */
    public String getDELIMITER() {
        return DELIMITER;
    }

    /**
     * @param DELIMITER the DELIMITER to set
     */
    public void setDELIMITER(String DELIMITER) {
        this.DELIMITER = DELIMITER;
    }

    /**
     * @return the TEXTQUALIFER
     */
    public String getTEXTQUALIFER() {
        return TEXTQUALIFER;
    }

    /**
     * @param TEXTQUALIFER the TEXTQUALIFER to set
     */
    public void setTEXTQUALIFER(String TEXTQUALIFER) {
        this.TEXTQUALIFER = TEXTQUALIFER;
    }

    /**
     * @return the CONSECUTIVE_DE_DELIMITER_AS_ONE
     */
    public String getCONSECUTIVE_DE_DELIMITER_AS_ONE() {
        return CONSECUTIVE_DE_DELIMITER_AS_ONE;
    }

    /**
     * @param CONSECUTIVE_DE_DELIMITER_AS_ONE the CONSECUTIVE_DE_DELIMITER_AS_ONE to set
     */
    public void setCONSECUTIVE_DE_DELIMITER_AS_ONE(String CONSECUTIVE_DE_DELIMITER_AS_ONE) {
        this.CONSECUTIVE_DE_DELIMITER_AS_ONE = CONSECUTIVE_DE_DELIMITER_AS_ONE;
    }

    /**
     * @return the NAME_ON_FIRST_ONE
     */
    public String getNAME_ON_FIRST_ONE() {
        return NAME_ON_FIRST_ONE;
    }

    /**
     * @param NAME_ON_FIRST_ONE the NAME_ON_FIRST_ONE to set
     */
    public void setNAME_ON_FIRST_ONE(String NAME_ON_FIRST_ONE) {
        this.NAME_ON_FIRST_ONE = NAME_ON_FIRST_ONE;
    }

    /**
     * @return the FIRST_DATE_LINE
     */
    public String getFIRST_DATE_LINE() {
        return FIRST_DATE_LINE;
    }

    /**
     * @param FIRST_DATE_LINE the FIRST_DATE_LINE to set
     */
    public void setFIRST_DATE_LINE(String FIRST_DATE_LINE) {
        this.FIRST_DATE_LINE = FIRST_DATE_LINE;
    }

    
    
    
    
    
}
