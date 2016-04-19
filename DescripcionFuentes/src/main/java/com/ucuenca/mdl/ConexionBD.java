/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

//import gestores.DAOBaseDatos;

import com.ucuenca.dao.DAOBaseDatos;





/**
 *
 * @author adrian
 */
public class ConexionBD extends Conexion{
    
    private String name;
    private String host;
    private String port;
    private String username;
    private String password;
    private String schema;

    public ConexionBD() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
    
    
    public BaseDatos getModel(){
        
        DAOBaseDatos coxBD = new DAOBaseDatos(this.host,this.port,this.schema,this.username,this.password);
        BaseDatos dataset = coxBD.getDataSet();
        return dataset;
        
        
    }
    
    
    
}
