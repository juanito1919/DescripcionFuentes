/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;

/**
 *
 * @author adrian
 */
public class Conexion {
    
    private String description;
    private String keyword;
    private String language;
    private String name;
    
    public Conexion() {
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String tipoConexion(){
        String tipoConexion = "";
        if(this instanceof ConexionBD){
            tipoConexion = "BD";
        }
        
        if(this instanceof ConexionCSV){
            tipoConexion = "CSV";
        }
        
        return tipoConexion;
        
    }
    
    
    
    
    
}
