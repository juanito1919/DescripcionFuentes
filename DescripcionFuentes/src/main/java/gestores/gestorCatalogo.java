/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.ucuenca.mdl.Catalog;
import com.ucuenca.mdl.Conexion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

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
    private List<Conexion> datasets =  new ArrayList();
    
    
        /** 
     * Intancia de Gestor
     * @return 
     */
    public static gestorCatalogo getInstance() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext context = facesContext.getELContext();
        ValueExpression ex = facesContext.getApplication().getExpressionFactory().createValueExpression(context, "#{gestorCatalogo}", gestorCatalogo.class);
        return (gestorCatalogo) ex.getValue(context);
    }


    
    public String initCatalogo(){
        
        catalogo = new Catalog();
        datasets =  new ArrayList<>();
        
        return "/"+NUEVO_CATALOGO+REDIRECT;
 
        
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
    
    
    
    
}
