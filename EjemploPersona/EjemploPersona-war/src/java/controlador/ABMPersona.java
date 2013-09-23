/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.Negocio.ABMPersonaLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author javier
 */
@ManagedBean
@SessionScoped
public class ABMPersona {

    private String nombre;
    private List<String> nombres;
    private String cantidad;
    
    @EJB
    private ABMPersonaLocal gestorPersona;
    /**
     * Creates a new instance of ABMPersona
     */
    public ABMPersona() {
        cantidad = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        setTotal();
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public List<String> getNombres() {
        nombres = gestorPersona.Registrados();
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }
    
    
    
    public String guardar(){
        System.out.println(nombre);
        if(nombre != null){
            gestorPersona.Registar(nombre);
            nombre = "";
        }
        
        return "index";
    }
    
    public void setTotal(){
        cantidad = new Integer(gestorPersona.ctsRegistrados()).toString();
    }
    
}
