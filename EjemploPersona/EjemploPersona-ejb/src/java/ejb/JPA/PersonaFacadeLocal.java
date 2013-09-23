/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.JPA;

import java.util.List;
import javax.ejb.Local;
import modelo.Persona;

/**
 *
 * @author javier
 */
@Local
public interface PersonaFacadeLocal {

    void create(String nombre);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Long id);

    List<Persona> findAll();

    int count();
    
}
