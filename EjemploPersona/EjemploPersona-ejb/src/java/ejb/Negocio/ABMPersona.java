/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.Negocio;

import ejb.JPA.PersonaFacade;
import java.util.ArrayList;
import java.util.List;


import javax.ejb.Stateless;
import modelo.Persona;

/**
 *
 * @author javier
 */

@Stateless
public class ABMPersona implements ABMPersonaLocal {

    @Override
    public boolean Registar(String Nombre) {
            new PersonaFacade().create(Nombre);
            return true;
    }

    @Override
    public int ctsRegistrados() {
        return new PersonaFacade().count();
    }

    @Override
    public List<String> Registrados() {
        List<String> resultado = new ArrayList();
        List<Persona> findAll = new PersonaFacade().findAll();
        int size = findAll.size();
        for(int i=0; i< size; i++){
            resultado.add(findAll.get(i).getNombre());
        }
        return resultado;
    }
}
