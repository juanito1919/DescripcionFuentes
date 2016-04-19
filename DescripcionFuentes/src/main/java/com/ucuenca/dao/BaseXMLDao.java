/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import com.ucuenca.mdl.Column;
import com.ucuenca.mdl.Table;
import com.ucuenca.mdl.Table_Excel;
import com.ucuenca.mdl.Table_XML;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Pablo
 */
public class BaseXMLDao extends AbstractDao {

    private String path;

    public BaseXMLDao() {
    }

    public BaseXMLDao(String path) {
        this.path = path;
    }
    

    public Table getTable() throws MalformedURLException, JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        URL url = new URL(path);
        InputStream stream = url.openStream();
        Document document = null;
        try {
            document = builder.build(stream);
        } catch (JDOMException e) {

        }
        Table table = new Table_Excel();
        // Get Root Element and name
        Element root = document.getRootElement();
        String rootName = root.getName();

        // Get Second Level Elements, the rows of the data table
        List<Element> items = root.getChildren();

        // Get column names, using the first element
        List<Element> firstItem = items.get(0).getChildren();
        List<Column> columns = new ArrayList<Column>();
        for (Element col : firstItem) {
            Column column = new Column();
            column.setCOLUMN_NAME(col.getName());
            column.setDATA_TYPE(formatColumn(""));//pendiente
            columns.add(column);
        }
//         Get data and identify type data
//        for (Element item : items) {
//            ArrayList<String> row = new ArrayList<String>();
//            for (Element col : item.getChildren()) {
//                row.add(col.getText());
//            }
//          
//        }
        return table;
    }
}
