/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.ucuenca.mdl.Catalog;
import com.ucuenca.mdl.Column;
import com.ucuenca.mdl.Column_Base;
import com.ucuenca.mdl.Column_CSV;
import com.ucuenca.mdl.Conexion;
import com.ucuenca.mdl.ConexionBD;
import com.ucuenca.mdl.ConexionCSV;
import com.ucuenca.mdl.DataBase;
import com.ucuenca.mdl.Table;
import com.ucuenca.mdl.Table_Base;
import com.ucuenca.mdl.Table_CSV;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author adrian
 */
public class GestorOntologia {

    private String filename = "";
    private OntModel model;
    private Individual indCatalog;

    public GestorOntologia() {
        filename = "/home/adrian/Documentos/TESIS/experimento1_v3.owl";
        // Create an empty model
        model = ModelFactory.createOntologyModel();

        // Use the FileManager to find the input file
        InputStream in = FileManager.get().open(filename);

        if (in == null) {
            throw new IllegalArgumentException("File: " + filename + " not found");
        }

        // Read the RDF/XML file
        model.read(in, null);

    }

    public String generarOntologia(Catalog catalogo) throws IOException, FileNotFoundException, SAXException, TikaException {
        String URI = model.getNsPrefixURI("");
        OntClass ontCatalogo = model.getOntClass(URI + "Catalog");
        indCatalog = model.createIndividual(URI + catalogo.getTitle(), ontCatalogo);
        DatatypeProperty propertyCatalogo = model.getDatatypeProperty(URI + "title");
        System.out.println("catalogo.." + catalogo.getTitle());
        indCatalog.addProperty(propertyCatalogo, catalogo.getTitle());
        DatatypeProperty propertyCatalogo1 = model.getDatatypeProperty(URI + "description");
        indCatalog.addProperty(propertyCatalogo1, catalogo.getDescription());
        DatatypeProperty propertyCatalogo2 = model.getDatatypeProperty(URI + "Catalog_issued");
        indCatalog.addProperty(propertyCatalogo2, catalogo.getIssued());
        DatatypeProperty propertyCatalogo3 = model.getDatatypeProperty(URI + "language");
        indCatalog.addProperty(propertyCatalogo3, catalogo.getLanguage());
        DatatypeProperty propertyCatalogo4 = model.getDatatypeProperty(URI + "licence");
        indCatalog.addProperty(propertyCatalogo4, catalogo.getLicense());

        for (Conexion con : catalogo.getDatasets()) {

            if (con instanceof ConexionBD) {
                ConexionBD conAux = (ConexionBD) con;
                generarOntologiaBD(conAux);
            }

            if (con instanceof ConexionCSV) {
                ConexionCSV conAux = (ConexionCSV) con;
                generarOntologiaCSV(conAux);
            }

        }

       String rdf = guardarOntologia();
      //  System.out.println("rdf.. "+rdf);
       return rdf;
    }

    public void generarOntologiaBD(ConexionBD con) {
        DataBase dataset = con.getModel();
        String URI = model.getNsPrefixURI("");
        //Entidad DATASET
        OntClass ontDataset = model.getOntClass(URI + "Dataset");
        Individual indDataset = model.createIndividual(URI + dataset.getSchema_name(), ontDataset);
        DatatypeProperty propertyDataset = model.getDatatypeProperty(URI + "dataset_title");
        indDataset.addProperty(propertyDataset, dataset.getSchema_name());
        DatatypeProperty propertyDataset1 = model.getDatatypeProperty(URI + "description_dataset");
        indDataset.addProperty(propertyDataset1, con.getDescription());
        DatatypeProperty propertyDataset2 = model.getDatatypeProperty(URI + "keyword_dataset");
        indDataset.addProperty(propertyDataset2, con.getKeyword());
        DatatypeProperty propertyDataset3 = model.getDatatypeProperty(URI + "language_dataset");
        indDataset.addProperty(propertyDataset3, con.getLanguage());
        DatatypeProperty propertyDataset4 = model.getDatatypeProperty(URI + "issued_dataset");
        indDataset.addProperty(propertyDataset4, dataset.getIssued());
       //Fehca de modificacion

        for (Table tab : dataset.getTables()) {
            Table_Base table = (Table_Base) tab;
            //Creacion de Entidad Table
            OntClass ontTable = model.getOntClass(URI + "Table");
            Individual indTable = model.createIndividual(URI + table.getTitle(), ontTable);
            DatatypeProperty propertyTable = model.getDatatypeProperty(URI + "title_distribution");
            indTable.addProperty(propertyTable, table.getTitle());
            DatatypeProperty propertyTable2 = model.getDatatypeProperty(URI + "description_distribution");
            indTable.addProperty(propertyTable2, table.getDescription());
            DatatypeProperty propertyTable3 = model.getDatatypeProperty(URI + "issued_distribution");
            indTable.addProperty(propertyTable3, table.getIssued());
            DatatypeProperty propertyTable4 = model.getDatatypeProperty(URI + "modified_distribution");
            indTable.addProperty(propertyTable4, table.getModified());
            DatatypeProperty propertyTable5 = model.getDatatypeProperty(URI + "mediaType_distribution");
            indTable.addProperty(propertyTable5, table.getMediaType());
            DatatypeProperty propertyTable6 = model.getDatatypeProperty(URI + "format_distribution");
            indTable.addProperty(propertyTable6, table.getFormat());
            DatatypeProperty propertyTable7 = model.getDatatypeProperty(URI + "byteSize_distribution");
            indTable.addProperty(propertyTable7, table.getByteSize());

            //Entidad TableStructure
            OntClass ontTableStructure = model.getOntClass(URI + "TableStructure");
            Individual indTableStructure = model.createIndividual(URI + "structure_" + table.getTitle(), ontTableStructure);
            DatatypeProperty propertyTableStructure1 = model.getDatatypeProperty(URI + "characterSet_tableStructure");
            indTableStructure.addProperty(propertyTableStructure1, table.getCharacterSet());
            DatatypeProperty propertyTableStructure2 = model.getDatatypeProperty(URI + "defaultDecimalSeparator_tableStructure");
            indTableStructure.addProperty(propertyTableStructure2, table.getDefaultDecimalSeparator());

            //Relacion entre table y su estructura
            ObjectProperty isStructuredBy = model.getObjectProperty(URI + "isStructuredBy");
            indTable.addProperty(isStructuredBy, indTableStructure);

            //Entidad TableDescription
            OntClass ontTableDescription = model.getOntClass(URI + "TableDescription");
            Individual indTableDes = model.createIndividual(URI + "Description_" + table.getTitle(), ontTableDescription);
            DatatypeProperty propertyTableDes1 = model.getDatatypeProperty(URI + "overallRecordCount");
            indTableDes.addProperty(propertyTableDes1, table.getOverrallRecordCount());

            //Relacion entre table y su descripcion
            ObjectProperty isDescribedBy = model.getObjectProperty(URI + "isDescribedBy");
            indTable.addProperty(isDescribedBy, indTableDes);

            //Relacion entre dataset y distribution
            ObjectProperty distribution = model.getObjectProperty(URI + "distribution");
            indDataset.addProperty(distribution, indTable);

            for (Column col : table.getColumnas()) {
                Column_Base column = (Column_Base) col;

                OntClass ontColumn = model.getOntClass(URI + "Column");
                Individual indColumn = model.createIndividual(URI + column.getTitle(), ontColumn);
                DatatypeProperty propertyColumn1 = model.getDatatypeProperty(URI + "nameColumn");
                indColumn.addProperty(propertyColumn1, column.getTitle());

                //Entidad ColumnDescription
                OntClass ontColumnDes = model.getOntClass(URI + "ColumnDescription");
                Individual indColumnDes = model.createIndividual(URI + "description_" + column.getTitle(), ontColumnDes);
                DatatypeProperty propertyColumDescrip1 = model.getDatatypeProperty(URI + "storage_format");
                indColumnDes.addProperty(propertyColumDescrip1, column.getStorageFormat());
                DatatypeProperty propertyColumDescrip2 = model.getDatatypeProperty(URI + "decimalPositions_columnDescription");
                indColumnDes.addProperty(propertyColumDescrip2, column.getDecimalPositions());
                DatatypeProperty propertyColumDescrip3 = model.getDatatypeProperty(URI + "recordNumber_columnDescription");
                indColumnDes.addProperty(propertyColumDescrip3, column.getRecordNumber());

                //Relacion entre column y su descripcion
                ObjectProperty columnDescribed = model.getObjectProperty(URI + "columnDescribed");
                indColumn.addProperty(columnDescribed, indColumnDes);

                //Relacion entre distribution y sus columnas
                ObjectProperty objColumn = model.getObjectProperty(URI + "column");
                indTableStructure.addProperty(objColumn, indColumn);

                //Relacion entre la columa y la tablas a la que perteenece
                ObjectProperty isContains = model.getObjectProperty(URI + "isContains");
                indColumn.addProperty(isContains, indTable);

            }

        }

        //Relacion entre la columa y la tablas a la que perteenece
        ObjectProperty isdataset = model.getObjectProperty(URI + "dataset");
        indCatalog.addProperty(isdataset, indDataset);

    }

    public void generarOntologiaCSV(ConexionCSV con) throws IOException, FileNotFoundException, SAXException, TikaException {
        Table data = con.getModel();
        Table_CSV dataset = (Table_CSV) data;
        String URI = model.getNsPrefixURI("");
        System.out.println("dataset..." + dataset);
        OntClass ontDataset = model.getOntClass(URI + "Dataset");
        Individual indDataset = model.createIndividual(URI + dataset.getTitle(), ontDataset);
        DatatypeProperty propertyDataset = model.getDatatypeProperty(URI + "dataset_title");
        indDataset.addProperty(propertyDataset, dataset.getTitle());

        DatatypeProperty propertyDataset1 = model.getDatatypeProperty(URI + "description_dataset");
        indDataset.addProperty(propertyDataset1, con.getDescription());

        DatatypeProperty propertyDataset2 = model.getDatatypeProperty(URI + "issued_dataset");
        indDataset.addProperty(propertyDataset2, dataset.getIssued());

        DatatypeProperty propertyDataset3 = model.getDatatypeProperty(URI + "keyword_dataset");
        indDataset.addProperty(propertyDataset3, con.getKeyword());

        DatatypeProperty propertyDataset4 = model.getDatatypeProperty(URI + "language_dataset");
        indDataset.addProperty(propertyDataset4, con.getLanguage());

        //Creacion de Entidad Table
        OntClass ontTable = model.getOntClass(URI + "Table");
        Individual indTable = model.createIndividual(URI + dataset.getTitle(), ontTable);
        DatatypeProperty propertyTable = model.getDatatypeProperty(URI + "title_distribution");
        indTable.addProperty(propertyTable, dataset.getTitle());
        DatatypeProperty propertyTable2 = model.getDatatypeProperty(URI + "description_distribution");
        indTable.addProperty(propertyTable2, con.getDescription());
        DatatypeProperty propertyTable3 = model.getDatatypeProperty(URI + "issued_distribution");
        indTable.addProperty(propertyTable3, dataset.getIssued());
        DatatypeProperty propertyTable4 = model.getDatatypeProperty(URI + "modified_distribution");
        indTable.addProperty(propertyTable4, dataset.getModified());
        DatatypeProperty propertyTable5 = model.getDatatypeProperty(URI + "mediaType_distribution");
        indTable.addProperty(propertyTable5, dataset.getMediaType());
        DatatypeProperty propertyTable6 = model.getDatatypeProperty(URI + "format_distribution");
        indTable.addProperty(propertyTable6, dataset.getFormat());
        DatatypeProperty propertyTable7 = model.getDatatypeProperty(URI + "byteSize_distribution");
        indTable.addProperty(propertyTable7, dataset.getByteSize());

        //Entidad Delimited
        OntClass ontDelimited = model.getOntClass(URI + "Delimited");
        Individual indDelimited = model.createIndividual(URI + "Delimited_" + dataset.getTitle(), ontDelimited);

        DatatypeProperty propertyDelimited1 = model.getDatatypeProperty(URI + "characterSet_tableStructure");
        indDelimited.addProperty(propertyDelimited1, dataset.getCharacterSet());
        DatatypeProperty propertyDelimited2 = model.getDatatypeProperty(URI + "defaultDecimalSeparator_tableStructure");
        indDelimited.addProperty(propertyDelimited2, dataset.getDefaultDecimalSeparator());
        DatatypeProperty propertyDelimited3 = model.getDatatypeProperty(URI + "defaultLenguaje_tableStructure");
        indDelimited.addProperty(propertyDelimited3, dataset.getDefaultLanguage());
        DatatypeProperty propertyDelimited4 = model.getDatatypeProperty(URI + "defaultLocale_tableStructure");
        indDelimited.addProperty(propertyDelimited4, dataset.getDefaultLocale());
        DatatypeProperty propertyDelimited5 = model.getDatatypeProperty(URI + "delimiter_Delimited");
        indDelimited.addProperty(propertyDelimited5, dataset.getDelimiter());
        DatatypeProperty propertyDelimited6 = model.getDatatypeProperty(URI + "textQualifer_Delimited");
        indDelimited.addProperty(propertyDelimited6, dataset.getTextQualifier());
        DatatypeProperty propertyDelimited7 = model.getDatatypeProperty(URI + "firstDataLine");
        indDelimited.addProperty(propertyDelimited7, dataset.getFirstDataLine());
        DatatypeProperty propertyDelimited8 = model.getDatatypeProperty(URI + "namesOnFirstRow_Delimited");
        indDelimited.addProperty(propertyDelimited8, dataset.getNameOnFirstRow());

        //Relacion entre table y delimited
        ObjectProperty isStructuredBy = model.getObjectProperty(URI + "isStructuredBy");
        indTable.addProperty(isStructuredBy, indDelimited);

        //Relacion entre dataset y distribution
        ObjectProperty distribution = model.getObjectProperty(URI + "distribution");
        indDataset.addProperty(distribution, indTable);

        for (Column col : dataset.getColumnas()) {
            Column_CSV column = (Column_CSV) col;
            OntClass ontColumn = model.getOntClass(URI + "Column");
            Individual indColumn = model.createIndividual(URI + column.getTitle(), ontColumn);
            DatatypeProperty propertyColumn1 = model.getDatatypeProperty(URI + "nameColumn");
            indColumn.addProperty(propertyColumn1, column.getTitle());

            //Entidad ColumnDescription
            OntClass ontColumnDes = model.getOntClass(URI + "DelimitedColumnDescription");
            Individual indColumnDes = model.createIndividual(URI + "description_" + column.getTitle(), ontColumnDes);
            DatatypeProperty propertyColumDescrip1 = model.getDatatypeProperty(URI + "storage_format");
            indColumnDes.addProperty(propertyColumDescrip1, column.getStorageFormat());
            DatatypeProperty propertyColumDescrip3 = model.getDatatypeProperty(URI + "recordNumber_columnDescription");
            indColumnDes.addProperty(propertyColumDescrip3, column.getRecordNumber());
            DatatypeProperty propertyColumDescrip4 = model.getDatatypeProperty(URI + "columPosition_DelimitedDescrip");
            indColumnDes.addProperty(propertyColumDescrip4, column.getColumnPosition());

            //Relacion entre column y su descripcion
            ObjectProperty columnDescribed = model.getObjectProperty(URI + "columnDescribed");
            indColumn.addProperty(columnDescribed, indColumnDes);

            //Relacion entre distribution y sus columnas
            ObjectProperty objColumn = model.getObjectProperty(URI + "column");
            indDelimited.addProperty(objColumn, indColumn);

            //Relacion entre la columa y la tablas a la que perteenece
            ObjectProperty isContains = model.getObjectProperty(URI + "isContains");
            indColumn.addProperty(isContains, indDelimited);

        }

        //Relacion entre la columa y la tablas a la que perteenece
        ObjectProperty isdataset = model.getObjectProperty(URI + "dataset");
        indCatalog.addProperty(isdataset, indDataset);

    }

    public String guardarOntologia() throws IOException {
        String fileName = "/home/adrian/Documentos/TESIS/result.rdf";
        FileWriter out = new FileWriter(fileName);
        model.write(out, "RDF/XML");
        StringWriter out1 = new StringWriter();
        model.write(out1, "RDF/XML");
        String result = out1.toString();
        return result;
        
    }

}
