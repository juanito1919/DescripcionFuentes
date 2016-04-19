/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import java.sql.Connection;

/**
 *
 * @author Pablo
 */
public abstract class AbstractDao {

    private Connection conexion = null;

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
