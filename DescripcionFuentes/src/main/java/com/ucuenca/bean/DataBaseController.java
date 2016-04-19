/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.bean;

import com.ucuenca.dao.BaseCSVDao;
import com.ucuenca.dao.BaseDatosDao;
import com.ucuenca.dao.BaseExcelDao;
import com.ucuenca.dao.BaseXMLDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author juan pablo juan.japal@hotmail.com
 */
@ManagedBean(name = "dataBaseController")
@ViewScoped
public class DataBaseController extends AbstractMB implements Serializable {

    private BaseDatosDao baseDatosDao;
    private BaseExcelDao baseExcelDao;
    private BaseCSVDao baseCSVDao;
    private BaseXMLDao baseXMLDao;

    private String type_DataBase;
    private String url;
    private String path;
    private String port;
    private String user;
    private String password;

    public void addDataBase() {
        if (getType_DataBase().equalsIgnoreCase("DATABASE")) {
            getBaseDatosDao();
        }
        if (getType_DataBase().equalsIgnoreCase("CSV")) {

        }
        if (getType_DataBase().equalsIgnoreCase("EXCEL")) {

        }
        if (getType_DataBase().equalsIgnoreCase("XML")) {

        }
    }

    public void createOntology() {

    }

    /**
     * @return the type_DataBase
     */
    public String getType_DataBase() {
        return type_DataBase;
    }

    /**
     * @param type_DataBase the type_DataBase to set
     */
    public void setType_DataBase(String type_DataBase) {
        this.type_DataBase = type_DataBase;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the BaseDatosDao
     */
    public BaseDatosDao getBaseDatosDao() {
        if (baseCSVDao == null) {
            baseCSVDao = new BaseCSVDao();
        }
        return baseDatosDao;
    }

    /**
     * @return the BaseExcelDao
     */
    public BaseExcelDao getBaseExcelDao() {
        if (baseExcelDao == null) {
            baseExcelDao = new BaseExcelDao();
        }
        return baseExcelDao;
    }

    /**
     * @return the BaseCSVDao
     */
    public BaseCSVDao getBaseCSVDao() {
        if (baseCSVDao == null) {
            baseCSVDao = new BaseCSVDao();
        }
        return baseCSVDao;
    }

    /**
     * @return the BaseXMLDao
     */
    public BaseXMLDao getBaseXMLDao() {
        if (baseXMLDao == null) {
            baseXMLDao = new BaseXMLDao();
        }
        return baseXMLDao;
    }
}
