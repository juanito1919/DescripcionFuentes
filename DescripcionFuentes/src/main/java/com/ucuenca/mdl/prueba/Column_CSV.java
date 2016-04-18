/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl.prueba;

/**
 *
 * @author pablo
 */
public class Column_CSV extends Column {

    private String FORMAT;
    private String POSITION;

    public Column_CSV(String COLUMN_NAME, String COLUMN_DEFAULT, boolean IS_NULLABLE, String DATA_TYPE, String CHARACTER_MAXIMUM_LENGTH, boolean COLUMN_KEY, String COLUMN_COMMENT) {
        super(COLUMN_NAME, COLUMN_DEFAULT, IS_NULLABLE, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, COLUMN_KEY, COLUMN_COMMENT);
    }

    /**
     * @return the FORMAT
     */
    public String getFORMAT() {
        return FORMAT;
    }

    /**
     * @param FORMAT the FORMAT to set
     */
    public void setFORMAT(String FORMAT) {
        this.FORMAT = FORMAT;
    }

    /**
     * @return the POSITION
     */
    public String getPOSITION() {
        return POSITION;
    }

    /**
     * @param POSITION the POSITION to set
     */
    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION;
    }

}
