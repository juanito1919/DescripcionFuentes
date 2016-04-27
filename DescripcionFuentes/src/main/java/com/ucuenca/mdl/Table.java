/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.mdl;


import java.util.ArrayList;

/**
 *
 * @author pablo Japa juan.japal@hotmail.com
 */
public class Table {

    private String title;
    private String description;
    private String issued;//Fecha de creacion
    private String modified;//Fecha de modificacion
    private String license;//Links que identifiquen la licencia de la tabla o distribucion
    private String rights;//Derechos del titular y de la distribucion
    private String accessURL;//Una página de destino , alimentación , SPARQL endpoint u otro tipo de recurso que da acceso a la distribución del conjunto de datos
    private boolean downloadURL;
    private String mediaType; //example text/csv  , sql proporcionado por IANA
    private String format; //example text/csv  , sql proporcionado por IANA
    private String byteSize;//tamano tabla en bytes
    private String characterSet; //Codificacion de la tabla
    private String defaultDecimalSeparator;//El carácter utilizado para separar los números enteros de los decimales expresa como una cadena de un carácter.
    private String defaultDigitGroupSeparator;//El carácter utilizado para separar el componente de números enteros (miles , millones , etc. ) expresado como una cadena de un carácter.
    private String defaultLanguage;
    private String defaultLocale;//Se trata de un conjunto de parámetros que define el país , y de cualquier preferencia variantes especiales similares a BCP 47.
    private String defaultDecimalPositions;
    private String newLine;//Especifica el marcador de fin de línea ( EOL ) utilizado en el archivo tal como se produce . Si ningún valor se proporciona asume el uso de un ( retorno de carro y línea) CRLF
    private String caseQuantity;
    private String fileName;//El nombre de archivo o URI de la tabla.
    private String recordPerCase;//El número de registros por caso . Los registros múltiples podrían representar un caso
    private String overrallRecordCount;//En general, el número de registros en la tabla.
    private String programFileName;//File name or URI of the input program.
    private String softwareType;
    private String programVersion;
    private ArrayList<Column> columnas;

    public Table() {
       
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getAccessURL() {
        return accessURL;
    }

    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }

    public boolean isDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(boolean downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getByteSize() {
        return byteSize;
    }

    public void setByteSize(String byteSize) {
        this.byteSize = byteSize;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public String getDefaultDecimalSeparator() {
        return defaultDecimalSeparator;
    }

    public void setDefaultDecimalSeparator(String defaultDecimalSeparator) {
        this.defaultDecimalSeparator = defaultDecimalSeparator;
    }

    public String getDefaultDigitGroupSeparator() {
        return defaultDigitGroupSeparator;
    }

    public void setDefaultDigitGroupSeparator(String defaultDigitGroupSeparator) {
        this.defaultDigitGroupSeparator = defaultDigitGroupSeparator;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public String getDefaultDecimalPositions() {
        return defaultDecimalPositions;
    }

    public void setDefaultDecimalPositions(String defaultDecimalPositions) {
        this.defaultDecimalPositions = defaultDecimalPositions;
    }

    public String getNewLine() {
        return newLine;
    }

    public void setNewLine(String newLine) {
        this.newLine = newLine;
    }

    public String getCaseQuantity() {
        return caseQuantity;
    }

    public void setCaseQuantity(String caseQuantity) {
        this.caseQuantity = caseQuantity;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRecordPerCase() {
        return recordPerCase;
    }

    public void setRecordPerCase(String recordPerCase) {
        this.recordPerCase = recordPerCase;
    }

    public String getOverrallRecordCount() {
        return overrallRecordCount;
    }

    public void setOverrallRecordCount(String overrallRecordCount) {
        this.overrallRecordCount = overrallRecordCount;
    }

    public String getProgramFileName() {
        return programFileName;
    }

    public void setProgramFileName(String programFileName) {
        this.programFileName = programFileName;
    }

    public String getSoftwareType() {
        return softwareType;
    }

    public void setSoftwareType(String softwareType) {
        this.softwareType = softwareType;
    }

    public String getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(String programVersion) {
        this.programVersion = programVersion;
    }

    public ArrayList<Column> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<Column> columnas) {
        this.columnas = columnas;
    }
    

}
