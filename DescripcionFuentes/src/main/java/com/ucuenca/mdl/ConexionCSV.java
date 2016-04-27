/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

import com.ucuenca.dao.BaseCSVDao;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author adrian
 */
public class ConexionCSV extends Conexion {

    private String accessURL;

    public ConexionCSV() {
    }

    public String getAccessURL() {
        return accessURL;
    }

    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }

    public Table getModel() throws IOException, FileNotFoundException, SAXException, TikaException{
        
        BaseCSVDao daoCsv = new BaseCSVDao();
        return daoCsv.getTable(this.accessURL);
        
    }
}
