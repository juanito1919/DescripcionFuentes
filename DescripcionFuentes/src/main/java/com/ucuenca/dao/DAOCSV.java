/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;


import com.csvreader.CsvReader;
import com.ucuenca.mdl.CSV;
import com.ucuenca.mdl.ColumnCsv;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Adrian Anguisaca
 */
public class DAOCSV {

    static DAOCSV instance = null;
    Connection conexion = null;

    public static DAOCSV getInstance() {
        if (instance == null) {
            instance = new DAOCSV();
        }
        return instance;
    }

    public DAOCSV() {
    }

    public int numRecord(String url, int column) throws FileNotFoundException, IOException {
        CsvReader reader = new CsvReader(url);
        reader.readHeaders();
        int cont = 0;
        while (reader.readRecord()) {
            if (!reader.get(column).isEmpty()) {
                cont = cont + 1;
            }
        }
        return cont;
    }

    public String formato(String aux) {
        
        
        try {
            
            Integer.parseInt(aux);
            return "Integer";
        } catch (NumberFormatException nfe) {

            try {
                Double.parseDouble(aux);
                return "Decimal";
            } catch (NumberFormatException nfe1) {
               
                    
                    return  "String";
        } 
        }

    }
    
    public String valorColumna(String url, int col) throws FileNotFoundException, IOException
    {
        CsvReader reader  = new CsvReader(url);
        int cont=0;
        while(reader.readRecord() ){
            
            if(reader.get(col)!=null && !reader.get(col).isEmpty() && cont > 0)
            {
                System.out.println("asdasdsad"+reader.get(col));
                return reader.get(col);
            }
            cont = cont +1;
            
        }
        return "";
    }

    public CSV getTablas(String url) throws FileNotFoundException, IOException, SAXException, TikaException {
        File file = new File(url);
         Parser parser = new AutoDetectParser();
             long start = System.currentTimeMillis();
            BodyContentHandler handler = new BodyContentHandler(10000000);
            Metadata metadata = new Metadata();
            InputStream content = DAOCSV.class
                        .getResourceAsStream(url);
            parser.parse(content, handler, metadata, new ParseContext());
            for (String name : metadata.names()) {
                  System.out.println(name + ":\t" + metadata.get(name));
            }
        
        String fechaModificacion = ""+file.lastModified();
        String title = file.getName();
        System.out.println("por aquiiii 1");
        CsvReader reader = new CsvReader(url);
        CSV csv = new CSV();
        csv.setDelimiter(csv.getDelimiter());
        csv.setTextQualifier("" + reader.getTextQualifier());
        csv.setFirstDataLine("2");
        csv.setNameOnFirstOne("true");
        csv.setTitle(title);
        csv.setModifiedDate(fechaModificacion);
        reader.readHeaders();
        System.out.println("AAA"+reader.getHeaderCount());
        String [] values = reader.getValues();
        for (String value : values) {
            System.out.println("aaa"+value);
        }
        
        
        //reader.getHeaders();
        int numColumns = reader.getHeaderCount();
        System.out.println("por aquiiii 2  "+numColumns);
        String[] columns = reader.getHeaders();
        System.out.println("por aquiiii 3  "+columns.length);
        
        ArrayList<ColumnCsv> colCSV = new ArrayList();
        for (int i = 0; i < numColumns; i++) {
            ColumnCsv columncsv = new ColumnCsv();
            columncsv.setNombre(columns[i]);
            columncsv.setFormato(formato(valorColumna(url, i)));
            columncsv.setPosicion(""+i);
            columncsv.setRecordNumber(""+numRecord(url, i));
            colCSV.add(columncsv);
            System.out.println("11122222222333333333444444445555");
        }
        
        csv.setColsCsv(colCSV);
        return csv;
    }

}
//version presentacion Lunes