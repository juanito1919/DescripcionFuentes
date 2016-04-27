/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.ucuenca.mdl.Catalog;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import com.ucuenca.mdl.Conexion;
import com.ucuenca.mdl.ConexionBD;
import com.ucuenca.mdl.ConexionCSV;
import com.ucuenca.mdl.ConexionEXCEL;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import org.apache.tika.exception.TikaException;
import org.primefaces.model.UploadedFile;
import org.xml.sax.SAXException;

/**
 *
 * @author adrian
 */
@Named(value = "gestorCatalogo")
@SessionScoped
public class gestorCatalogo implements Serializable {
    
    public gestorCatalogo() {
    }
    
    private static final String FORM = "/crearCatalogo.jsf?faces-redirect=true";
    private static final String NUEVO_CATALOGO = "crearCatalogo?faces-redirect=true";
    private static final String REDIRECT = "?faces-redirect=true";
    private static final String DISPONIBILIDAD = "/../crearCatalogo/";
    private Catalog catalogo;
    private Date issuedCatalogo = new Date();
    private List<Conexion> datasets = new ArrayList();
    private String tipo_conexion;
    /**
     * Variables utilizadas en la creacion de una conexion
     */
    private String keywords;
    private String descripcion;
    private String lenguaje;
    private String nombre;
    //Base de datos
    private String host = "localhost";
    private String puerto = "3306";
    private String username = "root";
    private String password = "1234";
    private String schema = "base";
    //CSV
    private String accessURL;
    private UploadedFile file;
    
    private boolean popupConexion;
    private boolean popupResult;
    
    //Ontologia RDF generado
    private String resultRDF;
    
    
    public gestorCatalogo(Catalog catalogo, String tipo_conexion, String keywords) {
        this.catalogo = catalogo;
        this.tipo_conexion = tipo_conexion;
        this.keywords = keywords;
    }

    /**
     * Intancia de Gestor
     *
     * @return
     */
    public static gestorCatalogo getInstance() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext context = facesContext.getELContext();
        ValueExpression ex = facesContext.getApplication().getExpressionFactory().createValueExpression(context, "#{gestorCatalogo}", gestorCatalogo.class);
        return (gestorCatalogo) ex.getValue(context);
    }
    
    public String initCatalogo() {
        
        catalogo = new Catalog();
        datasets = new ArrayList<>();
        popupConexion = false;
        tipo_conexion = "BD";
        popupResult = false;
        
        return "/" + NUEVO_CATALOGO + REDIRECT;
        
    }
    
    public void agregarDataset() {
        if (tipo_conexion.equalsIgnoreCase("BD")) {

            //Validaciones
            ConexionBD conexion = new ConexionBD();
            conexion.setName(nombre);
            conexion.setDescription(descripcion);
            conexion.setLanguage(lenguaje);
            conexion.setKeyword(keywords);
            conexion.setHost(host);
            conexion.setSchema(schema);
            conexion.setPort(puerto);
            conexion.setUsername(username);
            conexion.setPassword(password);
            //conexion.setNumTablas(conexion.getModel().getTables().size());
            datasets.add(conexion);
            
        }
        
        if (tipo_conexion.equalsIgnoreCase("CSV")) {

            //Validaciones
            ConexionCSV conexion = new ConexionCSV();
            conexion.setNombre(nombre);
            conexion.setDescription(descripcion);
            conexion.setLanguage(lenguaje);
            conexion.setKeyword(keywords);
            conexion.setAccessURL(accessURL);
            conexion.setNumTablas(1);
            
            datasets.add(conexion);
            
        }
        if (tipo_conexion.equalsIgnoreCase("EXCEL")) {
            ConexionEXCEL conexion = new ConexionEXCEL();
            conexion.setNombre(nombre);
            conexion.setDescription(descripcion);
            conexion.setKeyword(keywords);
            conexion.setLanguage(lenguaje);
            conexion.setAccessURL(accessURL);
            conexion.setNumTablas(0);
            conexion.getModel();
            datasets.add(conexion);
        }
        
        popupConexion = false;
        
    }
    
    public void upload() {
        if (file != null) {
            try {
                InputStream inputStream = file.getInputstream();
                
            } catch (IOException ex) {
                Logger.getLogger(gestorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void abrirPopUpConexion() {
        tipo_conexion = "BD";
        popupConexion = true;
        
    }
    
    public void generarOntologia(){
        
        try {
            System.out.println("Catalogo.."+catalogo.getTitle()+", "+catalogo.getDescription()+" "+catalogo.getIssued()+""+catalogo.getLicense());
            catalogo.setDatasets((ArrayList<Conexion>) datasets);
            GestorOntologia gestorOnt = new GestorOntologia();
            resultRDF = gestorOnt.generarOntologia(catalogo);
            System.out.println("redfggg.."+resultRDF);
            if(resultRDF!=null && !resultRDF.isEmpty()){
                   FacesContext context1 = FacesContext.getCurrentInstance();
                   context1.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ontologia Generada Correctamente", ""));
         
                popupResult = true;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(gestorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(gestorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TikaException ex) {
            Logger.getLogger(gestorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Catalog getCatalogo() {
        return catalogo;
    }
    
    public void setCatalogo(Catalog catalogo) {
        this.catalogo = catalogo;
    }
    
    public List<Conexion> getDatasets() {
        return datasets;
    }
    
    public void setDatasets(List<Conexion> datasets) {
        this.datasets = datasets;
    }
    
    public String getTipo_conexion() {
        return tipo_conexion;
    }
    
    public void setTipo_conexion(String tipo_conexion) {
        this.tipo_conexion = tipo_conexion;
    }
    
    public String getKeywords() {
        return keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getLenguaje() {
        return lenguaje;
    }
    
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getHost() {
        return host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    
    public String getPuerto() {
        return puerto;
    }
    
    public void setPuerto(String puerto) {
        this.puerto = puerto;
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
    
    public String getAccessURL() {
        return accessURL;
    }
    
    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }
    
    public UploadedFile getFile() {
        return file;
    }
    
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public boolean isPopupConexion() {
        return popupConexion;
    }
    
    public void setPopupConexion(boolean popupConexion) {
        this.popupConexion = popupConexion;
    }

    public Date getIssuedCatalogo() {
        return issuedCatalogo;
    }

    public void setIssuedCatalogo(Date issuedCatalogo) {
        this.issuedCatalogo = issuedCatalogo;
    }
 
    public void mostrar(){
        System.out.println("issued.. "+issuedCatalogo);
    }

    public String getResultRDF() {
        return resultRDF;
    }

    public void setResultRDF(String resultRDF) {
        this.resultRDF = resultRDF;
    }

    public boolean isPopupResult() {
        return popupResult;
    }

    public void setPopupResult(boolean popupResult) {
        this.popupResult = popupResult;
    }
    
    
    
}
