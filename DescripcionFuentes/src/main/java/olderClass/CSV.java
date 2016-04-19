/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olderClass;


import java.util.ArrayList;

/**
 *
 * @author adrian
 */
public class CSV {
    
    private String delimiter;
    private String textQualifier;
    private String consecutiveDelimiterAsOne;
    private String nameOnFirstOne;
    private String firstDataLine;
    private String modifiedDate;
    private String title;
    
    private ArrayList<ColumnCsv> colsCsv;

    public CSV() {
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public ArrayList<ColumnCsv> getColsCsv() {
        return colsCsv;
    }

    public void setColsCsv(ArrayList<ColumnCsv> colsCsv) {
        this.colsCsv = colsCsv;
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

    public String getNameOnFirstOne() {
        return nameOnFirstOne;
    }

    public void setNameOnFirstOne(String nameOnFirstOne) {
        this.nameOnFirstOne = nameOnFirstOne;
    }

    public String getFirstDataLine() {
        return firstDataLine;
    }

    public void setFirstDataLine(String firstDataLine) {
        this.firstDataLine = firstDataLine;
    }
    
   
    
}
