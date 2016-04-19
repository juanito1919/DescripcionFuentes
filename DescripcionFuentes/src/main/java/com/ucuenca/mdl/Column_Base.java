/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

/**
 *
 * @author Pablo
 */
public class Column_Base extends Column {

    private String CHARACTER_MAXIMUM_LENGTH;
    private String CHARACTER_OCTET_LENGTH;
    private String NUMERIC_PRECISION;
    private String NUMERIC_SCALE;
    private String CHARACTER_SET_NAME;
    private String COLLATION_NAME;
    private String COLUMN_KEY;
    private String EXTRA;

    public Column_Base() {
    }

    /**
     * @return the CHARACTER_MAXIMUM_LENGTH
     */
    public String getCHARACTER_MAXIMUM_LENGTH() {
        return CHARACTER_MAXIMUM_LENGTH;
    }

    /**
     * @param CHARACTER_MAXIMUM_LENGTH the CHARACTER_MAXIMUM_LENGTH to set
     */
    public void setCHARACTER_MAXIMUM_LENGTH(String CHARACTER_MAXIMUM_LENGTH) {
        this.CHARACTER_MAXIMUM_LENGTH = CHARACTER_MAXIMUM_LENGTH;
    }

    /**
     * @return the CHARACTER_OCTET_LENGTH
     */
    public String getCHARACTER_OCTET_LENGTH() {
        return CHARACTER_OCTET_LENGTH;
    }

    /**
     * @param CHARACTER_OCTET_LENGTH the CHARACTER_OCTET_LENGTH to set
     */
    public void setCHARACTER_OCTET_LENGTH(String CHARACTER_OCTET_LENGTH) {
        this.CHARACTER_OCTET_LENGTH = CHARACTER_OCTET_LENGTH;
    }

    /**
     * @return the NUMERIC_PRECISION
     */
    public String getNUMERIC_PRECISION() {
        return NUMERIC_PRECISION;
    }

    /**
     * @param NUMERIC_PRECISION the NUMERIC_PRECISION to set
     */
    public void setNUMERIC_PRECISION(String NUMERIC_PRECISION) {
        this.NUMERIC_PRECISION = NUMERIC_PRECISION;
    }

    /**
     * @return the NUMERIC_SCALE
     */
    public String getNUMERIC_SCALE() {
        return NUMERIC_SCALE;
    }

    /**
     * @param NUMERIC_SCALE the NUMERIC_SCALE to set
     */
    public void setNUMERIC_SCALE(String NUMERIC_SCALE) {
        this.NUMERIC_SCALE = NUMERIC_SCALE;
    }

    /**
     * @return the CHARACTER_SET_NAME
     */
    public String getCHARACTER_SET_NAME() {
        return CHARACTER_SET_NAME;
    }

    /**
     * @param CHARACTER_SET_NAME the CHARACTER_SET_NAME to set
     */
    public void setCHARACTER_SET_NAME(String CHARACTER_SET_NAME) {
        this.CHARACTER_SET_NAME = CHARACTER_SET_NAME;
    }

    /**
     * @return the COLLATION_NAME
     */
    public String getCOLLATION_NAME() {
        return COLLATION_NAME;
    }

    /**
     * @param COLLATION_NAME the COLLATION_NAME to set
     */
    public void setCOLLATION_NAME(String COLLATION_NAME) {
        this.COLLATION_NAME = COLLATION_NAME;
    }

    /**
     * @return the COLUMN_KEY
     */
    public String getCOLUMN_KEY() {
        return COLUMN_KEY;
    }

    /**
     * @param COLUMN_KEY the COLUMN_KEY to set
     */
    public void setCOLUMN_KEY(String COLUMN_KEY) {
        this.COLUMN_KEY = COLUMN_KEY;
    }

    /**
     * @return the EXTRA
     */
    public String getEXTRA() {
        return EXTRA;
    }

    /**
     * @param EXTRA the EXTRA to set
     */
    public void setEXTRA(String EXTRA) {
        this.EXTRA = EXTRA;
    }

}
