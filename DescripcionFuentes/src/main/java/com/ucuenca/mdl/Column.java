/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

/**
 *
 * @author pablo
 */
public class Column {

    private String title;
    private String recommendedDataType; 
    private String storageFormat;
    private String recommendedDisplayDataFormat;
    private String decimalPositions;
    private String recordNumber;
    
    public Column() {
    }

    public String getRecommendedDataType() {
        return recommendedDataType;
    }

    public void setRecommendedDataType(String recommendedDataType) {
        this.recommendedDataType = recommendedDataType;
    }

    public String getStorageFormat() {
        return storageFormat;
    }

    public void setStorageFormat(String storageFormat) {
        this.storageFormat = storageFormat;
    }

    public String getRecommendedDisplayDataFormat() {
        return recommendedDisplayDataFormat;
    }

    public void setRecommendedDisplayDataFormat(String recommendedDisplayDataFormat) {
        this.recommendedDisplayDataFormat = recommendedDisplayDataFormat;
    }

    public String getDecimalPositions() {
        return decimalPositions;
    }

    public void setDecimalPositions(String decimalPositions) {
        this.decimalPositions = decimalPositions;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    

}
