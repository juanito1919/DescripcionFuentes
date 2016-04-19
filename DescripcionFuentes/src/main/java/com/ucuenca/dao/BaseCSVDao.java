/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import com.csvreader.CsvReader;
import com.ucuenca.mdl.Column_CSV;
import com.ucuenca.mdl.Table_CSV;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

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
    public int numCols(String url, int column) {
        int cont = 0;
        try {
            CsvReader reader = new CsvReader(url);
            reader.readHeaders();
            while (reader.readRecord()) {
                if (!reader.get(column).isEmpty()) {
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
    public Table_CSV getTable(String url) {
        try {
            File file = new File(url);
            Parser parser = new AutoDetectParser();
            long start = System.currentTimeMillis();
            BodyContentHandler handler = new BodyContentHandler(10000000);
            Metadata metadata = new Metadata();
            InputStream content = BaseCSVDao.class.getResourceAsStream(url);
            parser.parse(content, handler, metadata, new ParseContext());
            for (String name : metadata.names()) {
                System.out.println(name + ":\t" + metadata.get(name));
            }
            String fechaModificacion = "" + file.lastModified();
            String title = file.getName();
            CsvReader reader = new CsvReader(url);
            Table_CSV table = new Table_CSV();
            table.setDELIMITER(table.getDELIMITER());
            table.setTEXTQUALIFER("" + reader.getTextQualifier());
            table.setFIRST_DATE_LINE("2");
            table.setNAME_ON_FIRST_ONE("true");
            table.setTABLE_NAME(title);
            table.setMAX_DATA_LENGTH(fechaModificacion);
            reader.readHeaders();
            //line for read header
            int numColumns = reader.getHeaderCount();
            String[] cols = reader.getHeaders();
            ArrayList<Column_CSV> columns = new ArrayList();
            for (int i = 0; i < numColumns; i++) {
                Column_CSV column = new Column_CSV();
                column.setCOLUMN_NAME(cols[i]);
                column.setFORMAT(formatColumn(valueColumn(url, i)));
                column.setPOSITION("" + i);
                //column.set("" + numRecord(url, i));
                columns.add(column);
            }
            return table;
        } catch (Exception ex) {

            return null;
        }
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
}
