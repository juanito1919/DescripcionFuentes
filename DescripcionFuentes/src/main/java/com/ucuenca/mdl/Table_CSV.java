/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

import olderClass.Column;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Table_CSV extends Table {

    private String delimiter;//Separador de cada atributo
    private String textQualifier;
    private String consecutiveDelimiterAsOne;
    private String nameOnFirstRow;
    private String firstDataLine;

    public Table_CSV() {
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getTextQualifier() {
        return textQualifier;
    }

    public void setTextQualifier(String textQualifier) {
        this.textQualifier = textQualifier;
    }

    public String getConsecutiveDelimiterAsOne() {
        return consecutiveDelimiterAsOne;
    }

    public void setConsecutiveDelimiterAsOne(String consecutiveDelimiterAsOne) {
        this.consecutiveDelimiterAsOne = consecutiveDelimiterAsOne;
    }

    public String getNameOnFirstRow() {
        return nameOnFirstRow;
    }

    public void setNameOnFirstRow(String nameOnFirstRow) {
        this.nameOnFirstRow = nameOnFirstRow;
    }

    public String getFirstDataLine() {
        return firstDataLine;
    }

    public void setFirstDataLine(String firstDataLine) {
        this.firstDataLine = firstDataLine;
    }

   
    
    
}
