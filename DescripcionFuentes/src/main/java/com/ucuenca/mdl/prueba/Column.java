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
public class Column {

    private String COLUMN_NAME;
    private String COLUMN_DEFAULT;
    private boolean IS_NULLABLE;
    private String DATA_TYPE;
    private String CHARACTER_MAXIMUM_LENGTH;
    private boolean COLUMN_KEY;
    private String COLUMN_COMMENT;

    public Column(String COLUMN_NAME, String COLUMN_DEFAULT, boolean IS_NULLABLE, String DATA_TYPE, String CHARACTER_MAXIMUM_LENGTH, boolean COLUMN_KEY, String COLUMN_COMMENT) {
        this.COLUMN_NAME = COLUMN_NAME;
        this.COLUMN_DEFAULT = COLUMN_DEFAULT;
        this.IS_NULLABLE = IS_NULLABLE;
        this.DATA_TYPE = DATA_TYPE;
        this.CHARACTER_MAXIMUM_LENGTH = CHARACTER_MAXIMUM_LENGTH;
        this.COLUMN_KEY = COLUMN_KEY;
        this.COLUMN_COMMENT = COLUMN_COMMENT;
    }

    /**
     * @return the COLUMN_NAME
     */
    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }

    /**
     * @param COLUMN_NAME the COLUMN_NAME to set
     */
    public void setCOLUMN_NAME(String COLUMN_NAME) {
        this.COLUMN_NAME = COLUMN_NAME;
    }

    /**
     * @return the COLUMN_DEFAULT
     */
    public String getCOLUMN_DEFAULT() {
        return COLUMN_DEFAULT;
    }

    /**
     * @param COLUMN_DEFAULT the COLUMN_DEFAULT to set
     */
    public void setCOLUMN_DEFAULT(String COLUMN_DEFAULT) {
        this.COLUMN_DEFAULT = COLUMN_DEFAULT;
    }

    /**
     * @return the IS_NULLABLE
     */
    public boolean isIS_NULLABLE() {
        return IS_NULLABLE;
    }

    /**
     * @param IS_NULLABLE the IS_NULLABLE to set
     */
    public void setIS_NULLABLE(boolean IS_NULLABLE) {
        this.IS_NULLABLE = IS_NULLABLE;
    }

    /**
     * @return the DATA_TYPE
     */
    public String getDATA_TYPE() {
        return DATA_TYPE;
    }

    /**
     * @param DATA_TYPE the DATA_TYPE to set
     */
    public void setDATA_TYPE(String DATA_TYPE) {
        this.DATA_TYPE = DATA_TYPE;
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
     * @return the COLUMN_KEY
     */
    public boolean isCOLUMN_KEY() {
        return COLUMN_KEY;
    }

    /**
     * @param COLUMN_KEY the COLUMN_KEY to set
     */
    public void setCOLUMN_KEY(boolean COLUMN_KEY) {
        this.COLUMN_KEY = COLUMN_KEY;
    }

    /**
     * @return the COLUMN_COMMENT
     */
    public String getCOLUMN_COMMENT() {
        return COLUMN_COMMENT;
    }

    /**
     * @param COLUMN_COMMENT the COLUMN_COMMENT to set
     */
    public void setCOLUMN_COMMENT(String COLUMN_COMMENT) {
        this.COLUMN_COMMENT = COLUMN_COMMENT;
    }
    
}
