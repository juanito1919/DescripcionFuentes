/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olderClass;

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

//    public CSV getModel() throws IOException, FileNotFoundException, SAXException, TikaException{
//        
////        DAOCSV daoCsv = new DAOCSV();
////        return daoCsv.getTablas(this.accessURL);
//        
//    }
}