/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import com.hp.hpl.jena.graph.query.Query;
import com.hp.hpl.jena.vocabulary.ResultSet;

/**
 *
 * @author Pablo
 */
public class ConsultaDao {

    private String pathOntology;
    private String sql;

    public ConsultaDao(String pathOntology, String sql) {
        this.pathOntology = pathOntology;
        this.sql = sql;
    }

    public void gnenerarConsulta() {
        String sparqlService = "http://sparql.bioontology.org/sparql";
        String apikey = "YOUR API KEY HERE";
       // SimpleTest test = new SimpleTest(sparqlService, apikey);
      //  String response = test.executeQuery(query,"text/tab-separated-values");
		//System.out.println(response);

    }
}
