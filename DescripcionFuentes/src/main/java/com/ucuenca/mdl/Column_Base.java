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

    private String character_set;
    private String ordinal_position;
    private String is_nullable;
    private String characther_maximum_length;
    private String column_type;
    private String column_key;

    public Column_Base() {
    }

    public String getCharacter_set() {
        return character_set;
    }

    public void setCharacter_set(String character_set) {
        this.character_set = character_set;
    }

    public String getOrdinal_position() {
        return ordinal_position;
    }

    public void setOrdinal_position(String ordinal_position) {
        this.ordinal_position = ordinal_position;
    }

    public String getIs_nullable() {
        return is_nullable;
    }

    public void setIs_nullable(String is_nullable) {
        this.is_nullable = is_nullable;
    }

    public String getCharacther_maximum_length() {
        return characther_maximum_length;
    }

    public void setCharacther_maximum_length(String characther_maximum_length) {
        this.characther_maximum_length = characther_maximum_length;
    }

    public String getColumn_type() {
        return column_type;
    }

    public void setColumn_type(String column_type) {
        this.column_type = column_type;
    }

    public String getColumn_key() {
        return column_key;
    }

    public void setColumn_key(String column_key) {
        this.column_key = column_key;
    }

    
}
