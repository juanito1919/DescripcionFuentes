/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.dao;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import olderClass.BaseDatos;
import olderClass.CSV;
import olderClass.Catalog;
import olderClass.Column;
import olderClass.ColumnCsv;
import com.ucuenca.mdl.Conexion;
import com.ucuenca.mdl.ConexionBD;
import com.ucuenca.mdl.ConexionCSV;
import olderClass.Table;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author adrian
 */
public class GestorOntologia {

//    private String filename="";
//    private OntModel model;
//    public GestorOntologia() {
//        filename = "/home/adrian/Documentos/TESIS/experimento1_v2.owl";
//      // Create an empty model
//	model = ModelFactory.createOntologyModel();
//	
//	// Use the FileManager to find the input file
//	InputStream in = FileManager.get().open(filename);
//
//	if (in == null)
//		throw new IllegalArgumentException("File: "+filename+" not found");
//
//	// Read the RDF/XML file
//	model.read(in, null);
//        
//        
//        
//        
//    }
//    
//    public void generarOntologia(Catalog catalogo) throws IOException, FileNotFoundException, SAXException, TikaException
//    {
//       String URI = model.getNsPrefixURI("");
//       OntClass ontCatalogo= model.getOntClass(URI+"Catalog");
//       Individual indCatalog = model.createIndividual( URI + catalogo.getTitle(), ontCatalogo );
//       DatatypeProperty propertyCatalogo = model.getDatatypeProperty(URI+"title");
//       indCatalog.addProperty(propertyCatalogo, catalogo.getTitle());
//       DatatypeProperty propertyCatalogo1 = model.getDatatypeProperty(URI+"description");
//       indCatalog.addProperty(propertyCatalogo1, catalogo.getDescription());
//       DatatypeProperty propertyCatalogo2 = model.getDatatypeProperty(URI+"Catalog_issued");
//       indCatalog.addProperty(propertyCatalogo2, catalogo.getIssued());
//       DatatypeProperty propertyCatalogo3 = model.getDatatypeProperty(URI+"language");
//       indCatalog.addProperty(propertyCatalogo3, catalogo.getLanguage());
//       DatatypeProperty propertyCatalogo4 = model.getDatatypeProperty(URI+"licence");
//       indCatalog.addProperty(propertyCatalogo4, catalogo.getLicense());
//       
//        for (Conexion con : catalogo.getDatasets()) {
//            
//            if(con instanceof ConexionBD){
//                ConexionBD conAux = (ConexionBD)con;
//                generarOntologiaBD(conAux);
//            }
//            
//            if(con instanceof ConexionCSV){
//                ConexionCSV conAux = (ConexionCSV)con;
//                generarOntologiaCSV(conAux);
//            }
//            
//            
//            
//            
//        }
//       
//       
//       guardarOntologia();
//       
//       
//        
//        
//        
//    }
//    
//    
// 
//    public void generarOntologiaBD(ConexionBD con)
//    {
//        BaseDatos dataset = con.getModel();
//       String URI = model.getNsPrefixURI("");
//       OntClass ontDataset= model.getOntClass(URI+"Dataset");
//       Individual indDataset = model.createIndividual( URI + dataset.getSCHEMA_NAME(), ontDataset );
//       DatatypeProperty propertyDataset = model.getDatatypeProperty(URI+"dataset_title");
//       indDataset.addProperty(propertyDataset, dataset.getSCHEMA_NAME());
//       
//        for (Table table : dataset.getTables()) {
//            //Creacion de Entidad Table
//            OntClass ontTable= model.getOntClass(URI+"Table");
//            Individual indTable = model.createIndividual( URI + table.getTABLE_NAME(), ontTable );
//            DatatypeProperty propertyTableTitle = model.getDatatypeProperty(URI+"title_distribution");
//            indTable.addProperty(propertyTableTitle, table.getTABLE_NAME());
//            DatatypeProperty propertyTableDesc = model.getDatatypeProperty(URI+"description_distribution");
//            if(table.getTABLE_COMMENT() == null)
//                table.setTABLE_COMMENT("");
//            indTable.addProperty(propertyTableDesc, table.getTABLE_COMMENT());
//            DatatypeProperty propertyTableIssued= model.getDatatypeProperty(URI+"issued_distribution");
//            indTable.addProperty(propertyTableIssued, table.getCREATE_TIME());
//            DatatypeProperty propertyTableModified= model.getDatatypeProperty(URI+"modified_distribution");
//            if(table.getUPDATE_TIME() == null)
//                table.setUPDATE_TIME("");
//            
//            indTable.addProperty(propertyTableModified, table.getUPDATE_TIME());
//            DatatypeProperty propertyTableFormat= model.getDatatypeProperty(URI+"format_distribution");
//            indTable.addProperty(propertyTableModified, table.getROW_FORMAT());
//            
//            //Entidad TableStructure
//            OntClass ontTableStructure= model.getOntClass(URI+"TableStructure");
//            Individual indTableStructure = model.createIndividual( URI + "structure_"+table.getTABLE_NAME(), ontTableStructure );
//            DatatypeProperty propertyTableStructureCharSet = model.getDatatypeProperty(URI+"characterSet_tableStructure");
//            indTableStructure.addProperty(propertyTableStructureCharSet,dataset.getDEFAULT_CHARACTER_SET_NAME());
//            
//            //Relacion entre table y su estructura
//            ObjectProperty isStructuredBy = model.getObjectProperty(URI+"isStructuredBy");
//            indTable.addProperty(isStructuredBy, indTableStructure);
//            
//            //Entidad TableDescription
//            OntClass ontTableDescription = model.getOntClass(URI+"TableDescription");
//            Individual indTableDes = model.createIndividual( URI + "Description_"+table.getTABLE_NAME(), ontTableDescription );
//            DatatypeProperty propertyTableDesOverall = model.getDatatypeProperty(URI+"overallRecordCount");
//            indTableDes.addProperty(propertyTableDesOverall,table.getTABLE_ROWS());
//            DatatypeProperty propertyTableDesProgram = model.getDatatypeProperty(URI+"input_program");
//            indTableDes.addProperty(propertyTableDesProgram,table.getENGINE());
//            
//            //Relacion entre table y su descripcion
//            ObjectProperty isDescribedBy = model.getObjectProperty(URI+"isDescribedBy");
//            indTable.addProperty(isDescribedBy, indTableDes);
//            
//            //Relacion entre dataset y distribution
//            ObjectProperty distribution = model.getObjectProperty(URI+"distribution");
//            indDataset.addProperty(distribution, indTable);
//            
//            for (Column column : table.getColumnas()) {
//                OntClass ontColumn = model.getOntClass(URI+"Column");
//                Individual indColumn = model.createIndividual( URI + column.getCOLUMN_NAME(), ontColumn );
//                DatatypeProperty propertyColumnName = model.getDatatypeProperty(URI+"nameColumn");
//                indColumn.addProperty(propertyColumnName,column.getCOLUMN_NAME());
//
//                //Entidad ColumnDescription
//                OntClass ontColumnDes = model.getOntClass(URI+"ColumnDescription");
//                Individual indColumnDes = model.createIndividual( URI + "des_"+column.getCOLUMN_NAME(), ontColumnDes );
//                DatatypeProperty propertyColumDesStorage = model.getDatatypeProperty(URI+"storage_format");
//                indColumnDes.addProperty(propertyColumDesStorage,column.getDATA_TYPE());
//
//                 //Relacion entre column y su descripcion
//                ObjectProperty columnDescribed = model.getObjectProperty(URI+"columnDescribed");
//                indColumn.addProperty(columnDescribed, indColumnDes);
//
//                 //Relacion entre distribution y sus columnas
//                ObjectProperty objColumn = model.getObjectProperty(URI+"column");
//                indTable.addProperty(objColumn, indColumn);
//                
//                System.out.println("Cooooo "+column.getCOLUMN_KEY());
//                if(column.getCOLUMN_KEY()!= null && column.getCOLUMN_KEY().equalsIgnoreCase("PRI"))
//                {
//                    System.out.println("entreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//                   //Relacion entre distribution y clave primaria
//                   ObjectProperty primaryKey = model.getObjectProperty(URI+"primaryKey");
//                   indTable.addProperty(primaryKey, indColumn);
//                 
//                }
//                if(column.getCOLUMN_KEY()!= null && column.getCOLUMN_KEY().equalsIgnoreCase("MUL"))
//                {
//                   //Relacion entre distribution y sus claves foreneas
//                   ObjectProperty foreign = model.getObjectProperty(URI+"foreign");
//                   indTable.addProperty(foreign, indColumn);
//                 
//                }
//               //Relacion entre la columa y la tablas a la que perteenece
//                ObjectProperty isContains = model.getObjectProperty(URI+"isContains");
//                indColumn.addProperty(isContains, indTable);
//               
//
//                
//            }
//            
//            
//        }
//       
//    }
//
//    public void generarOntologiaCSV(ConexionCSV con) throws IOException, FileNotFoundException, SAXException, TikaException
//    {
//       CSV dataset = con.getModel();
//       String URI = model.getNsPrefixURI("");
//       OntClass ontDataset= model.getOntClass(URI+"Dataset");
//       Individual indDataset = model.createIndividual( URI + dataset.getTitle(), ontDataset );
//       DatatypeProperty propertyDataset = model.getDatatypeProperty(URI+"dataset_title");
//       indDataset.addProperty(propertyDataset, dataset.getTitle());
//       
//       DatatypeProperty propertyDataset1 = model.getDatatypeProperty(URI+"description_dataset");
//       indDataset.addProperty(propertyDataset1, con.getDescription());
//       
//       DatatypeProperty propertyDataset2 = model.getDatatypeProperty(URI+"modified_dataset");
//       indDataset.addProperty(propertyDataset2, dataset.getModifiedDate());
//       
//       DatatypeProperty propertyDataset3 = model.getDatatypeProperty(URI+"keyword_dataset");
//       indDataset.addProperty(propertyDataset3, con.getKeyword());
//       
//       DatatypeProperty propertyDataset4 = model.getDatatypeProperty(URI+"language_dataset");
//       indDataset.addProperty(propertyDataset4, con.getLanguage());
//       
//            //Creacion de Entidad Table
//            OntClass ontTable= model.getOntClass(URI+"Table");
//            Individual indTable = model.createIndividual( URI + dataset.getTitle(), ontTable );
//            DatatypeProperty propertyTableTitle = model.getDatatypeProperty(URI+"title_distribution");
//            indTable.addProperty(propertyTableTitle, dataset.getTitle());
//            DatatypeProperty propertyTableDesc = model.getDatatypeProperty(URI+"description_distribution");
//            indTable.addProperty(propertyTableDesc, con.getDescription());
//            /*DatatypeProperty propertyTableIssued= model.getDatatypeProperty(URI+"issued_distribution");
//            indTable.addProperty(propertyTableIssued, table.getCREATE_TIME());*/
//            DatatypeProperty propertyTableModified= model.getDatatypeProperty(URI+"modified_distribution");
//            indTable.addProperty(propertyTableModified, dataset.getModifiedDate());
//            DatatypeProperty propertyTableFormat= model.getDatatypeProperty(URI+"format_distribution");
//            indTable.addProperty(propertyTableFormat, "CSV");
//            
//            //Entidad Delimited
//            OntClass ontDelimited= model.getOntClass(URI+"Delimited");
//            Individual indDelimited = model.createIndividual( URI + "Delimited_"+dataset.getTitle(), ontDelimited);
//            DatatypeProperty propertyDelimited1 = model.getDatatypeProperty(URI+"delimiter_Delimited");
//
//            if(dataset.getDelimiter() == null)
//                dataset.setDelimiter(",");
//            
//            indDelimited.addProperty(propertyDelimited1,dataset.getDelimiter());
//            DatatypeProperty propertyDelimited2 = model.getDatatypeProperty(URI+"firstDataLine");
//            indDelimited.addProperty(propertyDelimited2,dataset.getFirstDataLine());
//            DatatypeProperty propertyDelimited3 = model.getDatatypeProperty(URI+"namesOnFirstRow_Delimited");
//            if(dataset.getNameOnFirstOne() == null)
//                dataset.setNameOnFirstOne("true");
//
//            indDelimited.addProperty(propertyDelimited3,dataset.getNameOnFirstOne());
//            DatatypeProperty propertyDelimited4 = model.getDatatypeProperty(URI+"textQualifer_Delimited");
//            indDelimited.addProperty(propertyDelimited4,dataset.getTextQualifier());
//
//            //Relacion entre table y delimited
//            ObjectProperty isStructuredBy = model.getObjectProperty(URI+"isStructuredBy");
//            indTable.addProperty(isStructuredBy, indDelimited);
//            
//            
//            //Relacion entre dataset y distribution
//            ObjectProperty distribution = model.getObjectProperty(URI+"distribution");
//            indDataset.addProperty(distribution, indTable);
//            
//            for (ColumnCsv column : dataset.getColsCsv()) {
//                OntClass ontColumn = model.getOntClass(URI+"Column");
//                Individual indColumn = model.createIndividual( URI + column.getNombre(), ontColumn );
//                DatatypeProperty propertyColumnName = model.getDatatypeProperty(URI+"nameColumn");
//                indColumn.addProperty(propertyColumnName,column.getNombre());
//
//                System.out.println("por aqiiiiiiiiiiii");
//                //Entidad ColumnDescription
//                OntClass ontColumnDes = model.getOntClass(URI+"DelimitedColumnDescription");
//                Individual indColumnDes = model.createIndividual( URI + "DelimitedDes_"+column.getNombre(), ontColumnDes );
//                DatatypeProperty propertyColumDesStorage = model.getDatatypeProperty(URI+"storage_format");
//                indColumnDes.addProperty(propertyColumDesStorage,column.getFormato());
//
//                DatatypeProperty propertyColumDes2 = model.getDatatypeProperty(URI+"recordNumber");
//                indColumnDes.addProperty(propertyColumDes2,column.getRecordNumber());
//
//                DatatypeProperty propertyColumDes3 = model.getDatatypeProperty(URI+"columPosition_DelimitedDescrip");
//                indColumnDes.addProperty(propertyColumDes3,column.getPosicion());
//
//                
//                 //Relacion entre column y su descripcion
//                ObjectProperty columnDescribed = model.getObjectProperty(URI+"columnDescribed");
//                indColumn.addProperty(columnDescribed, indColumnDes);
//
//                 //Relacion entre distribution y sus columnas
//                ObjectProperty objColumn = model.getObjectProperty(URI+"column");
//                indTable.addProperty(objColumn, indColumn);
//                
//                
//               //Relacion entre la columa y la tablas a la que perteenece
//                ObjectProperty isContains = model.getObjectProperty(URI+"isContains");
//                indColumn.addProperty(isContains, indTable);
//               
//
//                
//            }
//            
//            
//        
//       
//    }
//
//    
//    
//    public void guardarOntologia() throws IOException{
//        
//        String fileName = "/home/adrian/Documentos/TESIS/result.rdf";
//        FileWriter out = new FileWriter( fileName );
//        model.write(out,"RDF/XML");
//
//    }
//    
    
}
