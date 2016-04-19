/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

import java.util.ArrayList;
import olderClass.Conexion;

/**
 *
 * @author adrian
 */
public class Catalog {
    
    private String title;
    private String description;
    private String issued;
    private String modified;
    private String language;
    private String temporal;
    private String spatial;
    private String license;
    private ArrayList<Conexion> datasets;

    public Catalog() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

    public String getSpatial() {
        return spatial;
    }

    public void setSpatial(String spatial) {
        this.spatial = spatial;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public ArrayList<Conexion> getDatasets() {
        return datasets;
    }

    public void setDatasets(ArrayList<Conexion> datasets) {
        this.datasets = datasets;
    }
     
    

    
}