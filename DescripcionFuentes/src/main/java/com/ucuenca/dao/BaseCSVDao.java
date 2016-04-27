/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import com.csvreader.CsvReader;
import com.ucuenca.mdl.Column;
import com.ucuenca.mdl.Column_CSV;
import com.ucuenca.mdl.Table_CSV;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Pablo
 */
public class BaseCSVDao extends AbstractDao {

    /**
     * This method gets number cols of file csv
     *
     * @param url
     * @Author pablo and adrain
     */
    public int getRecordNumber(String url, int column) {
        int cont = 0;
        try {
            CsvReader reader = new CsvReader(url);
            reader.readHeaders();
            while (reader.readRecord()) {
                if (reader.get(column)!=null && !reader.get(column).isEmpty()) {
                    cont = cont + 1;
                }
            }
        } catch (Exception ex) {

        }
        return cont;
    }

    /**
     * This method gets table
     *
     * @param url
     * @Author pablo and adrain
     */
    public Table_CSV getTable(String url)  {
        System.out.println("urllllllll "+url);

        try {
            File file = new File(url);
            String title = file.getName();
            Path p = Paths.get(url);
            BasicFileAttributes view = Files.getFileAttributeView(p, BasicFileAttributeView.class)
                    .readAttributes();
            String issued = view.creationTime().toString();
            String modified = view.lastModifiedTime().toString();
            String bytesize = String.valueOf(file.length());

            
           BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File(url));
      ParseContext pcontext = new ParseContext();
            Parser parser = new AutoDetectParser();
            parser.parse(inputstream, handler, metadata,pcontext);
            for (String name : metadata.names()) {
                System.out.println(name + ":\t" + metadata.get(name));
            }
            String characterSet = metadata.get("Content-Type");
            String defaultDecimalSeparator = getDecimalSeparatorCSV();
            String defaultLanguage = metadata.get("Content-Language");
            String defaultLocale = metadata.get("Content-Language");

            CsvReader reader = new CsvReader(url);
            String delimiter = ""+reader.getDelimiter();
            String textQualifier = ""+reader.getTextQualifier();
            String firstDataLine = "2"; //Consultar con el director
            String name_on_first_row = "true";//Consultar con el director
            String overrallRecordCount = getCountRecords(url);

            Table_CSV table = new Table_CSV();
            table.setTitle(title);
            table.setIssued(issued);
            table.setModified(modified);
            table.setMediaType("application/csv");
            table.setFormat("application/csv");
            table.setByteSize(bytesize);
            table.setCharacterSet(characterSet);
            table.setDefaultDecimalSeparator(defaultDecimalSeparator);
            table.setDefaultLanguage(defaultLanguage);
            table.setDefaultLocale(defaultLocale);
            table.setOverrallRecordCount(overrallRecordCount);
            table.setDelimiter(delimiter);
            table.setTextQualifier(textQualifier);
            table.setFirstDataLine(firstDataLine);
            table.setNameOnFirstRow(name_on_first_row);
            
            reader.readHeaders();
            int numColumns = reader.getHeaderCount();
            String[] cols = reader.getHeaders();
            ArrayList<Column> columns = new ArrayList();
            for (int i = 0; i < numColumns; i++) {
                Column_CSV column = new Column_CSV();
                column.setTitle(cols[i]);
                column.setStorageFormat(formatColumn(valueColumn(url, i)));
                column.setColumnPosition("" + i);
                column.setRecordNumber("" + getRecordNumber(url, i));
                columns.add(column);
            }
            table.setColumnas(columns);
            return table;
        } catch (IOException ex) {
            
            Logger.getLogger(BaseCSVDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (TikaException ex) {
            Logger.getLogger(BaseCSVDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SAXException ex) {
            Logger.getLogger(BaseCSVDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    }

    public String getDecimalSeparatorCSV() {
        return "";
    }

    public String valueColumn(String url, int col) {
        try {
            CsvReader reader = new CsvReader(url);
            int cont = 0;
            while (reader.readRecord()) {
                if (reader.get(col) != null && !reader.get(col).isEmpty() && cont > 0) {
                    return reader.get(col);
                }
                cont = cont + 1;
            }
            return "";
        } catch (Exception ex) {

        }
        return "";
    }

    public String getCountRecords(String url) throws FileNotFoundException, IOException {

        CsvReader reader = new CsvReader(url);
        reader.readHeaders();
        int cont = 0;
        while (reader.readRecord()) {
             cont = cont+1;
        }

        reader.close();
        return String.valueOf(cont);
    }
    
     public String formatColumn(String aux) {
        try {
            Integer.parseInt(aux);
            return "Integer";
        } catch (NumberFormatException nfe) {
            try {
                Double.parseDouble(aux);
                return "Decimal";
            } catch (NumberFormatException nfe1) {
                return "String";
            }
        }
    }
}
