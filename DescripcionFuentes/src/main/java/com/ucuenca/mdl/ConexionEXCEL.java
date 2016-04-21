/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

import com.ucuenca.dao.BaseExcelDao;

/**
 *
 * @author Pablo
 */
public class ConexionEXCEL extends Conexion{
   private String accessURL;
   private String path;

    public ConexionEXCEL() {
    }

    /**
     * @return the accessURL
     */
    public String getAccessURL() {
        return accessURL;
    }

    /**
     * @param accessURL the accessURL to set
     */
    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }
     public DataBase getModel(){
        BaseExcelDao coxBD = new BaseExcelDao(this.path);
        DataBase dataset = coxBD.getWorkBook();
        return dataset;
        
        
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
}
